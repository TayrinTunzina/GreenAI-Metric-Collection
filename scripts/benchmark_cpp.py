"""
GreenAI Metric Collection
Copyright (c) 2025 Tayrin Tunzina
Licensed under the Apache License 2.0

This script is part of the GreenAI project for measuring
execution time, memory, energy, and CO₂ footprint of AI-generated code.
"""

import subprocess
import os
import csv
import time
from codecarbon import OfflineEmissionsTracker
import psutil

# === CONFIGURATION ===
RUNS = 5
emissions_log_path = "emissions.csv"
results_log_path = "cpp_results.csv"
input_file_path = "input.txt"  # Must exist and contain test input

# === UTILITY FUNCTIONS ===
def clear_emissions_log():
    if os.path.exists(emissions_log_path):
        os.remove(emissions_log_path)

def read_last_emission_entry():
    with open(emissions_log_path, "r") as f:
        lines = f.readlines()
        if len(lines) < 2:
            return 0, 0
        last = lines[-1].strip().split(",")
        energy = float(last[13])   # energy_consumed (kWh)
        emissions = float(last[5]) # emissions (kg CO₂)
        return energy, emissions

def run_with_metrics(cmd, input_file):
    # Start subprocess with input redirected
    with open(input_file, "r") as infile:
        process = psutil.Popen(cmd, stdin=infile)
        proc = psutil.Process(process.pid)

        peak_mem = 0.0
        start_time = time.time()

        try:
            while process.poll() is None:  # While still running
                try:
                    mem = proc.memory_info().rss / (1024 * 1024)  # in MiB
                    if mem > peak_mem:
                        peak_mem = mem
                except psutil.NoSuchProcess:
                    break
                time.sleep(0.05)  # sample every 50ms
        except Exception as e:
            print(f"⚠️ Error tracking process: {e}")

        end_time = time.time()
        cpu_time = end_time - start_time  # Wall-clock execution time (excluding manual input)

    return cpu_time, peak_mem

# === MAIN LOGIC ===
def measure_cpp(exe_path, model_name, relative_path):
    rows = []
    for run in range(1, RUNS + 1):
        clear_emissions_log()
        tracker = OfflineEmissionsTracker(
            country_iso_code="BGD",  # 🇧🇩 Bangladesh
            output_file=emissions_log_path,
            measure_power_secs=1,
            log_level="error"
        )
        tracker.start()

        print(f"\n🟢 Run {run}: Input redirected from '{input_file_path}'")
        try:
            cmd = [exe_path]
            cpu_time, mem = run_with_metrics(cmd, input_file_path)
        except Exception as e:
            print(f"❌ C++ error: {e}")
            cpu_time, mem = 0, 0

        tracker.stop()

        # Read CodeCarbon output
        with open(emissions_log_path, "r") as f:
            lines = f.readlines()
            if len(lines) >= 2:
                last = lines[-1].strip().split(",")
                carbon_intensity = last[10]
                print(f"📍 Location: Bangladesh | 🧪 Carbon Intensity: {carbon_intensity} gCO₂/kWh")

        time.sleep(1)
        energy, co2 = read_last_emission_entry()
        print(f"Run {run}: ⚡ {energy:.8f} kWh, 🌍 {co2:.8f} kg CO₂, 🕒 {cpu_time:.4f} sec, 🧠 {mem:.4f} MiB")
        rows.append([model_name, relative_path, run, energy, co2, cpu_time, mem])
    return rows

def main():

    exe_path = r"path/to/your/program/example.exe"
    base_dir = r"path/to/your/cpp/projects"

    relative_path = os.path.relpath(exe_path, base_dir)
    model_name = relative_path.split(os.sep)[0]

    results = measure_cpp(exe_path, model_name, relative_path)

    with open(results_log_path, "a", newline="", encoding="utf-8") as f:
        writer = csv.writer(f)
        if f.tell() == 0:
            writer.writerow(["Model", "EXE Path", "Run", "Energy (kWh)", "CO2 (kg)", "CPU Time (sec)", "Memory (MiB)"])
        writer.writerows(results)

    print(f"\n✅ C++ runs completed. Results saved to {results_log_path}")

if __name__ == "__main__":
    main()
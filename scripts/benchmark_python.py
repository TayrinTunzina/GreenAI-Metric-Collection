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
results_log_path = "python_results.csv"
input_file_path = "input.txt"  # Must exist and contain test input

# === UTILITY ===
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

def run_with_metrics(python_file):
    cmd = ["python", python_file]
    try:
        with open(input_file_path, "r") as infile:
            start_time = time.time()
            process = psutil.Popen(cmd, stdin=infile)
            proc = psutil.Process(process.pid)

            peak_mem = 0.0
            while process.poll() is None:
                try:
                    mem = proc.memory_info().rss / (1024 * 1024)  # Convert bytes to MiB
                    if mem > peak_mem:
                        peak_mem = mem
                except psutil.NoSuchProcess:
                    break
                time.sleep(0.05)
            end_time = time.time()

            cpu_time = end_time - start_time  # Wall clock time
    except Exception as e:
        print(f"⚠️ Error during Python tracking: {e}")
        cpu_time = 0
        peak_mem = 0

    return cpu_time, peak_mem

# === MAIN RUNNER ===
def measure_python(python_file, model_name, relative_path):
    rows = []
    for run in range(1, RUNS + 1):
        clear_emissions_log()
        tracker = OfflineEmissionsTracker(
            country_iso_code="BGD",
            output_file=emissions_log_path,
            measure_power_secs=1,
            log_level="error"
        )
        tracker.start()

        try:
            cpu_time, memory = run_with_metrics(python_file)
        except subprocess.CalledProcessError as e:
            print(f"❌ Error running {python_file}: {e}")
            cpu_time, memory = 0, 0
        tracker.stop()

        with open(emissions_log_path, "r") as f:
            lines = f.readlines()
            if len(lines) >= 2:
                last = lines[-1].strip().split(",")
                carbon_intensity = last[10]
                print(f"📍 Location: Bangladesh | 🦩 Carbon Intensity: {carbon_intensity} gCO₂/kWh")

        time.sleep(1)
        energy, co2 = read_last_emission_entry()
        rows.append([model_name, relative_path, run, energy, co2, cpu_time, memory])
        print(f"Run {run}: ⚡ {energy:.8f} kWh, 🌍 {co2:.8f} kg CO₂, 🕒 {cpu_time:.4f} sec, 🧠 {memory:.4f} MiB")

    return rows

# === MAIN DRIVER ===
def main():
    
    python_file = r"path/to/your/code/example.py"
    base_dir = r"path/to/your/python/projects"

    relative_path = os.path.relpath(python_file, base_dir)
    model_name = relative_path.split(os.sep)[0]

    results = measure_python(python_file, model_name, relative_path)

    with open(results_log_path, "a", newline="", encoding="utf-8") as f:
        writer = csv.writer(f)
        if f.tell() == 0:
            writer.writerow([
                "Model", "Relative File Path", "Run Number",
                "Energy (kWh)", "CO2 (kg)", "CPU Time (sec)", "Memory (MiB)"
            ])
        writer.writerows(results)

    print(f"\n✅ All {RUNS} runs completed and saved to {results_log_path}")

if __name__ == "__main__":
    main()
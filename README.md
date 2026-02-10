# GreenAI-Metric-Collection
**Topic:** [**GreenAI: A Comparative Analysis of Environmental Efficiency in LLM-Generated Code**](https://)

This repository contains the **execution scripts and dataset** used for evaluating the environmental efficiency of AI-generated code across **Python, C++, and Java**.

## Contents

- **Execution scripts** to measure:
  - ⏱ Execution Time (seconds)
  - 📦 Peak memory usage (MiB)
  - ⚡ Energy consumption (kWh)
  - 🌍 Carbon footprint (kg CO₂)
- AI-generated code solutions in **Python, C++, and Java**.
- HackerRank task links used for generating the dataset (`hackerrank_tasks.txt`).

> ⚠️ Note: Statistical analysis, TOPSIS ranking, and GreenAI Efficiency Scores are **not included**.

## Installation

```bash
git clone https://github.com/TayrinTunzina/GreenAI-Metric-Collection.git
cd GreenAI-Metric-Collection
pip install -r dependencies.txt
```

## Usage

The execution scripts are located in the `scripts/` folder.  
Each script is a Python wrapper that measures runtime, memory, energy, and carbon footprint for the target program.  

You need to **update the file paths inside each script** to point to your own code files.

**📝Important:** Provide an 'input.txt' file containing the required input for your code; the script will use it automatically.

### 🔹 Python
```bash
scripts/benchmark_python.py

# Inside benchmark_python.py, set your target Python file and base directory:

python_file = r"path/to/your/code/example.py"
base_dir = r"path/to/your/python/projects"
```
No compilation needed for Python.

### 🔹 C++
```bash
scripts/benchmark_cpp.py

# Inside benchmark_cpp.py, configure your compiled .exe or binary file:

exe_path = r"path/to/your/program/example.exe"
base_dir = r"path/to/your/cpp/projects"
```
**Note:** Compile your C++ files before running the benchmark:
```bash
g++ path/to/your/code/example.cpp -o path/to/your/program/example.exe
```

### 🔹 Java
```bash
scripts/benchmark_java.py

# Inside benchmark_java.py, set your compiled Java class path and main class name:

java_class_path = r"path/to/your/java/project"
class_name = "YourMainClass"
base_dir = r"path/to/your/java/projects"
```
**Note:** To compile and run without class conflicts:

  **1.** Open Command Prompt in the folder containing your `.java` files.
  
  **2.** Compile only the required file:

```bash
javac YourFileName.java
```
  **3.** Run the program using the main class name.
  
💡 Avoid using `javac *.java` if the folder contains multiple files with the same class names.

## Dataset

All AI-generated code solutions are available in the `datasets/` folder, organized by language.

## HackerRank Tasks

The programming tasks used to generate the dataset are listed in:

```bash
hackerrank_tasks.txt
```
## Citation

```bash
T. Tunzina et al., "GreenAI: A Comparative Analysis of Environmental Efficiency in LLM-Generated Code," in IEEE Access, vol. 14, pp. 18654-18672, 2026, doi: 10.1109/ACCESS.2026.3658813.
```

## License

Copyright (c) 2025 Tayrin Tunzina

This project is licensed under the Apache License 2.0.

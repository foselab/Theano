from z3 import *


z3solver=Solver();



file_path = r'C:\Users\bened\OneDrive\Documenti\MATLAB\Examples\R2023a\slrequirements\ObserverExampleModelExample\Theano\tabella1.txt'

input_data = []
requirements = []

with open(file_path, 'r') as file:
    section = None

    for line in file:
        line = line.strip()

        if line == '------- Input Data -----':
            section = 'input'
        elif line == '------- Requirements -----':
            section = 'requirements'
        elif section == 'input' and line:
            name, data_type = line.split(',')
            input_data.append((name, data_type))
        elif section == 'requirements' and line:
            requirement = line.split(' > ')
            requirements.append((requirement[0], float(requirement[1])))

print("Input Data:")
for name, data_type in input_data:
    print(f"{name}: {data_type}")

print("\nRequirements:")
for variable, threshold in requirements:
    print(f"{variable} > {threshold}")



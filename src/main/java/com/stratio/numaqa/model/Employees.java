package com.stratio.numaqa.model;

import java.util.List;
import java.util.Iterator;

public class Employees {

    private List<Employee> employees;
    private final String csvFile = "./src/main/resources/empleados.csv";

    public Employees() throws Exception {
        this.loadEmployees();
    }

    private void loadEmployees() throws Exception {
        DataHandler dataHandler = new DataHandler();
        try {
            this.employees = dataHandler.readCSVFile(this.csvFile);
        } catch (Exception e) {
            throw new Exception("Problem reading csv file: " + e.getMessage());
        }
    }

    public Employee findEmployee(Integer id) throws Exception {
        Iterator<Employee> it = employees.iterator();
        Boolean found = false;
        Employee employee = null;

        while(it.hasNext() && !found) {
            employee = it.next();
            if (employee.getId().equals(id)) {
                found = true;
            }
        }

        if (!found) {
            throw new Exception("Element not found");
        }

        return employee;
    }

    public Employee modifyEmployee(Integer id, EmployeeBase mods) throws Exception {
        Iterator<Employee> it = employees.iterator();
        Boolean found = false;
        Employee employee = null;

        while(it.hasNext() && !found) {
            employee = it.next();
            if (employee.getId().equals(id)) {
                found = true;
                employee.setAddress(mods.getAddress());
                employee.setAge(mods.getAge());
                employee.setIdNumber(mods.getIdNumber());
                employee.setName(mods.getName());
                employee.setSurname(mods.getSurname());
                employee.setSalary(mods.getSalary());
                employee.setRole(mods.getRole());
            }
        }

        if (!found) {
            throw new Exception("Element not found");
        }

        return employee;
    }

    public Employee createEmployee(Integer id, EmployeeBase newEmployee) {
        Employee employee = new Employee(id, newEmployee.getName(),
                                             newEmployee.getSurname(),
                                             newEmployee.getAge(),
                                             newEmployee.getAddress(),
                                             newEmployee.getIdNumber(),
                                             newEmployee.getSalary(),
                                             newEmployee.getRole());

        employees.add(employee);
        return employee;
    }

    public void deleteEmployee(Integer id) throws Exception {
        Iterator<Employee> it = employees.iterator();
        Boolean found = false;
        Employee employee = null;

        while(it.hasNext() && !found) {
            employee = it.next();
            if (employee.getId().equals(id)) {
                employees.remove(employee);
            }
        }

        if (!found) {
            throw new Exception("Element not found");
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

}

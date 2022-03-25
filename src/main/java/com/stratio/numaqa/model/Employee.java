package com.stratio.numaqa.model;

public class Employee {

    private int id;
    private String name;
    private String surname;
    private int age;
    private String address;
    private String idNumber;
    private int salary;
    private String role;

    public Employee(Integer id, String name, String surname, Integer age, String address, String idNumber, Integer salary, String role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.idNumber = idNumber;
        this.salary = salary;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getRole() {
        return role;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

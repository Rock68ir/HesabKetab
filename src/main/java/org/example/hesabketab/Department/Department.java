package org.example.hesabketab.Department;

import org.example.hesabketab.Employee.Employee;

import java.io.Serializable;

public class Department implements Serializable {
    String name;
    int managerBase;
    Employee manager;

    public Department(Employee manager , String name , int managerBase) {
        this.manager = manager;
        this.name = name;
        this.managerBase = managerBase;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getManagerBase() {
        return managerBase;
    }

    public void setManagerBase(int managerBase) {
        this.managerBase = managerBase;
    }
}
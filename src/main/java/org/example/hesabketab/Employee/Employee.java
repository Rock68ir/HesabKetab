package org.example.hesabketab.Employee;

import org.example.hesabketab.Department.Department;
import org.example.hesabketab.Department.DepartmentDataManager;
import org.example.hesabketab.Salaries.Salary;
import org.example.hesabketab.Status.GENDER;
import org.example.hesabketab.Status.STATUS;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Employee implements Serializable {
    private int ID;
    private String firstName;
    private String lastName;
    private String codeID;
    private LocalDate birthDate;
    private ArrayList<Salary> Salaries;
    private boolean isManager;
    private Department department;
    private STATUS status;
    private GENDER gender;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCodeID() {
        return codeID;
    }

    public void setCodeID(String codeID) {
        this.codeID = codeID;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public ArrayList<Salary> getSalaries() {
        return Salaries;
    }

    public void setSalaries(ArrayList<Salary> salaries) {
        Salaries = salaries;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }

    public Employee(int ID, String firstName, String lastName, String codeID, LocalDate birthDate, ArrayList<Salary> salaries, boolean isManager, STATUS status , GENDER gender , Department department) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.codeID = codeID;
        this.birthDate = birthDate;
        Salaries = salaries;
        this.isManager = isManager;
        this.status = status;
        this.gender = gender;
        this.department = department;
    }
    @Override
    public boolean equals(Object in){
        return in instanceof Employee && ((Employee) in).getID() == this.ID;
    }
}

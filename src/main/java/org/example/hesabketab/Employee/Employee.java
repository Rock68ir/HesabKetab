package Employee;

import Salaries.Salary;
import Status.STATUS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Employee implements Serializable {
    private int ID;
    private String firstName;
    private String lastName;
    private String codeID;
    private Date birthDate;
    private ArrayList<Salary> Salaries;
    private boolean isManeger;
    private STATUS status;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public ArrayList<Salary> getSalaries() {
        return Salaries;
    }

    public void setSalaries(ArrayList<Salary> salaries) {
        Salaries = salaries;
    }

    public boolean isManeger() {
        return isManeger;
    }

    public void setManeger(boolean maneger) {
        isManeger = maneger;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public Employee(int ID, String firstName, String lastName, String codeID, Date birthDate, ArrayList<Salary> salaries, boolean isManeger, STATUS status) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.codeID = codeID;
        this.birthDate = birthDate;
        Salaries = salaries;
        this.isManeger = isManeger;
        this.status = status;
    }

}

package org.example.hesabketab.FileHandler;

import org.example.hesabketab.Employee.Employee;
import org.example.hesabketab.Salaries.Salary;
import org.example.hesabketab.Status.GENDER;
import org.example.hesabketab.Status.STATUS;
import org.example.hesabketab.Salaries.Salary;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public interface ISearchAndStatics {
     ArrayList<Employee> FindByName(String name) throws Exception;
     ArrayList<Employee> FindByID(String ID) throws Exception;
    ArrayList<Employee> FindByLastName(String lastName) throws Exception;
    ArrayList<Employee> FindByDate(LocalDate start , LocalDate end) throws Exception;
     ArrayList<Salary> FindBySalary(short Type) throws Exception;
    ArrayList<Employee> FindByGender(int ID) throws Exception;
    ArrayList<STATUS> FindByStatus(int ID) throws Exception;
    ArrayList<Employee> FindByManager(boolean condition);
}

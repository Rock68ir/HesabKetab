package org.example.hesabketab.Employee;

import org.example.hesabketab.FileHandler.ISearchAndStatics;
import org.example.hesabketab.Salaries.Salary;
import org.example.hesabketab.Status.GENDER;
import org.example.hesabketab.Status.STATUS;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class EmployeeSearch implements ISearchAndStatics {
    ArrayList<Employee> employees;
    ArrayList<Employee> result;
    public EmployeeSearch(ArrayList<Employee> employees) {
        this.employees = employees;
        result = new ArrayList<>();
    }
    @Override
    public ArrayList<Employee> FindByName(String name) throws Exception {
        for (Employee employee: employees
             ) {
            if(employee.getFirstName().equals(name)){
                result.add(employee);
            }
        }
        return result;
    }

    @Override
    public ArrayList<Employee> FindByID(String ID) throws Exception {
        for (Employee employee: employees
        ) {
            if(employee.getCodeID().equals(ID)){
                result.add(employee);
            }
        }
        return result;
    }

    @Override
    public ArrayList<Employee> FindByLastName(String lastName) throws Exception {
        for (Employee employee: employees
        ) {
            if(employee.getLastName().equals(lastName)){
                result.add(employee);
            }
        }
        return result;
    }
    @Override
    public ArrayList<Employee> FindByDate(LocalDate start, LocalDate end) throws Exception {

        for (Employee employee: employees
        ) {
            if(employee.getBirthDate().isBefore(end) && employee.getBirthDate().isAfter(start)){
                result.add(employee);
            }
        }
        return result;
    }
    @Override
    public ArrayList<Salary> FindBySalary(short Type) throws Exception {
        ArrayList<Salary> list = new ArrayList<>();

        for (Employee employee: employees
        ) {
            for (Salary salary : employee.getSalaries()
                 ) {
                if(salary.getType() == Type){
                    list.add(salary);
                }
            }
        }
        return list;
    }

    @Override
    public ArrayList<Employee> FindByGender(int ID) throws Exception {
        for (Employee employee: employees
        ) {
            if(employee.getStatus() == STATUS.ACTIVE){
                result.add(employee);
            }
        }
        return result;
    }

    @Override
    public ArrayList<STATUS> FindByStatus(int ID) throws Exception {
        return null;
    }
}

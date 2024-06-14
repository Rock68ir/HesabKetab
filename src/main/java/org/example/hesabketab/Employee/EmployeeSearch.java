package Employee;

import FileHandler.ISearchAndStatics;
import Salaries.Salary;
import Status.GENDER;
import Status.STATUS;

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
    public ArrayList<Employee> FindByDate(Date start, Date end) throws Exception {

        for (Employee employee: employees
        ) {
            if(employee.getBirthDate().before(end) && employee.getBirthDate().after(start)){
                result.add(employee);
            }
        }
        return result;
    }
    @Override
    public ArrayList<Employee> FindBySalary(short Type) throws Exception {
        ArrayList<Salary> list = new ArrayList<>();

        for (Employee employee: employees
        ) {
            for (Salary salary: employee.getSalaries()
                 ) {
                if(salary.getType() == ID){
                    list.add(salary);
                }
            }
        }
        return list;
    }

    @Override
    public ArrayList<GENDER> FindByGender(int ID) throws Exception {
        for (Employee employee: employees
        ) {
            if(employee.getStatus() ==)){
                result.add(employee);
            }
        }
    }

    @Override
    public ArrayList<STATUS> FindByStatus(int ID) throws Exception {
        return null;
    }
}

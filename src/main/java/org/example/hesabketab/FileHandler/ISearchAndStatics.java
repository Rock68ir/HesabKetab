package FileHandler;

import Employee.Employee;
import Salaries.Salary;
import Status.GENDER;
import Status.STATUS;

import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.Date;

public  interface ISearchAndStatics {
     ArrayList<Employee> FindByName(String name) throws Exception;
    ArrayList<Employee> FindByLastName(String lastName) throws Exception;
    ArrayList<Employee> FindByDate(Date start , Date end) throws Exception;
     ArrayList<Employee> FindBySalary(short Type) throws Exception;
    ArrayList<GENDER> FindByGender(int ID) throws Exception;
    ArrayList<STATUS> FindByStatus(int ID) throws Exception;

}

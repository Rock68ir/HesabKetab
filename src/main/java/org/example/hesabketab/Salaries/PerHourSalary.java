package Salaries;

import Status.STATUS;

import java.util.Date;

public class PerHourSalary extends Salary{
    private int perHour;

    public PerHourSalary(Date start, Date end, int managerBase, STATUS status, short type, int base , int perHour) {
        super(start, end, managerBase, status, type, base);
        this.perHour = perHour;
    }

    @Override
    protected int CalcuteIncome() {
        return base + (24 * perHour);
    }
    public int PerDay(){
        return CalcuteIncome();
    }
    public int PerMonth(){
        return PerDay() * 30;
    }
}

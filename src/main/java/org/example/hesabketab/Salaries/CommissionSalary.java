package Salaries;

import Status.STATUS;

import java.util.Date;

public class CommissionSalary extends Salary{
    private int percentage;

    public CommissionSalary(Date start, Date end, int managerBase, STATUS status, short type, int base , int percentage) {
        super(start, end, managerBase, status, type, base);
        this.percentage = percentage;
    }
    @Override
    protected int CalcuteIncome() {
        return base * percentage;
    }
    public int PerMonth(){
        return CalcuteIncome() * 30;
    }
}

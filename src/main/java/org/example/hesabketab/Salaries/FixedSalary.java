package Salaries;

import Status.STATUS;

import java.util.Date;

public class FixedSalary extends Salary{

    public FixedSalary(Date start, Date end, int managerBase, STATUS status, short type, int base) {
        super(start, end, managerBase, status, type, base);
    }

    @Override
    public int CalcuteIncome(){
        return super.base;
    }
    public int CalcuteIncomePerMonth(){
        return CalcuteIncome() * 30;
    }
}

package Salaries;

import Status.STATUS;

import java.util.Date;

public class FixedCommissionSalary extends CommissionSalary{
    private int fixedAmount;

    public FixedCommissionSalary(Date start, Date end, int managerBase, STATUS status, short type, int base, int percentage , int fixedAmount) {
        super(start, end, managerBase, status, type, base, percentage);
        this.fixedAmount = fixedAmount;
    }


    @Override
    protected int CalcuteIncome() {
        return super.CalcuteIncome() + fixedAmount;
    }
    public int PerMonth(){
        return CalcuteIncome() * 30;
    }
}

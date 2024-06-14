package org.example.hesabketab.Salaries;

import org.example.hesabketab.Status.STATUS;

import java.time.LocalDate;


public class FixedCommissionSalary extends CommissionSalary{
    private int fixedAmount;

    public FixedCommissionSalary(LocalDate start, LocalDate end, int managerBase, STATUS status, short type, int base, int percentage , int fixedAmount) {
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

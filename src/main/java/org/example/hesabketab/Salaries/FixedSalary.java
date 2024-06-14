package org.example.hesabketab.Salaries;

import org.example.hesabketab.Status.STATUS;

import java.time.LocalDate;

public class FixedSalary extends Salary{

    public FixedSalary(LocalDate start, LocalDate end, int managerBase, STATUS status, short type, int base) {
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

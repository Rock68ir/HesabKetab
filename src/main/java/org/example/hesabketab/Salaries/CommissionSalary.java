package org.example.hesabketab.Salaries;

import org.example.hesabketab.Status.STATUS;

import java.time.LocalDate;

public class CommissionSalary extends Salary{
    private double percentage;

    public CommissionSalary(LocalDate start, LocalDate end, int managerBase, STATUS status, short type, int base , int percentage) {
        super(start, end, managerBase, status, type, base);
        this.percentage = percentage;
    }
    @Override
    public int CalcuteIncome() {
        return (int) (base * percentage /100);
    }
}

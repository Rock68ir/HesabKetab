package org.example.hesabketab.Salaries;

import org.example.hesabketab.Status.STATUS;

import java.time.LocalDate;

public class PerHourSalary extends Salary{
    private int perHour;
    private int workingHours;

    public PerHourSalary(LocalDate start, LocalDate end, int managerBase, STATUS status, short type, int base , int perHour , int workingHours) {
        super(start, end, managerBase, status, type, base);
        this.workingHours = workingHours;
        this.perHour = perHour;
    }

    @Override
    public int CalcuteIncome() {
        return workingHours*perHour;
    }
}

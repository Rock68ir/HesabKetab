package org.example.hesabketab.Salaries;
import org.example.hesabketab.Status.STATUS;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Salary implements Serializable {
    public Salary(LocalDate start, LocalDate end, int managerBase, STATUS status, short type, int base) {
        this.start = start;
        this.end = end;
        this.managerBase = managerBase;
        this.status = status;
        this.type = type;
        this.base = base;
    }

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    protected LocalDate start;
    protected LocalDate  end;
    protected int managerBase;
    protected STATUS status;
    private short type;
    protected int base;
    protected abstract int CalcuteIncome();
}

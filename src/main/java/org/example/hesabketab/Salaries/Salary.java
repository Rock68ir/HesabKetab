package Salaries;
import Status.STATUS;

import java.util.Date;

public abstract class Salary {
    public Salary(Date start, Date end, int managerBase, STATUS status, short type, int base) {
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

    protected Date start;
    protected Date  end;
    protected int managerBase;
    protected STATUS status;
    private short type;
    protected int base;
    protected abstract int CalcuteIncome();
}

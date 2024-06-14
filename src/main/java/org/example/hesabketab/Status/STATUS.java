package Status;

public enum STATUS {
    ACTIVE(1 , "همکاری"),
    RETIREMENT(2 ,"بازنشتگی"),
    LEAVEWITHOUTPAYMENT(3 , "مرخصی بدون حقوق"),
    FIRED(4 , "اخراج"),
    DISSOCIATE(5,  "قطع همکاری");
    int ID;
    String Description;

    STATUS(int ID, String description) {
        this.ID = ID;
        Description = description;
    }

    public int getID() {
        return ID;
    }

    public String getDescription() {
        return Description;
    }
}

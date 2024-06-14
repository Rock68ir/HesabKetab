package Status;

public enum GENDER {
    MALE(1 , "مدکز"),
    FEMALE(2 , "مونث");
    private int ID;
    private String Description;
    GENDER(int ID, String description) {
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

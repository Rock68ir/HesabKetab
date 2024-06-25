import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Rand {
   private final Random random = new Random(LocalDateTime.now().getSecond());
   private final int rand = random.nextInt(1000000000);
   public static final ArrayList<String> maleNames = new ArrayList<>(Arrays.asList(
           "Liam", "Noah", "Jackson", "Lucas", "Oliver", "Ethan", "Mason", "James", "Elijah", "Aiden",
           "Benjamin", "William", "Alexander", "Henry", "Jacob", "Michael", "Daniel", "Matthew", "Samuel", "David",
           "Joseph", "Carter", "Gabriel", "Owen", "John", "Wyatt", "Luke", "Jack", "Andrew", "Isaac",
           "Theodore", "Julian", "Levi", "Joshua", "Nathan", "Ryan", "Eli", "Hunter", "Dylan", "Sebastian",
           "Caleb", "Nicholas", "Christian", "Landon", "Jonathan", "Jaxon", "Aaron", "Isaiah", "Thomas", "Charles",
           "Josiah", "Hudson", "Lincoln", "Brayden", "Easton", "Mateo", "Cooper", "Xavier", "Grayson", "Levi",
           "Isaiah", "Ryder", "Colton", "Elias", "Tristan", "Leonardo", "Sawyer", "Roman", "Camden", "Kai",
           "Bennett", "Vincent", "Kingston", "Zane", "Axel", "Mateo", "Miles", "Wesley", "Westley", "Silas",
           "Emmett", "Peter", "Jasper", "Weston", "Micah", "Damian", "Harrison", "Ezekiel", "Ezra", "Lorenzo",
           "August", "Grayson", "Sawyer", "Brandon", "King", "Jasper", "Finn", "Nicholas", "Maddox", "Dominic"
   ));
    public static final ArrayList<String> femaleNames = new ArrayList<>(Arrays.asList(
            "Emma", "Olivia", "Ava", "Isabella", "Sophia", "Charlotte", "Mia", "Amelia", "Harper", "Evelyn",
            "Abigail", "Emily", "Ella", "Madison", "Scarlett", "Luna", "Chloe", "Grace", "Lily", "Avery",
            "Sofia", "Eleanor", "Hannah", "Natalie", "Addison", "Elizabeth", "Zoey", "Victoria", "Lillian", "Aubrey",
            "Bella", "Stella", "Hazel", "Ellie", "Paisley", "Aria", "Nova", "Camila", "Penelope", "Layla",
            "Aurora", "Claire", "Violet", "Skylar", "Everly", "Isla", "Emilia", "Lucy", "Audrey", "Zoe",
            "Leah", "Savannah", "Brooklyn", "Maya", "Stella", "Elena", "Willow", "Aaliyah", "Reagan", "Faith",
            "Alexa", "Naomi", "Serenity", "Autumn", "Adeline", "Mackenzie", "Hailey", "Kaylee", "Sophie", "Brielle",
            "Sadie", "Genesis", "Piper", "Ruby", "Emery", "Lydia", "Clara", "Madelyn", "Alyssa", "Julia",
            "Taylor", "Kylie", "Eva", "Nora", "Caroline", "Nova", "Alice", "Quinn", "Vivian", "Gianna",
            "Eliana", "Ivy", "Lila", "Maria", "Sarah", "Eliza", "Luna", "Gabriella", "Kinsley", "Allison"
    ));
    public static final ArrayList<String> maleLastNames = new ArrayList<>(Arrays.asList(
            "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez",
            "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "Jackson", "White",
            "Harris", "Martin", "Thompson", "Clark", "Lewis", "Hall", "Scott", "Young", "Allen", "King",
            "Baker", "Green", "Adams", "Hill", "Carter", "Mitchell", "Roberts", "Turner", "Phillips", "Campbell",
            "Evans", "Murphy", "Torres", "Rivera", "Bailey", "Reed", "Ward", "Gray", "Sanchez", "Ortiz",
            "Collins", "Ramirez", "Griffin", "Washington", "Simmons", "Coleman", "Price", "Brooks", "Sanders", "Ross",
            "Butler", "Jenkins", "Stewart", "Perry", "Simmons", "Parker", "Howard", "Gonzalez", "Hughes", "Foster",
            "Long", "Butler", "Powell", "Griffin", "Perry", "Wright", "Nelson", "Walker", "Howard", "Martinez"
    ));
    public static final ArrayList<String> femaleLastNames = new ArrayList<>(Arrays.asList(
            "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez",
            "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "Jackson", "White",
            "Harris", "Martin", "Thompson", "Clark", "Lewis", "Hall", "Scott", "Young", "Allen", "King",
            "Baker", "Green", "Adams", "Hill", "Carter", "Mitchell", "Roberts", "Turner", "Phillips", "Campbell",
            "Evans", "Murphy", "Torres", "Rivera", "Bailey", "Reed", "Ward", "Gray", "Sanchez", "Ortiz",
            "Collins", "Ramirez", "Griffin", "Washington", "Simmons", "Coleman", "Price", "Brooks", "Sanders", "Ross",
            "Butler", "Jenkins", "Stewart", "Perry", "Simmons", "Parker", "Howard", "Gonzalez", "Hughes", "Foster",
            "Long", "Butler", "Powell", "Griffin", "Perry", "Wright", "Nelson", "Walker", "Howard", "Martinez"
    ));
    private String GenerateFirstName(){
        if(rand %2 == 0){
            return maleNames.get(rand % 100);
        }
        else {
            return femaleNames.get(rand % 100);
        }
    }
    private String GenerateLastName(){
        if(rand %2 == 0){
            return  maleLastNames.get(rand % 100) ;
        }
        else {
            return femaleLastNames.get(rand % 100) ;
        }
    }
    private int GenerateID(ArrayList<Employee> employees){
        boolean isRepeated = true;
        int id = rand%10000;
        while (isRepeated) {
            for (Employee e : employees
            ) {
                if(e.getID() == id%10000){
                    isRepeated = false;
                }
            }
            id += 1;
        }
        return id;
    }
    private String GenerateCodeID(){
        return String.valueOf(rand%1000000000);
    }
    private GENDER GenerateGender(){
        if(rand %2 == 0){
            return GENDER.MALE ;
        }
        else {
            return GENDER.FEMALE ;
        }
    }
    private boolean GenerateisManager(){
        return rand % 2 == 0;
    }
    private LocalDate GenerateBirthDay(){
        int year = rand % 64 + 1940;
        int month = rand % 11 + 1;
        int day = rand % 30 + 1;
        return LocalDate.of(year , month , day);
    }
    private STATUS GenerateStatus(int random){
        STATUS status = STATUS.ACTIVE;
        for (STATUS s: STATUS.values()
             ) {
            if (s.ID == random){
                status = s;
                break;
            }
        }
        return status;
    }
    private Stack<LocalDate> GenerateDateForSalary(LocalDate birthDate , int amount){
        LocalDate date;
        Stack<LocalDate> stack = new Stack<>();
        int year , month , day;
            do {
                 year =  random.nextInt(64) + 1940 + 20;
                 month =  random.nextInt(12) + 1;
                 day =  random.nextInt(28) + 1;
                date = LocalDate.of(year, month, day);
            } while (birthDate.isBefore(date));
        stack.add(date);
        for (int j=0 ; j < 2 * amount - 1 ; j++){
           while (true){
               year =  random.nextInt(64) + 1940 + 20;
               month =  random.nextInt(12) + 1;
               day =  random.nextInt(28) + 1;
               date = LocalDate.of(year, month, day);
               if (stack.peek().isBefore(date)){
                   stack.add(date);
                   break;
               }
           }
        }
       return stack;
    }
    private ArrayList<Salary> GenerateSalaries(LocalDate birthdayDate , ArrayList<Department> departments){
        Random radom = new Random();
        int department = radom.nextInt(departments.size());
        int randStatus = radom.nextInt(5) + 1;
        int amount = rand%4;
        int randBase = radom.nextInt(1000000000)+1;
        int randTime = radom.nextInt(10000)+1;
        int randPercentage = radom.nextInt(100)+1;
        int active = radom.nextInt(2);
        ArrayList<Salary> salaries = new ArrayList<>();
        Stack<LocalDate> dates = GenerateDateForSalary(birthdayDate , amount);
        int model = random.nextInt(4);
            for (int i = 0; i < amount; i++) {
                switch (model) {
                    case 0 -> {
                        Salary fixedSalary = new FixedSalary(dates.pop(), dates.pop(), departments.get(department).getManagerBase(), GenerateStatus(randStatus), (short) 1, randBase);
                        salaries.add(fixedSalary);
                    }
                    case 1 -> {
                        Salary perHourSalary = new PerHourSalary(dates.pop(), dates.pop(), departments.get(department).getManagerBase(), GenerateStatus(randStatus), (short) 2, randBase, randTime);
                        salaries.add(perHourSalary);
                    }
                    case 2 -> {
                        Salary commissionSalary = new CommissionSalary(dates.pop(), dates.pop(), departments.get(department).getManagerBase(), GenerateStatus(randStatus), (short) 2, randBase, randPercentage);
                        salaries.add(commissionSalary);
                    }
                    case 3 -> {
                        CommissionSalary commissionSalary = new FixedCommissionSalary(dates.pop(), dates.pop(), departments.get(department).getManagerBase(), GenerateStatus(randStatus), (short) 2, randBase, randPercentage, randBase);
                        salaries.add(commissionSalary);
                    }
                }
                 department = radom.nextInt(departments.size());
                 randStatus = radom.nextInt(5) + 1;
                 amount = rand%4;
                 randBase = radom.nextInt(1000000000)+1;
                 randTime = radom.nextInt(10000)+1;
                 randPercentage = radom.nextInt(100)+1;
            }
            if(active == 1){//is active
                switch (model) {
                    case 0 -> {
                        Salary fixedSalary = new FixedSalary(dates.pop(), dates.pop(), departments.get(department).getManagerBase(), STATUS.ACTIVE, (short) 1, randBase);
                        salaries.add(fixedSalary);

                    }
                    case 1 -> {
                        Salary perHourSalary = new PerHourSalary(dates.pop(), dates.pop(), departments.get(department).getManagerBase(), STATUS.ACTIVE, (short) 2, randBase, randTime);
                        salaries.add(perHourSalary);

                    }
                    case 2 -> {
                        Salary commissionSalary = new CommissionSalary(dates.pop(), dates.pop(), departments.get(department).getManagerBase(), STATUS.ACTIVE, (short) 2, randBase, randPercentage);
                        salaries.add(commissionSalary);

                    }
                    case 3 -> {
                        CommissionSalary commissionSalary = new FixedCommissionSalary(dates.pop(), dates.pop(), departments.get(department).getManagerBase(), STATUS.ACTIVE, (short) 2, randBase, randPercentage, randBase);
                        salaries.add(commissionSalary);

                    }
                }
            }
            else {
                switch (model) {
                    case 0 -> {
                        Salary fixedSalary = new FixedSalary(dates.pop(), dates.pop(), departments.get(department).getManagerBase(), GenerateStatus(randStatus), (short) 1, randBase);
                        salaries.add(fixedSalary);

                    }
                    case 1 -> {
                        Salary perHourSalary = new PerHourSalary(dates.pop(), dates.pop(), departments.get(department).getManagerBase(), GenerateStatus(randStatus), (short) 2, randBase, randTime);
                        salaries.add(perHourSalary);

                    }
                    case 2 -> {
                        Salary commissionSalary = new CommissionSalary(dates.pop(), dates.pop(), departments.get(department).getManagerBase(), GenerateStatus(randStatus), (short) 2, randBase, randPercentage);
                        salaries.add(commissionSalary);

                    }
                    case 3 -> {
                        CommissionSalary commissionSalary = new FixedCommissionSalary(dates.pop(), dates.pop(), departments.get(department).getManagerBase(), GenerateStatus(randStatus), (short) 2, randBase, randPercentage, randBase);
                        salaries.add(commissionSalary);

                    }
                }
            }
        return salaries;
    }
    public ArrayList<Employee> GenerateRandomEmployee(int amount , ArrayList<Employee> e){
       ArrayList<Employee> result = new ArrayList<>();
        LocalDate BD;
        for (int i = 0 ; i < amount ; i++){
            BD = GenerateBirthDay();
            ArrayList<Salary> salaries = GenerateSalaries(BD , new ArrayList<>());
            Salary statusSalary = salaries.get(salaries.size() - 1);
            Employee employee = new Employee(GenerateID(e) , GenerateFirstName() , GenerateLastName() , GenerateCodeID() , GenerateBirthDay()  , salaries, GenerateisManager() , statusSalary.getStatus() ,  GenerateGender());
            result.add(employee);
        }
        return result;
    }
}


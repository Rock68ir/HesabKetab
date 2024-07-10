import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandDep {
    public static final List<String> departments = Arrays.asList(
            "Accounting", "Advertising", "Aeronautics", "Agriculture", "Anthropology",
            "Architecture", "Art", "Astronomy", "Biology", "Biomedical Engineering",
            "Business Administration", "Chemical Engineering", "Chemistry", "Civil Engineering",
            "Classics", "Computer Science", "Criminology", "Dance", "Dentistry", "Design",
            "Economics", "Education", "Electrical Engineering", "English", "Environmental Science",
            "Film Studies", "Finance", "Fine Arts", "Food Science", "Forestry",
            "Genetics", "Geography", "Geology", "Graphic Design", "Health Administration",
            "History", "Hospitality Management", "Human Resources", "Industrial Engineering",
            "Information Technology", "International Relations", "Journalism", "Kinesiology",
            "Law", "Library Science", "Linguistics", "Management", "Marketing",
            "Materials Science", "Mathematics", "Mechanical Engineering", "Medicine",
            "Meteorology", "Microbiology", "Music", "Nursing", "Nutrition",
            "Occupational Therapy", "Oceanography", "Operations Management", "Pharmacy",
            "Philosophy", "Physical Education", "Physics", "Political Science", "Psychology",
            "Public Administration", "Public Health", "Real Estate", "Religious Studies",
            "Robotics", "Social Work", "Sociology", "Software Engineering", "Speech Pathology",
            "Sports Management", "Statistics", "Supply Chain Management", "Sustainability",
            "Theatre", "Tourism Management", "Urban Planning", "Veterinary Science", "Visual Arts",
            "Web Development", "Women's Studies", "Zoology", "Ethnic Studies", "Gender Studies",
            "Humanities", "Interdisciplinary Studies", "International Business", "Marine Biology",
            "Middle Eastern Studies", "Military Science", "Nanotechnology", "Neuroscience",
            "Peace Studies", "Petroleum Engineering", "Public Policy", "Radiology"
    );
    Random random = new Random(LocalDateTime.now().getSecond());
    private static int GenerateBase(){

        return random.nextInt(1000000000) + 1;
    }
    private static String GenerateName(ArrayList<Department> departments){
        String name;
        boolean flag;
        do{
            name = departments.get(random.nextInt(departments.size())).getName();
            flag = true;
            for (Department d: departments
                 ) {
                if(d.getName().equals(name)){
                    flag = false;
                    break;
                }
            }
        }while (flag);
        return name;
    }
    private static boolean ManagerAllCheckr(ArrayList<Employee> employees){
        for (Employee e: employees
             ) {
            if(!e.isManeger()){
                return true;
            }
        }
        return false;
    }
    private static Employee setManager(ArrayList<Employee> employees){
        if (!ManagerAllCheckr(employees)){
            return null;
        }
        int random = this.random.nextInt(employees.size());
        Employee manager = employees.get(random);
        while (true){
            if(!manager.isManeger()){
                break;
            }
            random = this.random.nextInt(employees.size());
            manager = employees.get(random);
        }
        return manager;
    }
    public static ArrayList<Department> GenerateDepartment(int amount){
        for (int i = 0 ; i < amount ; i++){
            Department department = new Department(GenerateBase() , setManager(null) , GenerateName(null));
        }
        return null;
    }

}

import java.util.ArrayList;
import java.time.LocalDate;
import static java.time.Period.between;

public class Adult extends Person implements Age {
    public static final int fakeAge = 40;
    private int age;
    public Adult(String firstName, String lastName, String dateOfBirth, String gender, String mobileNumber,
            int[] fivePersonalityTraits, boolean privacySetting) throws Exception {
        super(firstName, lastName, dateOfBirth, gender, mobileNumber, fivePersonalityTraits, privacySetting);
        this.setAge();
    }

    public Adult(String firstName, String lastName, String dateOfBirth, String gender, String mobileNumber,
            int[] fivePersonalityTraits, ArrayList<Activity> activities, boolean privacySetting) throws Exception {
        super(firstName, lastName, dateOfBirth, gender, mobileNumber, fivePersonalityTraits, activities, privacySetting);
        this.setAge();
    }

    public int getAge() {
        if(dataIsPrivate) return fakeAge;
        return this.age;
    }

    public void setAge() throws Exception {
        int age = between(LocalDate.parse(this.getDateOfBirth()),LocalDate.now()).getYears();
        if(age<25){
            System.out.println("Persons age 25 and above are considered adult.");
            throw new Exception("IncorrectPersonDetails");
        }
        else this.age = age;
    }

    @Override
    public String toString(){
        return this.getFirstName() + " " + this.getLastName() + " ("+ this.getAge()+ this.getGender() + ") is feeling " + this.getFeeling() 
        + ".\nTheir current activities are " + this.getActivities() + ".";
    }
    
}
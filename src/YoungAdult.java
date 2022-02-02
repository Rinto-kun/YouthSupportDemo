import java.util.ArrayList;
import java.time.LocalDate;
import static java.time.Period.between;

public class YoungAdult extends Person implements Age {
    public static final int fakeAge = 20;
    private int age;
    public YoungAdult(String firstName, String lastName, String dateOfBirth, String gender, String mobileNumber,
            int[] fivePersonalityTraits, boolean privacySetting) throws Exception {
        super(firstName, lastName, dateOfBirth, gender, mobileNumber, fivePersonalityTraits, privacySetting);
        this.setAge();
    }

    public YoungAdult(String firstName, String lastName, String dateOfBirth, String gender, String mobileNumber,
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
        if(age<16||age>25){
            System.out.println("Persons between age 16 and 25 are considered young adult.");
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

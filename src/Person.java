import java.time.LocalDate;
import java.util.ArrayList;


public class Person {
    // Big 5 Personality Traits:
    // Conscientiousness
    // Agreeableness
    // Neuroticism
    // Openness
    // Extraversion/Extroversion
    protected String firstName;
    protected String lastName;
    protected LocalDate dateOfBirth;
    protected String gender;
    protected String mobileNumber;
    protected int[] fivePersonalityTraits = new int[5];
    protected ArrayList<Activity> activities;
    protected int satisfactionIndex = (int)0;
    protected String feeling;
    protected boolean dataIsPrivate = false;

    public static final Person fakePerson = new Person("[REDACTED]","[REDACTED]","U");

    public Person(String firstName, String lastName, String dateOfBirth, String gender, String mobileNumber,
            int[] fivePersonalityTraits, boolean dataIsPrivate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.setDateOfBirth(dateOfBirth);
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.fivePersonalityTraits = fivePersonalityTraits;
        this.dataIsPrivate = dataIsPrivate;
    }

    public Person(String firstName, String lastName, String dateOfBirth, String gender, String mobileNumber,
            int[] fivePersonalityTraits, ArrayList<Activity> activities, boolean dataIsPrivate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.setDateOfBirth(dateOfBirth);
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.fivePersonalityTraits = fivePersonalityTraits;
        this.setActivities(activities);
        this.dataIsPrivate = dataIsPrivate;
}

    public Person(String firstName, String lastName, String gender) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setGender(gender);
    }

    public String getFirstName() {
        if(dataIsPrivate) return fakePerson.getFirstName();
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        if(dataIsPrivate) return fakePerson.getLastName();
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth.toString();
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
    }

    public String getGender() {
        if(dataIsPrivate) return fakePerson.getGender();
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int[] getFivePersonalityTraits() {
        return fivePersonalityTraits;
    }

    public void setFivePersonalityTraits(int[] fivePersonalityTraits) {
        this.fivePersonalityTraits = fivePersonalityTraits;
    }

    public String getMobileNumber() {
        if(dataIsPrivate) return fakePerson.getMobileNumber();
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public boolean isdataIsPrivate() {
        return dataIsPrivate;
    }

    public void setdataIsPrivate(boolean dataIsPrivate) {
        this.dataIsPrivate = dataIsPrivate;
    }

    public String getFeeling() {
        return feeling;
    }

    public void setFeeling(String feeling) {
        this.feeling = feeling;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<Activity> activities) {
        this.activities = activities;
        this.calculateFeelings();
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
        this.calculateFeelings();
    }

    public void addActivities(ArrayList<Activity> activities) {
        for(Activity activity:activities)
            this.activities.add(activity);
        this.calculateFeelings();
	}

    public void removeActivity(Activity activity){
        this.activities.remove(activity);
        this.calculateFeelings();
    }
    
	public void removeActivities(ArrayList<Activity> activities) {
        for(Activity activity:activities)
            this.activities.remove(activity);
        this.calculateFeelings();
	}

    private void calculateFeelings() {
        this.satisfactionIndex = 0;
        int[] affinity;
        int dummy = 0;
        for (Activity act : this.activities) {
            affinity = act.getPersonalityTraitFeelingAffinity();
            dummy = 0;
            for (int i=0; i < 5; i++)
                if (Math.abs(affinity[i] - fivePersonalityTraits[i]) <= 1)
                    dummy += 1;
            
            if(dummy>2) this.satisfactionIndex += 1;
        }
        this.determineFeelings();
    }

    private void determineFeelings(){

        switch (this.satisfactionIndex) {
            case 0:
                this.setFeeling("Depressed");
                break;
            case 1:
                this.setFeeling("Dissatisfied");
                break;
            case 2:
                this.setFeeling("Bored");
                break;
            case 3:
                this.setFeeling("Satisfied");
                break;
            case 4:
                this.setFeeling("Happy");
                break;
            default:
                this.setFeeling("Overjoyed");
        }
    }

    @Override
    public String toString(){
        return this.getFirstName() + " " + this.getLastName() + " ("+ this.getGender() + ") is feeling " + this.getFeeling() 
        + ".\nTheir current activities are " + this.getActivities() + ".";
    }


}
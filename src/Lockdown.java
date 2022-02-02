import java.util.ArrayList;

public class Lockdown {

    private static ArrayList<Activity> prohibitedActivities;

    public ArrayList<Activity> getProhibitedActivities() {
        return prohibitedActivities;
    }

    public void setProhibitedActivities(ArrayList<Activity> prohibitedActivities) {
        Lockdown.prohibitedActivities = prohibitedActivities;
    }

    public void removeProhibitedActivity(Activity activity){
        for(Activity prohibited:prohibitedActivities){
            if(prohibited.getActivityName()==activity.getActivityName()) {
                prohibitedActivities.remove(activity);
                break;
            }
        }
    }

    public void addProhibitedActivity(Activity activity){
        prohibitedActivities.add(activity);
    }

    public void applyLockdownOnPerson(Person person){
        ArrayList<Activity> prohibitions = new ArrayList<Activity>();
        for(Activity activity:person.getActivities()){
            if(Lockdown.prohibitedActivities.contains(activity)) {
                prohibitions.add(activity);
            }
        }
        person.removeActivities(prohibitions);
    }

    public Lockdown(ArrayList<Activity> prohibitedActivities) {
        Lockdown.prohibitedActivities = prohibitedActivities;
    }
    public Lockdown() {
        Lockdown.prohibitedActivities = null;
    }
}
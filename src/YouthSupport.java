import java.util.ArrayList;

public final class YouthSupport {

    private static ArrayList<Activity> permittedActivities;

    public YouthSupport(ArrayList<Activity> permittedActivities) {
        YouthSupport.permittedActivities = permittedActivities;
	}

    public YouthSupport() {
        YouthSupport.permittedActivities = null;
	}

	public ArrayList<Activity> getPermittedActivities() {
        return permittedActivities;
    }

    public void setPermittedActivities(ArrayList<Activity> permittedActivities) {
        YouthSupport.permittedActivities = permittedActivities;
    }

    public void recommendActivitiesToPerson(Person person){
        int[] activityAffinity;
        int[] personAffinity = person.getFivePersonalityTraits();
        int dummy;
        ArrayList<Activity> recommendedActivities = new ArrayList<Activity>();
        ArrayList<Activity> currentActivities = person.getActivities();
        for (Activity act : YouthSupport.permittedActivities) {

            if(currentActivities.contains(act)) continue;
            
            activityAffinity = act.getPersonalityTraitFeelingAffinity();
            dummy = 0;
            for (int i=0; i < 5; i++) {
                if (Math.abs(activityAffinity[i] - personAffinity[i]) <= 1)
                    dummy += 1;
            }
            if(dummy>2) recommendedActivities.add(act);
        }
        person.addActivities(recommendedActivities);
        }
    }
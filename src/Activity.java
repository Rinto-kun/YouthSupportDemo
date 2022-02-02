import java.time.LocalDateTime;

public class Activity {
    private String activityName;      // How the activity is called;
    private int numberOfParticipants; // Or people the Person has to interract with in order to accomplish this Activity
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int[] personalityTraitFeelingAffinity;

    public String getActivityName() {
        return activityName;
    }

    public int[] getPersonalityTraitFeelingAffinity() {
        return personalityTraitFeelingAffinity;
    }

    public void setPersonalityTraitFeelingAffinity(int[] personalityTraitFeelingAffinity) {
        this.personalityTraitFeelingAffinity = personalityTraitFeelingAffinity;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Activity() {
        this.activityName = "Default";
        this.numberOfParticipants = 1;
        this.startTime = LocalDateTime.now();
        this.endTime = LocalDateTime.now();
        int[] aff = {3,3,3,3,3};
        this.personalityTraitFeelingAffinity = aff;
    }


    public Activity(String activityName, int numberOfParticipants, LocalDateTime startTime, LocalDateTime endTime,
            int[] personalityTraitFeelingAffinity) {
        this.activityName = activityName;
        this.numberOfParticipants = numberOfParticipants;
        this.startTime = startTime;
        this.endTime = endTime;
        this.personalityTraitFeelingAffinity = personalityTraitFeelingAffinity;
    }

    public Activity(String activityName, int numberOfParticipants,
            int[] personalityTraitFeelingAffinity) {
        this.activityName = activityName;
        this.numberOfParticipants = numberOfParticipants;
        this.personalityTraitFeelingAffinity = personalityTraitFeelingAffinity;
    }

    public Activity(String activityName, int[] personalityTraitFeelingAffinity) {
        this.activityName = activityName;
        this.personalityTraitFeelingAffinity = personalityTraitFeelingAffinity;
    }

    public String toString(){
        return this.getActivityName();
    } 

}

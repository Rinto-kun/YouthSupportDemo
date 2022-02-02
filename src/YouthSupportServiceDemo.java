import java.util.ArrayList;

public class YouthSupportServiceDemo {
    public static void main(String[] args) throws Exception {
        ArrayList<Activity> activities = new ArrayList<Activity>();
        // Activities 1-5 usually involve a lot of people, 
        // whilst activities 6-10 can be done solo. Our young person will have a mix of both, 
        // but lockdown will restrict the communal activities. Our YouthSupport aims to relieve that by 
        // suggesting healthy and safe recommendations to that person's lifestyle during COVID.
        activities.add(new Activity(
            "go to a party",
            new int[] {1,2,3,4,5}
        ));
        activities.add(new Activity(
            "go out for coffee",
            new int[] {2,2,2,2,2}
        ));
        activities.add(new Activity(
            "go to the beach",
            new int[] {3,1,2,3,4}
        ));
        activities.add(new Activity(
            "go to the cinema",
            new int[] {4,4,4,4,4}
        ));
        activities.add(new Activity(
            "go to a concert",
            new int[] {5,5,5,5,5}
        ));



        activities.add(new Activity(
            "practice drawing",
            new int[] {3,2,1,4,5}
        ));
        activities.add(new Activity(
            "write in a journal",
            new int[] {1,1,1,1,1}
        ));
        activities.add(new Activity(
            "read a book",
            new int[] {1,2,3,4,5}
        ));
        activities.add(new Activity(
            "hike on a natural trail",
            new int[] {4,4,4,4,3}
        ));
        activities.add(new Activity(
            "go for a bike ride",
            new int[] {3,3,4,5,2}
        ));


        Lockdown lockdown = new Lockdown(
            new ArrayList<Activity>(activities.subList(0, activities.size()/2))
        );
        YouthSupport youthSupport = new YouthSupport(
            new ArrayList<Activity>(activities.subList(activities.size()/2, activities.size()))
        );


        Person youngAdult = new YoungAdult(
            "Martin", "Freeman","2000-01-20", "M","+44321321321", new int[] {3,3,3,3,3}, 
            new ArrayList<Activity>(activities.subList(2,6)),false
        );
        
        // Those are simply commented out because they show up as unused variables in the warnings section, 
        // they are fully functional, and testing them is encouraged.

/*         Adult father = new Adult(
            "Morgan", "Freeman","1969-04-25", "M","+44213213213", new int[] {4,2,4,2,4}, 
            new ArrayList<Activity>(activities.subList(3,7)), false
        ); */

/*         Adult mother = new Adult(
            "Louise", "Freeman","1970-09-27", "F","+44123123123", new int[] {2,4,2,4,2}, 
            new ArrayList<Activity>(activities.subList(4,8)), true
        ); */

/*         Adult tutor = new Adult(
            "George", "Lucas","1976-11-10", "M","+44312312312", new int[] {5,4,5,1,2}, 
            new ArrayList<Activity>(activities.subList(1,4)), false
        ); */

/*         Person sister = new YoungAdult(
            "Hannah", "Freeman","2001-12-03", "F","+44213213213", new int[] {4,4,4,4,4},
            new ArrayList<Activity>(activities.subList(1,5)), false
        ); */

/*         Person friend = new YoungAdult(
            "Matt", "Parker","2000-07-31", "M","+44132132132", new int[] {2,5,3,1,4}, 
            new ArrayList<Activity>(activities.subList(2,5)), false
        ); */

        System.out.println("Before lockdown: \n" + youngAdult.toString()+"\n");

        lockdown.applyLockdownOnPerson(youngAdult);

        System.out.println("After lockdown happened: \n" + youngAdult.toString()+"\n");

        youthSupport.recommendActivitiesToPerson(youngAdult);

        System.out.println("After they looked for help from YouthSupport: \n" + youngAdult.toString());

    }
}

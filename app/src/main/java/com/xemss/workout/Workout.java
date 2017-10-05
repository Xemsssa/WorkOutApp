package com.xemss.workout;

/**
 * Created by xemss on 05.10.2017.
 */

public class Workout {
    private String name;
    private String desc;

//    String[] workouts = new String[]{
//            "The Limb Loosener",
//            "Core Agony",
//            "The Wimp Special",
//            "Strength and Length"
//    };
// TODO: 05.10.2017 create array with exercises
    public static final Workout[] workouts = {
            new Workout("The Limb Loosener",
                    "5 Handstand push-ups\n10 1-legged squats\n15 Pull-ups"),
            new Workout("Core Agony",
                    "100 Pull-ups\n100 Pull-ups\n15 Sit-ups\n100 Squats"),
            new Workout("The Wimp Special",
                    "5 Pull-ups\n10 Push-ups\n15 Squats"),
            new Workout("Strength and Length",
                    "500 meter run\n21 x 1.5 pood kettleball swing\n21 x Pull-ups"),
    };

    // TODO: 05.10.2017 constructor
    private Workout(String name, String description) {
        this.name = name;
        this.desc = description;
    }

    // TODO: 05.10.2017 getter
    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

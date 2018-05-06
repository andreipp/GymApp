package zzr.licenta.gymapp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Andrei on 03/26/2018.
 */

public class Constants {

    public static String GRUPA = "Grupa";
    public static String INTENSITATE = "Intensitate";
    public static String GRUPA_INTENSITATE = GRUPA+"_"+INTENSITATE;



    public static ArrayList<NoName> initializeazaNoName(){
        ArrayList<NoName> arrayList = new ArrayList<NoName>();

        NoName noName1 = new NoName("Piept");
        NoName noName2 = new NoName("Brate");
        NoName noName3 = new NoName("Picioare");
        NoName noName4 = new NoName("Spate");
        NoName noName5 = new NoName("Umeri");

        arrayList.add(noName1);
        arrayList.add(noName2);
        arrayList.add(noName3);
        arrayList.add(noName4);
        arrayList.add(noName5);

        return  arrayList;
    }

    public static ArrayList<Exercise> initializeazaExercitiiPieptBeginner(){
        ArrayList<Exercise> exerciseArrayList = new ArrayList<Exercise>();
        Exercise exercise1 = new Exercise("Barbell Bench Press",10,3,45,"http://assets.menshealth.co.uk/main/assets/bench-press.gif?mtime=1447694450");
        Exercise exercise2 = new Exercise("45-degree incline Dumbbell Press",10,3,45,"http://assets.menshealth.co.uk/main/assets/fly-dumbbell-incline.gif?mtime=1456767160");
        Exercise exercise3 = new Exercise("Cable Pec fly",10,3,45,"http://assets.menshealth.co.uk/main/assets/cabley.gif?mtime=1432138937");
        Exercise exercise4 = new Exercise("Seated Chest Press Machine",10,3,20,"http://904fitness.com/wp-content/uploads/2016/09/Seated-Chest-Press-Machine.gif");

        exerciseArrayList.addAll(Arrays.asList(exercise1,exercise2,exercise3,exercise4));

        return exerciseArrayList;
    }

    public static ArrayList<Exercise> initializeazaExercitiiPieptIntermediate(){
        ArrayList<Exercise> exerciseArrayList = new ArrayList<Exercise>();
        Exercise exercise1 = new Exercise("Impins la piept Intermediate",12,4,30,"");
        Exercise exercise2 = new Exercise("Ridicari de gantere Intermediate",15,3,30,"");
        Exercise exercise3 = new Exercise("Genoflexiuni Intermediate",50,4,30,"");
        Exercise exercise4 = new Exercise("Abdomene Intermediate",50,2,30,"");

        exerciseArrayList.addAll(Arrays.asList(exercise1,exercise2,exercise3,exercise4));

        return exerciseArrayList;
    }

    public static ArrayList<Exercise> initializeazaExercitiiPieptAdvanced(){
        ArrayList<Exercise> exerciseArrayList = new ArrayList<Exercise>();

        Exercise exercise1 = new Exercise("Impins la piept Advanced",12,4,30,"");
        Exercise exercise2 = new Exercise("Ridicari de gantere Advanced",15,3,30,"");
        Exercise exercise3 = new Exercise("Genoflexiuni Advanced",50,4,30,"");
        Exercise exercise4 = new Exercise("Abdomene Advanced",50,2,30,"");

        exerciseArrayList.addAll(Arrays.asList(exercise1,exercise2,exercise3,exercise4));

        return exerciseArrayList;
    }
    public static ArrayList<Exercise> initializeazaExercitiiBrateBeginner(){
        ArrayList<Exercise> exerciseArrayList = new ArrayList<Exercise>();
        Exercise exercise1 = new Exercise("Impins la piept Beginner",12,4,30,"");
        Exercise exercise2 = new Exercise("Ridicari de gantere Beginner",15,3,30,"");
        Exercise exercise3 = new Exercise("Genoflexiuni Beginner",50,4,30,"");
        Exercise exercise4 = new Exercise("Abdomene Beginner",50,2,30,"");

        exerciseArrayList.addAll(Arrays.asList(exercise1,exercise2,exercise3,exercise4));

        return exerciseArrayList;
    }

    public static ArrayList<Exercise> initializeazaExercitiiBrateIntermediate(){
        ArrayList<Exercise> exerciseArrayList = new ArrayList<Exercise>();
        Exercise exercise1 = new Exercise("Impins la piept Intermediate",12,4,30,"");
        Exercise exercise2 = new Exercise("Ridicari de gantere Intermediate",15,3,30,"");
        Exercise exercise3 = new Exercise("Genoflexiuni Intermediate",50,4,30,"");
        Exercise exercise4 = new Exercise("Abdomene Intermediate",50,2,30,"");

        exerciseArrayList.addAll(Arrays.asList(exercise1,exercise2,exercise3,exercise4));

        return exerciseArrayList;
    }

    public static ArrayList<Exercise> initializeazaExercitiiBrateAdvanced(){
        ArrayList<Exercise> exerciseArrayList = new ArrayList<Exercise>();

        Exercise exercise1 = new Exercise("Impins la piept Advanced",12,4,30,"");
        Exercise exercise2 = new Exercise("Ridicari de gantere Advanced",15,3,30,"");
        Exercise exercise3 = new Exercise("Genoflexiuni Advanced",50,4,30,"");
        Exercise exercise4 = new Exercise("Abdomene Advanced",50,2,30,"");

        exerciseArrayList.addAll(Arrays.asList(exercise1,exercise2,exercise3,exercise4));

        return exerciseArrayList;
    }
    public static ArrayList<Exercise> initializeazaExercitiiPicioareBeginner(){
        ArrayList<Exercise> exerciseArrayList = new ArrayList<Exercise>();
        Exercise exercise1 = new Exercise("Impins la piept Beginner",12,4,30,"");
        Exercise exercise2 = new Exercise("Ridicari de gantere Beginner",15,3,30,"");
        Exercise exercise3 = new Exercise("Genoflexiuni Beginner",50,4,30,"");
        Exercise exercise4 = new Exercise("Abdomene Beginner",50,2,30,"");

        exerciseArrayList.addAll(Arrays.asList(exercise1,exercise2,exercise3,exercise4));

        return exerciseArrayList;
    }

    public static ArrayList<Exercise> initializeazaExercitiiPicioareIntermediate(){
        ArrayList<Exercise> exerciseArrayList = new ArrayList<Exercise>();
        Exercise exercise1 = new Exercise("Impins la piept Intermediate",12,4,30,"");
        Exercise exercise2 = new Exercise("Ridicari de gantere Intermediate",15,3,30,"");
        Exercise exercise3 = new Exercise("Genoflexiuni Intermediate",50,4,30,"");
        Exercise exercise4 = new Exercise("Abdomene Intermediate",50,2,30,"");

        exerciseArrayList.addAll(Arrays.asList(exercise1,exercise2,exercise3,exercise4));

        return exerciseArrayList;
    }

    public static ArrayList<Exercise> initializeazaExercitiiPicioareAdvanced(){
        ArrayList<Exercise> exerciseArrayList = new ArrayList<Exercise>();

        Exercise exercise1 = new Exercise("Impins la piept Advanced",12,4,30,"");
        Exercise exercise2 = new Exercise("Ridicari de gantere Advanced",15,3,30,"");
        Exercise exercise3 = new Exercise("Genoflexiuni Advanced",50,4,30,"");
        Exercise exercise4 = new Exercise("Abdomene Advanced",50,2,30,"");

        exerciseArrayList.addAll(Arrays.asList(exercise1,exercise2,exercise3,exercise4));

        return exerciseArrayList;
    }
    public static ArrayList<Exercise> initializeazaExercitiiSpateBeginner(){
        ArrayList<Exercise> exerciseArrayList = new ArrayList<Exercise>();
        Exercise exercise1 = new Exercise("Impins la piept Beginner",12,4,30,"");
        Exercise exercise2 = new Exercise("Ridicari de gantere Beginner",15,3,30,"");
        Exercise exercise3 = new Exercise("Genoflexiuni Beginner",50,4,30,"");
        Exercise exercise4 = new Exercise("Abdomene Beginner",50,2,30,"");

        exerciseArrayList.addAll(Arrays.asList(exercise1,exercise2,exercise3,exercise4));

        return exerciseArrayList;
    }

    public static ArrayList<Exercise> initializeazaExercitiiSpateIntermediate(){
        ArrayList<Exercise> exerciseArrayList = new ArrayList<Exercise>();
        Exercise exercise1 = new Exercise("Impins la piept Intermediate",12,4,30,"");
        Exercise exercise2 = new Exercise("Ridicari de gantere Intermediate",15,3,30,"");
        Exercise exercise3 = new Exercise("Genoflexiuni Intermediate",50,4,30,"");
        Exercise exercise4 = new Exercise("Abdomene Intermediate",50,2,30,"");

        exerciseArrayList.addAll(Arrays.asList(exercise1,exercise2,exercise3,exercise4));

        return exerciseArrayList;
    }

    public static ArrayList<Exercise> initializeazaExercitiiSpateAdvanced(){
        ArrayList<Exercise> exerciseArrayList = new ArrayList<Exercise>();

        Exercise exercise1 = new Exercise("Impins la piept Advanced",12,4,30,"");
        Exercise exercise2 = new Exercise("Ridicari de gantere Advanced",15,3,30,"");
        Exercise exercise3 = new Exercise("Genoflexiuni Advanced",50,4,30,"");
        Exercise exercise4 = new Exercise("Abdomene Advanced",50,2,30,"");

        exerciseArrayList.addAll(Arrays.asList(exercise1,exercise2,exercise3,exercise4));

        return exerciseArrayList;
    }
    public static ArrayList<Exercise> initializeazaExercitiiUmeriBeginner(){
        ArrayList<Exercise> exerciseArrayList = new ArrayList<Exercise>();
        Exercise exercise1 = new Exercise("Impins la piept Beginner",12,4,30,"");
        Exercise exercise2 = new Exercise("Ridicari de gantere Beginner",15,3,30,"");
        Exercise exercise3 = new Exercise("Genoflexiuni Beginner",50,4,30,"");
        Exercise exercise4 = new Exercise("Abdomene Beginner",50,2,30,"");

        exerciseArrayList.addAll(Arrays.asList(exercise1,exercise2,exercise3,exercise4));

        return exerciseArrayList;
    }

    public static ArrayList<Exercise> initializeazaExercitiiUmeriIntermediate(){
        ArrayList<Exercise> exerciseArrayList = new ArrayList<Exercise>();
        Exercise exercise1 = new Exercise("Impins la piept Intermediate",12,4,30,"");
        Exercise exercise2 = new Exercise("Ridicari de gantere Intermediate",15,3,30,"");
        Exercise exercise3 = new Exercise("Genoflexiuni Intermediate",50,4,30,"");
        Exercise exercise4 = new Exercise("Abdomene Intermediate",50,2,30,"");

        exerciseArrayList.addAll(Arrays.asList(exercise1,exercise2,exercise3,exercise4));

        return exerciseArrayList;
    }

    public static ArrayList<Exercise> initializeazaExercitiiUmeriAdvanced(){
        ArrayList<Exercise> exerciseArrayList = new ArrayList<Exercise>();

        Exercise exercise1 = new Exercise("Impins la piept Advanced",12,4,30,"");
        Exercise exercise2 = new Exercise("Ridicari de gantere Advanced",15,3,30,"");
        Exercise exercise3 = new Exercise("Genoflexiuni Advanced",50,4,30,"");
        Exercise exercise4 = new Exercise("Abdomene Advanced",50,2,30,"");

        exerciseArrayList.addAll(Arrays.asList(exercise1,exercise2,exercise3,exercise4));

        return exerciseArrayList;
    }
}

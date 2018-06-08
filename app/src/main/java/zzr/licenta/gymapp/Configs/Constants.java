package zzr.licenta.gymapp.Configs;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

import zzr.licenta.gymapp.Model.Exercise;
import zzr.licenta.gymapp.Model.NoName;
import zzr.licenta.gymapp.MyLocalDataBase.DatabaseSQLite;

/**
 * Created by Andrei on 03/26/2018.
 */

public class Constants {

    public static String GRUPA = "Grupa";
    public static String INTENSITATE = "Intensitate";
    public static String GRUPA_ISTORIC = "Grupa Istoric";
    public static String LISTA_EXERCITII = "ListaExercitii";
    public static String LISTA_EXERCITII_BUNDLE = "ListaExercitiiBundle";

    //Database
    public static DatabaseSQLite DATABASE;

    public static ArrayList<NoName> initializeazaNoName(){
        ArrayList<NoName> arrayList = new ArrayList<>();

        NoName noName1 = new NoName("Chest");
        noName1.setAdressImage("https://www.musclesupplements101.com/wp-content/uploads/2018/05/beginners-chest-workout.jpg");
        NoName noName2 = new NoName("Arms");
        noName2.setAdressImage("https://2.bp.blogspot.com/-8lrjyxp1E7A/WQxvQ0CU6BI/AAAAAAAAC7Q/fbJvTcbyAZcZAQmsCY3ai0NtbbHT8wo1gCLcB/s1600/Gym-Status-for-Whatsapp-in-English-Gym-Whatsapp-Status.jpg");
        NoName noName3 = new NoName("Legs");
        noName3.setAdressImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRtYc5wl3QaiTA7CluprH730PXsN7pOI7zMoqQYUAbrZPm5Cca8");
        NoName noName4 = new NoName("Back");
        noName4.setAdressImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQbvFcIBxhug9ECwGUrOuocsGe-gBtoxad88M6pzW1xCrx2CZGa");
        NoName noName5 = new NoName("Soulders");
        noName5.setAdressImage("http://bodycontrol.ba/wp-content/uploads/2018/04/trening.jpg");
        noName1.setListExercitii(Constants.initializeazaExercitiiPieptBeginner());
        noName2.setListExercitii(Constants.initializeazaExercitiiPieptIntermediate());
        noName3.setListExercitii(Constants.initializeazaExercitiiPieptIntermediate());
        noName4.setListExercitii(Constants.initializeazaExercitiiPieptIntermediate());
        noName5.setListExercitii(Constants.initializeazaExercitiiPieptIntermediate());
        arrayList.add(noName1);
        arrayList.add(noName2);
        arrayList.add(noName3);
        arrayList.add(noName4);
        arrayList.add(noName5);


        return  arrayList;
    }

    public static ArrayList<Exercise> initializeazaExercitiiPieptBeginner(){
        ArrayList<Exercise> exerciseArrayList = new ArrayList<>();
        Exercise exercise1 = new Exercise("Barbell Bench Press",10,1,45,"http://assets.menshealth.co.uk/main/assets/bench-press.gif?mtime=1447694450");
        //Exercise exercise2 = new Exercise("45-degree incline Dumbbell Press",10,3,45,"http://assets.menshealth.co.uk/main/assets/fly-dumbbell-incline.gif?mtime=1456767160");
        //Exercise exercise3 = new Exercise("Cable Pec fly",10,3,45,"http://assets.menshealth.co.uk/main/assets/cabley.gif?mtime=1432138937");
        //Exercise exercise4 = new Exercise("Seated Chest Press Machine",10,3,20,"http://904fitness.com/wp-content/uploads/2016/09/Seated-Chest-Press-Machine.gif");

        //exerciseArrayList.addAll(Arrays.asList(exercise1,exercise2,exercise3,exercise4));
        exerciseArrayList.add(exercise1);

        return exerciseArrayList;
    }

    public static ArrayList<Exercise> initializeazaExercitiiPieptIntermediate(){
        ArrayList<Exercise> exerciseArrayList = new ArrayList<>();
        Exercise exercise1 = new Exercise("Barbell Bench Press",10,1,45,"http://assets.menshealth.co.uk/main/assets/bench-press.gif?mtime=1447694450");
        Exercise exercise2 = new Exercise("45-degree incline Dumbbell Press",10,3,45,"http://assets.menshealth.co.uk/main/assets/fly-dumbbell-incline.gif?mtime=1456767160");
        Exercise exercise3 = new Exercise("Cable Pec fly",10,3,45,"http://assets.menshealth.co.uk/main/assets/cabley.gif?mtime=1432138937");
        Exercise exercise4 = new Exercise("Seated Chest Press Machine",10,3,20,"http://904fitness.com/wp-content/uploads/2016/09/Seated-Chest-Press-Machine.gif");

        exerciseArrayList.addAll(Arrays.asList(exercise1,exercise2,exercise3,exercise4));

        return exerciseArrayList;
    }

    public static ArrayList<Exercise> initializeazaExercitiiPieptAdvanced(){
        ArrayList<Exercise> exerciseArrayList = new ArrayList<>();

        Exercise exercise1 = new Exercise("Impins la piept Advanced",12,4,30,"");
        Exercise exercise2 = new Exercise("Ridicari de gantere Advanced",15,3,30,"");
        Exercise exercise3 = new Exercise("Genoflexiuni Advanced",50,4,30,"");
        Exercise exercise4 = new Exercise("Abdomene Advanced",50,2,30,"");

        exerciseArrayList.addAll(Arrays.asList(exercise1,exercise2,exercise3,exercise4));

        return exerciseArrayList;
    }
    public static ArrayList<Exercise> initializeazaExercitiiBrateBeginner(){
        ArrayList<Exercise> exerciseArrayList = new ArrayList<>();
        Exercise exercise1 = new Exercise("Impins la piept Beginner",12,4,30,"");
        Exercise exercise2 = new Exercise("Ridicari de gantere Beginner",15,3,30,"");
        Exercise exercise3 = new Exercise("Genoflexiuni Beginner",50,4,30,"");
        Exercise exercise4 = new Exercise("Abdomene Beginner",50,2,30,"");

        exerciseArrayList.addAll(Arrays.asList(exercise1,exercise2,exercise3,exercise4));

        return exerciseArrayList;
    }

    public static ArrayList<Exercise> initializeazaExercitiiBrateIntermediate(){
        ArrayList<Exercise> exerciseArrayList = new ArrayList<>();
        Exercise exercise1 = new Exercise("Impins la piept Intermediate",12,4,30,"");
        Exercise exercise2 = new Exercise("Ridicari de gantere Intermediate",15,3,30,"");
        Exercise exercise3 = new Exercise("Genoflexiuni Intermediate",50,4,30,"");
        Exercise exercise4 = new Exercise("Abdomene Intermediate",50,2,30,"");

        exerciseArrayList.addAll(Arrays.asList(exercise1,exercise2,exercise3,exercise4));

        return exerciseArrayList;
    }

    public static ArrayList<Exercise> initializeazaExercitiiBrateAdvanced(){
        ArrayList<Exercise> exerciseArrayList = new ArrayList<>();

        Exercise exercise1 = new Exercise("Impins la piept Advanced",12,4,30,"");
        Exercise exercise2 = new Exercise("Ridicari de gantere Advanced",15,3,30,"");
        Exercise exercise3 = new Exercise("Genoflexiuni Advanced",50,4,30,"");
        Exercise exercise4 = new Exercise("Abdomene Advanced",50,2,30,"");

        exerciseArrayList.addAll(Arrays.asList(exercise1,exercise2,exercise3,exercise4));

        return exerciseArrayList;
    }
    public static ArrayList<Exercise> initializeazaExercitiiPicioareBeginner(){
        ArrayList<Exercise> exerciseArrayList = new ArrayList<>();
        Exercise exercise1 = new Exercise("Impins la piept Beginner",12,4,30,"");
        Exercise exercise2 = new Exercise("Ridicari de gantere Beginner",15,3,30,"");
        Exercise exercise3 = new Exercise("Genoflexiuni Beginner",50,4,30,"");
        Exercise exercise4 = new Exercise("Abdomene Beginner",50,2,30,"");

        exerciseArrayList.addAll(Arrays.asList(exercise1,exercise2,exercise3,exercise4));

        return exerciseArrayList;
    }

    public static ArrayList<Exercise> initializeazaExercitiiPicioareIntermediate(){
        ArrayList<Exercise> exerciseArrayList = new ArrayList<>();
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

    public static ArrayList<Exercise> deepCopyArrayListExercise(ArrayList<Exercise> list){
        ArrayList<Exercise> arrayList = new ArrayList<Exercise>();
        for(int i = 0 ; i <list.size();i++){
            arrayList.set(i,new Exercise());
            arrayList.get(i).setNume(list.get(i).getNume());
            arrayList.get(i).setNrRepetitii(list.get(i).getNrRepetitii());
            arrayList.get(i).setNrSerii(list.get(i).getNrSerii());
            arrayList.get(i).setAdresaImagine(list.get(i).getAdresaImagine());
            arrayList.get(i).setPauza(list.get(i).getPauza());
        }

        return arrayList;
     }

//     public float getCompletedAsFloat(NoName group){
//        float result = 0;
//        int increment = 0;
//         if(group.getListExercitii()!=null) {
//             Log.i("tagulVietii4: flaot",increment+"");
//            for (int i = 0; i < group.getListExercitii().size(); i++) {
//                if (group.getListExercitii().get(i).isCompleted()==true) {
//                    increment++;
//                    Log.i("tagulVietii3: flaot",increment+"");
//                }
//            }
//            result = (increment/group.getListExercitii().size());
//            result = result*100;
//        }
//
//         Log.i("tagulVietii2: float",result+"");
//         return  result;
//     }
//
//    public String getCompletedAsString(NoName group){
//        float result = 0.2f;
//        int increment = 0;
//        if(group.getListExercitii()!=null) {
//            for (int i = 0; i < group.getListExercitii().size(); i++) {
//                if (group.getListExercitii().get(i).isCompleted()) {
//                    increment++;
//                }
//            }
//            result = (increment/group.getListExercitii().size())*100;
//        }
//
//        Log.i("tagulVietii2: string",result+"");
//        return  result+"%";
//    }
}

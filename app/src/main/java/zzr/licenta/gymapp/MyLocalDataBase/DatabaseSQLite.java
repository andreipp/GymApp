package zzr.licenta.gymapp.MyLocalDataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import zzr.licenta.gymapp.Configs.Constants;
import zzr.licenta.gymapp.Model.Exercise;
import zzr.licenta.gymapp.Model.NoName;

/**
 * Created by Andrei on 15-May-18.
 */

public class DatabaseSQLite extends SQLiteOpenHelper{

    public static final String TABLE_GROUPS = "GROUPS";
    public static final String TABLE_EXERCISE = "EXERCISE";

    public static final String TABLE_GROUPS_ISTORIC = "GROUPS_ISTORIC";
    public static final String TABLE_EXERCISE_ISTORIC = "EXERCISE_ISTORIC";

    public static final String GROUP_ID = "id_grupa";
    public static final String GROUP_GRUPA = "nume_grupa";
    public static final String GROUP_ADRESAIMAGINE = "adresa_imagine";

    public static final String EXERCISE_ID = "id_exercitiu";
    public static final String EXERCISE_IDGRUPA = "id_grupa";
    public static final String EXERCISE_NUME = "nume_exercitiu";
    public static final String EXERCISE_ADRESAIMAGINE = "adresa_imagine";
    public static final String EXERCISE_NRREPETII = "nr_repetii";
    public static final String EXERCISE_NRSERII ="nr_serii";
    public static final String EXERCISE_PAUZA ="pauza";
    public static final String EXERCISE_ISCOMPLETED = "is_completed";

    public static final String GROUP_COMPLETED_DATE = "completed_date";

    public DatabaseSQLite(Context context){
        super(context,"GymAppDb",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(
                "CREATE TABLE " + TABLE_GROUPS + " (" + GROUP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        GROUP_GRUPA + " TEXT, " +
                        GROUP_ADRESAIMAGINE + " TEXT);"
        );

        sqLiteDatabase.execSQL(
                "CREATE TABLE " + TABLE_EXERCISE + " (" +EXERCISE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        EXERCISE_IDGRUPA + " INTEGER, " +
                        EXERCISE_NUME + " TEXT," +
                        EXERCISE_ADRESAIMAGINE+ " TEXT," +
                        EXERCISE_NRREPETII + " INTEGER, " +
                        EXERCISE_NRSERII + " INTEGER, " +
                        EXERCISE_PAUZA + " INTEGER, " +
                        EXERCISE_ISCOMPLETED + " INTEGER );"
        );

        sqLiteDatabase.execSQL(
                "CREATE TABLE " + TABLE_GROUPS_ISTORIC + " (" + GROUP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        GROUP_GRUPA + " TEXT, " +
                        GROUP_ADRESAIMAGINE + " TEXT, " +
                        GROUP_COMPLETED_DATE + " INTEGER);"
        );

        sqLiteDatabase.execSQL(
                "CREATE TABLE " + TABLE_EXERCISE_ISTORIC + " (" +EXERCISE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        EXERCISE_IDGRUPA + " INTEGER, " +
                        EXERCISE_NUME + " TEXT," +
                        EXERCISE_ADRESAIMAGINE+ " TEXT," +
                        EXERCISE_NRREPETII + " INTEGER, " +
                        EXERCISE_NRSERII + " INTEGER, " +
                        EXERCISE_PAUZA + " INTEGER, " +
                        EXERCISE_ISCOMPLETED + " INTEGER );"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insertNoName(NoName noName){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        try {
            ContentValues contentValues = new ContentValues();

            contentValues.put(GROUP_GRUPA, noName.getGrupa());
            contentValues.put(GROUP_ADRESAIMAGINE, noName.getAdressImage());

            sqLiteDatabase.insert(TABLE_GROUPS,null,contentValues);

            for (int i = 0; i < noName.getListExercitii().size(); i++) {
                if(!insertExercise(noName.getListExercitii().get(i),getLastIndexGroups())){
                    deleteExerciseByIdGroup(getLastIndexGroups());
                    deleteGroupById(getLastIndexGroups());

                    throw new Exception("Nu s-au inserat");
                }
            }

            Log.i("Database : insertNoName" , noName.toString());

        }catch (Exception ex){
            Log.i("Database : insertNoName", ex.toString());
            return false;
        }
        return true;
    }

    public boolean insertExercise(Exercise exercise,int lastIndexGroup){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        try {
            ContentValues contentValue = new ContentValues();

            contentValue.put(EXERCISE_IDGRUPA, lastIndexGroup);
            contentValue.put(EXERCISE_NUME, exercise.getNume());
            contentValue.put(EXERCISE_ADRESAIMAGINE,exercise.getAdresaImagine());
            contentValue.put(EXERCISE_NRREPETII, exercise.getNrRepetitii());
            contentValue.put(EXERCISE_NRSERII, exercise.getNrSerii());
            contentValue.put(EXERCISE_PAUZA, exercise.getPauza());
            if(exercise.isCompleted()) {
                contentValue.put(EXERCISE_ISCOMPLETED, 1);
            }else{
                contentValue.put(EXERCISE_ISCOMPLETED, 0);
            }

            Log.i("exercise1", lastIndexGroup+"");
            sqLiteDatabase.insert(TABLE_EXERCISE,null,contentValue);
        }
        catch (Exception ex){
            Log.i("Database : insertExercise", ex.toString());
            return false;
        }
        return true;
    }

    public boolean insertNoNameIstoric(NoName noName, long data){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        try {
            ContentValues contentValues = new ContentValues();

            contentValues.put(GROUP_GRUPA, noName.getGrupa());
            contentValues.put(GROUP_ADRESAIMAGINE, noName.getAdressImage());
            contentValues.put(GROUP_COMPLETED_DATE, data);

            sqLiteDatabase.insert(TABLE_GROUPS_ISTORIC,null,contentValues);

            for (int i = 0; i < noName.getListExercitii().size(); i++) {
                if(!insertExerciseIstoric(noName.getListExercitii().get(i),getLastIndexGroupsIstoric())){
                    deleteExerciseByIdGroupIstoric(getLastIndexGroupsIstoric());
                    deleteGroupByIdIstoric(getLastIndexGroupsIstoric());

                    throw new Exception("Nu s-au inserat");
                }
            }

            Log.i("Database : insertNoNameIstoric" , noName.toString());

        }catch (Exception ex){
            Log.i("Database : insertNoNameIstoric", ex.toString());
            return false;
        }
        return true;
    }

    public boolean insertExerciseIstoric(Exercise exercise,int lastIndexGroup){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        try {
            ContentValues contentValue = new ContentValues();

            contentValue.put(EXERCISE_IDGRUPA, lastIndexGroup);
            contentValue.put(EXERCISE_NUME, exercise.getNume());
            contentValue.put(EXERCISE_ADRESAIMAGINE,exercise.getAdresaImagine());
            contentValue.put(EXERCISE_NRREPETII, exercise.getNrRepetitii());
            contentValue.put(EXERCISE_NRSERII, exercise.getNrSerii());
            contentValue.put(EXERCISE_PAUZA, exercise.getPauza());
            if(exercise.isCompleted()) {
                contentValue.put(EXERCISE_ISCOMPLETED, 1);
            }else{
                contentValue.put(EXERCISE_ISCOMPLETED, 0);
            }

            Log.i("exercise1Istoric", lastIndexGroup+"");
            sqLiteDatabase.insert(TABLE_EXERCISE_ISTORIC,null,contentValue);
        }
        catch (Exception ex){
            Log.i("Database : insertExerciseIstoric", ex.toString());
            return false;
        }
        return true;
    }


    public int getLastIndexGroups(){
        int lastIndex = 0;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT " + GROUP_ID + " FROM " + TABLE_GROUPS + " ORDER BY " + GROUP_ID + " DESC LIMIT 1;";

        Cursor cursor = sqLiteDatabase.rawQuery(query,null);

        if(cursor.moveToLast()) {
            lastIndex = cursor.getInt(0);
        }

        cursor.close();

        return lastIndex;
    }

    public int getLastIndexGroupsIstoric(){
        int lastIndex = 0;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT " + GROUP_ID + " FROM " + TABLE_GROUPS_ISTORIC + " ORDER BY " + GROUP_ID + " DESC LIMIT 1;";

        Cursor cursor = sqLiteDatabase.rawQuery(query,null);

        if(cursor.moveToLast()) {
            lastIndex = cursor.getInt(0);
        }

        cursor.close();

        return lastIndex;
    }

    public void deleteGroupById(int idGroup){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        //String query = "DELETE FROM " + TABLE_GROUPS + " WHERE " + GROUP_ID + " = '" + idGroup + "';";
        sqLiteDatabase.delete(TABLE_GROUPS,GROUP_ID+"=?",new String[]{Integer.toString(idGroup)});

    }

    public void deleteExerciseByIdGroup(int idGroup){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        //String query = "DELETE FROM " + TABLE_GROUPS + " WHERE " + GROUP_ID + " = '" + idGroup + "'";
        sqLiteDatabase.delete(TABLE_EXERCISE,EXERCISE_IDGRUPA+"=?",new String[]{Integer.toString(idGroup)});

    }

    public void deleteGroupByIdIstoric(int idGroup){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        //String query = "DELETE FROM " + TABLE_GROUPS + " WHERE " + GROUP_ID + " = '" + idGroup + "';";
        sqLiteDatabase.delete(TABLE_GROUPS_ISTORIC,GROUP_ID+"=?",new String[]{Integer.toString(idGroup)});

    }

    public void deleteExerciseByIdGroupIstoric(int idGroup){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        //String query = "DELETE FROM " + TABLE_GROUPS + " WHERE " + GROUP_ID + " = '" + idGroup + "'";
        sqLiteDatabase.delete(TABLE_EXERCISE_ISTORIC,EXERCISE_IDGRUPA+"=?",new String[]{Integer.toString(idGroup)});

    }

    public void deleteAllPlans(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_GROUPS,null,null);
        sqLiteDatabase.delete(TABLE_EXERCISE,null,null);
    }

    public void deleteAllProgress(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_GROUPS_ISTORIC,null,null);
        sqLiteDatabase.delete(TABLE_EXERCISE_ISTORIC,null,null);
    }

    public int numberOfRowsGroups(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(sqLiteDatabase, TABLE_GROUPS);
        return numRows;
    }

    public int numberOfRowsExercise(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(sqLiteDatabase, TABLE_EXERCISE);

        return numRows;
    }

//    public boolean updateStatusGroupById(int id,boolean status) { //todo vezi cu celalalt completed
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        try {
//            ContentValues contentValues = new ContentValues();
//
//            if (status == true) {
//                contentValues.put(GROUP_ISCOMPLETED, 1);
//            } else {
//                contentValues.put(GROUP_ISCOMPLETED, 0);
//            }
//
//            sqLiteDatabase.update(TABLE_GROUPS, contentValues, GROUP_ID + "=" + id, null);
//
//        }catch (Exception ex){
//            Log.i("Database : updateStatusGroupById", ex.toString());
//            return false;
//        }
//
//
//        return true;
//    }
    public boolean updateStatusExerciseByGroupID(int id, boolean status){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();

            if (status == true) {
                contentValues.put(EXERCISE_ISCOMPLETED, 1);
            } else {
                contentValues.put(EXERCISE_ISCOMPLETED, 0);
            }

            sqLiteDatabase.update(TABLE_EXERCISE, contentValues, EXERCISE_IDGRUPA + "=" + id, null);

        }catch (Exception ex){
            Log.i("Database : updateStatusGroupById", ex.toString());
            return false;
        }

        return true;
    }

    public boolean updateStatusExerciseByExerciseID(int id, boolean status){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();

            if (status == true) {
                contentValues.put(EXERCISE_ISCOMPLETED, 1);
            } else {
                contentValues.put(EXERCISE_ISCOMPLETED, 0);
            }

            sqLiteDatabase.update(TABLE_EXERCISE, contentValues, EXERCISE_ID + "=" + id, null);

        }catch (Exception ex){
            Log.i("Database : updateStatusGroupById", ex.toString());
            return false;
        }


        return true;
    }

    public boolean insertNoNameWithUpdateOnExercise(NoName noName){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        try {
            ContentValues contentValues = new ContentValues();

            contentValues.put(GROUP_GRUPA, noName.getGrupa());
            contentValues.put(GROUP_ADRESAIMAGINE, noName.getAdressImage());

            sqLiteDatabase.insert(TABLE_GROUPS,null,contentValues);

            for (int i = 0; i < noName.getListExercitii().size(); i++) {
                if(!updateIdGrupaExerciseByExerciseID(noName.getListExercitii().get(i).getIdExercitiu(),getLastIndexGroups())){
                    deleteGroupById(getLastIndexGroups());

                    throw new Exception("Nu s-au inserat");
                }
            }

            Log.i("Database : insertNoName" , noName.toString());

        }catch (Exception ex){
            Log.i("Database : insertNoName", ex.toString());
            return false;
        }
        return true;
    }

    public boolean updateIdGrupaExerciseByExerciseID(int id,int lastIndex){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();

            contentValues.put(EXERCISE_IDGRUPA, lastIndex);


            sqLiteDatabase.update(TABLE_EXERCISE, contentValues, EXERCISE_ID + "=" + id, null);

        }catch (Exception ex){
            Log.i("Database : updateStatusGroupById", ex.toString());
            return false;
        }


        return true;
    }


    public List<NoName> getGroupsList(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        List<NoName> listGroups  = new ArrayList<NoName>();
        List<Exercise> listExercise = new ArrayList<Exercise>();

        String queryGroups = "SELECT * FROM " + TABLE_GROUPS +";";
        String queryExercise = "SELECT * FROM " + TABLE_EXERCISE + ";";

        Cursor cursor1 = sqLiteDatabase.rawQuery(queryExercise,null);
        if(cursor1!=null && cursor1.moveToFirst()){
            do{
                Log.i("Baza : Exercise",cursor1.getInt(0) + " " + cursor1.getInt(1)+" "+ cursor1.getString(2) + " " + cursor1.getString(3) + " " +cursor1.getInt(4) + " " + cursor1.getInt(5) + " "+cursor1.getInt(6) +" // "+ cursor1.getInt(7));

                boolean isCompleted = false;
                if(cursor1.getInt(7)==1){
                    isCompleted = true;
                    Log.i("gasit", "Gasit");
                }

                Exercise exercise = new Exercise(cursor1.getInt(0),cursor1.getInt(1),cursor1.getString(2),cursor1.getString(3),cursor1.getInt(4),cursor1.getInt(5),cursor1.getInt(6),isCompleted);
                listExercise.add(exercise);
            }while (cursor1.moveToNext());

            cursor1.close();
        }

        Cursor cursor2 = sqLiteDatabase.rawQuery(queryGroups,null);
        if(cursor2!=null && cursor2.moveToFirst()){
            do{
                Log.i("Baza : NoName",cursor2.getInt(0)+ " " +cursor2.getString(1)+ " " + cursor2.getString(2));


                NoName noName = new NoName(cursor2.getInt(0),cursor2.getString(1),cursor2.getString(2));
                listGroups.add(noName);
            }while (cursor2.moveToNext());

            cursor2.close();
        }

        for (NoName no: listGroups) {
            for(Exercise ex : listExercise){
                if(no.getId()==ex.getIdGrupa()){
                    //Log.i("boolean",no.getId() + " " + ex.getIdGrupa());
                    no.getListExercitii().add(ex);
                }
            }
        }

//        for (int i = 0; i < listGroups.get(i).getListExercitii().size();i++){
////            for(Exercise ex : listExercise) {
////                Log.i("foreach", "NoID: " +no.getId()+" ExIDGRupa" + ex.getIdGrupa() + " // DIF" + ex.getIdExercitiu());
////            }
//            if(i==1){
//                for(int j = 0 ; j< listGroups.get(i).getListExercitii().size();i++)
//
//       Log.i("tagulVietii3 --: flaot",listGroups.get(i).getListExercitii().get(i).isCompleted()+" "+ listGroups.get(i).getId() + " " + listGroups.get(i).getListExercitii().get(j).getIdGrupa() +" " +listGroups.get(i).getListExercitii().get(j).getIdExercitiu());
//            }
//
//        }

        for (Exercise e: listExercise) {
            if(e.isCompleted()){
                Log.i("gasit","Gasit " + e.toString());
            }
        }
        return listGroups;
    }

    public List<Exercise> getExercisesListWithNoGroup(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        List<Exercise> listExercise = new ArrayList<Exercise>();


        String queryExercise = "SELECT * FROM " + TABLE_EXERCISE + ";";

        Cursor cursor1 = sqLiteDatabase.rawQuery(queryExercise,null);
        if(cursor1!=null && cursor1.moveToFirst()){
            do{
                if(cursor1.getInt(1)==-1) {
                    Log.i("Baza : Exercise", cursor1.getInt(0) + " " + cursor1.getInt(1) + " " + cursor1.getString(2) + " " + cursor1.getString(3) + " " + cursor1.getInt(4) + " " + cursor1.getInt(5) + " " + cursor1.getInt(6) + " // " + cursor1.getInt(7));

                    boolean isCompleted = false;
                    if (cursor1.getInt(7) == 1) {
                        isCompleted = true;
                        Log.i("gasit", "Gasit");
                    }

                    Exercise exercise = new Exercise(cursor1.getInt(0), cursor1.getInt(1), cursor1.getString(2), cursor1.getString(3), cursor1.getInt(4), cursor1.getInt(5), cursor1.getInt(6), isCompleted);
                    listExercise.add(exercise);
                }
            }while (cursor1.moveToNext());

            cursor1.close();
        }

        return listExercise;
    }



    public List<NoName> getExerciseListIstoricByWeek(int nr){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        List<NoName> listGroups  = new ArrayList<NoName>();
        List<Exercise> listExercise = new ArrayList<Exercise>();

        String queryGroups = "SELECT * FROM " + TABLE_GROUPS_ISTORIC +" WHERE " + GROUP_COMPLETED_DATE + " = " + nr;
        String queryExercise = "SELECT * FROM " + TABLE_EXERCISE_ISTORIC + ";";

        Cursor cursor1 = sqLiteDatabase.rawQuery(queryExercise,null);
        if(cursor1!=null && cursor1.moveToFirst()){
            do{
                Log.i("Baza : Exercise",cursor1.getInt(0) + " " + cursor1.getInt(1)+" "+ cursor1.getString(2) + " " + cursor1.getString(3) + " " +cursor1.getInt(4) + " " + cursor1.getInt(5) + " "+cursor1.getInt(6) +" // "+ cursor1.getInt(7));

                boolean isCompleted = false;
                if(cursor1.getInt(7)==1){
                    isCompleted = true;
                    Log.i("gasit", "Gasit");
                }

                Exercise exercise = new Exercise(cursor1.getInt(0),cursor1.getInt(1),cursor1.getString(2),cursor1.getString(3),cursor1.getInt(4),cursor1.getInt(5),cursor1.getInt(6),isCompleted);
                listExercise.add(exercise);
            }while (cursor1.moveToNext());

            cursor1.close();
        }

        Cursor cursor2 = sqLiteDatabase.rawQuery(queryGroups,null);
        if(cursor2!=null && cursor2.moveToFirst()){
            do{
                Log.i("Baza : NoName",cursor2.getInt(0)+ " " +cursor2.getString(1)+ " " + cursor2.getString(2));


                NoName noName = new NoName(cursor2.getInt(0),cursor2.getString(1),cursor2.getString(2));
                listGroups.add(noName);
            }while (cursor2.moveToNext());

            cursor2.close();
        }

        for (NoName no: listGroups) {
            for(Exercise ex : listExercise){
                if(no.getId()==ex.getIdGrupa()){
                    //Log.i("boolean",no.getId() + " " + ex.getIdGrupa());
                    no.getListExercitii().add(ex);
                }
            }
        }

//        for (int i = 0; i < listGroups.get(i).getListExercitii().size();i++){
////            for(Exercise ex : listExercise) {
////                Log.i("foreach", "NoID: " +no.getId()+" ExIDGRupa" + ex.getIdGrupa() + " // DIF" + ex.getIdExercitiu());
////            }
//            if(i==1){
//                for(int j = 0 ; j< listGroups.get(i).getListExercitii().size();i++)
//
//       Log.i("tagulVietii3 --: flaot",listGroups.get(i).getListExercitii().get(i).isCompleted()+" "+ listGroups.get(i).getId() + " " + listGroups.get(i).getListExercitii().get(j).getIdGrupa() +" " +listGroups.get(i).getListExercitii().get(j).getIdExercitiu());
//            }
//
//        }

        for (Exercise e: listExercise) {
            if(e.isCompleted()){
                Log.i("gasit","Gasit " + e.toString());
            }
        }

        return listGroups;
    }

}

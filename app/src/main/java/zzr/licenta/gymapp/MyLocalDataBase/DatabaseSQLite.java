package zzr.licenta.gymapp.MyLocalDataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import zzr.licenta.gymapp.Model.Exercise;
import zzr.licenta.gymapp.Model.NoName;

/**
 * Created by Andrei on 15-May-18.
 */

public class DatabaseSQLite extends SQLiteOpenHelper{

    public static final String TABLE_GROUPS = "GROUPS";
    public static final String TABLE_EXERCISE = "EXERCISE";

    public static final String GROUP_ID = "id_grupa";
    public static final String GROUP_GRUPA = "nume_grupa";
    public static final String GROUP_ADRESAIMAGINE = "adresa_imagine";
    public static final String GROUP_ISCOMPLETED = "is_completed";

    public static final String EXERCISE_ID = "id_exercitiu";
    public static final String EXERCISE_IDGRUPA = "id_grupa";
    public static final String EXERCISE_NUME = "nume_exercitiu";
    public static final String EXERCISE_NRREPETII = "nr_repetii";
    public static final String EXERCISE_NRSERII ="nr_serii";
    public static final String EXERCISE_PAUZA ="pauza";

    public DatabaseSQLite(Context context){
        super(context,"GymAppDb",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(
                "CREATE TABLE " + TABLE_GROUPS + " (" + GROUP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        GROUP_GRUPA + " TEXT, " +
                        GROUP_ADRESAIMAGINE + " TEXT, " +
                        GROUP_ISCOMPLETED + " TEXT );"
        );

        sqLiteDatabase.execSQL(
                "CREATE TABLE " + TABLE_EXERCISE + " (" +EXERCISE_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        EXERCISE_IDGRUPA + " INTEGER, " +
                        EXERCISE_NUME + " TEXT," +
                        EXERCISE_NRREPETII + " INTEGER, " +
                        EXERCISE_NRSERII + " INTEGER, " +
                        EXERCISE_PAUZA + " INTEGER )"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public int getLastIndex(){
        int lastIndex = 0;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        //Cursor cursor = sqLiteDatabase.rawQuery(GROUP_GRUPA)
        return lastIndex;
    }

    public boolean insertNoName(NoName noName){
        try {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();

            contentValues.put(GROUP_GRUPA, noName.getGrupa());
            contentValues.put(GROUP_ADRESAIMAGINE, noName.getAdressImage());
            contentValues.put(GROUP_ISCOMPLETED, noName.isCompleted() + "");

            for (int i = 0; i < noName.getListExercitii().size(); i++) {
                insertExercise(noName.getListExercitii().get(i));
            }

            sqLiteDatabase.insert(TABLE_GROUPS,null,contentValues);


        }catch (Exception ex){
            Log.i("Database : insertNoName", ex.toString());
            return false;
        }
        return true;
    }

    public boolean insertExercise(Exercise exercise){
        try {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

            ContentValues contentValue = new ContentValues();

            contentValue.put(EXERCISE_NUME, exercise.getNume());
            contentValue.put(EXERCISE_NRREPETII, exercise.getNrRepetitii());
            contentValue.put(EXERCISE_NRSERII, exercise.getNrSerii());
            contentValue.put(EXERCISE_PAUZA, exercise.getPauza());
            sqLiteDatabase.insert(TABLE_EXERCISE,null,contentValue);
        }
        catch (Exception ex){
            Log.i("Database : insertExercise", ex.toString());
            return false;
        }
        return true;
    }
}

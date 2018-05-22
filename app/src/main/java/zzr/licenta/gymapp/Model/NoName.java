package zzr.licenta.gymapp.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Relation;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei on 03/21/2018.
 */

public class NoName implements Serializable{

    private int id;

    private String grupa;

    private String adressImage;

    private List<Exercise> listExercitii;

    private boolean isCompleted = false;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public List<Exercise> getListExercitii() {
        return listExercitii;
    }

    public void setListExercitii(ArrayList<Exercise> listExercitii) {
        this.listExercitii = listExercitii;
    }

    public NoName(){
        this.grupa = "Piept";
    }

    public NoName(String grupa){
        this.grupa = grupa;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public String getAdressImage() {
        return adressImage;
    }

    public void setAdressImage(String adresaImagine) {
        this.adressImage = adresaImagine;
    }

    public NoName(int id, String grupa, String adressImage, List<Exercise> listExercitii, boolean isCompleted) {
        this.id = id;
        this.grupa = grupa;
        this.adressImage = adressImage;
        this.listExercitii = listExercitii;
        this.isCompleted = isCompleted;
    }

    public NoName(int id, String grupa, String adressImage, boolean isCompleted) {
        this.id = id;
        this.grupa = grupa;
        this.adressImage = adressImage;
        this.listExercitii = new ArrayList<Exercise>();
        this.isCompleted = isCompleted;
    }

    @Override
    public String toString() {
        String stringListExercitii = null;
        for(Exercise e : listExercitii){
            stringListExercitii += " " + e.toString() + " ";
        }
        return grupa + " " + adressImage + " " + stringListExercitii + " " + isCompleted;
    }
    public String toString2() {
        return grupa + " " + adressImage + " " + isCompleted;
    }
}

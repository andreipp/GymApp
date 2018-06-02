package zzr.licenta.gymapp.Model;


import android.support.annotation.NonNull;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import zzr.licenta.gymapp.Configs.Constants;

/**
 * Created by Andrei on 03/21/2018.
 */

public class NoName implements Serializable{

    private int id;

    private String grupa;

    private String adressImage;

    private List<Exercise> listExercitii;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setListExercitii(List<Exercise> listExercitii) {
        this.listExercitii = listExercitii;
    }

    public List<Exercise> getListExercitii() {
        return listExercitii;
    }

    public void setListExercitii(ArrayList<Exercise> listExercitii) {
        this.listExercitii = listExercitii;
    }

    public NoName(){
        this.grupa = "Piept";
        this.listExercitii = new ArrayList<Exercise>();
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

    public NoName(int id, String grupa, String adressImage, List<Exercise> listExercitii) {
        this.id = id;
        this.grupa = grupa;
        this.adressImage = adressImage;
        this.listExercitii = listExercitii;
    }

    public NoName(int id, String grupa, String adressImage) {
        this.id = id;
        this.grupa = grupa;
        this.adressImage = adressImage;
        this.listExercitii = new ArrayList<Exercise>();
    }

    public void deepCopy(NoName noName){

        this.setId(noName.getId());
        this.setGrupa(noName.getGrupa());
        for (Exercise e: noName.getListExercitii()) {
            this.getListExercitii().add(e);

       }
    }

    public NoName combineTwoListOfExercise(NoName noName){
        for(Exercise e1 : this.getListExercitii()){
            for(Exercise e2 : noName.getListExercitii()){
                if(e1.getIdExercitiu() == e2.getIdExercitiu()){
                    e1.setCompleted(e2.isCompleted());
                }
            }
        }
        return this;
    }

    public void afiseaza(float a, float b){
        //if(a!=0){
            Log.i("tagulVietii1: flaot",a + " " + b);
        //}
    }

    public float getCompletedAsFloat(){
        float result = 0.0000f;
        float increment = 0.0000f;
        Log.i("ciudat","null");
        if(this.listExercitii!=null) {
            Log.i("ciudat","glumeam");
           // afiseaza(result,increment);
            for (int i = 0; i < this.listExercitii.size(); i++) {
                afiseaza(result,increment);
                if (this.listExercitii.get(i).isCompleted()) {
                    increment++;
                    Log.i("tagulVietii3: flaot",result + " " + increment);
                }
            }
            Log.i("tagulVietii4: flaot",result + " " + increment);
            result = (increment/this.listExercitii.size());
            result = result*100;
            Log.i("tagulVietii5: flaot",result + " " + increment);
        }

        return  result;
    }

    public NoName getOnlyInCompletedExercise(NoName noName){
        this.id = noName.getId();
        this.grupa = noName.getGrupa();
        this.adressImage = noName.getAdressImage();
        for(Exercise exercise : noName.getListExercitii()){
            if(!exercise.isCompleted())
                this.getListExercitii().add(exercise);
        }
        return this;
    }

    @Override
    public String toString() {
        String stringListExercitii = null;
        for(Exercise e : listExercitii){
            stringListExercitii += " " + e.toString() + " ";
        }
        return grupa + " " + adressImage + " " + stringListExercitii + " " ;
    }
    public String toString2() {
        return grupa + " " + adressImage + " " ;
    }
}

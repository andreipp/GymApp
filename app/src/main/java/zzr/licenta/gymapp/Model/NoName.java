package zzr.licenta.gymapp.Model;


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

    public NoName deepCopy(NoName noName){
        NoName noNameNou = new NoName();
        noNameNou.setId(noName.getId());
        noNameNou.setGrupa(noName.getGrupa());
        for (Exercise e: noName.getListExercitii()) {
            noNameNou.getListExercitii().add(e);

       }
       return noNameNou;
    }

    public float getCompletedAsFloat(){
        float result = 0;
        int increment = 0;
        if(this.listExercitii!=null) {
            Log.i("tagulVietii4: flaot",increment+"");
            for (int i = 0; i < this.listExercitii.size(); i++) {
                Log.i("tagulVietii5: flaot",this.listExercitii.get(i).isCompleted()+" "+ this.id + " " + this.listExercitii.get(i).getIdGrupa() +" " +this.listExercitii.get(i).getIdExercitiu());
                if (this.listExercitii.get(i).isCompleted()) {
                    increment++;
                    Log.i("tagulVietii3: flaot",increment+"");
                }
            }
            result = (increment/this.listExercitii.size());
            result = result*100;
        }

        Log.i("tagulVietii2: float",result+"");
        return  result;
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

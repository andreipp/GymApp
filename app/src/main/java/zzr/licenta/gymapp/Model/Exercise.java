package zzr.licenta.gymapp.Model;


import java.io.Serializable;


/**
 * Created by Andrei on 04/11/2018.
 */
public class Exercise implements Serializable{

    private int idExercitiu;


    private int idGrupa;


    private String nume;


    private int nrRepetitii;


    private int nrSerii;


    private int pauza;

    private boolean completed;

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    private String adresaImagine = "";

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getNrRepetitii() {
        return nrRepetitii;
    }

    public void setNrRepetitii(int nrRepetitii) {
        this.nrRepetitii = nrRepetitii;
    }

    public int getNrSerii() {
        return nrSerii;
    }

    public String getFormatSeriiRepetii(){
        return nrSerii + "x" + nrRepetitii;
    }

    public void setNrSerii(int nrSerii) {
        this.nrSerii = nrSerii;
    }

    public int getPauza() {
        return pauza;
    }

    public void setPauza(int pauza) {
        this.pauza = pauza;
    }

    public String getAdresaImagine() {
        return adresaImagine;
    }

    public void setAdresaImagine(String adresaImagine) {
        this.adresaImagine = adresaImagine;
    }

    public int getIdExercitiu() {
        return idExercitiu;
    }

    public void setIdExercitiu(int idExercitiu) {
        this.idExercitiu = idExercitiu;
    }

    public int getIdGrupa() {
        return idGrupa;
    }

    public void setIdGrupa(int idGrupa) {
        this.idGrupa = idGrupa;
    }

    public Exercise() {

    }

    public Exercise deepCopy(Exercise exercise){
        Exercise exerciseNou = new Exercise();
        exerciseNou.setIdExercitiu(exercise.getIdExercitiu());
        exerciseNou.setIdGrupa(exercise.getIdGrupa());
        exerciseNou.setNume(exercise.getNume());
        exerciseNou.setAdresaImagine(exercise.getAdresaImagine());
        exerciseNou.setNrRepetitii(exercise.getNrRepetitii());
        exerciseNou.setNrSerii(exercise.getNrSerii());
        exerciseNou.setPauza(exercise.getPauza());
        exerciseNou.setCompleted(exercise.isCompleted());

        return exerciseNou;
    }

    public Exercise(int idExercitiu,int idGrupa , String nume, String adresaImagine, int nrRepetitii, int nrSerii, int pauza, boolean completed) {
        this.idGrupa = idGrupa;
        this.idExercitiu = idExercitiu;
        this.nume = nume;
        this.adresaImagine = adresaImagine;
        this.nrRepetitii = nrRepetitii;
        this.nrSerii = nrSerii;
        this.pauza = pauza;
        this.completed = completed;
    }

    public Exercise( String nume, int nrRepetitii, int nrSerii, int pauza, String adresaImagine){
        this.nume = nume;
        this.adresaImagine = adresaImagine;
        this.nrRepetitii = nrRepetitii;
        this.nrSerii = nrSerii;
        this.pauza = pauza;
        this.completed = false;
    }
//
//    public Exercise deepCopy(Exercise ex){
//        Exercise exercise = new Exercise(ex.getIdExercitiu(),ex.getIdGrupa())
//    }

    @Override
    public String toString() {
        return nume + " " + nrRepetitii + "x" + nrSerii;
    }
}

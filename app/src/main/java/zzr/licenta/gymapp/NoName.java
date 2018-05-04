package zzr.licenta.gymapp;

/**
 * Created by Andrei on 03/21/2018.
 */

public class NoName {

    String grupa;
    String[] adresaImagine = { "nullB", "nullI" , "nullA"};
    String[] textPeImagine = { "Beginner", "Intermediate" , "Advanced"};

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

    public String[] getAdresaImagine() {
        return adresaImagine;
    }

    public void setAdresaImagine(String[] adresaImagine) {
        this.adresaImagine = adresaImagine;
    }

    public String[] getTextPeImagine() {
        return textPeImagine;
    }

    public String getTextPeImagine(int i) {
        return textPeImagine[i].toString();
    }

    public void setTextPeImagine(String[] textPeImagine) {
        this.textPeImagine = textPeImagine;
    }
}

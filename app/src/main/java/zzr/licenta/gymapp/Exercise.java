package zzr.licenta.gymapp;

/**
 * Created by Andrei on 04/11/2018.
 */

public class Exercise {
    String nume;
    int nrRepetitii;
    int nrSerii;
    int pauza;
    String adresaImagine = "";

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

    public Exercise() {
    }

    public Exercise(String nume, int nrRepetitii, int nrSerii, int pauza, String adresaImagine) {
        this.nume = nume;
        this.nrRepetitii = nrRepetitii;
        this.nrSerii = nrSerii;
        this.pauza = pauza;
        this.adresaImagine = adresaImagine;
    }

    @Override
    public String toString() {
        return nume + " " + nrRepetitii + "x" + nrSerii;
    }
}

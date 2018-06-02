package zzr.licenta.gymapp.Model;

import java.util.Date;

/**
 * Created by Andrei on 29-May-18.
 */

public class Alarm {

    private Date data;
    private boolean switcher;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isSwitcher() {
        return switcher;
    }

    public void setSwitcher(boolean switcher) {
        this.switcher = switcher;
    }
}

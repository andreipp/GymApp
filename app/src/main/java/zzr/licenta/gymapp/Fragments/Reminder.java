package zzr.licenta.gymapp.Fragments;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import zzr.licenta.gymapp.Alarm.MyAlarm;
import zzr.licenta.gymapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Reminder extends Fragment {
    View view;

    TimePicker timePicker;
    Button button;


    public Reminder() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_reminder,container,false);

        timePicker = (TimePicker) view.findViewById(R.id.timePicker);
        button = (Button) view.findViewById(R.id.btnSetAlarm);
        timePicker.setIs24HourView(true);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();

                if(Build.VERSION.SDK_INT>=23) {
                    calendar.set(
                            calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH),
                            timePicker.getHour(),
                            timePicker.getMinute(),
                            0
                    );
                }
                else{
                    calendar.set(
                            calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH),
                            timePicker.getCurrentHour(),
                            timePicker.getCurrentMinute(),
                            0
                    );
                }

                setAlarm(calendar.getTimeInMillis());
            }
        });

        return view;
    }

    private void setAlarm(long timeInMillis) {
        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        //view.getcontext

        Intent intent = new Intent(getActivity(), MyAlarm.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(),0,intent,0);

        alarmManager.setRepeating(AlarmManager.RTC, timeInMillis, AlarmManager.INTERVAL_DAY, pendingIntent);

        Toast.makeText(getActivity(),"Alarm is set.",Toast.LENGTH_LONG).show();
    }

}

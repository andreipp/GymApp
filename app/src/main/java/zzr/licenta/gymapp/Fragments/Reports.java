package zzr.licenta.gymapp.Fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import zzr.licenta.gymapp.Configs.Constants;
import zzr.licenta.gymapp.Configs.DateHelper;
import zzr.licenta.gymapp.CustomAdapters.CustomAdapterForExercises;
import zzr.licenta.gymapp.CustomAdapters.CustomAdapterForPlans;
import zzr.licenta.gymapp.Model.NoName;
import zzr.licenta.gymapp.MyLocalDataBase.DatabaseSQLite;
import zzr.licenta.gymapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Reports extends Fragment {
    TextView textView;
    ImageButton ibLeft;
    ImageButton ibRight;
    ListView listView;

    Calendar calendar;

    DateHelper dateHelper;


    public Reports() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reports,container,false);

        textView = (TextView) view.findViewById(R.id.textView9);
        ibLeft = (ImageButton) view.findViewById(R.id.imageButton2);
        ibRight = (ImageButton) view.findViewById(R.id.imageButton3);
        listView = (ListView) view.findViewById(R.id.listViewIstoric);

        calendar = Calendar.getInstance();

        dateHelper = new DateHelper();

        textView.setText(dateHelper.getIntervalByWeekOfYear(calendar,calendar.get(Calendar.WEEK_OF_YEAR)));
        resetListViewIstoric(Integer.parseInt(calendar.get(Calendar.YEAR)+""+calendar.get(Calendar.WEEK_OF_YEAR)));

        ibLeft.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                    textView.setText(dateHelper.getIntervalByWeekOfYear(calendar,calendar.get(Calendar.WEEK_OF_YEAR)-1));
                    resetListViewIstoric(Integer.parseInt(calendar.get(Calendar.YEAR)+""+calendar.get(Calendar.WEEK_OF_YEAR)));
                }
        });

        ibRight.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                    textView.setText(dateHelper.getIntervalByWeekOfYear(calendar,calendar.get(Calendar.WEEK_OF_YEAR)+1));
                    resetListViewIstoric(Integer.parseInt(calendar.get(Calendar.YEAR)+""+calendar.get(Calendar.WEEK_OF_YEAR)));
                }
        });

        return view;
    }

    private void resetListViewIstoric(int weekYear){
        List<NoName> noNames = new ArrayList<NoName>();
        noNames = Constants.DATABASE.getExerciseListIstoricByWeek(weekYear);

        listView.setAdapter(new CustomAdapterForPlans(getActivity(),R.layout.customadapter_plans, noNames,1));
        //listView
    }

}

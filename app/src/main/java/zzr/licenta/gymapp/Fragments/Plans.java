package zzr.licenta.gymapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import zzr.licenta.gymapp.ActivityClasses.MainActivity;
import zzr.licenta.gymapp.Configs.Constants;
import zzr.licenta.gymapp.CustomAdapters.CustomAdapterForPlans;
import zzr.licenta.gymapp.Model.Exercise;
import zzr.licenta.gymapp.Model.NoName;
import zzr.licenta.gymapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Plans extends Fragment {
    List<NoName> arrayList = new ArrayList<>();

    public Plans() {
        // Required empty public constructor

       //arrayList = Constants.DATABASE.getGroupsList();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plans,container,false);

        arrayList = Constants.DATABASE.getGroupsList();

        ListView listView = (ListView) view.findViewById(R.id.listView);
        CustomAdapterForPlans adapter = new CustomAdapterForPlans(getActivity(),R.layout.customadapter_plans,arrayList);
        listView.setAdapter(adapter);

        return view;
    }



}

package zzr.licenta.gymapp.Fragments;


import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
        final CustomAdapterForPlans adapter = new CustomAdapterForPlans(getActivity(),R.layout.customadapter_plans,arrayList,0);
        listView.setAdapter(adapter);



        return view;
    }



}

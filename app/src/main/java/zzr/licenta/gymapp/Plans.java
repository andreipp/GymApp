package zzr.licenta.gymapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Plans extends Fragment {
    ArrayList<NoName> arrayList = new ArrayList<>();

    public Plans() {
        // Required empty public constructor
        arrayList = Constants.initializeazaNoName();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plans,container,false);
        ListView listView = (ListView) view.findViewById(R.id.listView);
        CustomAdapterForPlans adapter = new CustomAdapterForPlans(getActivity(),R.layout.customadapter_plans,arrayList);
        listView.setAdapter(adapter);


        return view;
    }



}

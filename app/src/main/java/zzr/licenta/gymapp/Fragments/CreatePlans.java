package zzr.licenta.gymapp.Fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import zzr.licenta.gymapp.Configs.Constants;
import zzr.licenta.gymapp.CustomAdapters.CustomAdapterForExercises;
import zzr.licenta.gymapp.Model.Exercise;
import zzr.licenta.gymapp.Model.NoName;
import zzr.licenta.gymapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreatePlans extends Fragment {

    EditText etName;
    ListView listView;
    Button  btnAdd;
    List<Exercise> list;
    public CreatePlans() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_plans, container, false);

        etName = (EditText) view.findViewById(R.id.etPlanName);
        listView = (ListView) view.findViewById(R.id.listView);
        btnAdd = (Button) view.findViewById(R.id.btnAdauga);

        refreshListView();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    NoName noName = new NoName();
                    if(!etName.getText().toString().trim().isEmpty() && list.size()>0) {
                        noName.setGrupa(etName.getText().toString());
                        noName.setListExercitii(list);
                        if (Constants.DATABASE.insertNoNameWithUpdateOnExercise(noName)) {
                            Toast.makeText(getActivity(), "Done!", Toast.LENGTH_LONG).show();
                            refreshListView();
                        } else {
                            throw new Exception();
                        }
                    }else {
                        throw new Exception();
                    }



                }catch (Exception ex){
                    Toast.makeText(getActivity(),"Not added",Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }

    private void refreshListView() {
       list = new ArrayList<>();

        listView.setAdapter(new CustomAdapterForExercises(getActivity(),R.layout.customadapter_exercises, Constants.DATABASE.getExercisesListWithNoGroup()));

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                CheckBox checkBox = (CheckBox) view.findViewById(R.id.selectat);
                checkBox.setEnabled(false);
                if(checkBox.getVisibility()==View.VISIBLE){
                    checkBox.setVisibility(View.GONE);
                    checkBox.setChecked(false);
                    list.remove((Exercise)adapterView.getItemAtPosition(i));
                }else{
                    checkBox.setVisibility(View.VISIBLE);
                    checkBox.setChecked(true);
                    list.add((Exercise)adapterView.getItemAtPosition(i));
                }

                return false;
            }
        });
    }

}

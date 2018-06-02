package zzr.licenta.gymapp.Fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import zzr.licenta.gymapp.Configs.Constants;
import zzr.licenta.gymapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Reset extends Fragment {
    TextView tvAllPlans;
    TextView tvAllProgress;

    public Reset() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reset, container, false);
        tvAllPlans = (TextView) view.findViewById(R.id.tv1);
        tvAllProgress = (TextView) view.findViewById(R.id.tv2);

        genereazaAlertDialog(tvAllPlans,0);
        genereazaAlertDialog(tvAllProgress,1);


        return view;
    }

    private void genereazaAlertDialog(TextView textView, final int reper){

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Delete Plans?");
                if(reper==1){
                    builder.setTitle("Delete Progress?");
                }
                builder.setIcon(R.drawable.ic_delete_sweep_black_24dp);
                builder.setMessage("All deleted items can't be recovered. Are you sure you wanna do this?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(reper==1){
                            Constants.DATABASE.deleteAllProgress();
                        }else {
                            Constants.DATABASE.deleteAllPlans();
                        }
                    }
                });
                builder.setNegativeButton("No",null);
                builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        Toast.makeText(getActivity(),"Done!",Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }
        });

    }
}

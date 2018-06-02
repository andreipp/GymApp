package zzr.licenta.gymapp.CustomAdapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import zzr.licenta.gymapp.Configs.Constants;
import zzr.licenta.gymapp.ActivityClasses.Groups;
import zzr.licenta.gymapp.Model.Exercise;
import zzr.licenta.gymapp.Model.NoName;
import zzr.licenta.gymapp.R;

/**
 * Created by Andrei on 03/21/2018.
 */

public class CustomAdapterForPlans extends ArrayAdapter<NoName> {

    private List<NoName> noNameArrayList = new ArrayList<NoName>();
    Context mContext;
    int istoric;


    public CustomAdapterForPlans( Context context, @LayoutRes int resource,List<NoName> data, int istoric){
        super(context,resource, data);
        this.noNameArrayList = data;
        this.mContext = context;
        this.istoric = istoric;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable final View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.customadapter_plans,null);
        }

        final NoName noName = getItem(position);

        if(noName!=null) {

            ImageButton imgBeginner = (ImageButton) view.findViewById(R.id.imgBeginner);
            TextView tvBeginner = (TextView) view.findViewById(R.id.tvBeginner);
            CheckBox isCompleted = (CheckBox) view.findViewById(R.id.checkBox);

            tvBeginner.setText(noName.getGrupa());
            Log.i("tagulVietii", noName.getCompletedAsFloat() + "");

            if (noName.getCompletedAsFloat() == 100) {
                isCompleted.setChecked(true);
                isCompleted.setTextColor(Color.GREEN);
            } else {
                isCompleted.setChecked(false);
                isCompleted.setTextColor(Color.RED);
            }

            isCompleted.setText("Completed " + noName.getCompletedAsFloat() + "%");

            if (istoric == 1) {
                imgBeginner.setBackgroundColor(Color.TRANSPARENT);
                isCompleted.setTextColor(Color.GREEN);
            }

            //imgBeginner.setBackgroundColor(Color.rgb(0, 0, 100));
            imgBeginner.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, Groups.class);
                    intent.putExtra(Constants.GRUPA, noName);
                    intent.putExtra(Constants.GRUPA_ISTORIC, istoric);
                    mContext.startActivity(intent);
                }
            });
            if (istoric != 1) {
                imgBeginner.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(final View view) {
                        Log.i("fmm", "fmm");
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
                        alertDialog.setIcon(R.drawable.ic_delete_sweep_black_24dp);
                        alertDialog.setTitle("Delete?");
                        alertDialog.setMessage("Are you sure you want to delete this plan?");
                        Log.i("fmm", "fmm");
                        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Log.i("fmm", "fmm");
                                Constants.DATABASE.deleteExerciseByIdGroup(noName.getId());
                                Constants.DATABASE.deleteGroupById(noName.getId());

                            }
                        });
                        alertDialog.setNegativeButton("No", null);
                        alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(DialogInterface dialogInterface) {
                                remove(noName);
                            }
                        });
                        alertDialog.show();
                        return false;
                    }
                });
            }
        }
        return view;
    }
}

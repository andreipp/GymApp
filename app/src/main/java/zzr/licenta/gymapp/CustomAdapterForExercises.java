package zzr.licenta.gymapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Andrei on 04/11/2018.
 */

public class CustomAdapterForExercises extends ArrayAdapter<Exercise>{

    private ArrayList<Exercise> exerciseArrayList = new ArrayList<Exercise>();
    Context mContext;

    public CustomAdapterForExercises(Context context, @LayoutRes int resource, ArrayList<Exercise> data){
        super(context,resource,data);
        exerciseArrayList.clear();
        this.exerciseArrayList = data;
        this.mContext = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable final View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if(view==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.customadapter_exercises,null);
        }

        Exercise exercise = getItem(position);

        if(exercise!=null){

            TextView tvDenumire =(TextView) view.findViewById(R.id.tvDenumire);

            TextView tvSeriiRepetari=(TextView) view.findViewById(R.id.tvSeriiRepetari);

            TextView tvPauza =(TextView) view.findViewById(R.id.tvPauza);

            ImageView imageView = (ImageView) view.findViewById(R.id.imageView3);

            //toDo setat imaginea

            tvDenumire.setText(exercise.getNume());
            tvSeriiRepetari.setText(exercise.getFormatSeriiRepetii());
            tvPauza.setText(Integer.toString(exercise.getPauza()));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view1) {
                    //AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                }
            });

        }
        return view;
    }
}

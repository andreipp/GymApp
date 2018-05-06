package zzr.licenta.gymapp;

import android.app.AlertDialog;
import android.app.admin.SystemUpdateInfo;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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

        final Exercise exercise = getItem(position);

        if(exercise!=null){

            TextView tvDenumire =(TextView) view.findViewById(R.id.tvDenumire);

            TextView tvSeriiRepetari=(TextView) view.findViewById(R.id.tvSeriiRepetari);

            TextView tvPauza =(TextView) view.findViewById(R.id.tvPauza);

            final ImageView ivMiniExercise = (ImageView) view.findViewById(R.id.ivMiniExercise);

            tvDenumire.setText(exercise.getNume());
            tvSeriiRepetari.setText(exercise.getFormatSeriiRepetii());
            tvPauza.setText("Pause " + Integer.toString(exercise.getPauza()) + " seconds");
            Glide.with(view.getContext()).load(exercise.adresaImagine).dontAnimate().into(ivMiniExercise);

            final View finalView = view;

            ivMiniExercise.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(finalView.getContext());
                    AlertDialog alert = builder.create();
                    LayoutInflater layoutInflater = LayoutInflater.from(finalView.getContext());
                    View view2 = layoutInflater.inflate(R.layout.gif_view,null);
                    alert.setView(view2);
                    return false;
                }
            });

            ivMiniExercise.setOnTouchListener(new View.OnTouchListener() {
                AlertDialog.Builder builder = new AlertDialog.Builder(finalView.getContext());
                AlertDialog alert = builder.create();

                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {

                    int actionMaskerd = motionEvent.getActionMasked();
                    switch (actionMaskerd){
                        case MotionEvent.ACTION_DOWN:
                            if(!alert.isShowing()) {
                                Log.e("Apas","3");
                                LayoutInflater layoutInflater = LayoutInflater.from(finalView.getContext());
                                View view2 = layoutInflater.inflate(R.layout.gif_view,null);
                                alert.setView(view2);
                                ImageView ivMaxiExercise = (ImageView) view2.findViewById(R.id.ivMaxiExercise);
                                Glide.with(view2.getContext()).load(exercise.adresaImagine).into(ivMaxiExercise);
                                alert.show();
                                Log.e("Apas","4");
                            }
                            break;
                        case MotionEvent.ACTION_UP:
                            Log.e("Nu Apas","1");
                            alert.dismiss();
                            Log.e("Nu Apas","2");
                            break;
                    }
                    return false;
                }
            });

        }
        return view;
    }
}

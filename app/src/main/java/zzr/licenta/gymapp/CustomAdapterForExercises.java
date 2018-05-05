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

        Exercise exercise = getItem(position);

        if(exercise!=null){

            TextView tvDenumire =(TextView) view.findViewById(R.id.tvDenumire);

            TextView tvSeriiRepetari=(TextView) view.findViewById(R.id.tvSeriiRepetari);

            TextView tvPauza =(TextView) view.findViewById(R.id.tvPauza);

            final ImageView imageView = (ImageView) view.findViewById(R.id.imageView3);

            //toDo setat imaginea

            tvDenumire.setText(exercise.getNume());
            tvSeriiRepetari.setText(exercise.getFormatSeriiRepetii());
            tvPauza.setText(Integer.toString(exercise.getPauza()));
            final View finalView = view;
            imageView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view1) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(finalView.getContext()); //sau Groups.class
                    LayoutInflater layoutInflater = LayoutInflater.from(finalView.getContext());
                    final View view2 = layoutInflater.inflate(R.layout.gif_view,null);
                    builder.setView(view2);
                    builder.show();
                    return false;
                }
            });


            imageView.setOnTouchListener(new View.OnTouchListener() {

                AlertDialog.Builder builder = new AlertDialog.Builder(finalView.getContext()); //sau Groups.class
                AlertDialog alert = builder.create();


                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {

                    int actionMaskerd = motionEvent.getActionMasked();
                    Log.e("APASARI", "Apas");

                    switch (actionMaskerd){
                        case MotionEvent.ACTION_DOWN:
                            if(!alert.isShowing()) {
                                LayoutInflater layoutInflater = LayoutInflater.from(finalView.getContext());
                                final View view2 = layoutInflater.inflate(R.layout.gif_view,null);
                                alert.setView(view2);
//                                alert.getWindow().setBackgroundDrawable(Color.rgb(0,0,0));
//                                alert.getWindow().setLayout(100,100);
                                ImageView imageView1 = (ImageView) view2.findViewById(R.id.imageView2);
                                Glide.with(view2.getContext()).load("https://upload.wikimedia.org/wikipedia/commons/2/2c/Rotating_earth_%28large%29.gif").into(imageView1);
                                alert.show();
                            }
//                            System.out.println("APAS");
//                            Log.e("APASARI","Apas");
                            break;
                        case MotionEvent.ACTION_UP:
//                            alert.hide();
                            alert.dismiss();
//                            alert.cancel();
                            System.out.println("nu mai apas");
                            Log.e("APASARI","Nu mai apas");
                            break;
                    }
                    return false;
                }
            });

        }
        return view;
    }
}

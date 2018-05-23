package zzr.licenta.gymapp.ActivityClasses;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import zzr.licenta.gymapp.Configs.Constants;
import zzr.licenta.gymapp.CustomAdapters.CustomAdapterForExercises;
import zzr.licenta.gymapp.Model.Exercise;
import zzr.licenta.gymapp.Model.NoName;
import zzr.licenta.gymapp.R;

public class Groups extends AppCompatActivity {

    RatingBar rbEnergy;
    TextView tvNrExercises;
    CheckBox isCompleted;
    ListView listView;
    Button btnGo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rbEnergy = (RatingBar) findViewById(R.id.ratingBar);
        tvNrExercises = (TextView) findViewById(R.id.textView4);
        listView = (ListView) findViewById(R.id.listView);
        isCompleted = (CheckBox) findViewById(R.id.isCompleted);
        btnGo = (Button) findViewById(R.id.btnGo);

        isCompleted.setVisibility(View.INVISIBLE);

        NoName data1 = null;
        //String data2 = null;
        List<Exercise> ex= new ArrayList<Exercise>();

        Bundle extras = getIntent().getExtras();

        if(extras!=null){
            data1 =(NoName) extras.get(Constants.GRUPA);
           // data2 = extras.getString("completed");
        }



        if(data1!=null){
            ex = data1.getListExercitii();
            if(data1.getCompletedAsFloat()==100){
                isCompleted.setVisibility(View.VISIBLE);
                isCompleted.setText("Workout completed.");
                isCompleted.setChecked(true);
            }else{
                isCompleted.setVisibility(View.VISIBLE);
                isCompleted.setText("Workout not completed. Its just " + data1.getCompletedAsFloat()+"%");
                isCompleted.setChecked(false);
            }
        }

        final NoName finalData1 = data1;

        if(isCompleted.isChecked()){
            isCompleted.setText(isCompleted.getText() + "\nGo back and try another Workout.");
            btnGo.setPaintFlags(btnGo.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            btnGo.setEnabled(false);
        }

        tvNrExercises.setText(ex.size()+"");
        listView.setAdapter(new CustomAdapterForExercises(this,R.layout.customadapter_exercises,ex));
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnGo.isEnabled()) {
                    Intent intent = new Intent(getBaseContext(), PlayWorkout.class);
                    intent.putExtra(Constants.GRUPA, finalData1);
                    startActivity(intent);
                }

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }


}



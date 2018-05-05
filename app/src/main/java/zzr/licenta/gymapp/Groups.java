package zzr.licenta.gymapp;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class Groups extends AppCompatActivity {

    RatingBar rbEnergy;
    TextView tvNrExercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rbEnergy = (RatingBar) findViewById(R.id.ratingBar);
        tvNrExercises = (TextView) findViewById(R.id.textView4);
        ListView listView = (ListView) findViewById(R.id.listView);
        String data = null;
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            data =extras.getString(Constants.GRUPA_INTENSITATE);
        }
        ArrayList<Exercise> ex= new ArrayList<Exercise>();
        if(data!=null){

            if(data.contains("Beginner")){
                rbEnergy.setRating(1);
            }else if(data.contains("Intermediate")){
                rbEnergy.setRating(2);
            }else if(data.contains("Advanced")){
                rbEnergy.setRating(3);
            }

            switch (data){
                case "Piept_Beginner": {
                    ex = Constants.initializeazaExercitiiPieptBeginner();
                    break;
                }
                case "Piept_Intermediate": {
                    ex = Constants.initializeazaExercitiiPieptIntermediate();
                    break;
                }
                case "Piept_Advanced": {
                    ex = Constants.initializeazaExercitiiPieptAdvanced();
                    break;
                }
                case "Brate_Beginner": {
                    ex = Constants.initializeazaExercitiiBrateBeginner();
                    break;
                }
                case "Brate_Intermediate": {
                    ex = Constants.initializeazaExercitiiBrateIntermediate();
                    break;
                }
                case "Brate_Advanced": {
                    ex = Constants.initializeazaExercitiiBrateAdvanced();
                    break;
                }
                case "Picioare_Beginner": {
                    ex = Constants.initializeazaExercitiiPicioareBeginner();
                    break;
                }
                case "Picioare_Intermediate": {
                    ex = Constants.initializeazaExercitiiPicioareIntermediate();
                    break;
                }
                case "Picioare_Advanced": {
                    ex = Constants.initializeazaExercitiiPicioareAdvanced();
                    break;
                }
                case "Spate_Beginner": {
                    ex = Constants.initializeazaExercitiiSpateBeginner();
                    break;
                }
                case "Spate_Intermediate": {
                    ex = Constants.initializeazaExercitiiSpateIntermediate();
                    break;
                }
                case "Spate_Advanced": {
                    ex = Constants.initializeazaExercitiiSpateAdvanced();
                    break;
                }
                case "Umeri_Beginner": {
                    ex = Constants.initializeazaExercitiiUmeriBeginner();
                    break;
                }
                case "Umeri_Intermediate": {
                    ex = Constants.initializeazaExercitiiUmeriIntermediate();
                    break;
                }
                case "Umeri_Advanced": {
                    ex = Constants.initializeazaExercitiiUmeriAdvanced();
                    break;
                }
            }
        }
        tvNrExercises.setText(ex.size()+"");
        listView.setAdapter(new CustomAdapterForExercises(this,R.layout.customadapter_exercises,ex));
        
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}

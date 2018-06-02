package zzr.licenta.gymapp.ActivityClasses;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import cdflynn.android.library.checkview.CheckView;
import zzr.licenta.gymapp.Configs.Constants;
import zzr.licenta.gymapp.Model.Exercise;
import zzr.licenta.gymapp.Model.NoName;
import zzr.licenta.gymapp.R;

public class PlayWorkout extends AppCompatActivity {
    ImageView ivMaxExercise;
    //ImageView ivSerieCompleta;
    CheckView checkView;
    TextView tvNameExercise;
    TextView tvCountDownExercise;
    TextView tvSeria;
    ImageButton btnDone;
    CheckBox isTimeRunning;
    CountDownTimer countDownTimer;
    NoName finalData1 = new NoName();
    NoName finalData2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_workout);

        NoName data1 = null;

        if(getIntent().getExtras()!=null) {
          // ex = (ArrayList<Exercise>) getIntent().getSerializableExtra(Constants.LISTA_EXERCITII_BUNDLE);
            data1= (NoName) getIntent().getExtras().get(Constants.GRUPA);
        } else {
            Log.i("PlayWorkout.class","Bundle e gol");
        }

        finalData2 = data1;
        finalData1.getOnlyInCompletedExercise(data1);

        ivMaxExercise = (ImageView) findViewById(R.id.ivMaxGif);
        //ivSerieCompleta = (ImageView) findViewById(R.id.ivSerieCompleta);
        checkView = (CheckView) findViewById(R.id.ivSerieCompleta);
        tvNameExercise = (TextView) findViewById(R.id.textView6);
        tvCountDownExercise = (TextView) findViewById(R.id.textView2);
        tvSeria = (TextView) findViewById(R.id.textView7);
        isTimeRunning = (CheckBox) findViewById(R.id.timerIsRunning);
        btnDone = (ImageButton) findViewById(R.id.imageButton);

        final int increment = 0;
        final int serieCompleta = 0; //todo

        Glide.with(getBaseContext()).load(finalData1.getListExercitii().get(increment).getAdresaImagine()).into(ivMaxExercise);
        tvNameExercise.setText(finalData1.getListExercitii().get(increment).getNume());
        tvCountDownExercise.setVisibility(View.INVISIBLE);
        tvSeria.setText("Seria "+ (serieCompleta+1));

        btnDone.setOnClickListener(new View.OnClickListener() {

            int incremenetNou = increment + 1;
            int serieCompletaNoua = serieCompleta +1;

            @Override
            public void onClick(View view) {

                finalData1.getListExercitii().get(incremenetNou-1).setCompleted(true);
                Log.i("ceva ----", finalData1.getListExercitii().get(incremenetNou-1).toString());
                Log.i("ceva",incremenetNou+ " " +serieCompletaNoua );

                if(isTimeRunning.isChecked()){
                    countDownTimer.cancel();
                    tvCountDownExercise.setVisibility(View.INVISIBLE);
                    isTimeRunning.setChecked(false);
                    serieCompletaNoua--;
                }else {
                    countDownTimer = new CountDownTimer(finalData1.getListExercitii().get(increment).getPauza() * 1000, 1000) {

                        @Override
                        public void onTick(long l) {
                            isTimeRunning.setChecked(true);
                            if (l > 0) {
                                tvCountDownExercise.setText("Remaining seconds of pause \n" + l / 1000);
                                tvCountDownExercise.setVisibility(View.VISIBLE);
                                tvSeria.setVisibility(View.INVISIBLE);

                            } else {
                                tvCountDownExercise.setText("Pause completed!");
                                tvSeria.setVisibility(View.VISIBLE);
                            }
                        }

                        @Override
                        public void onFinish() {
                            tvCountDownExercise.setVisibility(View.INVISIBLE);
                            isTimeRunning.setChecked(false);
                            serieCompletaNoua--;

                        }


                    };
                }

                if(tvNameExercise.getText().equals("Workout done!") && tvSeria.getText().equals("Congrats!")){
                    //finalData1.setCompleted(100);
                    Intent intent = new Intent(getBaseContext(),Groups.class);
                    for(Exercise ex : finalData1.getListExercitii()){
                        ex.setCompleted(true);
                    }
                    finalData2.combineTwoListOfExercise(finalData1);
                    Constants.DATABASE.updateStatusExerciseByGroupID(finalData1.getId(),true);

                    intent.putExtra(Constants.GRUPA,finalData2);
                    //Log.i("ceva",finalData1.getCompleted()+"");
                    startActivity(intent);
                }
                else if(serieCompletaNoua==finalData1.getListExercitii().get(incremenetNou-1).getNrSerii() && incremenetNou==finalData1.getListExercitii().size()+1)
                {
                    //Glide.with(getBaseContext()).load("E:\\Android\\GymApp\\app\\src\\main\\res\\drawable\\ic_checkmark_exercise.gif").into(ivMaxExercise);
                    Log.i("Ajung","Ajung");

                }else {
                    if (serieCompletaNoua == finalData1.getListExercitii().get(incremenetNou-1).getNrSerii()) {
                        if (incremenetNou < finalData1.getListExercitii().size()) {

                            Glide.with(getBaseContext()).load(finalData1.getListExercitii().get(incremenetNou).getAdresaImagine()).into(ivMaxExercise);
                            tvNameExercise.setText(finalData1.getListExercitii().get(incremenetNou).getNume());
                            tvCountDownExercise.setText(finalData1.getListExercitii().get(incremenetNou++).getPauza() + "");
                            serieCompletaNoua = 1;
                            tvSeria.setText("Seria " + serieCompletaNoua + "");
                            finalData1.getListExercitii().get(incremenetNou-2).setCompleted(true);
                            countDownTimer.start();

                        } else {
                            //Glide.with(getBaseContext()).load(R.raw.ic_checkmark_exercise).into(ivMaxExercise);
                            checkView.check();
                            tvNameExercise.setText("Workout done!");
                            tvSeria.setText("Congrats!");
                            tvCountDownExercise.setVisibility(View.INVISIBLE);

                        }
                    } else {
                        if (serieCompletaNoua < finalData1.getListExercitii().get(incremenetNou-1).getNrRepetitii()) {
                            new CountDownTimer(3000,1000){


                                @Override
                                public void onTick(long l) {
                                    btnDone.setVisibility(View.INVISIBLE);
                                    //Glide.with(getBaseContext()).load(R.raw.ic_checkmark_exercise).into(ivSerieCompleta);
                                    checkView.check();

                                    tvSeria.setVisibility(View.GONE);
                                    checkView.setVisibility(View.VISIBLE);

                                }


                                @Override
                                public void onFinish() {
                                    btnDone.setVisibility(View.VISIBLE);
                                    tvSeria.setVisibility(View.VISIBLE);
                                    checkView.setVisibility(View.GONE);
                                    tvSeria.setText("Seria " + ++serieCompletaNoua);

                                }

                            }.start();

                        }
                    }
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finalData2.combineTwoListOfExercise(finalData1);
                Intent intent = new Intent(getBaseContext(),Groups.class);
                intent.putExtra(Constants.GRUPA,finalData2);
                for (Exercise e: finalData1.getListExercitii()) {
                    if(e.isCompleted()){
                        Constants.DATABASE.updateStatusExerciseByExerciseID(e.getIdExercitiu(),true);
                    }
                }
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

package zzr.licenta.gymapp.ActivityClasses;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import zzr.licenta.gymapp.Configs.Constants;
import zzr.licenta.gymapp.Model.NoName;
import zzr.licenta.gymapp.R;

public class PlayWorkout extends AppCompatActivity {
    ImageView ivMaxExercise;
    ImageView ivSerieCompleta;
    TextView tvNameExercise;
    TextView tvCountDownExercise;
    TextView tvSeria;
    ImageButton btnDone;
    CheckBox isTimeRunning;
    CountDownTimer countDownTimer;

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

        final NoName finalData1 = data1;

        ivMaxExercise = (ImageView) findViewById(R.id.ivMaxGif);
        ivSerieCompleta = (ImageView) findViewById(R.id.ivSerieCompleta);
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
                    finalData1.setCompleted(true);
                    Intent intent = new Intent(getBaseContext(),Groups.class);

                    intent.putExtra(Constants.GRUPA,finalData1);
                    Log.i("ceva",finalData1.isCompleted()+"");
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
                            countDownTimer.start();


                        } else {
                            Glide.with(getBaseContext()).load(R.raw.ic_checkmark_exercise).into(ivMaxExercise);
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
                                    Glide.with(getBaseContext()).load(R.raw.ic_checkmark_exercise).into(ivSerieCompleta);
                                    tvSeria.setVisibility(View.GONE);
                                    ivSerieCompleta.setVisibility(View.VISIBLE);

                                }


                                @Override
                                public void onFinish() {
                                    btnDone.setVisibility(View.VISIBLE);
                                    tvSeria.setVisibility(View.VISIBLE);
                                    ivSerieCompleta.setVisibility(View.GONE);
                                    tvSeria.setText("Seria " + ++serieCompletaNoua);

                                }


                            }.start();

                        }
                    }
                }
            }
        });

    }
}

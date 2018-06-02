package zzr.licenta.gymapp.Fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import zzr.licenta.gymapp.Configs.Constants;
import zzr.licenta.gymapp.Model.Exercise;
import zzr.licenta.gymapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreateExercise extends Fragment {
    EditText etDen;
    EditText etUrl;

    TextView tvRepetii;
    TextView tvSerii;
    TextView tvPauza;

    SeekBar sbRepetii;
    SeekBar sbSerii;
    SeekBar sbPauza;

    Button btnBrowse;
    Button btnAdauga;

    ImageView ivPreview;


    public static final int PICK_IMAGE = 1;

    public CreateExercise() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_exercise, container, false);

        etDen = (EditText) view.findViewById(R.id.etExerciseName);
        etUrl =(EditText) view.findViewById(R.id.etURL);

        tvRepetii = (TextView) view.findViewById(R.id.tvRepetii);
        tvSerii = (TextView) view.findViewById(R.id.tvSerii);
        tvPauza = (TextView) view.findViewById(R.id.tvPauza);

        sbRepetii = (SeekBar) view.findViewById(R.id.sbRepetii);
        sbSerii = (SeekBar) view.findViewById(R.id.sbSerii);
        sbPauza = (SeekBar) view.findViewById(R.id.sbPauza);

        btnBrowse = (Button) view.findViewById(R.id.btnBrowse);
        btnAdauga = (Button) view.findViewById(R.id.btnAdauga);

        ivPreview = (ImageView) view.findViewById(R.id.ivPreviewImage);

        sbSerii.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvSerii.setText("Series : " + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbRepetii.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvRepetii.setText("Repeat : " + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbPauza.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                switch (i){
                    case 0 :
                        tvPauza.setText("Small Pause(15 sec)");
                        break;
                    case 1 :
                        tvPauza.setText("Medium Pause(30 sec)");
                        break;
                    case 2 :
                        tvPauza.setText("Long Pause(45 sec)");
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);

            }
        });

        etUrl.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Glide.with(getActivity()).load(etUrl.getText().toString()).into(ivPreview);
            }
        });



        btnAdauga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Exercise exercise = new Exercise();
                    if(etDen.getText().toString().isEmpty()){
                        etDen.setError("Incomplete");
                    }else {
                        etDen.setError(null);
                        exercise.setNume(etDen.getText().toString());
                    }
                    exercise.setNrSerii(sbSerii.getProgress());
                    exercise.setNrRepetitii(sbRepetii.getProgress());
                    switch (sbPauza.getProgress()) {
                        case 0:
                            exercise.setPauza(15);
                            break;
                        case 1:
                            exercise.setPauza(30);
                            break;
                        case 2:
                            exercise.setPauza(45);
                            break;
                    }
                    exercise.setCompleted(false);
                    if(etUrl.getText().toString().isEmpty()){
                        exercise.setAdresaImagine("");
                    }else {
                        exercise.setAdresaImagine(etUrl.getText().toString().trim());
                    }

                    if(Constants.DATABASE.insertExercise(exercise,-1)){
                        Toast.makeText(getActivity(),"Done!",Toast.LENGTH_LONG).show();
                    }else{
                        throw new Exception();
                    }


                }catch (Exception ex){
                    Toast.makeText(getActivity(),"Exercise not inserted",Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == PICK_IMAGE) {
            if(data!=null) {
                Glide.with(getActivity()).load(data.getDataString()).into(ivPreview);
                etUrl.setText(data.getDataString());
            }

        }
    }

}

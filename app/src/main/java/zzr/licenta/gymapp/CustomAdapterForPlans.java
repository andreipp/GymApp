package zzr.licenta.gymapp;

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
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrei on 03/21/2018.
 */

public class CustomAdapterForPlans extends ArrayAdapter<NoName> {

    private ArrayList<NoName> noNameArrayList = new ArrayList<NoName>();
    Context mContext;


    public CustomAdapterForPlans( Context context, @LayoutRes int resource,ArrayList<NoName> data){
        super(context,resource, data);
        this.noNameArrayList = data;
        this.mContext = context;
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

        if(noName!=null){

            TextView tvGrupa =(TextView) view.findViewById(R.id.tvGrupa);
            ImageButton imgBeginner = (ImageButton) view.findViewById(R.id.imgBeginner);
            TextView tvBeginner =(TextView) view.findViewById(R.id.tvBeginner);
            ImageButton imgIntermediate = (ImageButton) view.findViewById(R.id.imgIntermediate);
            TextView tvIntermediate =(TextView) view.findViewById(R.id.tvIntermediate);
            ImageButton imgAdvanced = (ImageButton) view.findViewById(R.id.imgAdvanced);
            TextView tvAdvanced =(TextView) view.findViewById(R.id.tvAdvanced);

            tvGrupa.setText(noName.getGrupa());

            List<TextView> lstTextViews= new ArrayList<TextView>();
            lstTextViews.addAll(Arrays.asList(tvBeginner,tvIntermediate,tvAdvanced));
            for(int i = 0 ;i <lstTextViews.size();i++){
                lstTextViews.get(i).setTextColor(Color.WHITE);
                lstTextViews.get(i).setText(noName.getTextPeImagine(i));
            }

            List<ImageButton> lstImageButtons = new ArrayList<ImageButton>();
            lstImageButtons.addAll(Arrays.asList(imgBeginner,imgIntermediate,imgAdvanced));

            List<Integer> lstColors = new ArrayList<Integer>();
            lstColors.addAll(Arrays.asList(Color.argb(50,0,0,100),Color.argb(100,0,0,100),Color.rgb(0,0,100)));

            for(int i = 0; i<lstImageButtons.size();i++){
                final int j = i;
                lstImageButtons.get(i).setBackgroundColor(lstColors.get(i));
                lstImageButtons.get(i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(mContext,Groups.class);
                        intent.putExtra(Constants.GRUPA_INTENSITATE,noName.getGrupa()+"_"+noName.getTextPeImagine(j));
                        mContext.startActivity(intent);
                    }
                });
            }
        }
        return view;
    }
}

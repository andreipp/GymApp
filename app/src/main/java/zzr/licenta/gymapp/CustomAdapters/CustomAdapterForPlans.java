package zzr.licenta.gymapp.CustomAdapters;

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
import java.util.List;

import zzr.licenta.gymapp.Configs.Constants;
import zzr.licenta.gymapp.ActivityClasses.Groups;
import zzr.licenta.gymapp.Model.NoName;
import zzr.licenta.gymapp.R;

/**
 * Created by Andrei on 03/21/2018.
 */

public class CustomAdapterForPlans extends ArrayAdapter<NoName> {

    private List<NoName> noNameArrayList = new ArrayList<NoName>();
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

        if(noName!=null) {

            TextView tvGrupa = (TextView) view.findViewById(R.id.tvGrupa);
            ImageButton imgBeginner = (ImageButton) view.findViewById(R.id.imgBeginner);
            TextView tvBeginner = (TextView) view.findViewById(R.id.tvBeginner);

            tvGrupa.setText(noName.getGrupa());


            tvBeginner.setTextColor(Color.WHITE);
            tvBeginner.setText(noName.getGrupa());


            imgBeginner.setBackgroundColor(Color.rgb(0, 0, 100));
            imgBeginner.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, Groups.class);
                    intent.putExtra(Constants.GRUPA, noName);
                    mContext.startActivity(intent);
                }
            });
        }
        return view;
    }
}

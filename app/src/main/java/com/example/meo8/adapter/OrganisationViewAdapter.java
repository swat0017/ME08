package com.example.me08.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.example.me08.R;

import com.example.meo8.entity.Organisation;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
//custom list adapter for search results
public class OrganisationViewAdapter extends ArrayAdapter<Organisation> {

    ArrayList<Organisation> organisations;
    Context context;
    int resource;

    Organisation organisation=null;
    TextView name;

    public OrganisationViewAdapter(Context context, int resource, ArrayList<Organisation> organisations) {
        super(context, resource, organisations);
        this.organisations = organisations;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.listview_org, null, true);

        }
        organisation = getItem(position);

          name = (TextView) convertView.findViewById(R.id.orgname);
        name.setText(organisation.getName()+","+organisation.getState()+","+organisation.getAddress());
        //image url from api call
         String url = organisation.getImage();
        //String url="https://image.tmdb.org/t/p/w92/qJ2tW6WMUDux911r6m7haRef0WH.jpg";
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewOrg);
        Picasso.with(context).setLoggingEnabled(true);
        Picasso.with(context).load(url).resize(92,92).into(imageView);
       Log.i("picassa","Picasso.with(context).load(url).resize(92,92).into(imageView)");


        return convertView;
    }
    @Override
    public boolean isEnabled(int position)
    {
        return true;
    }
}

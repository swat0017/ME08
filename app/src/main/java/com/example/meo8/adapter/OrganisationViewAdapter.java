package com.example.me08.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
    Button viewmoreorg_button;
    // MovieApiConnection movieApiConnection=null;
    Organisation organisation=null;

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

        final TextView name = (TextView) convertView.findViewById(R.id.orgname);
        name.setText(organisation.getName());
        //image url from tmdb
       // String url = "http://image.tmdb.org/t/p/w92";
        //ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewMovie);
        //Picasso.with(context).load(url+movie.getImage()).into(imageView);
        return convertView;
    }
    @Override
    public boolean isEnabled(int position)
    {
        return true;
    }
}

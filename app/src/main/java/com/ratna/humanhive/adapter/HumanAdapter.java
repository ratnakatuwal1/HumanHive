package com.ratna.humanhive.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.ratna.humanhive.Human;
import com.ratna.humanhive.R;

import java.util.ArrayList;

public class HumanAdapter extends ArrayAdapter<Human> {

    Activity activity;
    ArrayList<Human> humanArrayList;

    public HumanAdapter(@NonNull Activity context, ArrayList<Human> humanArrayList) {
        super(context, R.layout.item_human_list);
        this.activity = context;
        this.humanArrayList = humanArrayList;
    }
    
    @NonNull
    @Override
    public View getView (int position, @NonNull View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = LayoutInflater.inflate(R.layout.item_human_list, null, true);

        ImageView imageView = view.findViewById(R.id.thumbnail);
        TextView name = view.findViewById(R.id.name);
        TextView gender = view.findViewById(R.id.gender);
        TextView age = view.findViewById(R.id.age);
        TextView email = view.findViewById(R.id.email);
        TextView phone = view.findViewById(R.id.phone);
        TextView contact = view.findViewById(R.id.contact_number);

        Human human = humanArrayList.get(position);
        Glide.with(activity).load(human.thumbnail).into(imageView);
        String hname = human.title + " " + human.firstName + " " + human.lastName;
        name.setText(hname);
        gender.setText(human.gender);
        age.setText(human.age);
        email.setText(human.email);
        phone.setText(human.phone);
return view;
    }
}

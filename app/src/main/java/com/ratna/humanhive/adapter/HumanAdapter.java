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

import com.bumptech.glide.Glide;
import com.ratna.humanhive.Human;
import com.ratna.humanhive.R;

import java.util.ArrayList;

public class HumanAdapter extends ArrayAdapter<Human> {

    Activity context;
    ArrayList<Human> humanList;

    public HumanAdapter(@NonNull Activity context, ArrayList<Human> humanArrayList) {
        super(context, R.layout.item_human_list);
        this.context = context;
        this.humanList = humanList;
    }

    @Override
    public int getCount(){
        return humanList.size();
    }
    
    @NonNull
    @Override
    public View getView (int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        Human human = humanList.get(position);

        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.item_human_list, null, true);

        ImageView image = view.findViewById(R.id.thumbnail);

        Glide.with(context).load(human.getPictureThumbnail()).into(image);


        TextView name = view.findViewById(R.id.name);

        String nameText = human.getTitle() + " " + human.getFirstName() + " " + human.getLastName();
        name.setText(nameText);

        TextView age = view.findViewById(R.id.age);

        age.setText(String.valueOf(human.getDobAge()));


        TextView gender = view.findViewById(R.id.gender);

        gender.setText(human.getGender());

        TextView email = view.findViewById(R.id.email);

        email.setText(human.getEmail());

        TextView phone = view.findViewById(R.id.phone);

        phone.setText(human.getPhone());

        TextView contact = view.findViewById(R.id.contact_number);

        contact.setText(human.getCell());
        return view;
    }
}

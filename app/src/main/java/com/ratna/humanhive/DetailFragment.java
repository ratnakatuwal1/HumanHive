package com.ratna.humanhive;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailFragment extends Fragment {
ImageView detailThumbnail;
TextView detailName, detailGender, detailAge, detailEmail, detailPhone, detailCell, detailLocation, detailCoordinates, detailTimezone;
Human human;

DetailFragment(Human human) {
    this.human = human;
}

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        detailThumbnail = view.findViewById(R.id.detail_thumbnail);
        detailName = view.findViewById(R.id.detail_name);
        detailGender = view.findViewById(R.id.detail_gender);
        detailAge = view.findViewById(R.id.detail_age);
        detailEmail = view.findViewById(R.id.detail_email);
        detailPhone = view.findViewById(R.id.detail_phone);
        detailCell = view.findViewById(R.id.detail_cell);
        detailLocation = view.findViewById(R.id.detail_location);
        detailCoordinates = view.findViewById(R.id.detail_coordinates);
        detailTimezone = view.findViewById(R.id.detail_timezone);

        Glide.with(getContext()).load(human.getPictureLarge()).into(detailThumbnail);
        detailName.setText(human.getTitle() + " " + human.getFirstName() + " " + human.getLastName());
        detailGender.setText(human.getGender());
        detailAge.setText(String.valueOf(human.getDobAge()));
        detailEmail.setText(human.getEmail());
        detailPhone.setText(human.getPhone());
        detailCell.setText(human.getCell());
        detailLocation.setText(human.getStreetName() + " " + human.getCity() + " " + human.getState() + " " + human.getCountry() + " " + human.getPostcode());
        detailTimezone.setText(human.getTimezoneOffset() + " " + human.getTimezoneDescription());
        detailCoordinates.setText(human.getLatitude() + " " + human.getLongitude());
        return view;
    }
}
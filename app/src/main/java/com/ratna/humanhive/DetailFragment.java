package com.ratna.humanhive;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFragment extends Fragment {
private ImageView detailThumbnail;
private TextView detailName, detailGender, detailAge, detailEmail, detailPhone, detailCell, detailLocation, detailCoordinates, detailTimezone;

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
        return view;
    }
}
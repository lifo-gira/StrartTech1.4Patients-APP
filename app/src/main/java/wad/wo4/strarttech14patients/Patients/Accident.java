package wad.wo4.strarttech14patients.Patients;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wad.wo4.strarttech14patients.R;


public class Accident extends Fragment {

    ConstraintLayout constraintLayout4,constraintLayout5,button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_accident, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        constraintLayout4 = view.findViewById(R.id.constraintLayout4);
        constraintLayout5 = view.findViewById(R.id.constraintLayout5);

        GradientDrawable drawable = (GradientDrawable) constraintLayout4.getBackground();
        // Change the border color
        drawable.setStroke(10, getResources().getColor(R.color.black));

        GradientDrawable drawable1 = (GradientDrawable) constraintLayout5.getBackground();
        // Change the border color
        drawable1.setStroke(10, getResources().getColor(R.color.black));

        constraintLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradientDrawable drawable = (GradientDrawable) constraintLayout4.getBackground();
                // Change the border color
                drawable.setStroke(10, getResources().getColor(R.color.neonblue));

                GradientDrawable drawable1 = (GradientDrawable) constraintLayout5.getBackground();
                // Change the border color
                drawable1.setStroke(10, getResources().getColor(R.color.black));
            }
        });
        constraintLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradientDrawable drawable1 = (GradientDrawable) constraintLayout4.getBackground();
                // Change the border color
                drawable1.setStroke(10, getResources().getColor(R.color.black));

                GradientDrawable drawable = (GradientDrawable) constraintLayout5.getBackground();
                // Change the border color
                drawable.setStroke(10, getResources().getColor(R.color.neonblue));
            }
        });

        button= view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container1, new Gender());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

    }
}
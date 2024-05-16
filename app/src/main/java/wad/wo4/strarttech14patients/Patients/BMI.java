package wad.wo4.strarttech14patients.Patients;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

import wad.wo4.strarttech14patients.R;


public class BMI extends Fragment {


    NumberPicker height,weight;

    private  int h=0,w=0;

    private float bm=0;

    ConstraintLayout constraintLayout8,button;

    TextView bmivalue,fetchbmi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b_m_i, container, false);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        height = view.findViewById(R.id.numberPicker);
        weight= view.findViewById(R.id.numberPicker2);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            height.setTextColor(R.color.black);
            weight.setTextColor(R.color.black);
            height.setTextSize(60);
            weight.setTextSize(60);
        }

        height.setMinValue(0);
        weight.setMinValue(0);
        height.setMaxValue(1000);
        weight.setMaxValue(1000);

        button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container1, new Pain());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        bmivalue=view.findViewById(R.id.bmivalue);
        constraintLayout8=view.findViewById(R.id.constraintLayout8);



        fetchbmi=view.findViewById(R.id.fetchbmi);
        fetchbmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h=height.getValue();
                w=weight.getValue();
                BMI(w,h/100.0f);
            }
        });

    }

    private void BMI(int w, float h){
        Log.e("Height", String.valueOf(h));
        Log.e("Weight", String.valueOf(w));
        bm=w/(h*h);
        Log.e("Bmi", String.valueOf(bm));
        bmivalue.setText(String.format("%.2f",bm));
        constraintLayout8.setVisibility(View.VISIBLE);
    }
}
package wad.wo4.strarttech14patients.Patients;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import wad.wo4.strarttech14patients.R;


public class Introduction extends Fragment {


    CheckBox checkBox;
    ConstraintLayout button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_introduction, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        checkBox = view.findViewById(R.id.checkBox);
        button = view.findViewById(R.id.button);

        checkBox.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if(isChecked) {
                button.setVisibility(View.VISIBLE);
            }else{
                button.setVisibility(View.GONE);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container1, new Accident());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}
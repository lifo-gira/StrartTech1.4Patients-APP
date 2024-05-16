package wad.wo4.strarttech14patients.Nurses;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import wad.wo4.strarttech14patients.Nurses.Adapter.PatientListAdapter;
import wad.wo4.strarttech14patients.Nurses.DataModel.PatientData;
import wad.wo4.strarttech14patients.R;


public class Nursereports extends Fragment {



    RecyclerView patientlist;
    PatientListAdapter patientListAdapter;

    ArrayList<PatientData> patdata=new ArrayList<>();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        patientlist = view.findViewById(R.id.patientlist);
        patientlist.setLayoutManager(new LinearLayoutManager(getContext()));
        patientListAdapter = new PatientListAdapter(getContext(), getMydata());
        patientlist.setAdapter(patientListAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nursereports, container, false);
    }

    private ArrayList<PatientData> getMydata()  {

        patdata.add(new PatientData("Suresh","42","Male","2356478","Assigned",null));
        patdata.add(new PatientData("John", "35", "Male", "9876543", "Pending", null));
        patdata.add(new PatientData("Emily", "28", "Female", "8765432", "Assigned", null));
        patdata.add(new PatientData("Michael", "50", "Male", "7654321", "Assigned", null));
        patdata.add(new PatientData("Sophia", "42", "Female", "6543210", "Pending", null));
        patdata.add(new PatientData("David", "33", "Male", "5432109", "Pending", null));
        patdata.add(new PatientData("Emma", "29", "Female", "4321098", "Assigned", null));
        patdata.add(new PatientData("Daniel", "45", "Male", "3210987", "Assigned", null));
        patdata.add(new PatientData("Olivia", "38", "Female", "2109876", "Pending", null));
        patdata.add(new PatientData("William", "55", "Male", "1098765", "Pending", null));
        patdata.add(new PatientData("Ava", "31", "Female", "0987654", "Assigned", null));

        return patdata;
    }

}
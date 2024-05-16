package wad.wo4.strarttech14patients.Nurses;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import wad.wo4.strarttech14patients.Nurses.Adapter.PatientGenAdapter;
import wad.wo4.strarttech14patients.Nurses.DataModel.PatientData;
import wad.wo4.strarttech14patients.Nurses.DataModel.PatientGenData;
import wad.wo4.strarttech14patients.R;


public class NurseAnalysis extends Fragment {

    RecyclerView patientgentlist;

    PatientGenAdapter patientGenAdapter;

    ArrayList<PatientGenData> patdata=new ArrayList<>();


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        patientgentlist=view.findViewById(R.id.patientgenlist);
        patientgentlist.setLayoutManager(new LinearLayoutManager(getContext()));
        patientGenAdapter=new PatientGenAdapter(getContext(),getMydata());
        patientgentlist.setAdapter(patientGenAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nurse_analysis, container, false);
    }

    private ArrayList<PatientGenData> getMydata()  {

        patdata.add(new PatientGenData("Suresh","42","Male","2356478",null));
        patdata.add(new PatientGenData("John", "35", "Male", "9876543",  null));
        patdata.add(new PatientGenData("Emily", "28", "Female", "8765432",  null));
        patdata.add(new PatientGenData("Michael", "50", "Male", "7654321",  null));
        patdata.add(new PatientGenData("Sophia", "42", "Female", "6543210",  null));
        patdata.add(new PatientGenData("David", "33", "Male", "5432109",  null));
        patdata.add(new PatientGenData("Emma", "29", "Female", "4321098",  null));
        patdata.add(new PatientGenData("Daniel", "45", "Male", "3210987",  null));
        patdata.add(new PatientGenData("Olivia", "38", "Female", "2109876",  null));
        patdata.add(new PatientGenData("William", "55", "Male", "1098765",  null));
        patdata.add(new PatientGenData("Ava", "31", "Female", "0987654",  null));

        return patdata;
    }
}
package wad.wo4.strarttech14patients.Nurses;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import wad.wo4.strarttech14patients.Nurses.Adapter.DoctorListAdapter;
import wad.wo4.strarttech14patients.Nurses.Adapter.PatientListAdapter;
import wad.wo4.strarttech14patients.Nurses.DataModel.DoctorData;
import wad.wo4.strarttech14patients.Nurses.DataModel.PatientData;
import wad.wo4.strarttech14patients.R;


public class NurseDoctorDetails extends Fragment {


    ArrayList<DoctorData> docdata=new ArrayList<>();

    RecyclerView doctorslist;
    DoctorListAdapter doctorListAdapter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        doctorslist = view.findViewById(R.id.doctorslist);
        doctorslist.setLayoutManager(new LinearLayoutManager(getContext()));
        doctorListAdapter = new DoctorListAdapter(getContext(), getDocdata());

        GridLayoutManager gridLayoutManager= new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
        doctorslist.setLayoutManager(gridLayoutManager);
        doctorslist.setAdapter(doctorListAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nurse_doctor_details, container, false);
    }

    private ArrayList<DoctorData> getDocdata()  {

        docdata.add(new DoctorData("Suresh","Dermatologist"));
        docdata.add(new DoctorData("Alisha","Cardiologist"));
        docdata.add(new DoctorData("Rajesh","Neurologist"));
        docdata.add(new DoctorData("Priya","Pediatrician"));
        docdata.add(new DoctorData("Ankit","Orthopedic Surgeon"));
        docdata.add(new DoctorData("Neha","Oncologist"));
        docdata.add(new DoctorData("Vikram","Psychiatrist"));
        docdata.add(new DoctorData("Kavita","Gynecologist"));
        docdata.add(new DoctorData("Arjun","Urologist"));
        docdata.add(new DoctorData("Sanjay","ENT Specialist"));
        docdata.add(new DoctorData("Manisha","Endocrinologist"));


        return docdata;
    }
}
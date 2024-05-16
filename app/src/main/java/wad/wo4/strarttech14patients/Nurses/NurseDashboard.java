package wad.wo4.strarttech14patients.Nurses;

import android.app.DatePickerDialog;
import android.media.midi.MidiOutputPort;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.SimpleTimeZone;

import wad.wo4.strarttech14patients.Nurses.Adapter.PatientListAdapter;
import wad.wo4.strarttech14patients.Nurses.DataModel.PatientData;
import wad.wo4.strarttech14patients.R;


public class NurseDashboard extends Fragment {

    TextView datepick,viewall;
    int year=0,month=0,day=0;

    ArrayList<PatientData> patdata=new ArrayList<>();

    RecyclerView patientlist;
    PatientListAdapter patientListAdapter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        datepick=view.findViewById(R.id.datepick);
        final Calendar calendar = Calendar.getInstance();
        datepick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year=calendar.get(Calendar.YEAR);
                month=calendar.get(Calendar.MONTH);
                day=calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog= new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        datepick.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));
                    }
                }, year,month,day);
                datePickerDialog.show();
            }
        });

        viewall = view.findViewById(R.id.viewall);
        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.container1,new Nursereports());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        patientlist = view.findViewById(R.id.patientlist);
        patientlist.setLayoutManager(new LinearLayoutManager(getContext()));
        patientListAdapter = new PatientListAdapter(getContext(), getMydata());
        patientlist.setAdapter(patientListAdapter);

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nurse_dashboard, container, false);
    }
}
package wad.wo4.strarttech14patients.Nurses;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import wad.wo4.strarttech14patients.Nurses.NurseAnalysis;
import wad.wo4.strarttech14patients.Nurses.NurseDashboard;
import wad.wo4.strarttech14patients.Nurses.NurseDoctorDetails;
import wad.wo4.strarttech14patients.Nurses.Nursereports;
import wad.wo4.strarttech14patients.R;

public class Nurse extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_nurse);

        getSupportFragmentManager().beginTransaction().replace(R.id.container1,new NurseDashboard()).commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_home) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container1,new NurseDashboard()).commit();
            } else if (item.getItemId() == R.id.bottom_reports) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container1,new Nursereports()).commit();
            } else if (item.getItemId() == R.id.bottom_doctordetails) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container1,new NurseDoctorDetails()).commit();
            } else if (item.getItemId() == R.id.bottom_nurseanalysis) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container1,new NurseAnalysis()).commit();
            }
            return false;
        });

    }
}
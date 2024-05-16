package wad.wo4.strarttech14patients;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.ebanx.swipebtn.OnStateChangeListener;
import com.ebanx.swipebtn.SwipeButton;

import wad.wo4.strarttech14patients.Doctors.Doctor;
import wad.wo4.strarttech14patients.Nurses.Nurse;
import wad.wo4.strarttech14patients.Patients.MainActivity;

public class LoginActivity extends AppCompatActivity {

    ConstraintLayout user,nurse,doctor;
    private String nav;

    SwipeButton swipeButton;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        user=findViewById(R.id.constraintLayout14);
        nurse=findViewById(R.id.constraintLayout16);
        doctor=findViewById(R.id.constraintLayout15);

        swipeButton = findViewById(R.id.swipelogin);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nav="MainActivity.class";
                intent= new Intent(LoginActivity.this, MainActivity.class);

                swipeButton.setVisibility(View.VISIBLE);
                GradientDrawable drawable = (GradientDrawable) user.getBackground();
                drawable.setStroke(7, getResources().getColor(R.color.neonblue));
                GradientDrawable drawable1 = (GradientDrawable) nurse.getBackground();
                drawable1.setStroke(7, getResources().getColor(R.color.loginselectborder));
                GradientDrawable drawable2 = (GradientDrawable) doctor.getBackground();
                drawable2.setStroke(7, getResources().getColor(R.color.loginselectborder));
            }
        });
        nurse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nav="Nurse.class";
                intent= new Intent(LoginActivity.this, Nurse.class);

                swipeButton.setVisibility(View.VISIBLE);
                GradientDrawable drawable = (GradientDrawable) user.getBackground();
                drawable.setStroke(7, getResources().getColor(R.color.loginselectborder));
                GradientDrawable drawable1 = (GradientDrawable) nurse.getBackground();
                drawable1.setStroke(7, getResources().getColor(R.color.neonblue));
                GradientDrawable drawable2 = (GradientDrawable) doctor.getBackground();
                drawable2.setStroke(7, getResources().getColor(R.color.loginselectborder));
            }
        });
        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nav="Doctor.class";
                intent= new Intent(LoginActivity.this, Doctor.class);

                swipeButton.setVisibility(View.VISIBLE);
                GradientDrawable drawable = (GradientDrawable) user.getBackground();
                drawable.setStroke(7, getResources().getColor(R.color.loginselectborder));
                GradientDrawable drawable1 = (GradientDrawable) nurse.getBackground();
                drawable1.setStroke(7, getResources().getColor(R.color.loginselectborder));
                GradientDrawable drawable2 = (GradientDrawable) doctor.getBackground();
                drawable2.setStroke(7, getResources().getColor(R.color.neonblue));
            }
        });

        SwipeButton swipeButton = findViewById(R.id.swipelogin);
        swipeButton.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {
                startActivity(intent);

                GradientDrawable drawable = (GradientDrawable) user.getBackground();
                drawable.setStroke(7, getResources().getColor(R.color.loginselectborder));
                GradientDrawable drawable1 = (GradientDrawable) nurse.getBackground();
                drawable1.setStroke(7, getResources().getColor(R.color.loginselectborder));
                GradientDrawable drawable2 = (GradientDrawable) doctor.getBackground();
                drawable2.setStroke(7, getResources().getColor(R.color.loginselectborder));

            }
        });

    }
}
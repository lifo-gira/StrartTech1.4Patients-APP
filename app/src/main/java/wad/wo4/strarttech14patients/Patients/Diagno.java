package wad.wo4.strarttech14patients.Patients;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;

import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import ir.samanjafari.easycountdowntimer.CountDownInterface;
import ir.samanjafari.easycountdowntimer.EasyCountDownTextview;
import wad.wo4.strarttech14patients.Nurses.DataModel.DoctorData;
import wad.wo4.strarttech14patients.Patients.Adapter.IndiviCardAdapter;
import wad.wo4.strarttech14patients.Patients.DataModel.IndiviCardData;
import wad.wo4.strarttech14patients.R;


public class Diagno extends Fragment {


    NumberPicker min,sec;
    ImageView playtimer, sidebar, closedrawer;
    TextView side;
    int totaltime,m,s,playflag=0,i=0;

    RecyclerView indivi;
    IndiviCardAdapter indiviCardAdapter;
    ArrayList<IndiviCardData> indiviCardData = new ArrayList<>();

    DrawerLayout drawerLayout;
    NavigationView navigationMenu;


    private boolean isStarted = false;
    private int progressStatus = 0;
    private Handler handler;
    private Handler secondaryHandler;
    private int primaryProgressStatus = 0;
    private int secondaryProgressStatus = 0;

    ProgressBar progressBarSecondary;
    TextView textViewPrimary, textViewSecondary;
    Button buttonprogressd;



    ProgressBar progressBar;
    LinearLayout circleLayout;
    private int progressStat = 0;
    private Handler handle = new Handler();

    // Define the number of circles
    private final int numCircles = 4;

    @SuppressLint("ResourceAsColor")
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EasyCountDownTextview timer = view.findViewById(R.id.timer);
        Typeface typeface = ResourcesCompat.getFont(getContext(), R.font.poppinsmedium);
        timer.setTypeFace(typeface);

        sidebar = view.findViewById(R.id.imageView15);
        side = view.findViewById(R.id.textView);

        indivi = view.findViewById(R.id.indivi);
        indivi.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        indiviCardAdapter = new IndiviCardAdapter(getContext(),getindvidata());
        indivi.setAdapter(indiviCardAdapter);

        min=view.findViewById(R.id.min);
        sec=view.findViewById(R.id.sec);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            min.setTextColor(R.color.black);
            sec.setTextColor(R.color.black);
            min.setTextSize(40);
            sec.setTextSize(40);
        }

        min.setMinValue(0);
        sec.setMinValue(0);
        min.setMaxValue(80);
        sec.setMaxValue(80);

        playtimer=view.findViewById(R.id.imageView16);

        playtimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totaltime=0;
                m=0;
                s=0;
                i=0;
                if (playflag == 0) {
                    playflag =1;
                    m = min.getValue();
                    s = sec.getValue();
                    totaltime = (m * 60) + s;
                    playtimer.setImageResource(R.drawable.pause);
                    min.setVisibility(View.INVISIBLE);
                    sec.setVisibility(View.INVISIBLE);
                    timer.setVisibility(View.VISIBLE);
                    timer.setTime(0, 0, m, s);
                    timer.startTimer();
                } else{
                    playflag =0;
                    totaltime=0;
                    m=0;
                    s=0;
                    playtimer.setImageResource(R.drawable.playicon);
                    min.setVisibility(View.VISIBLE);
                    sec.setVisibility(View.VISIBLE);
                    timer.setVisibility(View.INVISIBLE);

                }
            }
        });

        drawerLayout = view.findViewById(R.id.drawerLayout);
        navigationMenu = view.findViewById(R.id.navigation);
        closedrawer = view.findViewById(R.id.closedrawer);

        closedrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(navigationMenu, true);
            }
        });

        sidebar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.END);

            }
        });
        side.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.END);
            }
        });

        progressBarSecondary = view.findViewById(R.id.progressBarSecondary);
        textViewPrimary = view.findViewById(R.id.textViewPrimary);
        textViewSecondary = view.findViewById(R.id.textViewSecondary);
        buttonprogressd = view.findViewById(R.id.btnProgressBarSecondary);

        buttonprogressd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click
                primaryProgressStatus = 0;
                secondaryProgressStatus = 0;

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (primaryProgressStatus < 100) {
                            primaryProgressStatus += 1;

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            // Start secondary progress
                            startSecondaryProgress();

                            secondaryProgressStatus = 0; // Reset secondary progress status

                            // Update UI on the main thread
                            requireActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    progressBarSecondary.setProgress(primaryProgressStatus);
                                    textViewPrimary.setText("Complete " + primaryProgressStatus + "% of 100");

                                    if (primaryProgressStatus == 100) {
                                        textViewPrimary.setText("All tasks completed");
                                    }
                                }
                            });
                        }
                    }
                }).start();
            }
        });




    }

    public void horizontalDeterminate() {
        isStarted = !isStarted;
    }

    public void startSecondaryProgress() {
        new Thread(() -> {
            while (secondaryProgressStatus < 100) {
                secondaryProgressStatus += 1;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                requireActivity().runOnUiThread(() -> {
                    progressBarSecondary.setSecondaryProgress(secondaryProgressStatus);
                    textViewSecondary.setText("Current task progress\n" + secondaryProgressStatus + "% of 100");
                    if (secondaryProgressStatus == 100) {
                        textViewSecondary.setText("Single task complete.");
                    }
                });
            }
        }).start();
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_diagno, container, false);
    }

    private ArrayList<IndiviCardData> getindvidata()  {

        indiviCardData.add(new IndiviCardData("10","5","10","5","5","1"));
        indiviCardData.add(new IndiviCardData("8", "3", "7", "4", "6","2"));
        indiviCardData.add(new IndiviCardData("12", "6", "9", "3", "7","3"));
        indiviCardData.add(new IndiviCardData("6", "4", "11", "5", "8","4"));
        indiviCardData.add(new IndiviCardData("9", "5", "8", "2", "4","5"));

        return indiviCardData;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
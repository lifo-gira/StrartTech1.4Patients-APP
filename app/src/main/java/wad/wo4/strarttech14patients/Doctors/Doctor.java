package wad.wo4.strarttech14patients.Doctors;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.Arrays;

import wad.wo4.strarttech14patients.Doctors.Dashboard;
import wad.wo4.strarttech14patients.Doctors.Exercise;
import wad.wo4.strarttech14patients.Doctors.PatientList;
import wad.wo4.strarttech14patients.Doctors.Schedule;
import wad.wo4.strarttech14patients.R;
import wad.wo4.strarttech14patients.SliderBar.DrawerAdapter;
import wad.wo4.strarttech14patients.SliderBar.DrawerItem;
import wad.wo4.strarttech14patients.SliderBar.SimpleItem;
import wad.wo4.strarttech14patients.SliderBar.SpaceItem;

public class Doctor extends AppCompatActivity implements DrawerAdapter.OnItemSelectedListener {

    private static final int DASHBOARD = 0;
    private static final int PATIENTLIST = 1;
    private static final int SCHEDULE = 2;
    private static final int SETTING = 3;
    private static final int POS_LOGOUT = 4;
    int count=0;

    private String[] screenTitles;
    private Drawable[] screenIcons;

    Button nextbutton;
    int flag=0;
    private SlidingRootNav slidingRootNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_doctor);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.hamburger);


        slidingRootNav = new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.menu_left_drawer)
                .inject();

        screenIcons = loadScreenIcons();
        screenTitles = loadScreenTitles();

        DrawerAdapter adapter = new DrawerAdapter(Arrays.asList(
                createItemFor(DASHBOARD).setChecked(true),
                createItemFor(PATIENTLIST),
                createItemFor(SCHEDULE),
                createItemFor(SETTING),
                new SpaceItem(48),
                createItemFor(POS_LOGOUT)));
        adapter.setListener(this);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        RecyclerView list1 = (RecyclerView) findViewById(R.id.list1);
        list1.setNestedScrollingEnabled(false);
        list1.setLayoutManager(new LinearLayoutManager(this));
        list1.setAdapter(adapter);
        adapter.setSelected(DASHBOARD);

    }

    @Override
    public void onItemSelected(int position) {

        if (position == POS_LOGOUT) {
            finish();
        }
        else if(position == DASHBOARD){
            getSupportFragmentManager().beginTransaction().replace(R.id.container1,new Exercise()).commit();
        }
        else if(position == PATIENTLIST){
            getSupportFragmentManager().beginTransaction().replace(R.id.container1,new PatientList()).commit();
        }
        else if(position == SCHEDULE){
            getSupportFragmentManager().beginTransaction().replace(R.id.container1,new Schedule()).commit();
        }

    }
    private DrawerItem createItemFor(int position) {
        return new SimpleItem(screenIcons[position], screenTitles[position])
                .withIconTint(color(R.color.textColorPrimary))
                .withTextTint(color(R.color.textColorPrimary))
                .withSelectedIconTint(color(R.color.colorAccent))
                .withSelectedTextTint(color(R.color.colorAccent));
    }

    private String[] loadScreenTitles() {
        return getResources().getStringArray(R.array.ld_activityScreenTitles1);
    }

    private Drawable[] loadScreenIcons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.ld_activityScreenIcons1);
        Drawable[] icons = new Drawable[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if (id != 0) {
                icons[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();
        return icons;
    }

    @ColorInt
    private int color(@ColorRes int res) {
        return ContextCompat.getColor(this, res);
    }
}
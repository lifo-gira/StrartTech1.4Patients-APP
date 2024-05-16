package wad.wo4.strarttech14patients.Patients;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.Arrays;

import wad.wo4.strarttech14patients.R;
import wad.wo4.strarttech14patients.SliderBar.DrawerAdapter;
import wad.wo4.strarttech14patients.SliderBar.DrawerItem;
import wad.wo4.strarttech14patients.SliderBar.SimpleItem;
import wad.wo4.strarttech14patients.SliderBar.SpaceItem;

public class MainActivity extends AppCompatActivity implements DrawerAdapter.OnItemSelectedListener {


    private static final int POS_INTRO = 0;
    private static final int POS_ACCIDENT = 1;
    private static final int POS_GENDER = 2;
    private static final int POS_BMI = 3;
    private static final int POS_PAIN = 4;
    private static final int POS_EXERCISE = 5;
    private static final int POS_LOGOUT = 6;
    int count=0;

    private String[] screenTitles;
    private Drawable[] screenIcons;
    Button nextbutton;
    int flag=0;
    private SlidingRootNav slidingRootNav;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

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
                createItemFor(POS_INTRO).setChecked(true),
                createItemFor(POS_ACCIDENT),
                createItemFor(POS_GENDER),
                createItemFor(POS_BMI),
                createItemFor(POS_PAIN),
                createItemFor(POS_EXERCISE),
                new SpaceItem(48),
                createItemFor(POS_LOGOUT)));
        adapter.setListener(this);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        RecyclerView list1 = (RecyclerView) findViewById(R.id.list1);
        list1.setNestedScrollingEnabled(false);
        list1.setLayoutManager(new LinearLayoutManager(this));
        list1.setAdapter(adapter);
        adapter.setSelected(POS_INTRO);

    }

    @Override
    public void onItemSelected(int position) {
        if (position == POS_LOGOUT) {
            finish();
        }
        else if(position == POS_INTRO){
            getSupportFragmentManager().beginTransaction().replace(R.id.container1,new Introduction()).commit();
        }
        else if(position == POS_ACCIDENT){
            getSupportFragmentManager().beginTransaction().replace(R.id.container1,new Accident()).commit();
        }
        else if(position == POS_GENDER){
            getSupportFragmentManager().beginTransaction().replace(R.id.container1,new Gender()).commit();
        }
        else if( position == POS_BMI){
            getSupportFragmentManager().beginTransaction().replace(R.id.container1,new BMI()).commit();
        }
        else if( position == POS_PAIN){
            getSupportFragmentManager().beginTransaction().replace(R.id.container1,new Pain()).commit();
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
        return getResources().getStringArray(R.array.ld_activityScreenTitles);
    }

    private Drawable[] loadScreenIcons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.ld_activityScreenIcons);
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
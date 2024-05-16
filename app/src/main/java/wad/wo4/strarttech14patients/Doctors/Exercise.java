package wad.wo4.strarttech14patients.Doctors;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import wad.wo4.strarttech14patients.Doctors.Adapter.ExerciseListAdapter;
import wad.wo4.strarttech14patients.Doctors.DataModel.ExerciseList;
import wad.wo4.strarttech14patients.Nurses.Adapter.DoctorListAdapter;
import wad.wo4.strarttech14patients.Nurses.Adapter.PatientGenAdapter;
import wad.wo4.strarttech14patients.Nurses.DataModel.DoctorData;
import wad.wo4.strarttech14patients.Nurses.DataModel.PatientGenData;
import wad.wo4.strarttech14patients.R;


public class Exercise extends Fragment {

    RecyclerView exerciselist;

    ExerciseListAdapter exerciseListAdapter;

    ArrayList<ExerciseList> exerciseLists=new ArrayList<>();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        exerciselist = view.findViewById(R.id.exerciselist);
        exerciselist.setLayoutManager(new LinearLayoutManager(getContext()));
        exerciseListAdapter = new ExerciseListAdapter(getContext(), getExercisedata());
        exerciselist.setAdapter(exerciseListAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercise, container, false);
    }

    private ArrayList<ExerciseList> getExercisedata()  {

        exerciseLists.add(new ExerciseList("Stretching","Side Stretch","3", "10"));
        exerciseLists.add(new ExerciseList("Dynamic Stretching", "Leg Swings", "3", "10"));
        exerciseLists.add(new ExerciseList("Static Stretching", "Hamstring Stretch", "2", "15"));
        exerciseLists.add(new ExerciseList("Pilates", "Hundreds", "3", "20"));
        exerciseLists.add(new ExerciseList("Yoga", "Downward Dog", "5", "30"));
        exerciseLists.add(new ExerciseList("Strength Training", "Bench Press", "4", "12"));
        exerciseLists.add(new ExerciseList("HIIT", "Jump Squats", "4", "20"));
        exerciseLists.add(new ExerciseList("Cardio", "Running", "1", "30"));
        exerciseLists.add(new ExerciseList("CrossFit", "Kettlebell Swings", "3", "15"));
        exerciseLists.add(new ExerciseList("Barre", "Plank with Leg Lift", "3", "12"));
        exerciseLists.add(new ExerciseList("Circuit Training", "Mountain Climbers", "4", "20"));


        return exerciseLists;
    }
}
package wad.wo4.strarttech14patients.Patients;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import wad.wo4.strarttech14patients.R;


public class Pain extends Fragment {


    private AutoCompleteTextView autoCompleteTextView;
    private ChipGroup chipGroup;
    private String[] suggestions = {"Left shoulder pain", "Ankle pain", "Knee pain"};

    private Typeface customTypeface;

    ConstraintLayout button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_pain, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        customTypeface = ResourcesCompat.getFont(requireContext(), R.font.poppinsregular);

        autoCompleteTextView = view.findViewById(R.id.autoCompleteText);
        chipGroup = view.findViewById(R.id.chipGroup);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_dropdown_item_1line, suggestions);
        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView.setOnItemClickListener((parent, view1, position, id) -> {
            String selectedPain = (String) parent.getItemAtPosition(position);
            addChip(selectedPain);
            autoCompleteTextView.setText(""); // Clear the text after selecting
        });

        button=view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container1, new Diagno());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });



    }
    private void addChip(String text) {
        Chip chip = (Chip) getLayoutInflater().inflate(R.layout.chipitem, chipGroup, false);

        chip.setText(text);
        chip.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);

        // Set custom font
        chip.setTypeface(customTypeface);

        chip.setEllipsize(null);
        chip.setCloseIconVisible(true);
        chip.setCheckable(false);
        chip.setClickable(false);
        chip.setOnCloseIconClickListener(v -> chipGroup.removeView(chip));
        chipGroup.addView(chip);
    }
}
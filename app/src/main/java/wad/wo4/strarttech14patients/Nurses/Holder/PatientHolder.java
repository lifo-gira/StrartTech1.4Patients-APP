package wad.wo4.strarttech14patients.Nurses.Holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import wad.wo4.strarttech14patients.R;


public class PatientHolder extends RecyclerView.ViewHolder {

    TextView title,stage,location,camera,video,priority,date;
    ImageView image;
    ConstraintLayout priority_layout;

    public PatientHolder(@NonNull View itemView) {
        super(itemView);


    }
}

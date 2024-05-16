package wad.wo4.strarttech14patients.Nurses.Holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PatientGenHolder extends RecyclerView.ViewHolder  {

    TextView title,stage,location,camera,video,priority,date;
    ImageView image;

    public PatientGenHolder(@NonNull View itemView) {
        super(itemView);


    }
}

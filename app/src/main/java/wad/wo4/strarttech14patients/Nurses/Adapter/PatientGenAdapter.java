package wad.wo4.strarttech14patients.Nurses.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import wad.wo4.strarttech14patients.Nurses.DataModel.PatientData;
import wad.wo4.strarttech14patients.Nurses.DataModel.PatientGenData;
import wad.wo4.strarttech14patients.R;

public class PatientGenAdapter extends RecyclerView.Adapter<PatientGenAdapter.PatientGenHolder> {

    ArrayList<PatientGenData> data;
    Context context;

    public PatientGenAdapter(Context context, ArrayList<PatientGenData> data) {
        this.data = data;
        this.context = context;

    }

    @NonNull
    @Override
    public PatientGenAdapter.PatientGenHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.patientgenlist,parent,false);
        return new PatientGenAdapter.PatientGenHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientGenAdapter.PatientGenHolder holder, int position) {

        holder.patientname.setText(data.get(position).getName());
        holder.patientage.setText(data.get(position).getAge());
        holder.patientgender.setText(data.get(position).getGender());
        holder.patientid.setText(data.get(position).getId());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class PatientGenHolder extends RecyclerView.ViewHolder {

        private ImageView profileimage;
        private CardView redirect;
        private TextView patientname,patientage,patientgender,patientid;
        public PatientGenHolder(@NonNull View itemView) {
            super(itemView);
            profileimage=itemView.findViewById(R.id.image_view2);
            patientname=itemView.findViewById(R.id.patientname);
            patientage=itemView.findViewById(R.id.patientage);
            patientgender=itemView.findViewById(R.id.gender);
            patientid=itemView.findViewById(R.id.idvalue);
            redirect=itemView.findViewById(R.id.gencard);
        }
    }
}

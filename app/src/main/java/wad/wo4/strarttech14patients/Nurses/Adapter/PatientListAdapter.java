package wad.wo4.strarttech14patients.Nurses.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import wad.wo4.strarttech14patients.Nurses.DataModel.PatientData;
import wad.wo4.strarttech14patients.Nurses.Holder.PatientHolder;
import wad.wo4.strarttech14patients.R;

public class PatientListAdapter extends RecyclerView.Adapter<PatientListAdapter.PatientHolder> {

    private LayoutInflater layoutInflater;
    private String due_color;
    ArrayList<PatientData> data;
    Context context;


    public PatientListAdapter(Context context, ArrayList<PatientData> data) {
        this.data = data;
this.context = context;

    }

    @NonNull
    @Override
    public PatientHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.patientlist,parent,false);
        return new PatientHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientListAdapter.PatientHolder holder, int position) {
        holder.patientname.setText(data.get(position).getName());
        holder.patientage.setText(data.get(position).getAge());
        holder.patientgender.setText(data.get(position).getGender());
        holder.patientid.setText(data.get(position).getId());
        holder.assign.setText(data.get(position).getStatus());
        if(data.get(position).getStatus() == "Pending"){
            holder.assign.setBackgroundColor(Color.parseColor("#E32C2C"));
        }else if(data.get(position).getStatus() == "Assigned"){
            holder.assign.setBackgroundColor(Color.parseColor("#25BFE1"));
        }

    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class PatientHolder extends RecyclerView.ViewHolder {

        private ImageView profileimage,redirect;
        private TextView patientname,patientage,patientgender,patientid,assign;

        public PatientHolder(@NonNull View itemView) {
            super(itemView);

            profileimage=itemView.findViewById(R.id.image_view2);
            patientname=itemView.findViewById(R.id.patientname);
            patientage=itemView.findViewById(R.id.patientage);
            patientgender=itemView.findViewById(R.id.gender);
            patientid=itemView.findViewById(R.id.idvalue);
            assign=itemView.findViewById(R.id.assign);
            redirect=itemView.findViewById(R.id.image_view3);
        }
    }
}

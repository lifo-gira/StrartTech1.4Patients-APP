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

import wad.wo4.strarttech14patients.Nurses.DataModel.DoctorData;
import wad.wo4.strarttech14patients.Nurses.DataModel.PatientData;
import wad.wo4.strarttech14patients.R;

public class DoctorListAdapter extends RecyclerView.Adapter<DoctorListAdapter.DoctorHolder> {

    ArrayList<DoctorData> data;
    Context context;

    public DoctorListAdapter(Context context, ArrayList<DoctorData> data) {
        this.data = data;
        this.context = context;

    }

    @NonNull
    @Override
    public DoctorListAdapter.DoctorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctorlist,parent,false);
        return new DoctorListAdapter.DoctorHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorListAdapter.DoctorHolder holder, int position) {
        holder.docname.setText(data.get(position).getName());
        holder.docspecial.setText(data.get(position).getSpecial());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class DoctorHolder extends RecyclerView.ViewHolder {

        private ImageView doctorimage;
        private TextView docname,docspecial;
        public DoctorHolder(@NonNull View itemView) {
            super(itemView);
            doctorimage=itemView.findViewById(R.id.doctorimage);
            docname=itemView.findViewById(R.id.doctorname);
            docspecial=itemView.findViewById(R.id.doctorspecialist);
        }
    }
}

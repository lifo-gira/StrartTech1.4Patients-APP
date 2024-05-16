package wad.wo4.strarttech14patients.Doctors.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import wad.wo4.strarttech14patients.Doctors.DataModel.ExerciseList;
import wad.wo4.strarttech14patients.Nurses.Adapter.DoctorListAdapter;
import wad.wo4.strarttech14patients.Nurses.DataModel.DoctorData;
import wad.wo4.strarttech14patients.R;

public class ExerciseListAdapter extends RecyclerView.Adapter<ExerciseListAdapter.ExerciseListHolder> {

    ArrayList<ExerciseList> data;
    Context context;
    public ExerciseListAdapter(Context context, ArrayList<ExerciseList> data) {

        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ExerciseListAdapter.ExerciseListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercisecard,parent,false);
        return new ExerciseListAdapter.ExerciseListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseListAdapter.ExerciseListHolder holder, int position) {
        holder.category.setText(data.get(position).getCategory());
        holder.name.setText(data.get(position).getExername());
        holder.rep.setText(data.get(position).getRepcount());
        holder.duration.setText(data.get(position).getRepduration());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ExerciseListHolder extends RecyclerView.ViewHolder {
        private ImageView exerciseimage;
        private TextView category,name,rep,duration;
        public ExerciseListHolder(@NonNull View itemView) {
            super(itemView);
            exerciseimage=itemView.findViewById(R.id.exerciseimage);
            category=itemView.findViewById(R.id.exercisecategory);
            name=itemView.findViewById(R.id.exercisename);
            rep=itemView.findViewById(R.id.repcount);
            duration=itemView.findViewById(R.id.durationcount);
        }
    }
}

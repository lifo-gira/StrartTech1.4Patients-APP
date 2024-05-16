package wad.wo4.strarttech14patients.Patients.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import wad.wo4.strarttech14patients.Patients.DataModel.IndiviCardData;
import wad.wo4.strarttech14patients.R;

public class IndiviCardAdapter extends RecyclerView.Adapter<IndiviCardAdapter.IndiviCardAdapter_ViewHolder>{

    Context context;
    ArrayList<IndiviCardData> data;

    public IndiviCardAdapter(Context context, ArrayList<IndiviCardData> data) {
        this.data=data;
        this.context=context;
    }

    @NonNull
    @Override
    public IndiviCardAdapter.IndiviCardAdapter_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.individualgraphcard,parent,false);
        return new IndiviCardAdapter.IndiviCardAdapter_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IndiviCardAdapter.IndiviCardAdapter_ViewHolder holder, int position) {
        holder.pain.setText(data.get(position).getPain());
        holder.max.setText(data.get(position).getMaxang());
        holder.min.setText(data.get(position).getMinang());
        holder.flex.setText(data.get(position).getFlexvel());
        holder.ext.setText(data.get(position).getExtenvel());
        holder.cycle.setText(data.get(position).getCyclecount());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class IndiviCardAdapter_ViewHolder extends RecyclerView.ViewHolder {

        TextView pain,max,min,flex,ext,cycle;

        public IndiviCardAdapter_ViewHolder(@NonNull View itemView) {
            super(itemView);
            pain=itemView.findViewById(R.id.painscore);
            max=itemView.findViewById(R.id.maximumangle);
            min=itemView.findViewById(R.id.minimumangle);
            flex=itemView.findViewById(R.id.flexionvelocity);
            ext=itemView.findViewById(R.id.extensionvelocity);
            cycle=itemView.findViewById(R.id.cyclecount);
        }
    }
}

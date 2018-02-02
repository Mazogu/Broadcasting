package com.example.micha.broadcastservices;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.micha.broadcastservices.model.Taco;

import java.util.List;

/**
 * Created by micha on 2/1/2018.
 */

public class TacoAdapter extends RecyclerView.Adapter<TacoAdapter.TacoHolder> {

    private static final String TAG = TacoAdapter.class.getSimpleName();
    private List<Taco> tacos;

    public TacoAdapter(List<Taco> tacos) {
        this.tacos = tacos;
    }

    @Override
    public TacoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.taco_card,parent,false);
        return new TacoHolder(view);
    }

    @Override
    public void onBindViewHolder(TacoHolder holder, int position) {
            holder.meat.setText(tacos.get(position).getMeat());
            holder.cheese.setText(tacos.get(position).getCheese());
            holder.shell.setText(tacos.get(position).getShell());
            holder.salsa.setText(tacos.get(position).getSalsa());
    }

    public void addToList(List<Taco> tacos){
        this.tacos.addAll(tacos);
        notifyDataSetChanged();
    }

    public List<Taco> getTacos(){
        return tacos;
    }

    @Override
    public int getItemCount() {
        return tacos.size();
    }

    public class TacoHolder extends RecyclerView.ViewHolder{
        private final TextView meat,cheese,shell,salsa;

        public TacoHolder(View itemView) {
            super(itemView);
            meat = itemView.findViewById(R.id.meat);
            cheese = itemView.findViewById(R.id.cheese);
            shell = itemView.findViewById(R.id.shell);
            salsa = itemView.findViewById(R.id.salsa);
        }
    }
}

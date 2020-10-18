package com.dastan.tezbus.ui.travel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dastan.tezbus.R;
import com.dastan.tezbus.Travel;

import org.w3c.dom.Text;

import java.util.List;

public class TravelResultAdapter extends RecyclerView.Adapter<TravelResultAdapter.TravelResultViewHolder> {

    private List<Travel> travelList;

    public TravelResultAdapter(List<Travel> travelList) {
        this.travelList = travelList;
    }

    @NonNull
    @Override
    public TravelResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_travel_schedule, parent,false);
        return new TravelResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TravelResultViewHolder holder, int position) {
        holder.bind(travelList.get(position));
    }

    @Override
    public int getItemCount() {
        return travelList.size();
    }

    public class TravelResultViewHolder extends RecyclerView.ViewHolder{

        private TextView textDate;
        private TextView textTime;
        private TextView textDirection;
        private TextView textPrice;
        private TextView textInfo;

        public TravelResultViewHolder(@NonNull View itemView) {
            super(itemView);
            initViews(itemView);
        }

        private void initViews(View view){
            textDate = view.findViewById(R.id.tvDate);
            textTime = view.findViewById(R.id.tvTime);
            textDirection = view.findViewById(R.id.tvDirection);
            textPrice = view.findViewById(R.id.tvPrice);
            textInfo = view.findViewById(R.id.tvInfo);
        }

        public void bind(Travel travel) {
            textDate.setText(travel.getDate());
            textTime.setText(travel.getTime());
            textDirection.setText(travel.getDirection());
            textPrice.setText(travel.getPrice());
            textInfo.setText(travel.getInfo());
        }
    }
}

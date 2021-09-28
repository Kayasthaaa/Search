package com.example.search;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List <Model> ModelList;
    public Adapter (List <Model> ModelList) {this.ModelList=ModelList;}


    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_second,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        int rescource = ModelList.get(position).getImage();
        String name= ModelList.get(position).getCountry_name();
        String capital = ModelList.get(position).getCapital();
        String reg = ModelList.get(position).getRegion();
        String pop = ModelList.get(position).getPopln();
        String bord = ModelList.get(position).getBor();
        String language = ModelList.get(position).getLang();

        holder.setData(rescource,name,capital,reg,pop,bord,language);

    }

    @Override
    public int getItemCount() {
        return ModelList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView Image;
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Image = itemView.findViewById(R.id.image);
            textView1 = itemView.findViewById(R.id.country_name);
            textView2 = itemView.findViewById(R.id.capital);
            textView3 = itemView.findViewById(R.id.region);
            textView4 = itemView.findViewById(R.id.popln);
            textView5 = itemView.findViewById(R.id.bor);
            textView6 = itemView.findViewById(R.id.lang);


        }

        public void setData(int rescource, String name, String capital, String reg, String pop ,String bord, String language) {

            Image.setImageResource(rescource);
            textView1.setText(name);
            textView2.setText(capital);
            textView3.setText(reg);
            textView4.setText(pop);
            textView5.setText(bord);
            textView6.setText(language);
        }


    }

    public void filterList(ArrayList<Model> filteredList){

        ModelList = filteredList;
        notifyDataSetChanged();
    }


}

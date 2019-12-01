package com.example.roomdbmvvmexample.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdbmvvmexample.R;
import com.example.roomdbmvvmexample.model.Movie;
import com.example.roomdbmvvmexample.model.MovieList;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>{

    public List<MovieList> mLists = new ArrayList<>();


    public void updateList(List<MovieList> newList){
        mLists.clear();
        mLists.addAll(newList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item,parent,false);
        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {

        holder.movie_name.setText(mLists.get(position).title);
        holder.release_date.setText(mLists.get(position).release_date);
        holder.movie_overView.setText(mLists.get(position).overview);

    }

    @Override
    public int getItemCount() {
        return mLists.size();
    }

    public class MoviesViewHolder extends RecyclerView.ViewHolder{

        TextView movie_name,release_date,movie_overView;

        public MoviesViewHolder(@NonNull View itemView) {
            super(itemView);

            movie_name = itemView.findViewById(R.id.movie_name);
            release_date = itemView.findViewById(R.id.release_date);
            movie_overView = itemView.findViewById(R.id.movie_overView);

        }
    }
}

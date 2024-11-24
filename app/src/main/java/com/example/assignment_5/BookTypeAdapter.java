package com.example.assignment_5;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookTypeAdapter extends RecyclerView.Adapter<BookTypeAdapter.ViewHolder> {

    private Context context;
    private List<String> bookTypes;

    private int[] bookImages = {
            R.drawable.science, R.drawable.fiction, R.drawable.thriller,
            R.drawable.fantasy, R.drawable.history, R.drawable.biography,
            R.drawable.philosophy, R.drawable.art, R.drawable.technology,
            R.drawable.self_help
    };

    public BookTypeAdapter(Context context, List<String> bookTypes) {
        this.context = context;
        this.bookTypes = bookTypes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String bookType = bookTypes.get(position);
        holder.bookTypeTextView.setText(bookType);

        if (position < bookImages.length) {
            holder.bookTypeImageView.setImageResource(bookImages[position]);
        }

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, BookListActivity.class);
            intent.putExtra("bookType", bookType);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return bookTypes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView bookTypeTextView;
        ImageView bookTypeImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Corrected IDs for TextView and ImageView
            bookTypeTextView = itemView.findViewById(R.id.bookTypeTextView);
            bookTypeImageView = itemView.findViewById(R.id.bookTypeImageView);
        }
    }
}

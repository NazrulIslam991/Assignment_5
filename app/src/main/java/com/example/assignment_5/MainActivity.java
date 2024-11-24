package com.example.assignment_5;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String[] bookTypes = {
            "Science", "Fiction", "Thriller", "Fantasy",
            "History", "Biography", "Philosophy", "Art", "Technology",
            "Self-Help"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.Home));

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        List<String> bookTypeList = Arrays.asList(bookTypes);

        BookTypeAdapter adapter = new BookTypeAdapter(this, bookTypeList);
        recyclerView.setAdapter(adapter);
    }
}

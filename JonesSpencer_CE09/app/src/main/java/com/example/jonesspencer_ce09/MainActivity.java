// Spencer Jones
// MDV3832-0 - 062024
// MainActivity.java

package com.example.jonesspencer_ce09;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ProgressBar progressBar;
    private BookFetcher bookFetcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        progressBar = findViewById(R.id.progressBar);

        bookFetcher = new BookFetcher(this);
        fetchBooks();
    }

    private void fetchBooks() {
        bookFetcher.fetchBooks();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bookFetcher.cancel();
    }
}
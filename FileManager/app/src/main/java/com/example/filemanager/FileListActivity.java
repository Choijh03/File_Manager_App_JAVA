package com.example.filemanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class FileListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_list);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        TextView noFielsText  = findViewById(R.id.nofiles_textview);

        String path = getIntent().getStringExtra("path");

        File root = new File(path);
        File [] filesAndFolders = root.listFiles();

        if(filesAndFolders == null || filesAndFolders.length == 0){
            noFielsText.setVisibility(View.VISIBLE);
            return;
        }

        noFielsText.setVisibility(View.INVISIBLE);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),filesAndFolders));
    }
}
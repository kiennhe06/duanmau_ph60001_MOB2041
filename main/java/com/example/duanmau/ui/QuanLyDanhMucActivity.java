package com.example.duanmau.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.duanmau.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class QuanLyDanhMucActivity extends AppCompatActivity {
    private ListView lvDanhMuc;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_danh_muc);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        lvDanhMuc = findViewById(R.id.lvSanPham);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Quản lý danh mục");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fabThemDanhMuc = findViewById(R.id.fabThemDanhMuc);

        fabThemDanhMuc.setOnClickListener(view -> {
            Toast.makeText(this, "Chức năng thêm danh mục sẽ được thêm sau", Toast.LENGTH_SHORT).show();
        });
    }
}


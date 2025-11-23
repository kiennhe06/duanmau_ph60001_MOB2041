package com.example.duanmau.ui;

import static android.view.View.GONE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.duanmau.R;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int chucVu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Home");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        toolbar.setPopupTheme(R.style.DarkPopupMenu);

        findViewById(R.id.lnDoiMatKhau).setOnClickListener(this);
        findViewById(R.id.lnDangXuat).setOnClickListener(this);

        chucVu = getIntent().getIntExtra("CHUC_VU", 0);
        if (chucVu == 0) {
            View lnThongKe = findViewById(R.id.lnThongKe);
            View lnNhanVien = findViewById(R.id.lnNhanVien);
            if (lnThongKe != null) lnThongKe.setVisibility(GONE);
            if (lnNhanVien != null) lnNhanVien.setVisibility(GONE);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.lnDangXuat) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
    }
}


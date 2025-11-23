package com.example.duanmau.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.duanmau.R;

import java.util.Objects;

public class DoiMatKhauActivity extends AppCompatActivity {
    private EditText edtMatKhauCu, edtMatKhauMoi, edtNhapLaiMatKhauMoi;
    private Button btnLuu, btnHuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_mat_khau);

        edtMatKhauCu = findViewById(R.id.edtOldPassword);
        edtMatKhauMoi = findViewById(R.id.edtNewPassword);
        edtNhapLaiMatKhauMoi = findViewById(R.id.edtConfirmPassword);
        btnLuu = findViewById(R.id.btnLuu);
        btnHuy = findViewById(R.id.btnHuy);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Đổi mật khẩu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnLuu.setOnClickListener(v -> doiMatKhau());
        btnHuy.setOnClickListener(v -> {
            edtMatKhauCu.setText("");
            edtMatKhauMoi.setText("");
            edtNhapLaiMatKhauMoi.setText("");
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void doiMatKhau() {
        String matKhauCu = edtMatKhauCu.getText().toString().trim();
        String matKhauMoi = edtMatKhauMoi.getText().toString().trim();
        String nhapLaiMatKhauMoi = edtNhapLaiMatKhauMoi.getText().toString().trim();

        if (matKhauCu.isEmpty() || matKhauMoi.isEmpty() || nhapLaiMatKhauMoi.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }

        if (matKhauMoi.equals(matKhauCu)) {
            Toast.makeText(this, "Mật khẩu mới phải khác so với mật khẩu cũ", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!matKhauMoi.equals(nhapLaiMatKhauMoi)) {
            Toast.makeText(this, "Mật khẩu mới không khớp!", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Đổi mật khẩu thành công!", Toast.LENGTH_SHORT).show();
        finish();
    }
}


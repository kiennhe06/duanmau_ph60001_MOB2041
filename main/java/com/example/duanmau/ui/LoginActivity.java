package com.example.duanmau.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duanmau.R;

public class LoginActivity extends AppCompatActivity {
    private EditText edtUsername, edtPassword;
    private CheckBox chkRemember;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        chkRemember = findViewById(R.id.chkRemember);
        Button btnLogin = findViewById(R.id.btnLogin);

        sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);
        ghiNhoThongTinNguoiDung();
        btnLogin.setOnClickListener(view -> checkDangNhap());
    }

    private void ghiNhoThongTinNguoiDung() {
        String savedUsername = sharedPreferences.getString("username", "");
        String savedPassword = sharedPreferences.getString("password", "");
        boolean isRemembered = sharedPreferences.getBoolean("remember", false);

        edtUsername.setText(savedUsername);
        edtPassword.setText(savedPassword);
        chkRemember.setChecked(isRemembered);
    }

    private void checkDangNhap() {
        String maNhanVien = edtUsername.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        
        if (maNhanVien.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (chkRemember.isChecked()) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username", maNhanVien);
            editor.putString("password", password);
            editor.putBoolean("remember", true);
            editor.apply();
        } else {
            sharedPreferences.edit().clear().apply();
        }

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("CHUC_VU", 1);
        startActivity(intent);
        finish();
    }
}


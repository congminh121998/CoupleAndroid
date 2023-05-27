package com.example.couple.View.Main.HomePage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.couple.R;
import com.example.couple.View.Sub.ExperianceActivity;
import com.example.couple.ViewModel.Main.HomePage.EnterPasswordViewModel;

public class EnterPasswordDialog extends Dialog implements EnterPasswordView{

    public Activity activity;
    EditText edtPassword;
    Button btnOK;

    EnterPasswordViewModel viewModel;

    public EnterPasswordDialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_enter_password);
        edtPassword = findViewById(R.id.edtPassword);
        btnOK = findViewById(R.id.btnOK);

        viewModel=new EnterPasswordViewModel(activity,this);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password=edtPassword.getText().toString().trim();
                if(password.equals("")){
                    ShowError("Bạn chưa nhập mật khẩu.");
                }else {
                    viewModel.CheckPassword(password);
                }

            }
        });

    }

    @Override
    public void ShowError(String message) {
        Toast.makeText(activity,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void PasswordIsRight() {
        activity.startActivity(new Intent(activity, ExperianceActivity.class));
    }
}
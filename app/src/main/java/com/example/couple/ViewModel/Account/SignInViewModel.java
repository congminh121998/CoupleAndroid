package com.example.couple.ViewModel.Account;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.couple.View.Account.SignInView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInViewModel {
    Context context;
    SignInView signInView;

    public SignInViewModel(Context context, SignInView signInView) {
        this.context = context;
        this.signInView = signInView;
    }

    public void SignIn(String username, String password) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(username,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            signInView.SignInSuccess();
                        }else {
                            signInView.ShowError("Bạn đã nhập sai tên đăng nhập hoặc mật khẩu!");
                            Log.d("MINHTRAN",task.getException().getMessage());
                        }
                    }
                });
    }
}
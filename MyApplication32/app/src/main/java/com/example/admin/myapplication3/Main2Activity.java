package com.example.admin.myapplication3;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Main2Activity extends AppCompatActivity {
    EditText e3;
    Button b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        e3 =  (EditText)findViewById(R.id.editText3);
        b2 = (Button)findViewById(R.id.button3);
        b3 = (Button)findViewById(R.id.button5);
        Bundle bundle = null;
        bundle = getIntent().getExtras();

    }

    public void Resend_sms(View v)
    {
        String number = e1.getText().toString();
        PhoneAuthProvider.getInstance().verifyPhoneNumber( number, 60, TimeUnit.SECONDS, this, mcallback);
    }
    public void signInWithPhone(PhoneAuthCredential credential)
    {
        auth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(),"User signed in succesfully",Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }
    public void verify(View v)
    {
        String input_code=e2.getText().toString();
        {
            verifyPhoneNumber(verification_code,input_code);
        }
    }

    public void verifyPhoneNumber(String verification_code,String input_code)
    {
        PhoneAuthCredential credential  = PhoneAuthProvider.getCredential(verification_code,input_code);
        signInWithPhone(credential);
    }
}





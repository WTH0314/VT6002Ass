package com.example.vt6002app.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.content.Intent;

import com.example.vt6002app.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vt6002app.R;

public class SignupActivity extends AppCompatActivity {
    Activity context = this;
    TextView tvb;
    EditText edt1, edt2;
    Button bt;
    ImageButton btb;
    String email;

    // connect to Firebase
    FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_signupactivity);

        edt1=(EditText)findViewById(R.id.editText1);
        edt2=(EditText)findViewById(R.id.editText2);

        bt=(Button) findViewById(R.id.button);

        tvb=(TextView)findViewById(R.id.textViewBack);

        btb=(ImageButton)findViewById(R.id.backButton);

        mAuth=FirebaseAuth.getInstance();


        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mAuth.createUserWithEmailAndPassword(edt1.getText().toString(),
                        edt2.getText().toString()).addOnCompleteListener(context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser user=mAuth.getCurrentUser();
                            tvb.setText("Sign up is Successful.");
                        }else{
                            tvb.setText("Error, can not sign up your email. Please check whether the email you entered contains \"blank\"  "+task.getException());
                        }
                    }
                });
            }
        });

        btb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(SignupActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}

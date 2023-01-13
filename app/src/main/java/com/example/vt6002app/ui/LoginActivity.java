package com.example.vt6002app.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vt6002app.MainActivity;
import com.example.vt6002app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    Activity context = this;
    TextView tvb;
    EditText edt1, edt2;
    Button btn1, btn2;
    ImageButton btb;

    // connect to Firebase
    FirebaseAuth mAuth;



    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_loginactivity);

        edt1=(EditText)findViewById(R.id.editText1);
        edt2=(EditText)findViewById(R.id.editText2);

        btn1=(Button) findViewById(R.id.button);
        btn2=(Button) findViewById(R.id.button2);
        btb=(ImageButton)findViewById(R.id.backButton);

        tvb=(TextView)findViewById(R.id.textViewBack);

        mAuth=FirebaseAuth.getInstance();

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mAuth.signInWithEmailAndPassword(edt1.getText().toString(),
                        edt2.getText().toString()).addOnCompleteListener(context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser user=mAuth.getCurrentUser();
                            tvb.setText("Login is Successful. Welcome "+user.getEmail());
                        }else{
                            tvb.setText("Error. Please check whether the email you entered contains \"blank\"  "+task.getException());
                        }
                    }
                });
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText(null);
                edt2.setText(null);
            }
        });

        btb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}

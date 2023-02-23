package com.example.parcial1_2518602019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText teUser, tePassword;

    private TextView tvStatus;
    private String user, password;

    private Intent i;

    public MainActivity(){
        this.user = "parcialETps1";
        this.password = "p4rC14l#tp$";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.teUser = findViewById(R.id.teUser);
        this.tePassword = findViewById(R.id.tePassword);

        this.tvStatus = findViewById(R.id.tvStatus);
    }

    public void login(View view){
        String user =  this.teUser.getText().toString();
        String password = this.tePassword.getText().toString();

        if(this.user.equals(user) && this.password.equals(password)){
            this.i = new Intent(MainActivity.this, CalcularImc.class);
            initView(this.i);
        }else{
            System.out.println("entro");
            this.tvStatus.setText("contraseña y usuario no son correctos");
        }
    }
    private void initView(Intent intent){
        startActivity(intent);
    }
}
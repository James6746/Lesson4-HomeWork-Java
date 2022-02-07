package com.example.lesson4.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.lesson4.R;
import com.example.lesson4.model.Member;
import com.example.lesson4.model.User;

public class Task4_SecondActivity extends AppCompatActivity {
    TextView name;
    TextView age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task4_second);

        name = findViewById(R.id.tv_recieved_name);
        age = findViewById(R.id.tv_recieved_age);

        Bundle bundle = getIntent().getExtras();
        User user = (User) bundle.getSerializable("User");
        name.setText(user.getName());
        age.setText(String.valueOf(user.getAge()));

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Member member = new Member();
                member.setName((new StringBuilder(user.getName())).reverse().toString());
                int newAge = 0;
                int tempAge = user.getAge();

                while(tempAge != 0){
                    newAge *= 10;
                    newAge += tempAge % 10;
                    tempAge /= 10;
                }

                member.setAge(newAge);

                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("Member", member);
                Intent resultIntent = new Intent();
                resultIntent.putExtras(bundle2);

                setResult(RESULT_OK, resultIntent);
                finish();

            }
        });



    }
}
package com.example.lesson4.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lesson4.R;
import com.example.lesson4.model.Member;
import com.example.lesson4.model.MemberParcelable;
import com.example.lesson4.model.User;
import com.example.lesson4.model.UserParcelable;


public class Task5_SecondActivity extends AppCompatActivity {
    TextView name;
    TextView age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task5_second);

        name = findViewById(R.id.tv_recieved_name);
        age = findViewById(R.id.tv_recieved_age);

        Bundle bundle = getIntent().getExtras();
        UserParcelable userParcelable = (UserParcelable) bundle.getParcelable("User");
        name.setText(userParcelable.getName());
        age.setText(String.valueOf(userParcelable.getAge()));

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MemberParcelable memberParcelable = new MemberParcelable();
                memberParcelable.setName((new StringBuilder(userParcelable.getName())).reverse().toString());
                int newAge = 0;
                int tempAge = userParcelable.getAge();

                while (tempAge != 0) {
                    newAge *= 10;
                    newAge += tempAge % 10;
                    tempAge /= 10;
                }

                memberParcelable.setAge(newAge);

                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("MemberParcelable", memberParcelable);
                Intent resultIntent = new Intent();
                resultIntent.putExtras(bundle2);

                setResult(RESULT_OK, resultIntent);
                finish();

            }
        });


    }
}

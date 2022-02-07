package com.example.lesson4.activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lesson4.R;
import com.example.lesson4.model.Member;
import com.example.lesson4.model.User;

public class Task4_FirstActivity extends AppCompatActivity {

    EditText et_name;
    EditText et_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task4_first);

        User user = new User();

        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);

        ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {

                            Member member = (Member) result.getData().getExtras().getSerializable("Member");
                            et_name.setText(member.getName());
                            et_age.setText(String.valueOf(member.getAge()));


                        }
                    }
                });


        findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user.setName(et_name.getText().toString());
                user.setAge((Integer.parseInt(et_age.getText().toString())));

                Intent intent = new Intent(getApplicationContext(), Task4_SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("User", user);
                intent.putExtras(bundle);

                someActivityResultLauncher.launch(intent);

                Toast.makeText(getApplicationContext(), user.getName(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
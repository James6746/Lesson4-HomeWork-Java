package com.example.lesson4.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lesson4.R;
import com.example.lesson4.model.MemberParcelable;
import com.example.lesson4.model.User;
import com.example.lesson4.model.UserParcelable;

public class Task5_FirstActivity extends AppCompatActivity {

    EditText et_name;
    EditText et_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task5_first);

        UserParcelable userParcelable = new UserParcelable();

        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);

        ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {

                            assert result.getData() != null;
                            MemberParcelable memberParcelable = (MemberParcelable) result.getData().getExtras().getParcelable("MemberParcelable");
                            et_name.setText(memberParcelable.getName());
                            et_age.setText(String.valueOf(memberParcelable.getAge()));

                        }
                    }
                });


        findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userParcelable.setName(et_name.getText().toString());
                userParcelable.setAge((Integer.parseInt(et_age.getText().toString())));

                Intent intent = new Intent(getApplicationContext(), Task5_SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("User", userParcelable);
                intent.putExtras(bundle);

                someActivityResultLauncher.launch(intent);

                Toast.makeText(getApplicationContext(), userParcelable.getName(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
package com.guozhe.android.property;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    EditText editName,editEmail,editPassword;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("settings",MODE_PRIVATE);
        editName = (EditText)findViewById(R.id.editName);
        editEmail = (EditText)findViewById(R.id.editEmail);
        editPassword =(EditText)findViewById(R.id.editPassword);

        loadPreference();

        save = (Button)findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               savePref("name",editName.getText().toString());
                savePref("email",editEmail.getText().toString());
                savePref("password",editPassword.getText().toString());

            }
        });

    }
    private  void loadPreference(){
        String name = sharedPreferences.getString("name","");
        String email = sharedPreferences.getString("email","");
        String password = sharedPreferences.getString("password","");

        editName.setText(name);
        editEmail.setText(email);
        editPassword.setText(password);


    }
    public void savePref(String key,String value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key,value);
        editor.commit();


    }

    private void removePreferences(String key){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.commit();
    }

    // 전체 삭제하기
    private void removeAllPreferences(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }


}

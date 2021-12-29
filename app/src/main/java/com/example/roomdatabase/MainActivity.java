package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText t1,t2,t3;
    Button b1;
    TextView lbl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        b1 = findViewById(R.id.b1);
        lbl = findViewById(R.id.lbl);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"Room_db").allowMainThreadQueries().build();
                UserDao userDao = db.userDao();
                Boolean check = userDao.is_exist(Integer.parseInt(t1.getText().toString()));
                if (check == false){
                    userDao.insertrecord(new User(Integer.parseInt(t1.getText().toString()),t2.getText().toString(),t3.getText().toString()));
                    t1.setText("");
                    t2.setText("");
                    lbl.setText("Inserted Successfully");
                }else {
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    lbl.setText("Data already exists");

                }
            }
        });
    }

   /* class bgthread extends Thread {

        public void run(){
            super.run();
            AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                    AppDatabase.class, "room.db").build();
            UserDao userDao = db.userDao();
            userDao.insertrecord(new User(1,t1.getText().toString(),t2.getText().toString()));
            t1.setText("");
            t2.setText("");
        }
    }*/
}
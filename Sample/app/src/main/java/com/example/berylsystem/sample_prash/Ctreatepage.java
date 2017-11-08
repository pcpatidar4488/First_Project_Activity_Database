package com.example.berylsystem.sample_prash;

import android.content.Intent;
import android.os.ParcelUuid;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ctreatepage extends AppCompatActivity {

    boolean result;
    EditText name, mobile_number, etclass, rollno;
    Button save, update;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ctreatepage);

        name = (EditText) findViewById(R.id.name);
        rollno = (EditText) findViewById(R.id.rollno);

        mobile_number = (EditText) findViewById(R.id.mobile_no);

        etclass = (EditText) findViewById(R.id.etclass);

        save = (Button) findViewById(R.id.save);

        update = (Button) findViewById(R.id.update);


        //Value pas
        //final String my_id = getIntent().getStringExtra("id");

        String name1 = getIntent().getStringExtra("name");
        name.setText(name1);
        String rollno1 = getIntent().getStringExtra("rollno");
        rollno.setText(rollno1);

        final String mobile1 = getIntent().getStringExtra("mobile_no");
        mobile_number.setText(mobile1);
        String etclass1 = getIntent().getStringExtra("etclass");
        etclass.setText(etclass1);

       /* Toast.makeText(Ctreatepage.this, ""+mobile1, Toast.LENGTH_LONG).show();
        Toast.makeText(Ctreatepage.this, ""+etclass1, Toast.LENGTH_LONG).show();*/

        //end


        databaseHelper = new DatabaseHelper(this);

        Boolean button = getIntent().getExtras().getBoolean("pc");


        if (button) {

            update.setVisibility(View.GONE);

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        result = databaseHelper.insertData(name.getText().toString(), rollno.getText().toString(), mobile_number.getText().toString(), etclass.getText().toString());

                        if (result && (!name.getText().toString().equals("") && !rollno.getText().toString().equals("") && !mobile_number.getText().toString().equals(""))) {
                            Toast.makeText(Ctreatepage.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Ctreatepage.this, MainActivity.class);
                            startActivity(i);
                            name.setText(" ");
                            rollno.setText(" ");
                            mobile_number.setText(" ");
                            etclass.setText(" ");
                        } else
                            Toast.makeText(Ctreatepage.this, "Data not Inserted...Please enter Data", Toast.LENGTH_SHORT).show();
                    }
                });
        }
        else
        {
            save.setVisibility(View.GONE);
                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if(!name.getText().toString().equals("") && !rollno.getText().toString().equals("") && !mobile_number.getText().toString().equals("")) {
                            databaseHelper.updateData(name.getText().toString(), rollno.getText().toString(), mobile_number.getText().toString(), etclass.getText().toString());
                            Toast.makeText(Ctreatepage.this, "Data is Update", Toast.LENGTH_SHORT).show();
                            name.setText(" ");
                            rollno.setText(" ");
                            mobile_number.setText(" ");
                            etclass.setText(" ");
                            Intent i = new Intent(Ctreatepage.this, MainActivity.class);
                            startActivity(i);
                        }
                        else
                            Toast.makeText(Ctreatepage.this, "Data not Inserted...Please enter Data", Toast.LENGTH_SHORT).show();
                    }
                });
        }

        rollno.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(rollno.getText().length()<6)
                {
                    rollno.setError("Please enter Valid Roll no");
                }
            }
        });

        mobile_number.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(mobile_number.getText().length()<10)
                {
                    mobile_number.setError("Please enter valid mobile no");
                }
            }
        });
    }
}

   /* public void viewContact(View view)
    {
        if(result)
        {
            *//*Intent i = new Intent(Ctreatepage.this,MainActivity.class);
            startActivity(i);*//*
        }
    }*/
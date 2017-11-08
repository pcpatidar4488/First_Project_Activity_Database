package com.example.berylsystem.sample_prash;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.berylsystem.DataProvider;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button submit;
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    DatabaseHelper databaseHelper;
    Cursor cursor;
    ListDataAdapter listDataAdapter;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.ic_add_circle_outline_black_24dp);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);

        databaseHelper = new DatabaseHelper(this);

        listView = (ListView) findViewById(R.id.list_view);
        listDataAdapter = new ListDataAdapter(getApplicationContext(),R.layout.activity_main);
        listView.setAdapter(listDataAdapter);
        databaseHelper = new DatabaseHelper(getApplicationContext());
        sqLiteDatabase = databaseHelper.getReadableDatabase();
        cursor = databaseHelper.getAllData();

        //Click On List Item


        listView.setOnItemClickListener(new ItemList());

        if(cursor.moveToFirst())
        {
            do{
                String name,rollno,etclass,mob,idi;
                Integer id;
                id=cursor.getInt(0);
                idi=Integer.toString(id);
                name=cursor.getString(1);
                rollno=cursor.getString(2);
                mob=cursor.getString(3);
                etclass=cursor.getString(4);
                DataProvider dataProvider = new DataProvider(idi,name,rollno,mob,etclass);
                listDataAdapter.add(dataProvider);
            }while (cursor.moveToNext());
        }

        //viewAll();
    }

    class ItemList implements AdapterView.OnItemClickListener
    {
       Cursor cursor;
        /*Ctreatepage ctreatepage;
        EditText name,rollno,mobileno,etclass;*/

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ViewGroup viewGroup=(ViewGroup)view;
            TextView textView =(TextView)viewGroup.findViewById(R.id.text_name);
            TextView textView1 = (TextView)viewGroup.findViewById(R.id.text_rollno);
            TextView textView2 = (TextView)viewGroup.findViewById(R.id.text_mobile);
            TextView textView3 = (TextView)viewGroup.findViewById(R.id.text_etclass);
            /*TextView textView4 = (TextView)viewGroup.findViewById(R.id.text_id);*/

            Intent i = new Intent(MainActivity.this,Ctreatepage.class);

          /*  cursor = (Cursor) listDataAdapter.getItem(position);
            i.putExtra("id", cursor.getInt(cursor.getColumnIndex(String.valueOf(position))));*/

            i.putExtra("name",textView.getText().toString());
            i.putExtra("rollno",textView1.getText().toString());
            i.putExtra("mobile_no",textView2.getText().toString());
            i.putExtra("etclass",textView3.getText().toString());
            startActivity(i);
        }
        /*b.putInt("TEXT", view);
        intent.putExtras(b);*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main_action, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.icon_id:
                //Toast.makeText(MainActivity.this, "Selected", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, Ctreatepage.class);

                 i.putExtra("pc",true);
                startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }




}


// View All data in a Box

   /* public void viewAll() {
        btViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = databaseHelper.getAllData();
                if (res.getCount() == 0) {
                    //show message
                    showMessage("Error","Nothing found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("NAME :" + res.getString(0) + "\n");
                    buffer.append("ROLL NO :" + res.getString(1) + "\n");
                    buffer.append("MOBILE_NUMBER :" + res.getString(2) + "\n");
                    buffer.append("CLASS :" + res.getString(3) + "\n");
                }
                //SHOW ALL DATA
                showMessage("Data",buffer.toString());
            }
        });
    }

    public  void showMessage(String title,String Message){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }*/
package com.example.contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnSearch;
    private Button btnAddContact;
    public Button btnEditContact;
    private EditText editSearch;
    RecyclerView rv_listOfContacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSearch=findViewById(R.id.btn_search);
        btnAddContact=findViewById(R.id.btn_addContact);
        btnEditContact=findViewById(R.id.btn_editContact);
        editSearch=findViewById(R.id.edit_search);
        rv_listOfContacts=findViewById(R.id.rv_listOfContacts);

        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,EditActivity.class));
            }
        });


    }


}
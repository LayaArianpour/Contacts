package com.example.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity_FirebaseRecyclerOption extends AppCompatActivity {

    private Button btnSearch;
    private Button btnAddContact;
    public Button btnEditContact;
    private EditText editSearch;

    RecyclerView rv_listOfContacts;
    ContactAdapter_FirebaseRecyclerOption contactAdapter;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSearch=findViewById(R.id.btn_search);
        btnEditContact=findViewById(R.id.btn_editContact);
        editSearch=findViewById(R.id.edit_search);
        btnAddContact=findViewById(R.id.btn_addContact);


        rv_listOfContacts=findViewById(R.id.rv_listOfContacts);
        rv_listOfContacts.setLayoutManager(new LinearLayoutManager(MainActivity_FirebaseRecyclerOption.this));

        FirebaseRecyclerOptions<Contacts> options=
                new FirebaseRecyclerOptions.Builder<Contacts>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Contacts"),Contacts.class)
                .build();

        contactAdapter=new ContactAdapter_FirebaseRecyclerOption(options);
        rv_listOfContacts.setAdapter(contactAdapter);

        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity_FirebaseRecyclerOption.this,EditActivity.class));
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        contactAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        contactAdapter.stopListening();
    }



}
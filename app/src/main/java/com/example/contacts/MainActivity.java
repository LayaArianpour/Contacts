package com.example.contacts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnSearch;
    private Button btnAddContact;
    public Button btnEditContact;
    private EditText editSearch;

    RecyclerView rv_listOfContacts;
    DatabaseReference reference;
    ArrayList<Contacts> contactsList;
    ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSearch=findViewById(R.id.btn_search);
        btnEditContact=findViewById(R.id.btn_editContact);
        editSearch=findViewById(R.id.edit_search);
        btnAddContact=findViewById(R.id.btn_addContact);

        rv_listOfContacts=findViewById(R.id.rv_listOfContacts);
        rv_listOfContacts.setLayoutManager(new LinearLayoutManager(this));
        contactsList=new ArrayList<Contacts>();

        reference=FirebaseDatabase.getInstance().getReference().child("Contacts");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Contacts contact=dataSnapshot.getValue(Contacts.class);
                    contactsList.add(contact);
                }
                adapter=new ContactAdapter(MainActivity.this,contactsList);
                rv_listOfContacts.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this,"Opsss....",Toast.LENGTH_SHORT).show();
            }
        });

        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,EditActivity.class));
            }
        });



    }






}
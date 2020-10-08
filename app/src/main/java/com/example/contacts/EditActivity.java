package com.example.contacts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class EditActivity extends AppCompatActivity {

    private EditText editNameOfContact;
    private EditText editPhoneOfContact;
    private Button btnSaveContact;
    private Button btnCancelSaveContact;
    private DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editNameOfContact=findViewById(R.id.edit_nameOfContact);
        editPhoneOfContact=findViewById(R.id.edit_phoneOfContact);
        btnSaveContact=findViewById(R.id.btn_saveContact);
        btnCancelSaveContact=findViewById(R.id.btn_cancelSaveContact);
        dbRef= FirebaseDatabase.getInstance().getReference();

        btnCancelSaveContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditActivity.this,MainActivity.class));
            }
        });

        btnSaveContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameOfContact=editNameOfContact.getText().toString();
                String phoneOfContact=editPhoneOfContact.getText().toString();

                if(nameOfContact.isEmpty()||phoneOfContact.isEmpty())
                {
                    Toast.makeText(EditActivity.this,"Empty Fields!!",Toast.LENGTH_LONG).show();
                }


                else if(phoneOfContact.length()<11)
                {
                    Toast.makeText(EditActivity.this,"Phone Number is short!!",Toast.LENGTH_LONG).show();
                }

                else {
                    registerContact(nameOfContact,phoneOfContact);
                }
            }
        });
    }



    private void registerContact(String nameOfContact, String phoneOfContact) {
        HashMap<String,Object> mapContact=new HashMap<>();
        mapContact.put("name",nameOfContact);
        mapContact.put("phone",phoneOfContact);
        dbRef.child("Contacts").setValue(mapContact).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(EditActivity.this,"The Contact Was Save Successfully!!",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(EditActivity.this,MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(EditActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                Intent intent=new Intent(EditActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }

}
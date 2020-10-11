package com.example.contacts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import android.content.Context;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    Context context;
    ArrayList<Contacts> contacts;

    public ContactAdapter(Context c,ArrayList<Contacts> contacts) {
        this.contacts=contacts;
        this.context=c;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       /* LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.item_list_contacts,parent,false);*/
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_contacts,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contacts contact=contacts.get(position);
       // holder.txtFirstCharacterNameOfContact.setText(contact.getFirstCharacter_nameOfContact());
        holder.name.setText(contact.getNameOfContact());
        holder.phone.setText(contact.getPhoneOfContact());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

       // public TextView txtFirstCharacterNameOfContact;
        public TextView name;
        public TextView phone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           // txtFirstCharacterNameOfContact=(itemView).findViewById(R.id.txt_firstCharacterNameOfContact);
            name=(itemView).findViewById(R.id.txt_nameOfContact);
            phone=(itemView).findViewById(R.id.txt_phoneOfContact);

        }
    }

}

package com.example.contacts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    ArrayList<Contacts> contacts;

    public ContactAdapter(ArrayList<Contacts> contacts) {
        this.contacts=contacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.item_list_contacts,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contacts contact=contacts.get(position);
        holder.txtFirstCharacterNameOfContact.setText(contact.getFirstCharacter_nameOfContact());
        holder.txtNameOfContact.setText(contact.getNameOfContact());
        holder.txtPhoneOfContact.setText(contact.getPhoneOfContact());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtFirstCharacterNameOfContact;
        public TextView txtNameOfContact;
        public TextView txtPhoneOfContact;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtFirstCharacterNameOfContact=(itemView).findViewById(R.id.txt_firstCharacterNameOfContact);
            txtNameOfContact=(itemView).findViewById(R.id.txt_nameOfContact);
            txtPhoneOfContact=(itemView).findViewById(R.id.txt_phoneOfContact);

        }
    }

}

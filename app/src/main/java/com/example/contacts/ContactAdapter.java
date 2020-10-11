package com.example.contacts;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

import android.content.Context;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    Context context;
    ArrayList<Contacts> contacts;
    int r=0,g=0,b=0;

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
        holder.firstCharacterOfName.setText(contact.getFirstCharacterOfName());
        holder.name.setText(contact.getName());
        holder.phone.setText(contact.getPhone());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView firstCharacterOfName;
        public TextView name;
        public TextView phone;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            firstCharacterOfName=(itemView).findViewById(R.id.txt_firstCharacterNameOfContact);
            name=(itemView).findViewById(R.id.txt_nameOfContact);
            phone=(itemView).findViewById(R.id.txt_phoneOfContact);

        }
    }

}

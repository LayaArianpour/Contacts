package com.example.contacts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ContactAdapter_FirebaseRecyclerOption extends FirebaseRecyclerAdapter<Contacts, ContactAdapter_FirebaseRecyclerOption.ViewHolder> {


    public ContactAdapter_FirebaseRecyclerOption(@NonNull FirebaseRecyclerOptions<Contacts> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Contacts model) {

      //  holder.txtFirstCharacterNameOfContact.setText(model.getFirstCharacter_nameOfContact());
        holder.name.setText(model.getName());
        holder.phone.setText(model.getPhone());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.item_list_contacts,parent,false);
        return new ViewHolder(view);
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

      //  public TextView txtFirstCharacterNameOfContact;
        public TextView name;
        public TextView phone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
          //  txtFirstCharacterNameOfContact=(itemView).findViewById(R.id.txt_firstCharacterNameOfContact);
            name=(itemView).findViewById(R.id.txt_nameOfContact);
            phone=(itemView).findViewById(R.id.txt_phoneOfContact);
        }
    }


}

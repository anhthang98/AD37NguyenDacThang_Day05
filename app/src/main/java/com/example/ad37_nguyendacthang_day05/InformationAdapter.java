package com.example.ad37_nguyendacthang_day05;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.ViewHolder> {

    List<Phonebook> phonebookList;
    IonClickContact ionClickContact;

    public void setIonClickContact(IonClickContact ionClickContact) {
        this.ionClickContact = ionClickContact;
    }

    public InformationAdapter(List<Phonebook> contactList) {
        this.phonebookList = contactList;
    }

    @NonNull
    @Override
    public InformationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_listview_information, parent, false);

        InformationAdapter.ViewHolder viewHolder = new InformationAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InformationAdapter.ViewHolder holder, int position) {
        final Phonebook phonebook = phonebookList.get(position);

        holder.tvPhoneNumberItem.setText(phonebook.getPhoneNumber());
        holder.tvDateItem.setText(phonebook.getDate());

    }

    @Override
    public int getItemCount() {
        return phonebookList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvPhoneNumberItem, tvDateItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPhoneNumberItem = itemView.findViewById(R.id.tvPhoneNumberItem);
            tvDateItem = itemView.findViewById(R.id.tvDateItem);

        }
    }

}

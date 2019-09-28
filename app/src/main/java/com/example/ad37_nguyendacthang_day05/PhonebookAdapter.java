package com.example.ad37_nguyendacthang_day05;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PhonebookAdapter extends RecyclerView.Adapter<PhonebookAdapter.ViewHolder> {
    private static OnItemClickListener listener;
    List<Phonebook> phonebookList;
    IonClickContact ionClickContact;

    public void setIonClickContact(IonClickContact ionClickContact) {
        this.ionClickContact = ionClickContact;
    }

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public PhonebookAdapter(List<Phonebook> contactList) {
        this.phonebookList = contactList;
    }

    @NonNull
    @Override
    public PhonebookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_recycleview, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PhonebookAdapter.ViewHolder holder, int position) {
        final Phonebook phonebook = phonebookList.get(position);

        holder.tvPhoneNumber.setText(phonebook.getPhoneNumber());
        holder.tvLocation.setText(phonebook.getLocation());
        holder.tvDate.setText(phonebook.getDate());

        holder.imgContact.setImageResource(R.drawable.ic_info_outline_black_24dp);
        if (phonebook.getLocation().equals("Messenger video")) {
            holder.imgTypeCall.setImageResource(R.drawable.ic_video_call_black_24dp);
        } else {
            holder.imgTypeCall.setImageResource(R.drawable.ic_call_black_24dp);
        }

        holder.tvPhoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ionClickContact.onClickName(phonebook.getPhoneNumber());
            }
        });

        holder.tvLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ionClickContact.onClickLocation(phonebook.getLocation());
            }
        });


        holder.tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ionClickContact.onClickDate(phonebook.getDate());
            }
        });
    }

    @Override
    public int getItemCount() {
        return phonebookList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvPhoneNumber, tvLocation, tvDate;
        ImageView imgContact, imgTypeCall;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            tvPhoneNumber = itemView.findViewById(R.id.tvPhoneNumber);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvDate = itemView.findViewById(R.id.tvDate);
            imgContact = itemView.findViewById(R.id.imgContact);
            imgTypeCall = itemView.findViewById(R.id.imgTypeCall);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onItemClick(itemView, getLayoutPosition());
                    }
                }
            });

        }
    }
}

package com.example.ad37_nguyendacthang_day05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Phonebook> phonebookList;
    PhonebookAdapter adapterPhonebook;
    RecyclerView rvPhonebook;
    Phonebook phonebook1, phonebook2, phonebook3, phonebook4, phonebook5, phonebook6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPhonebook = findViewById(R.id.rvList);

        phonebookList = new ArrayList<>();
        phonebook1 = new Phonebook("", "Luan", "Điện thoại", "16/2/2019");
        phonebookList.add(phonebook1);

        phonebookList.add(new Phonebook("", "Tuan Anh", "Messenger video", "16/2/2019"));
        phonebookList.add(new Phonebook("", "098999999", "Việt Nam", "16/2/2019"));
        phonebookList.add(new Phonebook("", "Binh", "Việt Nam", "12/3/2019"));
        phonebookList.add(new Phonebook("", "Quan", "Việt Nam", "19/6/2019"));
        phonebookList.add(new Phonebook("", "Hiep", "Di động", "19/4/2019"));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext(), RecyclerView.VERTICAL, false);

        adapterPhonebook = new PhonebookAdapter(phonebookList);
        rvPhonebook.setAdapter(adapterPhonebook);
        rvPhonebook.setLayoutManager(layoutManager);

        adapterPhonebook.setIonClickContact(new IonClickContact() {
            @Override
            public void onClickName(String phoneNumber) {
                Toast.makeText(getBaseContext(), phoneNumber, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onClickLocation(String location) {
                Toast.makeText(getBaseContext(), location, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onClickDate(String date) {
                Toast.makeText(getBaseContext(), date, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onClickObject(Phonebook phonebook, int i) {

            }

        });

        adapterPhonebook.setOnItemClickListener(new PhonebookAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Intent intent = new Intent(getBaseContext(), InformationActivity.class);
                intent.putExtra("phonebook", phonebookList.get(position));
                startActivity(intent);
            }

        });


    }
}

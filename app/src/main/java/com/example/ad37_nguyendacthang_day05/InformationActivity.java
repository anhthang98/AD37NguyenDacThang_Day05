package com.example.ad37_nguyendacthang_day05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class InformationActivity extends AppCompatActivity {
    List<Phonebook> phonebookList;
    TextView tvName, tvPhoneNumberInfor, tvLocationInfor;
    ImageView imgBack;
    RecyclerView rvInformation;
    Phonebook phonebook, phonebook1;
    InformationAdapter adapterInformation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        setTitle("Information Phone number");

        phonebookList = new ArrayList<>();
        rvInformation = findViewById(R.id.rvInformation);
        tvName = findViewById(R.id.tvName);
        tvPhoneNumberInfor = findViewById(R.id.tvPhoneNumberInfor);
        tvLocationInfor = findViewById(R.id.tvLocationInfor);
        imgBack = findViewById(R.id.imgBack);


        final Intent intent = getIntent();
        phonebook = (Phonebook) intent.getSerializableExtra("phonebook");
        phonebook1 = new Phonebook(phonebook.getDate(), phonebook.getPhoneNumber());

        phonebookList.add(phonebook1);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getBaseContext(), 2, RecyclerView.VERTICAL, false);

        adapterInformation = new InformationAdapter(phonebookList);
        rvInformation.setAdapter(adapterInformation);
        rvInformation.setLayoutManager(layoutManager);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        tvName.setText(phonebook.getPhoneNumber());
        tvPhoneNumberInfor.setText(phonebook.getPhoneNumber());
        tvLocationInfor.setText(phonebook.getLocation());


    }
}

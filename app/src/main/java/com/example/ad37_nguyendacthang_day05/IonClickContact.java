package com.example.ad37_nguyendacthang_day05;

public interface IonClickContact {

    void onClickName(String phoneNumber);

    void onClickLocation(String location);

    void onClickDate(String date);

    void  onClickObject(Phonebook phonebook, int i);
}

package com.example.kafkaproducerconsumerexample.database;

import org.springframework.stereotype.Component;

@Component
public class DataHolder {

    private int data = 0;
    public int getData() {
        return data;
    }

    public synchronized void plusData() {
        this.data++;
    }
}

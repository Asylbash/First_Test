package ru.zhyldyz.enums;

public enum Language {

    EN("Track Your Shipment"),
    IT("Traccia la tua spedizione");

    public final String text;

    Language(String text) {

        this.text = text;
    }
}

package ru.vetyugov.springMiddle.service;

public interface MessageService {
    String getMessageByKey(String key, String[] options);

    String getMessageByKey(String key);
}

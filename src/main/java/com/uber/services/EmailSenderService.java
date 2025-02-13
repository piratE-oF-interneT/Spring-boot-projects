package com.uber.services;

public interface EmailSenderService {

    void sendEmail(String receiver , String subject , String body);
}

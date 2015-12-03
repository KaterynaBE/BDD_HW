package com.epam.auto.patterns.staticfactorymethod;

/**
 * Created by ekaterinabut on 11/18/15.
 */
public class Email {

    private String addressee;
    private String subject;
    private String emailBody;

    public Email(String addressee, String subject, String emailBody) {
        this.addressee = addressee;
        this.subject = subject;
        this.emailBody = emailBody;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    public String getAddressee() {
        return addressee;
    }

    public String getSubject() {
        return subject;
    }

    public String getEmailBody() {
        return emailBody;
    }
}

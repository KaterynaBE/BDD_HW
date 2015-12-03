package com.epam.auto.patterns.staticfactorymethod;

/**
 * Created by ekaterinabut on 11/19/15.
 */
public class EmailStaticFactory {


    public static Email createDefaultEmail(String addressee, String subject, String emailBody) {
        Email email = new Email(addressee, subject, emailBody);
        email.setAddressee(addressee);
        email.setSubject(subject);
        email.setEmailBody(emailBody);
        return email;
    }
}
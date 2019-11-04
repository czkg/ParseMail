package com.zhichai.parsemail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;



public class EmailReceiver {
    /*
    Returns a Properties object which is configured for POP3/IMAP server
    @param protocol either 'imap' or 'pop3'
    @param host
    @param port
    @return a Properties object
     */
    private Properties getServerProperties(String protocol, String host, String port) {
        Properties properties = new Properties();

        //server setting
        properties.put(String.format("mail.%s.host", protocol), host);
        properties.put(String.format("mail.%s.port", protocol), port);

        //SSL setting
        properties.setProperty(
                String.format("mail.%s.socketFactory.class", protocol),
                "javax.net.ssl.SSLSocketFactory");
        properties.setProperty(
                String.format("mail.%s.socketFactory.fallback", protocol),
                "false");
        properties.setProperty(String.format("mail.%s.socketFactory.port", protocol),
                String.valueOf(port));

        return properties;
    }

    /*
    Downloads new message and fetches details for each message.
    @param protocol
    @param host
    @param port
    @param username
    @param password
     */
    public void downloadEmails(String protocol, String host, String port, String username, String password) {}


}
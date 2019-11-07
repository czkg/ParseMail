package com.zhichai.parsemail;

public class Email {
    private String address;
    private String password;
    private String protocol;
    private String host;
    private String port;

    public Email(String address, String password, String protocol, String port) {
        this.address = address;
        this.password = password;
        this.protocol = protocol;
        this.port = port;

        int l = this.address.indexOf('@');
        int r = this.address.lastIndexOf('.');
        this.host = this.address.substring(l+1, r);
    }

}
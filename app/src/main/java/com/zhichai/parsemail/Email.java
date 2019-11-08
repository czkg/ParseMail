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

        int l = this.address.indexOf('@');
        int r = this.address.lastIndexOf('.');
        parseHostandPort(this.address.substring(l+1, r));
    }

    public void parseHostandPort(String domain) {
        switch (domain) {
            case "gmail":
                this.host = "imap.gmail.com";
                this.port = "993";
                break;
            case "outlook":
                this.host = "imap-mail.outlook.com";
                this.port = "993";
            case "qq":
                this.host = "imap.qq.com";
                this.port = "993";
                break;
            case "hotmail":
                this.host = "imap-mail.outlook.com";
                this.port = "993";
                break;
            case "yahoo":
                this.host = "imap.mail.yahoo.com";
                this.port = "993";
                break;
            case "aol":
                this.host = "imap.aol.com";
                this.port = "993";
                break;
            case "163":
                this.host = "imap.163.com";
                this.port = "993";
                break;
            case "icloud":
                this.host = "imap.mail.me.com";
                this.port = "993";
                break;
            case "zoho":
                this.host = "imap.zoho.com";
                this.port = "993";
                break;
        }
    }

    public String getAddress() {
        return this.address;
    }

    public String getPassword() {
        return this.password;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getPort() {
        return this.port;
    }

    public String getHost() {
        return this.host;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setHost(String host) {
        this.host = host;
    }

}
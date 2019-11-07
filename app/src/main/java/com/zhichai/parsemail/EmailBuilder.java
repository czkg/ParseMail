package com.zhichai.parsemail;

public class EmailBuilder {
    private String address;
    private String password;
    private String protocol = "imap";
    private String port = "993";

    public EmailBuilder() {}

    public Email buildEmail() {
        return new Email(address, password, protocol, port);
    }

    public EmailBuilder address(String address) {
        this.address = address;
        return this;
    }
    public EmailBuilder password(String password) {
        this.password = password;
        return this;
    }
    public EmailBuilder protocol(String protocol) {
        this.protocol = protocol;
        return this;
    }
    public EmailBuilder port(String port) {
        this.port = port;
        return this;
    }
}

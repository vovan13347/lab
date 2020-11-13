package com.example.myshop.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

public class HostValueGetter {

    private static final String defaultHostValue = "localhost";

    public String getHostId() {
        return new StringBuilder()
                .append(getHostName())
                .toString();
    }

    private String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException uhe) {
            return defaultHostValue;
        }
    }

    public String uuid() {
        return UUID.randomUUID().toString();
    }

}
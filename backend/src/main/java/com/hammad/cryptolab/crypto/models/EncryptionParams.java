package com.hammad.cryptolab.crypto.models;

import java.util.Arrays;

public record EncryptionParams(char[] password) {

    public EncryptionParams {
        if(password == null || password.length == 0) {
            throw new IllegalArgumentException("Password must not be Empty");
        }
    }

    public void wipe() {
        Arrays.fill(password, '\0');
    }

    @Override
    public String toString() {
        return "EncryptionParams[password=***]";
    }
}

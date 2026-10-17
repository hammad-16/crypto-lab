package com.hammad.cryptolab.crypto.strategy;

import com.hammad.cryptolab.crypto.enums.AlgorithmId;
import com.hammad.cryptolab.crypto.models.EncryptionParams;

import java.io.InputStream;
import java.io.OutputStream;

public interface CipherStrategy {
    AlgorithmId id();

    void encrypt(InputStream inputStream, OutputStream outputStream, EncryptionParams params);

    void decrypt(InputStream inputStream, OutputStream outputStream, EncryptionParams params);
}

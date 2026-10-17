package com.hammad.cryptolab.crypto.enums;

import java.util.function.Function;

import com.hammad.cryptolab.crypto.exception.CryptoException;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public enum AlgorithmId {
    AES_GCM_PBKDF2   ((byte) 0x01, "AES-256-GCM (password)"),
    AES_CBC_HMAC     ((byte) 0x02, "AES-256-CBC + HMAC-SHA256"),
    AES_ECB_DEMO     ((byte) 0x03, "AES-ECB (insecure demo)"),
    CHACHA20_POLY1305((byte) 0x04, "ChaCha20-Poly1305"),
    RSA_OAEP_HYBRID  ((byte) 0x05, "RSA-OAEP + AES-GCM"),
    X25519_HYBRID    ((byte) 0x06, "X25519 + HKDF + AES-GCM");

    private static final Map<Byte, AlgorithmId> BY_CODE = Arrays.stream(values()).collect(Collectors.toUnmodifiableMap(AlgorithmId::code, Function.identity()));

    private final byte code;
    private final String displayName;

    AlgorithmId(byte code, String displayName){
        this.code = code;
        this.displayName = displayName;
    }

    public byte code() {
        return code;
    }

    public String displayName() {
        return displayName;
    }

    public static AlgorithmId fromCode(byte code) {
        AlgorithmId id = BY_CODE.get(code);
        if (id == null) {
            throw new CryptoException(String.format("Unknown algorithm code: 0x%02X", code));
        }
        return id;
    }

}

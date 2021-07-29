package com.company;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HMAC {
    static public byte[] calcHmacSha256(byte[] secretKey, byte[] message) {
        byte[] hmacSha256 = null;
        try {
            Mac mac = Mac.getInstance("HMacSha256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, "HMacSha256");
            mac.init(secretKeySpec);
            hmacSha256 = mac.doFinal(message);
        } catch (Exception e) {
            throw new RuntimeException("Failed to calculate HMacSha256", e);
        }
        return hmacSha256;
    }
}


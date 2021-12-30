package com.upt.cti.aplicatiecomandat.Utilities;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingSHA256 {

    public static String getEncoding(String string){
        return convertByteArrayToHex(getHashing(string));
    }

    public static byte[] getHashing(String string){
        MessageDigest messageDigest = null;

        try{
            messageDigest = MessageDigest.getInstance("SHA-256");
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        messageDigest.reset();
        return messageDigest.digest(string.getBytes(StandardCharsets.UTF_8));
    }

    public static String convertByteArrayToHex(byte[] data){
        return String.format("%0" + (data.length*2) + "X", new BigInteger(1, data));
    }

}

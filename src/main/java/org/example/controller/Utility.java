package org.example.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utility {
    public static String getPassHashSha256(String password, byte[] salt) {

        String passwordString = null;
        try {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-256");
            messagedigest.update(salt);
            byte[] bytes = messagedigest.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            //System.out.println(bytes);
            for (byte aByte : bytes) {
                //convert to HEX;
                //System.out.print(bytes[i]+" ");
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
                //System.out.println(sb);
            }
            passwordString = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return passwordString;
    }

    public static byte[] makeSalt()  {
        return new byte[16];
    }

}

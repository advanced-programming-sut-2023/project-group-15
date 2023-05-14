package org.example.controller;


import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;

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

    public static String groupFinder(Matcher matcher, String toFind) {
        while (matcher.find()) {
            for (int i = 0; i < matcher.groupCount(); i++) {
                if (matcher.group(i) == null)
                    continue;
                if (matcher.group(i).equals(toFind))
                    return matcher.group(i + 1);
            }
        }
        return null;
    }

    public static byte[] makeSalt() {
        return new byte[16];
    }

    public static void deleteFile() {
        String path = ("d:/json/dataBase.json");
        try {
            File toDelete = new File(path);
            toDelete.delete();
//            toDelete.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

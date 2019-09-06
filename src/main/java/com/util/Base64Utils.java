package com.util;

import org.apache.commons.codec.binary.Base64;
import java.io.UnsupportedEncodingException;

public class Base64Utils {
    public static String toBase64(String str){
        try{
            byte[] encodeBase64 = Base64.encodeBase64(str.getBytes("GBK"));
            return new String(encodeBase64);
        } catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return "";
    }
}

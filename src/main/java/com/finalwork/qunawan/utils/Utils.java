package com.finalwork.qunawan.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * author: 钱苏涛
 * created on: 2019/6/17 20:37
 * description:
 */
public class Utils {
    public static String toMD5(String data) {
        if (data == null)
            return null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 加密转换
            md.update(data.getBytes());
            String result = new BigInteger(1, md.digest()).toString(16);

            return result;

        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}

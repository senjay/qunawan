package com.finalwork.qunawan.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

    public static void getFile(byte[] bfile, String filePath) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if (!dir.exists() && dir.isDirectory()) {// 判断文件目录是否存在
                dir.mkdirs();
            }
            file = new File(filePath);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }


    public static int getPageNum(String pageStr) {
        if ("".equals(pageStr) || pageStr == null) {
            pageStr = "1";
        }
        // 当前页码
        return Integer.parseInt(pageStr);
    }

    public static String createName() {
        java.text.DateFormat format = new java.text.SimpleDateFormat("hhmmss");
        return format.format(new java.util.Date()) + (int) (Math.random() * 89 + 10);
    }
    public static String isoToUtf(String s) {
        try {
            return new String(s.getBytes("iso8859-1"), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

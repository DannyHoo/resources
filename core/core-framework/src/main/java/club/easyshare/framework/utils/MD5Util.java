package club.easyshare.framework.utils;

import java.util.Random;
import org.apache.commons.codec.binary.Hex;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
/**
 * @author huyuyang@lxfintech.com
 * @Title: MD5Util
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-07 22:49:33
 */
public class MD5Util {

    public MD5Util() {
    }

    public static String md5HexTwoSourceAndSalt(String source, String salt) {
        String firstResult = digest(source);
        String secordResult = digest(firstResult + salt);
        return secordResult;
    }

    public static String digest(String input) {
        try {
            MessageDigest e = MessageDigest.getInstance("MD5");
            byte[] bDigests = e.digest(input.getBytes("UTF-8"));
            return byte2hex(bDigests);
        } catch (Exception var3) {
            var3.printStackTrace();
            return "";
        }
    }

    private static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";

        for(int n = 0; n < b.length; ++n) {
            stmp = Integer.toHexString(b[n] & 255);
            if(stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }

        return hs.toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(MD5Util.md5HexTwoSourceAndSalt("123","456"));
        System.out.println(MD5Util.digest("123456"));
    }
}

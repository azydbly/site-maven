package com.xst.common.util;

import java.security.MessageDigest;
import java.util.Random;

/**
 * @ClassName: PasswordUtil
 * @类描述： PasswordUtil  密码通过盐值进行加密
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/8/23 11:26
 */
public class PasswordUtil {

    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private Object salt;
    private String algorithm;

    public PasswordUtil(Object salt, String algorithm) {
        this.salt = salt;
        this.algorithm = algorithm;
    }

    public PasswordUtil(){}

    public String encode(String rawPass) {
        String result = null;
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            //加密后的字符串
            result = byteArrayToHexString(md.digest(mergePasswordAndSalt(rawPass).getBytes("utf-8")));
        } catch (Exception ex) {
        }
        return result;
    }

    public boolean isPasswordValid(String encPass, String rawPass) {
        String pass1 = "" + encPass;
        String pass2 = encode(rawPass);
        return pass1.equals(pass2);
    }

    private String mergePasswordAndSalt(String password) {
        if (password == null) {
            password = "";
        }
        if ((salt == null) || "".equals(salt)) {
            return password;
        } else {
            return password + "{" + salt.toString() + "}";
        }
    }

    /**
     * 转换字节数组为16进制字串
     *
     * @param b 字节数组
     * @return 16进制字串
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    //根据长度生成，字母 + 数字 盐值
    public String getStringRandom(int length) {
        String salt = "";
        Random random = new Random();
        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                salt += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                salt += String.valueOf(random.nextInt(10));
            }
        }
        return salt;
    }

    //通过盐值加加密进行验证
    public Boolean LoginPassword(String saltPassword,String password,String salt){
        PasswordUtil encoderMd5 = new PasswordUtil(salt, "MD5");
        return encoderMd5.isPasswordValid(saltPassword, password);
    }

    //给用户密码通过盐值进行加密
    public String Md5Password(String password,int length){
        String salt = getStringRandom(length);
        PasswordUtil encoderMd5 = new PasswordUtil(salt, "MD5");
        String encode = encoderMd5.encode(password);
        return salt  + "," + encode;
    }

    //给用户密码通过盐值进行加密
    public String Md5LoginPassword(String password,String salt){
        PasswordUtil encoderMd5 = new PasswordUtil(salt, "MD5");
        return encoderMd5.encode(password);
    }

    public static void main(String[] args) {
        //根据盐值进行加密
        String salt = "IeA7iu";
        PasswordUtil encoderMd5 = new PasswordUtil(salt, "MD5");
        //通过盐值加把密码进行加密
        String encode = encoderMd5.encode("123456");
        System.out.println(encode);
        //根据盐值对加密密码进行解密，返回值类型  Boolean
        boolean passwordValid = encoderMd5.isPasswordValid("736f51b31cd7a1f5c5936c685b89fa61", "123456");
        System.out.println(passwordValid);
    }
}

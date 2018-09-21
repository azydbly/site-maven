package com.xst.common.util;

import java.util.Calendar;

/**
 * @ClassName: IdCard
 * @类描述： IdCard  身份证号解析工具类
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/9/20 17:08
 */

public class IdCard {

    /**
     * 中国公民身份证号码最小长度。
     */
    public final int CHINA_ID_MIN_LENGTH = 15;

    /**
     * 中国公民身份证号码最大长度。
     */
    public final int CHINA_ID_MAX_LENGTH = 18;

    /**
     * 根据身份编号获取年龄
     *
     * @param idCard 身份编号
     * @return 年龄
     */
    public static int getAgeByIdCard(String idCard) {
        int iAge = 0;
        Calendar cal = Calendar.getInstance();
        String year = idCard.substring(6, 10);
        int iCurrYear = cal.get(Calendar.YEAR);
        iAge = iCurrYear - Integer.valueOf(year);
        return iAge;
    }

    /**
     * 根据身份编号获取生日
     *
     * @param idCard 身份编号
     * @return 生日(yyyyMMdd)
     */
    public static String getBirthByIdCard(String idCard) {
        return idCard.substring(6, 14);
    }

    /**
     * 根据身份编号获取生日年
     *
     * @param idCard 身份编号
     * @return 生日(yyyy)
     */
    public static Short getYearByIdCard(String idCard) {
        return Short.valueOf(idCard.substring(6, 10));
    }

    /**
     * 根据身份编号获取生日月
     *
     * @param idCard 身份编号
     * @return 生日(MM)
     */
    public static Short getMonthByIdCard(String idCard) {
        return Short.valueOf(idCard.substring(10, 12));
    }

    /**
     * 根据身份编号获取生日天
     *
     * @param idCard 身份编号
     * @return 生日(dd)
     */
    public static Short getDateByIdCard(String idCard) {
        return Short.valueOf(idCard.substring(12, 14));
    }


    /**
     * 根据身份编号获取后6位
     *
     * @param idCard 身份编号
     * @return 身份证号后6位
     */
    public static String getSixEndNumber(String idCard) {
        return idCard.substring(12,18);
    }

    /**
     * 根据身份编号获取性别
     *
     * @param idCard 身份编号
     * @return 性别(M - 男 ， F - 女 ， N - 未知)
     */
    public static String getGenderByIdCard(String idCard) {
        String sGender = "未知";

        String sCardNum = idCard.substring(16, 17);
        if (Integer.parseInt(sCardNum) % 2 != 0) {
            sGender = "男";//男
        } else {
            sGender = "女";//女
        }
        return sGender;
    }


    /**
     * 15位省份证号装换 18位
     * @param input
     * @return
     */
    public static String[] trans15bitTo18bit(String[] input) {
        String[] result = new String[18];
        for (int i = 0; i < input.length; i++) {
            if (i <= 5) {
                result[i] = input[i];
            } else {
                result[i + 2] = input[i];
            }
        }
        //年份最后两位小于17,年份为20XX，否则为19XX
        if (Integer.valueOf(input[6]) <= 1 && Integer.valueOf(input[7]) <= 7) {
            result[6] = "2";
            result[7] = "0";
        } else {
            result[6] = "1";
            result[7] = "9";
        }
        //计算最后一位
        String[] xs = {"7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7", "9", "10", "5", "8", "4", "2"};
        //前十七位乘以系数[7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2],
        int sum = 0;
        for (int i = 0; i < 17; i++) {
            sum += Integer.valueOf(result[i]) * Integer.valueOf(xs[i]);
        }
        //对11求余，的余数 0 - 10
        int rod = sum % 11;
        //所得余数映射到对应数字即可
        if (rod == 0) {
            result[17] = "1";
        } else if (rod == 1) {
            result[17] = "0";
        } else if (rod == 2) {
            result[17] = "X";
        } else if (rod == 3) {
            result[17] = "9";
        } else if (rod == 4) {
            result[17] = "8";
        } else if (rod == 5) {
            result[17] = "7";
        } else if (rod == 6) {
            result[17] = "6";
        } else if (rod == 7) {
            result[17] = "5";
        } else if (rod == 8) {
            result[17] = "4";
        } else if (rod == 9) {
            result[17] = "3";
        } else if (rod == 10) {
            result[17] = "2";
        }
        return result;
    }

    //15位身份证号转换18位身份证号
    public String Transformation(String IdCard) {
        String[] IdCardNumber = IdCard.split("");
        String[] resultNumber = trans15bitTo18bit(IdCardNumber);
        String result = "";
        for (String string : resultNumber) {
            result = string;
        }
        return result;
    }

    //根据18位省份证号获取出生年月
    public String DateOfBirth(String IdCard) {
        Short nian = getYearByIdCard(IdCard);
        Short yue = getMonthByIdCard(IdCard);
        Short ri = getDateByIdCard(IdCard);
        String date = nian + "-" + yue + "-" + ri;
        return date;
    }


     /*public static void main(String[] args){
       String code = "131102960601201";
        String reg = "^(.{6})(.{4})(.{2}).*$";
        String a = code.replaceAll(reg, "$1");
        String y = code.replaceAll(reg, "$2");
        String m = code.replaceAll(reg, "$3");
        System.out.println("所在地区代码：" + a);
        System.out.println("出生年月: " + y + ", " + m);

    }*/


}

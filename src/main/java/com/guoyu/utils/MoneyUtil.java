package com.guoyu.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author guguoyu
 * @since 1.8
 * @
 */
public class MoneyUtil {

    private static Pattern pattern = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){1,2})?$");

    /**
     * 判断是否是金额
     *
     * @param str 金额字符串，例如 0.01
     * @return 返回true则是金额，false则不是金额
     */
    public static boolean isMoney(String str) {
        if (str.length() > 10) {
            return false;
        }
        Matcher match = pattern.matcher(str);
        return match.matches();
    }

    /**
     * main函数测试
     *
     * @param args
     */
    public static void main(String[] args) {
        boolean number1 = isMoney("1");
        System.out.println("1 is " + number1);

        boolean b = isMoney("1.0");
        System.out.println("1.0 is " + b);

        boolean c = isMoney("1.22");
        System.out.println("1.22 is " + c);

        boolean d = isMoney("1.222");
        System.out.println("1.222 is " + d);

        boolean e = isMoney("222.22");
        System.out.println("222.22 is " + e);


        boolean f = isMoney("0.01");
        System.out.println("0.01 is " + f);

        boolean g = isMoney("0.001");
        System.out.println("0.001 is " + g);

        boolean h = isMoney("");
        System.out.println(" is " + h);

        boolean i = isMoney("1.");
        System.out.println("1. is " + i);

        boolean j = isMoney("1.1");
        System.out.println("1.1 is " + j);

        boolean k = isMoney("01");
        System.out.println("01 is " + k);

        boolean l = isMoney("10");
        System.out.println("10 is " + l);

        boolean m = isMoney("10.0");
        System.out.println("10.0 is " + m);

        boolean n = isMoney("011");
        System.out.println("011 is " + n);

        boolean o = isMoney("-11");
        System.out.println("-11 is " + o);

        boolean p = isMoney("1111111111111111111111111111111111111111111");
        System.out.println("1111111111111111111111111111111111111111111 is " + p);

        boolean q = isMoney("+11");
        System.out.println("+11 is " + q);

        boolean r = isMoney("0.1");
        System.out.println("0.1 is " + r);


    }
}

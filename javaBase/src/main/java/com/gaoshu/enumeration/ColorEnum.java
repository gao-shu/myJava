package com.gaoshu.enumeration;

import java.util.Arrays;

/**
 * @author ：ZMJ
 * @version ： 1.0
 * @ClassName ：ColorEnum
 * @date ：Created in 2021/1/27 17:27
 * @description：颜色枚举
 */
public enum ColorEnum {
    RED,
    BLUE,
    BLACK;

    // 构造函数
//    private ColorEnum()
//    {
//        System.out.println("Constructor called for : " + this.toString());
//    }
//
//    public void colorInfo()
//    {
//        System.out.println("Universal Color");
//    }
}

class test{
    public static void main(String[] args) {
        System.out.println(ColorEnum.RED);
        System.out.println(ColorEnum.RED.name());
        System.out.println(ColorEnum.RED.ordinal());
        System.out.println(Arrays.asList(ColorEnum.values()));
        System.out.println(ColorEnum.valueOf("RED"));
//        System.out.println(ColorEnum.values());
    }
}

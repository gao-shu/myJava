package com.gaoshu.enumeration;

/**
 * @author ：ZMJ
 * @version ： 1.0
 * @ClassName ：ColorEnum
 * @date ：Created in 2021/1/27 17:27
 * @description：颜色枚举
 */
public enum ColorEnum02 {
    RED(0, "红色"),
    BLUE(1, "蓝色"),
    BLACK(2, "黑色");
    // 构造函数
    ColorEnum02(Integer value1, String value2)
    {
        this.value1 = value1;
        this.value2 = value2;
    }

    private Integer value1;
    private String value2;

    
}

class test02{
    public static void main(String[] args) {
        System.out.println(ColorEnum.RED);
//        System.out.println(ColorEnum.values());
        ColorEnum red = ColorEnum.RED;
    }
}

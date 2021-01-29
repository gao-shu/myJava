package com.gaoshu.enumeration;

/**
 * @author ：ZMJ
 * @version ： 1.0
 * @ClassName ：ColorEnum
 * @date ：Created in 2021/1/27 17:27
 * @description：颜色枚举
 */
public enum ColorEnum01 {
    RED(12),
    BLUE(123),
    BLACK(1234);
    // 构造函数
    ColorEnum01(Integer value)
    {
        this.value = value;
    }
    //创建变量
    private Integer value;

    //获取枚举对应值
    public Integer getValue() {
        return this.value;
    }

    //获取所有的values
    public static void getValues(){
        Integer[] integers = new Integer[values().length];
        for (int i = 0; i < values().length; i++) {
            integers[i] = values()[i].getValue();
        }
    }

    //获取value的enum
    public static ColorEnum01 getEnum(Integer value){
        ColorEnum01[] values = ColorEnum01.values();
        for (ColorEnum01 colorEnum01 : values) {
            if (colorEnum01.getValue().equals(value)) {
                return colorEnum01;
            }
        }
        return null;
    }

}

class test01{
    public static void main(String[] args) {
        for (ColorEnum01 colorEnum01 : ColorEnum01.values()) {
            System.out.println(colorEnum01.getValue());
        }
    }
}

package com.gaoshu.singleto;

/**
 * @author ：ZMJ
 * @version ： 1.0
 * @ClassName ：SingleObject02
 * @date ：Created in 2021/1/28 15:36
 * @description：懒汉式，线程不安全
 */
public class SingleObject02 {
    private static SingleObject02 instance;
    private SingleObject02 (){}

    public static SingleObject02 getInstance() {
        if (instance == null) {
            instance = new SingleObject02();
        }
        return instance;
    }
}

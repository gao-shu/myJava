package com.gaoshu.singleto;

/**
 * @author ：ZMJ
 * @version ： 1.0
 * @ClassName ：SingleObject
 * @date ：Created in 2021/1/28 15:35
 * @description：饿汉式，线程安全
 */
public class SingleObject {
    private static SingleObject singleObject = new SingleObject();
    private SingleObject(){}
    public static SingleObject getSingleObject(){
        return singleObject;
    }

}

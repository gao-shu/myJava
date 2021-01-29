package com.gaoshu.work;

/**
 * @author ：ZMJ
 * @version ： 1.0
 * @ClassName ：SingleObject
 * @date ：Created in 2021/1/28 15:31
 * @description：懒汉式，线程安全
 */
public class SingleObject {
    private static SingleObject singleObject;
    private SingleObject(){};
    public static SingleObject getSingleObject(){
        if (singleObject == null) {
            singleObject = new SingleObject();
        }
        return singleObject;
    }
}

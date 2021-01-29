package com.gaoshu.factory;

/**
 * @author ：ZMJ
 * @version ： 1.0
 * @ClassName ：SimpleFactory
 * @date ：Created in 2021/1/28 16:16
 * @description：工厂方法模式
 */

//抽象工厂类角色
interface Driver3 {
    Car3 createBenz3();

    Car3 createBmw3();
}

//具体工厂类角色(抽象属性)
//红色工厂
class redDriver3 implements Driver3{

    public Car3 createBenz3() {
        return new Benz3red();
    }

    public Car3 createBmw3() {
        return new Bmw3red();
    }
}
//蓝色工厂
class blueDriver3 implements Driver3{

    public Car3 createBenz3() {
        return new Benz3blue();
    }

    public Car3 createBmw3() {
        return new Bmw3blue();
    }
}



//抽象产品角色
abstract class Car3{
    //所有的车都有开的功能
    abstract void driver();
    //车都有放颜色属性
    abstract void color();
}


//具体产品角色
abstract class Benz3 extends Car3{
    @Override
    public void driver() {
        System.out.println("开奔驰");
    }
}
abstract class Bmw3 extends Car3{
    @Override
    public void driver() {
        System.out.println("开宝马");
    }
}


class Benz3red extends Benz3{
    @Override
    public void color() {
        System.out.println("红色奔驰");
    }
}
class Bmw3red extends Bmw3{
    @Override
    public void color() {
        System.out.println("红色宝马");
    }
}
class Benz3blue extends Benz3{
    @Override
    public void color() {
        System.out.println("蓝色奔驰");
    }
}
class Bmw3blue extends Bmw3{
    @Override
    public void color() {
        System.out.println("蓝色宝马");
    }
}


//实际应用场景
public class SimpleFactory3{
    public static void main(String[] args) throws Exception {
        Car3 car = new redDriver3().createBenz3();
        car.driver();
        car.color();
    }
}

//扩展产品族困难。比如在phone中类型增加一个带手写笔类型的手机，那么每个已经实现的手机类就都需要实现这个方法。这严重违反了开闭原则。
//增加等级简单。如果在折叠屏手机下增加一个双折叠屏和三折叠屏的手机这就比较简单，只需要在折叠屏手机构建工厂下面修改就行。
//扩展产品，需要增加新增具体工厂角色的内容，及产品对应属性的具体角色，---修改原有工厂，违背开闭原则
//扩展属性，需要增加属性抽象工厂，增加新增属性对应的产品







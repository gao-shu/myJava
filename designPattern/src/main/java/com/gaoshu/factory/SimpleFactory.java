package com.gaoshu.factory;

/**
 * @author ：ZMJ
 * @version ： 1.0
 * @ClassName ：SimpleFactory
 * @date ：Created in 2021/1/28 16:16
 * @description：简单工厂模式/静态工厂
 */

//工厂类角色
class Driver {
    public static Car DriverCar(String s) throws Exception {
        if (s.equals("Benz")) {
            return new Benz();
        }else if(s.equals("Bmw")){
            return new Bmw();
        }
        throw new Exception();
    }

}

//抽象产品角色
interface Car{
    public void driver();
}


//具体产品角色
class Benz implements Car{
    public void driver() {
        System.out.println("开奔驰");
    }
}

class Bmw implements Car{
    public void driver() {
        System.out.println("开宝马");
    }
}


//实际应用场景
public class SimpleFactory{
    public static void main(String[] args) throws Exception {
        Car car = Driver.DriverCar("Bmw");
        car.driver();
    }
}


//在简单工厂模式中，
//新产品的加入要修改工厂角色中的判断语句。破坏了开闭原则





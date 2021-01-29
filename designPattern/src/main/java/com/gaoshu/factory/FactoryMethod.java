package com.gaoshu.factory;

/**
 * @author ：ZMJ
 * @version ： 1.0
 * @ClassName ：SimpleFactory
 * @date ：Created in 2021/1/28 16:16
 * @description：工厂方法模式
 */

//抽象工厂类角色
interface Driver2 {
    public Car2 driverCar();
}

//具体工厂类角色
class BenzDriver implements Driver2{
    public Car2 driverCar(){
        return new Benz2();
    }
}

class BmwDriver implements Driver2{
    public Car2 driverCar(){
        return new Bmw2();
    }
}


//抽象产品角色
interface Car2{
    public void driver();
}


//具体产品角色
class Benz2 implements Car2{
    public void driver() {
        System.out.println("开奔驰");
    }
}

class Bmw2 implements Car2{
    public void driver() {
        System.out.println("开宝马");
    }
}


//实际应用场景
public class SimpleFactory2{
    public static void main(String[] args) throws Exception {
        Driver2 driver = new BenzDriver();
        Car2 car = driver.driverCar();
        car.driver();
    }
}

//而在工厂方法模式中，要么将判断逻辑留在抽象工厂角色中，
// 要么在客户程序中将具体工厂角色写死（就象上面的例子一样）
//新增产品时，新增具体工厂直接实现即可，不需要修改原有原有工厂







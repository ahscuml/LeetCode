package test;

import java.util.PriorityQueue;

/**
 * @author ahscuml
 * @date 2018/10/25
 * @time 19:40
 */
public class Test {
    static abstract class Human {

    }

    static class Man extends Human{}
    static class Woman extends Human{}

    public void sayHello(Human guy) {
        System.out.println("Hello, guy");
    }

    public void sayHello(Man guy) {
        System.out.println("Hello, Gentleman");
    }

    public void sayHello(Woman guy) {
        System.out.println("Hello, Lady");
    }

    public static void main(String[] args) {
        // 实际类型变化
        Human man = new Man();
        Human woman = new Woman();
        Test te = new Test();
        te.sayHello(man);
        te.sayHello(woman);
        // 静态类型变化
        te.sayHello((Man) man);
        te.sayHello((Woman) woman);
    }
}


import java.util.*;

public class Vehicle {
    void m1() {
        System.out.println("car 1");
    }

    void m2() {
        System.out.println("car 2");
    }

    public static void main(String[] args) {
        Car c = new Car();
        c.m1();
        c.m2();
        //Honk h = new Car();
        c.honking();
    }
}

class Car extends Vehicle implements Honk{
    @Override
    void m1() {
        System.out.println("car 3");
    }

    public void honking() {
        System.out.println("honk honk");
    }
}

interface Honk {
    public void honking();
}


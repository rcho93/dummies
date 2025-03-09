
/*
 Design a coffee maker machine class There is a coffee maker with a screen.
 We need to add three ingredients into the machine: coffee beans, water and 
 milk.
There are three types of drinks we can make, below are the default recipes:

Espresso: cost 3 coffee beans and 1 water

Americano: cost 2 coffee beans and 3 water

Latte: cost 2 coffee beans, 2 milk and 2 water

When a user comes, on the screen we show available drinks. 
After the user chooses a drink, the user will be able to 
customize the amount of ingredients. (For example, after choosing Espresso, 
the user can change from default to 4 coffee beans and 1 water)

The admin is able to refill the ingredients. The admin and the users 
interact with the machine via the screen. In the future, we might can 
support more drink types.
 * 
 */
public class CoffeeMachine {
    public static void main(String[] args) {
        Expresso expresso = new Expresso();
        System.out.println(expresso.getCost());
        expresso.customize(0, 4, 0);
        System.out.println(expresso.getCost());

        Latte latte = new Latte();
        System.out.println("price of latte: " + latte.getCost());
        latte.customize(10, 2, 1);
        System.out.println("price of latte after customization: " + latte.getCost());
    }
}

abstract class Beverage {
    double milk_cost = 2.00;
    double beans_c = 1.50;
    double water_c = 0.0;

    int milk;
    int beans;
    int water;

    public Beverage(int milk, int beans, int water) {
        this.milk = milk;
        this.beans = beans;
        this.water = water;
    }

    public double getCost() {
        return (milk_cost * this.milk) + (beans_c * this.beans) + (water_c * this.water);
    }

    public void customize(int milk, int beans, int water) {
        this.milk = milk > 0 ? milk : this.milk;
        this.beans = beans > 0 ? beans : this.beans;
        this.water = water > 0 ? water : this.water;
    }
}

class Expresso extends Beverage {
    public Expresso() {
        super(0, 3, 1);
    }

}

class Americano extends Beverage {
    public Americano() {
        super(0, 2, 3);
    }

   
}

class Latte extends Beverage {
    public Latte() {
        super(2, 2, 2);
    }

    
}

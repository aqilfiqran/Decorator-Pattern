
package menu;

public class Espresso extends Beverage {
    Beverage beverage;

    public Espresso() {
        description = "Espresso";
    }

    public Espresso(Beverage beverage) {
        description = "Espresso";
        this.beverage = beverage;
    }

    public double cost() {
        try {
            return 1.99 + beverage.cost();
        } catch (Exception e) {
            return 1.99;
        }
    }
}

import menu.*;

/**
 * Tugas APL, testing double expresso
 * 
 * @author Aqil Fiqran Dzi'Ul Haq
 * @since 4/12/2019
 * @version 1.0
 */
public class StarbuzzCoffee {

    /**
     * @param args untuk menangkap perintah lanjutan dari command line
     */
    public static void main(String args[]) {
        Beverage beverage = new Espresso();
        beverage = new Espresso(beverage);
        beverage = new Milk(beverage);
        System.out.println("double " + beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new Espresso();
        beverage2 = new Espresso(beverage2);
        beverage2 = new Milk(beverage2);
        beverage2 = new Milk(beverage2);
        System.out.println("double " + beverage2.getDescription() + " $" + beverage2.cost());

        Beverage beverage3 = new Espresso();
        beverage3 = new Espresso(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println("double " + beverage3.getDescription() + " $" + beverage3.cost());

        Beverage beverage4 = new Espresso();
        beverage4 = new Espresso(beverage4);
        beverage4 = new Whip(beverage4);
        beverage4 = new Whip(beverage4);
        System.out.println("double " + beverage4.getDescription() + " $" + beverage4.cost());

        Beverage beverage5 = new Espresso();
        beverage5 = new Espresso(beverage5);
        System.out.println("double " + beverage5.getDescription() + " $" + beverage5.cost());

        Beverage beverage6 = new Espresso();
        beverage6 = new Espresso(beverage6);
        beverage6 = new Whip(beverage6);
        beverage6 = new Oreo(beverage6);
        System.out.println("double " + beverage6.getDescription() + " $" + beverage6.cost());
    }
}

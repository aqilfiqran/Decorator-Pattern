import java.util.Scanner;
import java.util.ArrayList;
import menu.*;

public class Main {
    static Scanner user = new Scanner(System.in);

    public static void main(String args[]) {
        ArrayList<Beverage> order = new ArrayList<Beverage>();

        while (true) {
            dmenu();
            System.out.print("\n--> Your Order : ");
            String choice = user.nextLine();
            if (choice.equals("1"))
                order.add(new DarkRoast());
            else if (choice.equals("2"))
                order.add(new Decaf());
            else if (choice.equals("3"))
                order.add(new Espresso());
            else if (choice.equals("4"))
                order.add(new HouseBlend());
            else if (choice.equals("5"))
                order.add(new MilkShake());
            else {
                System.out.println("<-- Choose 1-5 -->");
                continue;
            }

            if (question("<<>> Want Condiment (Y/N) : ").equalsIgnoreCase("y"))
                while (true) {
                    dcondiment();
                    System.out.print("\n--> Your Condiment : ");
                    choice = user.nextLine();
                    if (choice.equals("1"))
                        order.set(order.size() - 1, new Milk(order.get(order.size() - 1)));
                    else if (choice.equals("2"))
                        order.set(order.size() - 1, new Mocha(order.get(order.size() - 1)));
                    else if (choice.equals("3"))
                        order.set(order.size() - 1, new Oreo(order.get(order.size() - 1)));
                    else if (choice.equals("4"))
                        order.set(order.size() - 1, new Soy(order.get(order.size() - 1)));
                    else if (choice.equals("5"))
                        order.set(order.size() - 1, new Whip(order.get(order.size() - 1)));
                    else {
                        System.out.println("<-- Choose 1-5 -->");
                        continue;
                    }

                    if (question("<<>> More Condiment (Y/N) : ").equalsIgnoreCase("n"))
                        break;
                }

            if (question("<<>> More Order (Y/N) : ").equalsIgnoreCase("n"))
                break;
        }
        double money, total = 0;

        for (Beverage item : order) {
            System.out.println("[-] " + item.getDescription() + " $" + item.cost());
            total += item.cost();
        }

        System.out.println("\n--> Total Price : $" + total);
        while (true) {
            System.out.print("--> Your Money : ");
            while (!user.hasNextDouble()) {
                System.out.print("Number\n--> Your Money : ");
                user.next();
            }
            money = user.nextDouble();

            if (total < money) {
                System.out.println("==> Back : $" + String.format("%.2f", money - total));
                System.out.println("<< Thank You For Coming >>");
                break;
            } else
                System.out.println("<-- Need $" + total + " -->");
        }

        System.out.println("\n\n---- Copyrigth by Aqil Fiqran Dzi'Ul Haq ----");
    }

    private static void dmenu() {
        System.out.println("[+]------------------------[+]-------------[+]");
        System.out.println(" |           Menu           |     Price     |");
        System.out.println("[+]------------------------[+]-------------[+]");
        System.out.println(" | 1. DarkRoast             |  $0.99        |");
        System.out.println(" | 2. Decaf                 |  $1.05        |");
        System.out.println(" | 3. Expresso              |  $1.99        |");
        System.out.println(" | 4. HouseBlend            |  $0.89        |");
        System.out.println(" | 5. MilkShake             |  $1.25        |");
        System.out.println("[+]------------------------[+]-------------[+]");
    }

    private static void dcondiment() {
        System.out.println("[+]------------------------[+]-------------[+]");
        System.out.println(" |        Condiment         |     Price     |");
        System.out.println("[+]------------------------[+]-------------[+]");
        System.out.println(" | 1. Milk                  |  $0.10        |");
        System.out.println(" | 2. Mocha                 |  $0.20        |");
        System.out.println(" | 3. Oreo                  |  $0.22        |");
        System.out.println(" | 4. Soy                   |  $0.15        |");
        System.out.println(" | 5. Whip                  |  $0.10        |");
        System.out.println("[+]------------------------[+]-------------[+]");
    }

    private static String question(String q) {
        String choice;
        while (true) {
            System.out.print(q);
            choice = user.nextLine();
            if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("n"))
                break;
            else
                System.out.println("<-- Choose Y or N -->");
        }

        return choice;
    }
}

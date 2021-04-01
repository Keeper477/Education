package prac_16;


public class Tester {
    public static void main(String[] ar) {
        OrderManager om = new OrderManager();
        RestaurantOrder ro = new RestaurantOrder();
        InternetOrder io = new InternetOrder();

        try {
            Drink vodka = new Drink("Vodka", "0.5", 150);
            Drink wine = new Drink("Wine", "0.5", 305);
            Drink coffee = new Drink("Coffee", "0.2", 60);
            Dish chicken = new Dish("Сhicken", "chicken", 250);
            Dish dumplings = new Dish("Dumplings", "dumplings", 150);
            Dish smoothie = new Dish("Smoothie", "smoothie", 40);
            ro.add(vodka);
            ro.add(coffee);
            io.add(chicken);
            io.add(wine);
            io.add(smoothie);
            ro.add(dumplings);
            ro.add(dumplings);
            ro.add(chicken);
            om.add(1, ro);
            om.add(2,ro);
            om.add("Moscow",io);
            System.out.println(ro.CostTotal());
            System.out.println(om.RestaurantOrdersCostSummary());
            System.out.println(ro.dishQuantity());
            System.out.println(ro.dishQuantity("Dumplings"));
            System.out.println(io.getSize());
            System.out.println(io.CostTotal());
            io.remove("Сhicken");
            System.out.println(io.getSize());
            System.out.println(io.CostTotal());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

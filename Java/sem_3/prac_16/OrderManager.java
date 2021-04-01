package prac_16;

import java.util.HashMap;

public class OrderManager  {
    private HashMap<Integer, RestaurantOrder> res_orders;
    private HashMap<String, InternetOrder> int_orders;

    public OrderManager(){
        res_orders = new HashMap<>();
        int_orders = new HashMap<>();
    }

    public boolean add(int tableNumber, RestaurantOrder order) throws Exception {
        if (res_orders.containsKey(tableNumber)){
            throw new Exception ("OrderAlreadyAddedException");
        }
        else {
            res_orders.put(tableNumber, order);
            return true;
        }
    }
    public boolean add(String address, InternetOrder order){
        try {
            int_orders.put(address, order);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public void removeRestaurantOrder(int tableNumber){
        res_orders.remove(tableNumber);
    }

    public void removeInternetOrder(String address){
        int_orders.remove(address);
    }

    public RestaurantOrder getRestaurantOrder(int tableNumber) {
        return res_orders.get(tableNumber);
    }

    public InternetOrder getInternetOrder(String address) {
        return int_orders.get(address);
    }

    public double RestaurantOrdersCostSummary(){
        double total = 0;
        for(int key : res_orders.keySet()){
            total += res_orders.get(key).CostTotal();
        }
        return total;
    }
    public double InternetOrdersCostSummary(){
        double total = 0;
        for(String key : int_orders.keySet()){
            total += int_orders.get(key).CostTotal();
        }
        return total;
    }
    public void addDish_RestaurantOrder(int tableNumber, Dish dish){
        res_orders.get(tableNumber).add(dish);
    }
    public void addDrink_RestaurantOrder(int tableNumber, Drink drink){
        res_orders.get(tableNumber).add(drink);
    }
    public void addDish_InternetOrder(String address, Dish dish){
        int_orders.get(address).add(dish);
    }
    public void addDrink_InternetOrder(String address, Drink drink){
        int_orders.get(address).add(drink);
    }

    public String getAllOrders(){
        String s = "";
        if (!res_orders.isEmpty()) {
            s += "Заказы в ресторане:\n";
            for (int key : res_orders.keySet()) {
                s += "Заказ на стол №" + key + " на сумму : " + res_orders.get(key).CostTotal() + "\n";
            }
        }
        if (!int_orders.isEmpty()) {
            s += "Заказы в интернете:\n";
            for (String key : int_orders.keySet()) {
                s += "Заказ по адресу: " + key + " на сумму : " + int_orders.get(key).CostTotal() + "\n";
            }
        }
        return s;
    }
}

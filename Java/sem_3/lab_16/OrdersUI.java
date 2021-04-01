package lab_16;

import prac_16.*;

import javax.swing.*;
import java.awt.*;

public class OrdersUI extends JFrame {
    JButton internet_bt, restaurant_bt, list_orders, choose_drink, choose_dish, enter_data, back, ready_order;
    JPanel pnl1, pnl3;
    choice_order pnl2;
    JTextField jta;
    OrderManager manager;
    InternetOrder internet;
    RestaurantOrder restaurant;

    OrdersUI(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        manager = new OrderManager();
        internet = new InternetOrder();
        restaurant = new RestaurantOrder();
        pnl1 = create_pnl1();
        internet_bt.addActionListener(ae -> {
            remove(pnl1);
            pnl2 = new choice_order();
            pnl2.update_txt(internet);
            add(pnl2);
            pnl2.choose_drink.addActionListener(ae1 -> {
                remove(pnl2);
                pnl3 = create_Drink(internet);
                add(pnl3);
                repaint();
                revalidate();
                back.addActionListener(ae11 -> {
                    remove(pnl3);
                    add(pnl2);
                    pnl2.update_txt(internet);
                    SwingUtilities.updateComponentTreeUI(this);
                });
            });
            pnl2.choose_dish.addActionListener(ae12 -> {
                remove(pnl2);
                pnl3 = create_Dish(internet);
                add(pnl3);
                repaint();
                revalidate();
                back.addActionListener(ae121 -> {
                    remove(pnl3);
                    add(pnl2);
                    pnl2.update_txt(internet);
                    SwingUtilities.updateComponentTreeUI(this);
                });
            });
            pnl2.enter_data.addActionListener(ae13 -> {
                remove(pnl2);
                pnl3 = create_pnl3();
                add(pnl3);
                repaint();
                revalidate();
                back.addActionListener(ae131 -> {
                    remove(pnl3);
                    add(pnl2);
                    repaint();
                });
                ready_order.addActionListener(ae1312 -> {
                    String s = jta.getText();
                    if(!s.equals("")){
                        remove(pnl3);
                        add(pnl1);
                        manager.add(s, internet);
                        JOptionPane.showMessageDialog(null, "Успешно",
                                "Информация", JOptionPane.INFORMATION_MESSAGE);
                        internet = new InternetOrder();
                        repaint();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Неверный адрес",
                                "Информация", JOptionPane.ERROR_MESSAGE);
                    }
                });
            });
            pnl2.back.addActionListener(ae14 -> {
                remove(pnl2);
                add(pnl1);
                repaint();
                internet = new InternetOrder();
            });
            repaint();
            revalidate();
        });
        restaurant_bt.addActionListener(ae -> {
            remove(pnl1);
            pnl2 = new choice_order();
            pnl2.update_txt(restaurant);
            add(pnl2);
            pnl2.choose_drink.addActionListener(ae15 -> {
                remove(pnl2);
                pnl3 = create_Drink(restaurant);
                add(pnl3);
                repaint();
                revalidate();
                back.addActionListener(ae151 -> {
                    remove(pnl3);
                    pnl2.update_txt(restaurant);
                    add(pnl2);
                    SwingUtilities.updateComponentTreeUI(this);
                });
            });
            pnl2.choose_dish.addActionListener(ae16 -> {
                remove(pnl2);
                pnl3 = create_Dish(restaurant);
                add(pnl3);
                repaint();
                revalidate();
                back.addActionListener(ae161 -> {
                    remove(pnl3);
                    pnl2.update_txt(restaurant);
                    add(pnl2);
                    SwingUtilities.updateComponentTreeUI(this);
                });
            });
            pnl2.enter_data.addActionListener(ae17 -> {
                remove(pnl2);
                pnl3 = create_pnl4();
                add(pnl3);
                repaint();
                revalidate();
                back.addActionListener(ae171 -> {
                    remove(pnl3);
                    add(pnl2);
                    repaint();
                });
                ready_order.addActionListener(ae1712 -> {
                    String s = jta.getText();
                    if(!s.equals("")){
                        try {
                            int k =  Integer.parseInt(s);
                            try {
                                manager.add(k, restaurant);
                                remove(pnl3);
                                add(pnl1);
                                repaint();
                                JOptionPane.showMessageDialog(null, "Успешно",
                                        "Информация", JOptionPane.INFORMATION_MESSAGE);
                                restaurant = new RestaurantOrder();
                            }
                            catch (Exception e){
                                JOptionPane.showMessageDialog(null, "Стол занят",
                                        "Информация", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        catch (Exception e){
                            JOptionPane.showMessageDialog(null, "Такого стола нет",
                                    "Информация", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Такого стола нет",
                                "Информация", JOptionPane.ERROR_MESSAGE);
                    }
                });
            });
            pnl2.back.addActionListener(ae18 -> {
                remove(pnl2);
                add(pnl1);
                repaint();
                restaurant = new RestaurantOrder();
            });
            repaint();
            revalidate();
        });
        list_orders.addActionListener(ae -> {
            String s = manager.getAllOrders();
            if(!s.equals("")){
                JOptionPane.showMessageDialog(null, s, "Информация",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null, "Заказов нет",
                        "Информация", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(pnl1);
        setSize(600, 600);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo (null);
    }

    public JPanel create_pnl1(){
        JPanel pnl = new JPanel();
        pnl.setLayout(null);

        JLabel tx1 = new JLabel("Оформление заказа");
        Font fn = new Font("Times New Roman", Font.BOLD, 30);
        tx1.setFont(fn);
        internet_bt = new JButton("Закать в интернете");
        restaurant_bt = new JButton("Заказать в ресторане");
        list_orders = new JButton("Список");

        tx1.setBounds(160, 80,300,80);
        internet_bt.setBounds(200, 180,200,80);
        restaurant_bt.setBounds(200,280,200,80);
        list_orders.setBounds(200, 380,200,80);

        pnl.add(tx1);
        pnl.add(internet_bt);
        pnl.add(restaurant_bt);
        pnl.add(list_orders);

        return pnl;
    }

    public static class choice_order extends JPanel {
        JButton choose_drink, choose_dish, enter_data, back;
        JLabel tx1, tx2, txt;

        public choice_order() {
            this.setLayout(null);
            choose_drink = new JButton("Добавить напиток");
            choose_dish = new JButton("Добавить блюдо");
            enter_data = new JButton("Заказать");
            back = new JButton("Отмена");
            Font fn = new Font("Times New Roman", Font.BOLD, 40);
            tx1 = new JLabel("Ваш заказ: ");
            tx1.setFont(fn);
            tx2 = new JLabel();
            txt = new JLabel();
        }

        public void update_txt(InternetOrder io) {
            removeAll();

            StringBuilder s = new StringBuilder();
            String s1 = "Итого: ";

            Font fn1 = new Font("Times New Roman", Font.BOLD, 18);
            txt.setFont(fn1);

            Drink[] drinks = io.getDrinks();
            Dish[] dishes = io.getDish();
            int k = 0;
            for (Drink drink : drinks) {
                if (drink != null) {
                    s.append(drink).append(" x ").append(io.getOrderQuantity(drink.getTitle()));
                    txt = new JLabel(s.toString());
                    txt.setBounds(340, 120 + 20 * k, 300, 80);
                    add(txt);
                    s = new StringBuilder();
                    k++;
                }
            }
            for (Dish dish : dishes) {
                if (dish != null) {
                    s.append(dish).append(" x ").append(io.getOrderQuantity(dish.getTitle()));
                    txt = new JLabel(s.toString());
                    txt.setBounds(340, 120 + 20 * k, 300, 80);
                    add(txt);
                    s = new StringBuilder();
                    k++;
                }
            }
            s1 += io.CostTotal();
            tx2.setText(s1);
            Font fn2 = new Font("Times New Roman", Font.BOLD, 25);
            tx2.setFont(fn2);

            tx1.setBounds(340, 70, 300, 80);
            tx2.setBounds(350, 380, 300, 80);
            choose_drink.setBounds(100, 80, 200, 80);
            choose_dish.setBounds(100, 180, 200, 80);
            enter_data.setBounds(100, 280, 200, 80);
            back.setBounds(100, 380, 200, 80);

            add(tx1);
            add(tx2);
            add(txt);
            add(choose_drink);
            add(choose_dish);
            add(enter_data);
            add(back);
        }

        public void update_txt(RestaurantOrder ro){
            removeAll();
            StringBuilder s = new StringBuilder();
            String s1 = "Итого: ";

            txt.setText(s.toString());
            Font fn1 = new Font("Times New Roman", Font.BOLD, 18);
            txt.setFont(fn1);

            for (int i = 0; i < ro.getSize(); i++){
                Drink[] drinks = ro.getDrinks();
                Dish[] dishes = ro.getDishes();
                int k = 0;
                for (Drink drink : drinks) {
                    if (drink != null) {
                        s.append(drink).append(" x ").append(ro.drinkQuantity(drink.getTitle()));
                        txt = new JLabel(s.toString());
                        txt.setBounds(340, 120 + 20 * k, 300, 80);
                        add(txt);
                        s = new StringBuilder();
                        k++;
                    }
                }
                for (Dish dish : dishes) {
                    if (dish != null) {
                        s.append(dish).append(" x ").append(ro.dishQuantity(dish.getTitle()));
                        txt = new JLabel(s.toString());
                        txt.setBounds(340, 120 + 20 * k, 300, 80);
                        add(txt);
                        s = new StringBuilder();
                        k++;
                    }
                }
            }
            s1 += ro.CostTotal();
            tx2.setText(s1);
            Font fn2 = new Font("Times New Roman", Font.BOLD, 25);
            tx2.setFont(fn2);


            tx1.setBounds(340, 70,300,80);
            tx2.setBounds(350, 380,300,80);
            choose_drink.setBounds(100, 80,200,80);
            choose_dish.setBounds(100,180,200,80);
            enter_data.setBounds(100, 280,200,80);
            back.setBounds(100, 380,200,80);

            add(tx1);
            add(tx2);
            add(txt);
            add(choose_drink);
            add(choose_dish);
            add(enter_data);
            add(back);
        }
    }

    public JPanel create_pnl3(){
        JPanel pnl = new JPanel();
        pnl.setLayout(null);

        jta = new JTextField (15);
        ready_order = new JButton("Готово");
        back = new JButton("Отмена");
        JLabel tx1 = new JLabel("Введите адрес");
        Font fn = new Font("Times New Roman", Font.BOLD, 45);
        tx1.setFont(fn);

        tx1.setBounds(160, 130,300,80);
        jta.setBounds(200, 240,200,40);
        ready_order.setBounds(200, 300,200,80);
        back.setBounds(200, 400,200,80);

        pnl.add(tx1);
        pnl.add(jta);
        pnl.add(ready_order);
        pnl.add(back);

        return pnl;
    }

    public JPanel create_pnl4(){
        JPanel pnl = new JPanel();
        pnl.setLayout(null);

        jta = new JTextField (15);
        ready_order = new JButton("Готово");
        back = new JButton("Отмена");
        JLabel tx1 = new JLabel("Введите номер");
        JLabel tx2 = new JLabel("стола");
        Font fn = new Font("Times New Roman", Font.BOLD, 40);
        tx1.setFont(fn);
        tx2.setFont(fn);

        tx1.setBounds(170, 100,300,80);
        tx2.setBounds(250, 145,300,80);
        jta.setBounds(200, 240,200,40);
        ready_order.setBounds(200, 300,200,80);
        back.setBounds(200, 400,200,80);

        pnl.add(tx1);
        pnl.add(tx2);
        pnl.add(jta);
        pnl.add(ready_order);
        pnl.add(back);

        return pnl;
    }

    public JPanel create_Drink(InternetOrder io){
        JPanel pnl = new JPanel();
        pnl.setLayout(null);

        JButton juice = new JButton("Сок");
        JButton tea = new JButton("Чай");
        JButton coffee = new JButton("Кофе");
        JButton beer = new JButton("Пиво");
        JButton wine = new JButton("Вино");
        back = new JButton("Закончить выбор");

        juice.setBounds(200, 40,200,60);
        tea.setBounds(200,120,200,60);
        coffee.setBounds(200, 200,200,60);
        beer.setBounds(200, 280,200,60);
        wine.setBounds(200,360,200,60);
        back.setBounds(200, 440,200,60);

        pnl.add(juice);
        pnl.add(tea);
        pnl.add(coffee);
        pnl.add(beer);
        pnl.add(wine);
        pnl.add(back);

        juice.addActionListener(ae -> {
            try{
                Drink juice1 = new Drink("Сок", "0.5", 100);
                io.add(juice1);
            }
            catch (Exception e){
                System.out.println("Такого напитка нет");
            }
        });
        tea.addActionListener(ae -> {
            try{
                Drink tea1 = new Drink("Чай", "1", 40);
                io.add(tea1);
            }
            catch (Exception e){
                System.out.println("Такого напитка нет");
            }
        });
        coffee.addActionListener(ae -> {
            try{
                Drink coffee1 = new Drink("Кофе", "1", 50);
                io.add(coffee1);
            }
            catch (Exception e){
                System.out.println("Такого напитка нет");
            }
        });
        beer.addActionListener(ae -> {
            try{
                Drink beer1 = new Drink("Пиво", "0.5", 120);
                io.add(beer1);
            }
            catch (Exception e){
                System.out.println("Такого напитка нет");
            }
        });
        wine.addActionListener(ae -> {
            try{
                Drink wine1 = new Drink("Вино", "0.5", 200);
                io.add(wine1);
            }
            catch (Exception e){
                System.out.println("Такого напитка нет");
            }
        });

        return pnl;
    }

    public JPanel create_Drink(RestaurantOrder ro){
        JPanel pnl = new JPanel();
        pnl.setLayout(null);

        JButton juice = new JButton("Сок");
        JButton tea = new JButton("Чай");
        JButton coffee = new JButton("Кофе");
        JButton beer = new JButton("Пиво");
        JButton wine = new JButton("Вино");
        back = new JButton("Закончить выбор");

        juice.setBounds(200, 40,200,60);
        tea.setBounds(200,120,200,60);
        coffee.setBounds(200, 200,200,60);
        beer.setBounds(200, 280,200,60);
        wine.setBounds(200,360,200,60);
        back.setBounds(200, 440,200,60);

        pnl.add(juice);
        pnl.add(tea);
        pnl.add(coffee);
        pnl.add(beer);
        pnl.add(wine);
        pnl.add(back);

        juice.addActionListener(ae -> {
            try{
                Drink juice1 = new Drink("Сок", "0.5", 100);
                ro.add(juice1);
            }
            catch (Exception e){
                System.out.println("Такого напитка нет");
            }
        });
        tea.addActionListener(ae -> {
            try{
                Drink tea1 = new Drink("Чай", "1", 40);
                ro.add(tea1);
            }
            catch (Exception e){
                System.out.println("Такого напитка нет");
            }
        });
        coffee.addActionListener(ae -> {
            try{
                Drink coffee1 = new Drink("Кофе", "1", 50);
                ro.add(coffee1);
            }
            catch (Exception e){
                System.out.println("Такого напитка нет");
            }
        });
        beer.addActionListener(ae -> {
            try{
                Drink beer1 = new Drink("Пиво", "0.5", 120);
                ro.add(beer1);
            }
            catch (Exception e){
                System.out.println("Такого напитка нет");
            }
        });
        wine.addActionListener(ae -> {
            try{
                Drink wine1 = new Drink("Вино", "0.5", 200);
                ro.add(wine1);
            }
            catch (Exception e){
                System.out.println("Такого напитка нет");
            }
        });

        return pnl;
    }

    public JPanel create_Dish(InternetOrder io){
        JPanel pnl = new JPanel();
        pnl.setLayout(null);

        JButton steak = new JButton("Стейк");
        JButton fries = new JButton("Картошка фри");
        JButton dumplings = new JButton("Пельмени");
        JButton mozzarella = new JButton("Курица");
        JButton borsch = new JButton("Борщ");
        back = new JButton("Закончить выбор");

        steak.setBounds(200, 40,200,60);
        fries.setBounds(200,120,200,60);
        dumplings.setBounds(200, 200,200,60);
        mozzarella.setBounds(200, 280,200,60);
        borsch.setBounds(200,360,200,60);
        back.setBounds(200, 440,200,60);

        pnl.add(steak);
        pnl.add(fries);
        pnl.add(dumplings);
        pnl.add(mozzarella);
        pnl.add(borsch);
        pnl.add(back);

        steak.addActionListener(ae -> {
            try{
                Dish steak1 = new Dish("Стейк", "тарелка", 400);
                io.add(steak1);
            }
            catch (Exception e){
                System.out.println("Такого блюда нет");
            }
        });
        fries.addActionListener(ae -> {
            try{
                Dish fries1 = new Dish("фри", "тарелка", 100);
                io.add(fries1);
            }
            catch (Exception e){
                System.out.println("Такого блюда нет");
            }
        });
        dumplings.addActionListener(ae -> {
            try{
                Dish dumplings1 = new Dish("Пельмени", "тарелка", 150);
                io.add(dumplings1);
            }
            catch (Exception e){
                System.out.println("Такого блюда нет");
            }
        });
        mozzarella.addActionListener(ae -> {
            try{
                Dish mozzarella1 = new Dish("Курица", "тарелка", 250);
                io.add(mozzarella1);
            }
            catch (Exception e){
                System.out.println("Такого блюда нет");
            }
        });
        borsch.addActionListener(ae -> {
            try{
                Dish borsch1 = new Dish("Борщ", "тарелка", 120);
                io.add(borsch1);
            }
            catch (Exception e){
                System.out.println("Такого блюда нет");
            }
        });

        return pnl;
    }

    public JPanel create_Dish(RestaurantOrder ro){
        JPanel pnl = new JPanel();
        pnl.setLayout(null);

        JButton steak = new JButton("Стейк");
        JButton fries = new JButton("Картошка фри");
        JButton dumplings = new JButton("Пельмени");
        JButton mozzarella = new JButton("Курица");
        JButton borsch = new JButton("Борщ");
        back = new JButton("Закончить выбор");

        steak.setBounds(200, 40,200,60);
        fries.setBounds(200,120,200,60);
        dumplings.setBounds(200, 200,200,60);
        mozzarella.setBounds(200, 280,200,60);
        borsch.setBounds(200,360,200,60);
        back.setBounds(200, 440,200,60);

        pnl.add(steak);
        pnl.add(fries);
        pnl.add(dumplings);
        pnl.add(mozzarella);
        pnl.add(borsch);
        pnl.add(back);

        steak.addActionListener(ae -> {
            try{
                Dish steak1 = new Dish("Стейк", "тарелка", 400);
                ro.add(steak1);
            }
            catch (Exception e){
                System.out.println("Такого блюда нет");
            }
        });
        fries.addActionListener(ae -> {
            try{
                Dish fries1 = new Dish("Фри", "тарелка", 100);
                ro.add(fries1);
            }
            catch (Exception e){
                System.out.println("Такого блюда нет");
            }
        });
        dumplings.addActionListener(ae -> {
            try{
                Dish dumplings1 = new Dish("Пельмени", "тарелка", 150);
                ro.add(dumplings1);
            }
            catch (Exception e){
                System.out.println("Такого блюда нет");
            }
        });
        mozzarella.addActionListener(ae -> {
            try{
                Dish mozzarella1 = new Dish("Курица", "тарелка", 250);
                ro.add(mozzarella1);
            }
            catch (Exception e){
                System.out.println("Такого блюда нет");
            }
        });
        borsch.addActionListener(ae -> {
            try{
                Dish borsch1 = new Dish("Борщ", "тарелка", 120);
                ro.add(borsch1);
            }
            catch (Exception e){
                System.out.println("Такого блюда нет");
            }
        });

        return pnl;
    }

}

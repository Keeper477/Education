package prac_9.INN;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Order extends JFrame{
    Order(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridBagLayout gd = new GridBagLayout();
        setLayout(gd);

        JLabel tx = new JLabel("Оформление заказа");
        GridBagConstraints con1 = new GridBagConstraints();
        con1.gridx = 1;
        con1.gridy = 0;
        con1.insets.left = 70;
        con1.anchor = GridBagConstraints.WEST;
        Font fn = new Font("Times New Roman", Font.BOLD, 25);
        tx.setFont(fn);
        add(tx, con1);

        GridBagConstraints con2 = new GridBagConstraints();
        con2.insets.top = 20;
        con2.gridx = 0;
        con2.gridy = 1;
        con2.insets.right = 20;
        JLabel tx1 = new JLabel("Введите ФИО");
        add(tx1, con2);
        con2.insets.right = 0;
        con2.gridx = 1;
        JTextField jta1 = new JTextField (40);
        add(jta1, con2);

        GridBagConstraints con3 = new GridBagConstraints();
        con3.insets.top = 20;
        con3.gridx = 0;
        con3.gridy = 2;
        con3.insets.right = 20;
        JLabel tx2 = new JLabel("Введите ИНН");
        add(tx2, con3);
        JTextField jta2 = new JTextField (40);
        con3.gridx = 1;
        con3.insets.right = 0;
        add(jta2, con3);

        GridBagConstraints con4 = new GridBagConstraints();
        con4.gridx = 1;
        con4.gridy = 3;
        con4.insets.top = 50;
        con4.insets.right = 80;
        JButton bt = new JButton("Ввести");
        add(bt, con4);

        bt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    String x = jta2.getText();
                    if (x.length() != 12 && x.length() != 10) {
                        throw new Exception("Неверный ИНН");
                    }
                    int temp;
                    try {
                        temp = Integer.parseInt(x.trim());
                        JOptionPane.showMessageDialog(null, "Успешно", "Информация",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "В ИНН нет букв",
                                "Информация", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Неверный формат ИНН", "Информация",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        setSize(800, 800);
        setVisible(true);
    }
}

package lab_6;

import java.awt.event.*;
import javax.swing.*;

public class Game extends JFrame {
    public int num = (int)(Math.random() * 20), att = 3;
    Game(){
        setSize(500,600);
        setLayout(null);
        JButton bt = new JButton("Нажать");
        JTextField jta = new JTextField (10);
        JLabel tx = new JLabel("Попробуй угадать число");
        bt.setBounds(150, 300,200,50);
        tx.setBounds(180, 100,400,200);
        jta.setBounds(150, 250,200,40);
        add(tx);
        add(jta);
        add(bt);
        bt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                int x = Integer.parseInt(jta.getText().trim());
                if (x == num) {
                    JOptionPane.showMessageDialog(null, "Вы угадали число." +
                                    "\nПоздравляю","Информация", JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    dispose();
                }
                else {
                    att--;
                    JOptionPane.showMessageDialog(null, "Вы не угадали число. " +
                                    "\nОставшиеся попытки: " + att,"Информация", JOptionPane.ERROR_MESSAGE);
                }
                if (att == 0){
                    setVisible(false);
                    dispose();
                }
            }
        });
    }
}

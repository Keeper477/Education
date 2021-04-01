package prac_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame  {
    Card deck1, deck2, card1, card2;
    JLabel txt1, txt2;
    JButton bt;
    G_Queue gq = new G_Queue();
    G_Stack gs = new G_Stack();
    G_Dequeue gd = new G_Dequeue();
    int k;
    Game(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,800);
        setLayout(null);
        deck1 = new Card(10);
        deck2 = new Card(10);
        deck1.setBounds(300, 10 , 200, 160);
        deck2.setBounds(300, 600, 200, 160);
        add(deck1);
        add(deck2);

        txt1 = new JLabel(String.valueOf(5));
        txt2 = new JLabel(String.valueOf(5));
        Font fn = new Font("Times New Roman", Font.BOLD, 50);
        txt1.setFont(fn);
        txt2.setFont(fn);
        txt1.setBounds(100, 250 , 100, 50);
        txt2.setBounds(100, 450 , 100, 50);
        add(txt1);
        add(txt2);

        bt = new JButton("Выложить карты");
        bt.setBounds(600, 340 , 150, 100);
        add(bt);

        bt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if (bt.getText() == "Выложить карты") {
                    card1 = new Card(gd.GetEl(1));
                    card2 = new Card(gd.GetEl(2));
                    card1.setBounds(300, 210, 200, 160);
                    card2.setBounds(300, 410, 200, 160);
                    add(card1);
                    add(card2);
                    bt.setText("Продолжить");
                }
                else{
                    gd.turn();
                    k++;
                    txt1.setText(String.valueOf(gd.len(1)));
                    txt2.setText(String.valueOf(gd.len(2)));
                    remove(card1);
                    remove(card2);
                    if (gd.len(1) == 0 || gd.len(2) == 0|| k == 106){
                        if (gd.len(1) == 0){
                            JOptionPane.showMessageDialog(null, "Конец игры\n" +
                                            "Выиграл: Второй игрок\nХодов сделано: " + k  , "Информация",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        else if(k == 106){
                            JOptionPane.showMessageDialog(null, "botva", "Информация",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Конец игры\n" +
                                            "Выиграл: Первый игрок\nХодов сделано: " + k  , "Информация",
                                    JOptionPane.ERROR_MESSAGE);
                        }

                        setVisible(false);
                        dispose();
                    }
                    bt.setText("Выложить карты");
                }
            }
        });
    }
    public static void main(String[]args){
        Game test = new Game();
        test.setVisible(true);
    }
}

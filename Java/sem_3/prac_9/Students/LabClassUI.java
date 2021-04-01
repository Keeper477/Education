package prac_9.Students;


import prac_6.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LabClassUI extends JFrame {
    JButton bt1, bt2, bt3, bt4, bt5 = new JButton("Найти");
    JTextField jta = new JTextField (15);
    LabClassUI() {
        LabClass lb = new LabClass();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        bt1 = new JButton("Вывести всех студентов");
        bt1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String s = "";
                for (int i = 0; i < lb.Students.length; i++){
                    s += lb.Students[i] + "\n";
                }
                JOptionPane.showMessageDialog(null, s, "Список",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        bt1.setBounds(200, 80,200,80);
        add(bt1);

        bt2 = new JButton("Сортировка по оценкам");
        bt2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                lb.srt.sort(lb.Students, 0, lb.Students.length - 1);
            }
        });
        bt2.setBounds(200, 180,200,80);
        add(bt2);

        bt3 = new JButton("Сортировка по id");
        bt3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                lb.qs.sort(lb.Students);
            }
        });
        bt3.setBounds(200, 280,200,80);
        add(bt3);

        bt4 = new JButton("Поиск студента");
        bt4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                jta = new JTextField (15);
                jta.setBounds(450, 380,100,30);
                add(jta);
                bt5.setBounds(450, 420,100,40);
                add(bt5);
                repaint();
            }
        });
        bt5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Student temp = lb.find(jta.getText());
                if(temp != null){
                    JOptionPane.showMessageDialog(null, temp, "Информация",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Такого имени нет в списке",
                            "Информация", JOptionPane.ERROR_MESSAGE);
                }
                remove(bt5);
                remove(jta);
                repaint();
            }
        });
        bt4.setBounds(200, 380,200,80);
        add(bt4);

        setSize(600, 600);
        setVisible(true);
    }

}

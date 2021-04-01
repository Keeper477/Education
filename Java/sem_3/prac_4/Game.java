package prac_4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game  extends JFrame{
    public int mil_sc = 0, mad_sc = 0;
    public String result = "DRAW";
    JButton mil = new JButton("AC Milan");
    JButton mad = new JButton("Real Madrid");
    JLabel sc = new JLabel("Result: " + mil_sc + " X " + mad_sc);
    JLabel last = new JLabel("Last Scorer: N/A" );
    Label res = new Label("Winner: " + result);

    Game(){
        setLayout(null);
        mil.setBounds(150, 270,160,80);
        mad.setBounds(490, 270, 160, 80);
        sc.setBounds(350, 130,140,80);
        sc.setFont(new Font("Serif", Font.PLAIN, 20));
        last.setBounds(120, 130,250,80);
        last.setFont(new Font("Serif", Font.PLAIN, 20));
        res.setBounds(500, 130,180,80);
        res.setFont(new Font("Serif", Font.PLAIN, 20));
        add(sc);
        add(last);
        add(res);
        add(mil);
        add(mad);
        mil.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                mil_sc += 1;
                sc.setText("Result: " + mil_sc + " X " + mad_sc);
                if (mil_sc == mad_sc){
                    result = "DRAW";
                }
                else if (mil_sc > mad_sc){
                    result = "AC Milan";
                }
                else {
                    result = "Real Madrid";
                }
                res.setText("Winner: " + result);
                last.setText("Last Scorer:\nAC Milan");
            }
        });
        mad.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                mad_sc += 1;
                sc.setText("Result: " + mil_sc + " X " + mad_sc);
                if (mil_sc == mad_sc){
                    result = "DRAW";
                }
                else if (mil_sc > mad_sc){
                    result = "AC Milan";
                }
                else {
                    result = "Real Madrid";
                }
                res.setText("Winner: " + result);
                last.setText("Last Scorer: Real Madrid");
            }
        });
        setSize(800,500);
    }

    public static void main(String[]args){
        Game g = new Game();
        g.setVisible(true);
    }


}

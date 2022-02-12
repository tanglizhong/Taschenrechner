package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    public static int count = 0;
    public static String s1 = ""; //erste Zahl (str)
    public static String s2 = ""; //zweite Zahl (str)
    public static Double zahl1 = 0.0; //erste Zahl (double)
    public static Double zahl2 = 0.0; //zweite Zahl (double)
    public static JTextField text;
    public static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) {

        JFrame frame = new JFrame("Taschenrechner");
        frame.setSize(480,550);
        frame.setLocationRelativeTo(null); //zentrieren
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //关闭时的操作
        frame.setLayout(null); //Layoutstandard weg
        text = new JTextField();
        text.setBounds(30,30,301,50);
        frame.getContentPane().add(text);
        JButton buttonClear = new JButton("clear");
        buttonClear.setBounds(330,30,100,49);
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
                list.clear();
            }
        });
        frame.getContentPane().add(buttonClear);
        String str = "123+456-789*.0=/";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JButton button = new JButton(Character.toString(str.charAt(count)));
                button.setBounds(30+j*100,80+i*100,100,100);
                //button.setBorderPainted(false);//不显示边框
                button.addActionListener(new ActionListener() {//添加事件监听
                    @Override
                    public void actionPerformed(ActionEvent e) {//监听触发事件
                        String eingabe = e.getActionCommand(); //Eingabe
                        if(eingabe.equals("=")){
                            opration();
                        }
                        else{
                            String str = "";
                            list.add(eingabe);
                            for (int k = 0; k < list.size(); k++) {
                                str += list.get(k);
                            }
                            text.setText(str);
                        }
                    }
                });
                frame.getContentPane().add(button);
                count ++;
            }
        }

        frame.setVisible(true); //Zeigen
    }

    public static void opration(){
        for (int k = 0; k < list.size(); k++) {
            if(list.get(k).equals("+")){
                analyse(k);
                text.setText(Double.toString(zahl1+zahl2));
                break;
            }
           if(list.get(k).equals("-")){
                analyse(k);
                text.setText(Double.toString(zahl1-zahl2));
                break;
            }
           if(list.get(k).equals("*")){
                analyse(k);
                text.setText(Double.toString(zahl1*zahl2));
                break;
            }
           if(list.get(k).equals("/")){
                analyse(k);
                text.setText(Double.toString(zahl1/zahl2));
                break;
            }
        }
        //Initialisierung
        list.clear();
        s1="";
        s2="";
        zahl1 = 0.0;
        zahl2 = 0.0;
    }

    public static void analyse(int k){
        for (int i = 0; i < k; i++) {//11+22=33
            s1 += list.get(i); //11
        }
        if(s1.equals("")){
            zahl1 = 0.0;
        }
        else{
            zahl1 = Double.parseDouble(s1);
        }

        for (int i = k+1; i < list.size(); i++) {
            s2 += list.get(i);//12
        }
        if(s2.equals("")){
            zahl2 = 0.0;
        }
        else{
            zahl2 = Double.parseDouble(s2);
        }
    }
}







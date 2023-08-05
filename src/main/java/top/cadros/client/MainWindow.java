package top.cadros.client;

import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame{
    JFrame frame;

    public MainWindow(){
        super("助翔助手");
        this.setLayout(new CardLayout());
        this.setSize(750,463);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void startup(){
        LoginPanel loginPanel=new LoginPanel();
        this.add(loginPanel);
        this.setVisible(true);
    }
}
package top.cadros.client;

import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame{
    LoginPanel loginPanel;

    public MainWindow(){
        super("助翔助手");
        this.setLayout(new CardLayout());
        this.setSize(750,463);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.startup();
    }

    private void startup(){
        loginPanel=new LoginPanel();
        this.add(loginPanel);
        this.setVisible(true);
        for(;;){
            try{
                Client.connect();
                break;
            }catch(Exception e){
                if(JOptionPane.showOptionDialog(null,"连接到服务器时出错",
                "错误",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE,null,
                new String[]{"重试","退出"},"重试")==JOptionPane.YES_OPTION){
                    continue;
                }else{
                    this.dispose();
                    break;
                }
            }
        }
    }
}
package top.cadros.client;

import javax.swing.*;
import top.cadros.object.*;
import java.awt.*;

public class LoginPanel extends JPanel{
    public LoginPanel(){
        this.setLayout(null);

        //欢迎信息
        JLabel welcomeMessage=new JLabel("欢迎使用助翔助手");
        welcomeMessage.setFont(new Font("新宋体",Font.PLAIN,30));
        welcomeMessage.setBounds(50,170,400,50);

        //学号输入提示
        JLabel studentIDLabel=new JLabel("学号:");
        studentIDLabel.setFont(new Font("新宋体",Font.PLAIN,15));
        studentIDLabel.setBounds(400,150,50,50);

        //学号输入框
        JTextField studentIDField=new JTextField();
        studentIDField.setBounds(450,163,200,25);

        //密码输入提示
        JLabel passwordLabel=new JLabel("密码:");
        passwordLabel.setFont(new Font("新宋体",Font.PLAIN,15));
        passwordLabel.setBounds(400,200,50,50);

        //密码输入框
        JPasswordField passwordField=new JPasswordField();
        passwordField.setBounds(450,213,200,25);

        //登录按钮
        JButton loginButton=new JButton("登录");
        loginButton.setBounds(450,300,75,25);

        this.add(welcomeMessage);
        this.add(studentIDLabel);
        this.add(studentIDField);
        this.add(passwordLabel);
        this.add(passwordField);
        this.add(loginButton);

        loginButton.addActionListener(e ->{
            if(studentIDField.getText().length()!=13)
                JOptionPane.showMessageDialog(null,"学号长度不正确","错误",JOptionPane.ERROR_MESSAGE);
            else if(passwordField.getPassword().length<8)
                JOptionPane.showMessageDialog(null,"密码长度不正确","错误",JOptionPane.ERROR_MESSAGE);
            else{
                try{
                    Response response=Client.sendRequest(new Request(Request.LOGIN,new User(studentIDField.getText(),String.valueOf(passwordField.getPassword()))));
                    if(response.hasSucceed()){
                        JOptionPane.showMessageDialog(null,"登录成功","成功",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        throw (Exception)response.getData();
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
                }
                studentIDField.setText(null);
                passwordField.setText(null);
            }
        });
    }
}

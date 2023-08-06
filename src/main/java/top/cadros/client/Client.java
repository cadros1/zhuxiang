package top.cadros.client;

import java.io.*;
import java.net.*;
import top.cadros.object.*;

/**
 * 此类用于与服务端通信，包含了建立通信的功能和发送请求的接口
 * 
 * @author Cadros
 */
public class Client {
    private static Socket sock;
    private static ObjectOutputStream oos;
    private static ObjectInputStream ois;
    private static boolean connect=false;

    public static void connect()throws Exception{
        sock=new Socket("localhost",6666);
        oos=new ObjectOutputStream(sock.getOutputStream());
        ois=new ObjectInputStream(sock.getInputStream());
        connect=true;
    }

    public static void disconnect()throws Exception{
        if(connect)
            return;
        oos.close();
        ois.close();
        sock.close();
        connect=false;
    }

    public static Response sendRequest(Request request)throws Exception{
        oos.writeObject(request);
        oos.flush();
        return (Response)ois.readObject();
    }
}

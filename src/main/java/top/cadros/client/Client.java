package top.cadros.client;

import java.io.*;
import java.net.*;
import top.cadros.object.*;

public class Client {
    private static Socket sock;
    private static ObjectOutputStream oos;
    private static ObjectInputStream ois;

    public static void connect()throws Exception{
        sock=new Socket("localhost",6666);
        oos=new ObjectOutputStream(sock.getOutputStream());
        ois=new ObjectInputStream(sock.getInputStream());
    }

    public static void disconnect()throws Exception{
        oos.close();
        ois.close();
        sock.close();
    }

    public static Response sendRequest(Request request)throws Exception{
        oos.writeObject(request);
        oos.flush();
        return (Response)ois.readObject();
    }
}

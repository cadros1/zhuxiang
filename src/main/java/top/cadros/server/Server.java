package top.cadros.server;

import java.io.*;
import java.net.*;
import top.cadros.object.*;

public class Server {
    public static void main(String[] args)throws Exception{
        ServerSocket ss=new ServerSocket(6666);
        System.out.println("服务器已启动，端口号：6666\n等待客户端连接...\n");
        for(;;){
            Socket sock=ss.accept();
            System.out.println("客户端"+sock.getInetAddress()+"已连接\n");
            new Handler(sock).start();
        }
    }
}

class Handler extends Thread{
    Socket sock;

    public Handler(Socket sock){
        this.sock=sock;
    }

    @Override
    public void run(){
        try(ObjectInputStream ois=new ObjectInputStream(sock.getInputStream())){
            try(ObjectOutputStream oos=new ObjectOutputStream(sock.getOutputStream())){
                for(;;){
                    oos.writeObject(handle((Request)ois.readObject()));
                    oos.flush();
                }
            }
        }catch(Exception e){
            try{
                this.sock.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
            System.out.println("客户端"+sock.getInetAddress()+"已断开\n");
        }
    }
    
    public Response handle(Request request)throws Exception{
        switch(request.getType()){
            case 0:
                return new Response(true,null);
        }
        return null;
    }
}

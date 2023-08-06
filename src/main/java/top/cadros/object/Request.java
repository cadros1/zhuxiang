package top.cadros.object;

/**
 * 此类封装了客户端发送的请求。所有请求都将被封装为Resquest实例后发送给服务端
 * 
 * @author Cadros
 * 
 * @param type 请求类型
 * @param data 请求包含的数据
 */
public class Request implements java.io.Serializable{
    private int type;
    private Object data;

    public final static int LOGIN=0;

    public Request(int type,Object data){
        this.type=type;
        this.data=data;
    }

    public int getType(){
        return type;
    }

    public Object getData(){
        return data;
    }
}

package top.cadros.object;


/**
 * 此类封装了服务端返回的响应。所有响应都将被封装为Response实例后发送给客户端
 * 
 * @author Cadros
 * 
 * @param success 表示响应是否成功
 * @param data 响应包含的数据
 */
public class Response implements java.io.Serializable{
    private boolean success;
    private Object data;

    public Response(boolean success,Object data){
        this.success=success;
        this.data=data;
    }

    public boolean hasSucceed(){
        return success;
    }

    public Object getData(){
        return data;
    }
}

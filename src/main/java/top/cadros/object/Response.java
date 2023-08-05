package top.cadros.object;

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

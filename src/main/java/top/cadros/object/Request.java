package top.cadros.object;

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

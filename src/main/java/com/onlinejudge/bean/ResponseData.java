package com.onlinejudge.bean;

public class ResponeData<T>{
    private int code;
    public boolean isSucess;
    private String msg;
    private T data;

    public ResponeData(int code, String msg, T data,boolean isSucess) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.isSucess=isSucess;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public static ResponeData Success(int msgCode){
        return new ResponeData(msgCode,null,null,true);
    }
    public static ResponeData Success(int msgCode,Object data){
        return new ResponeData(msgCode,null,data,true);
    }
    public static  ResponeData Error(int msgCode){
        return new ResponeData(msgCode,null,null,false);
    }
    public static  ResponeData Error(String msg){
        return new ResponeData(-1,msg,null,false);
    }
}

package com.onlinejudge.bean;

public class ResponseData<T>{
    private int code;
    public boolean isSucess;
    private String msg;
    private T data;

    public ResponseData(int code, String msg, T data, boolean isSucess) {
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
    public static ResponseData Success(int msgCode){
        return new ResponseData(msgCode,null,null,true);
    }
    public static ResponseData Success(int msgCode, Object data){
        return new ResponseData(msgCode,null,data,true);
    }
    public static ResponseData Error(int msgCode){
        return new ResponseData(msgCode,null,null,false);
    }
    public static ResponseData Error(String msg){
        return new ResponseData(-1,msg,null,false);
    }
}

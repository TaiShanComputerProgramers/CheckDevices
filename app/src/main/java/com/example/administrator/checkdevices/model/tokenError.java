package com.example.administrator.checkdevices.model;

/**
 * Created by Administrator on 2018/3/19.
 */

public class tokenError {
    private int code;
    private String login;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

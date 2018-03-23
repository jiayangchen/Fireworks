package me.chenjiayang.utils;

/**
 * create by chenjiayang on 2018/3/23
 */
public enum Constant {
    SUCCESS("OK", 200), SERVER_ERROR("SERVER_ERROR", 500);
    private String name;
    private int statusCode;

    Constant(String name, int statusCode) {
        this.name = name;
        this.statusCode = statusCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}

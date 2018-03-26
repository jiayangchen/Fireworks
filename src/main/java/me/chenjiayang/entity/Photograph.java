package me.chenjiayang.entity;

import java.sql.Timestamp;

/**
 * create by chenjiayang on 2018/3/26
 */
public class Photograph {
    private String src;
    private String desc;
    private String filmDateAndPlace;
    private Timestamp createTime;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFilmDateAndPlace() {
        return filmDateAndPlace;
    }

    public void setFilmDateAndPlace(String filmDateAndPlace) {
        this.filmDateAndPlace = filmDateAndPlace;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}

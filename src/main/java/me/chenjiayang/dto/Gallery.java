package me.chenjiayang.dto;

import me.chenjiayang.entity.Photograph;

import java.util.List;

/**
 * create by chenjiayang on 2018/3/26
 */
public class Gallery {
    List<Photograph> gallery;

    public List<Photograph> getGallery() {
        return gallery;
    }

    public void setGallery(List<Photograph> gallery) {
        this.gallery = gallery;
    }
}

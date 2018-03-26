package me.chenjiayang.dao;

import me.chenjiayang.entity.Photograph;

import java.util.List;

/**
 * create by chenjiayang on 2018/3/26
 */
public interface GalleryDao {
    void insert(Photograph photograph);
    List<Photograph> getGallery();
}

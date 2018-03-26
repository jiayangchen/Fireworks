package me.chenjiayang.service;

import me.chenjiayang.dto.Gallery;
import me.chenjiayang.entity.Photograph;

import java.util.List;

/**
 * create by chenjiayang on 2018/3/26
 */
public interface GalleryService {
    void addPhotograph(Photograph photograph);
    void addGallery(List<Photograph> gallery);
    Gallery findGallery();
}

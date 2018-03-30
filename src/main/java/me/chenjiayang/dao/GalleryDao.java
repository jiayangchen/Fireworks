package me.chenjiayang.dao;

import me.chenjiayang.entity.Photograph;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * create by chenjiayang on 2018/3/26
 */

@Component
public interface GalleryDao {
    void insert(Photograph photograph);
    List<Photograph> getGallery();
}

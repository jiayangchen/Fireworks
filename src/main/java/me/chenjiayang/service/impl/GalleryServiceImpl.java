package me.chenjiayang.service.impl;

import me.chenjiayang.dao.GalleryDao;
import me.chenjiayang.dto.Gallery;
import me.chenjiayang.entity.Photograph;
import me.chenjiayang.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * create by chenjiayang on 2018/3/26
 */

@Service
public class GalleryServiceImpl implements GalleryService {

    @Autowired
    private GalleryDao galleryDao;

    @Override
    public Gallery findGallery() {
        List<Photograph> photographList = galleryDao.getGallery();
        Gallery gallery = new Gallery();
        gallery.setGallery(photographList);
        return gallery;
    }

    @Override
    public void addGallery(List<Photograph> gallery) {
        for(Photograph photograph : gallery) {
            photograph.setCreateTime(new Timestamp(new Date().getTime()));
            galleryDao.insert(photograph);
        }
    }

    @Override
    public void addPhotograph(Photograph photograph) {
        galleryDao.insert(photograph);
    }
}

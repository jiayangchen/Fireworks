package me.chenjiayang.service.impl;

import me.chenjiayang.dao.BlogDao;
import me.chenjiayang.dto.Archive;
import me.chenjiayang.entity.Blog;
import me.chenjiayang.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * create by chenjiayang on 2018/3/20
 */

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Override
    public List<Blog> findAll() {
        return blogDao.getAll();
    }

    @Override
    public void addBlog(Blog blog) {
        blogDao.insert(blog);
    }

    @Override
    public void updateBlog(Blog blog) {
        blogDao.update(blog);
    }

    @Override
    public List<Blog> listBlogTitle(int page, int capacity) {
        return blogDao.getAllDescByPage(page, capacity);
    }

    @Override
    public Blog findBlogByName(String blogName) {
        return blogDao.getBlogByName(blogName);
    }

    @Override
    public Set<Archive> findArchives() {
        Map<String, Integer> dateStr2Count = new HashMap<>();
        List<Blog> blogList = blogDao.getAll();
        Set<Archive> result = new TreeSet<>(new Comparator<Archive>() {
            @Override
            public int compare(Archive o1, Archive o2) {
                return o2.getDate().compareTo(o1.getDate());
            }
        });
        for(Blog blog : blogList) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            String date = sdf.format(new Date(blog.getCreateTime().getTime()));
            if(!dateStr2Count.containsKey(date)) {
                dateStr2Count.put(date, 1);
            } else {
                dateStr2Count.put(date, dateStr2Count.get(date) + 1);
            }
        }

        Set<String> dateList = dateStr2Count.keySet();
        for(String key : dateList) {
            Archive archive = new Archive();
            archive.setDate(key);
            archive.setNumber(dateStr2Count.get(key));
            result.add(archive);
        }
        return result;
    }

    @Override
    public List<Blog> listBlogTitleByDate(String month, int page) throws ParseException {
        String startDate = month + "-01 00:00:00";
        String endDate = month + "-31 23:59:59";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
        Timestamp startTime = new Timestamp(sdf.parse(startDate).getTime());
        Timestamp endTime = new Timestamp(sdf.parse(endDate).getTime());
        return blogDao.getBlogByDate(startTime, endTime, page);
    }
}

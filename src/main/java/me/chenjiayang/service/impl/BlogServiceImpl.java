package me.chenjiayang.service.impl;

import me.chenjiayang.dao.BlogDao;
import me.chenjiayang.entity.Blog;
import me.chenjiayang.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
    public List<Blog> listBlogTitle(int page) {
        return blogDao.getAllDescByPage(page);
    }

    @Override
    public Blog findBlogByName(String blogName) {
        return blogDao.getBlogByName(blogName);
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

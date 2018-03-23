package me.chenjiayang.service.impl;

import me.chenjiayang.dao.BlogDao;
import me.chenjiayang.entity.Blog;
import me.chenjiayang.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<Blog> blogList = blogDao.getAllDescByPage(page);
        return blogList;
    }
}

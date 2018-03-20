package me.chenjiayang.service.impl;

import me.chenjiayang.dao.BlogDao;
import me.chenjiayang.entity.Blog;
import me.chenjiayang.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

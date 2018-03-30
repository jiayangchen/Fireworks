package me.chenjiayang.service;

import me.chenjiayang.dto.Archive;
import me.chenjiayang.entity.Blog;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;
import java.util.Set;

/**
 * create by chenjiayang on 2018/3/20
 */
public interface BlogService {
    List<Blog> findAll();
    void addBlog(Blog blog);
    void updateBlog(Blog blog);
    List<Blog> listBlogTitle(int page, int capacity);
    List<Blog> listBlogTitleByDate(String month, int page) throws ParseException;
    Blog findBlogByName(String blogName);
    Set<Archive> findArchives();
}

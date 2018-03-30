package me.chenjiayang.dao;

import me.chenjiayang.entity.Blog;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

/**
 * create by chenjiayang on 2018/3/20
 */

@Component
public interface BlogDao {
    List<Blog> getAll();
    List<Blog> getAllDescByPage(int page);
    List<Blog> getBlogByDate(Timestamp startDate, Timestamp endDate, int page);
    void insert(Blog blog);
    void update(Blog blog);
    Blog getBlogByName(String blogName);
}

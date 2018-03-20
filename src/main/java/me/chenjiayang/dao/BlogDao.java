package me.chenjiayang.dao;

import me.chenjiayang.entity.Blog;

import java.util.List;

/**
 * create by chenjiayang on 2018/3/20
 */
public interface BlogDao {
    List<Blog> getAll();
}

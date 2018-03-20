package me.chenjiayang.service;

import me.chenjiayang.entity.Blog;

import java.util.List;

/**
 * create by chenjiayang on 2018/3/20
 */
public interface BlogService {
    List<Blog> findAll();
}

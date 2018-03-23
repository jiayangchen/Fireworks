package me.chenjiayang.service;

import me.chenjiayang.entity.Activity;

import java.util.List;

/**
 * create by chenjiayang on 2018/3/22
 */
public interface ActivityService {
    void addActivity (Activity activity);
    List<Activity> findActivitiesByPage(int page);
}

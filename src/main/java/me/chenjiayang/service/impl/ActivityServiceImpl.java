package me.chenjiayang.service.impl;

import me.chenjiayang.dao.ActivityDao;
import me.chenjiayang.entity.Activity;
import me.chenjiayang.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by chenjiayang on 2018/3/22
 */

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityDao activityDao;

    @Override
    public void addActivity(Activity activity) {
        activityDao.insert(activity);
    }

    @Override
    public List<Activity> findActivitiesByPage(int page, int capacity) {
        return activityDao.getActivityByPage(page, capacity);
    }

    @Override
    public List<Activity> findAll() {
        return activityDao.getAll();
    }
}

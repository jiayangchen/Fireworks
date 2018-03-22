package me.chenjiayang.service.impl;

import me.chenjiayang.dao.ActivityDao;
import me.chenjiayang.entity.Activity;
import me.chenjiayang.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

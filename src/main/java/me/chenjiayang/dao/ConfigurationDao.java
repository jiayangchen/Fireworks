package me.chenjiayang.dao;

import me.chenjiayang.entity.Configuration;
import org.springframework.stereotype.Component;

/**
 * create by chenjiayang on 2018/3/30
 */

@Component
public interface ConfigurationDao {
    void update(Configuration configuration);
    Configuration getConfiguration();
}

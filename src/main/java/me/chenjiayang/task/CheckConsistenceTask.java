package me.chenjiayang.task;

import me.chenjiayang.entity.Blog;
import me.chenjiayang.service.BlogService;
import me.chenjiayang.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

/**
 * create by chenjiayang on 2018/3/23
 */

@Component
public class CheckConsistenceTask {

    private Logger logger = Logger.getLogger("CheckConsistenceTask");

    @Autowired
    private BlogService blogService;

    //*/5 * * * * ?
    //0 30 6 * * *
    @Scheduled(cron = "*/10 * * * * ?")
    public void checkdb2mdConsistence() {
        check();
    }

    private void check() {
        boolean isConsistence = true;
        List<Blog> blogList = blogService.findAll();
        Set<String> fileNameList = FileUtils.traverseFolder();
        HashMap<String, Boolean> isDBExist = new HashMap<>();
        HashMap<String, Boolean> isMDExist = new HashMap<>();
        for(Blog blog : blogList) {
            isDBExist.put(blog.getBlogName(), true);
        }
        for(String fileName : fileNameList) {
            isMDExist.put(fileName, true);
        }
        for(String fileName : fileNameList) {
            if(!isDBExist.containsKey(fileName)) {
                isConsistence = false;
                logger.info("[注意] 博文 [" + fileName + "] md文件夹下存在但数据库中不存在");
            }
        }
        for(Blog blog : blogList) {
            if(!isMDExist.containsKey(blog.getBlogName())) {
                isConsistence = false;
                logger.info("[注意] 博文 [" + blog.getBlogName() + "] 数据库中存在但MD文件夹下不存在");
            }
        }
        if(isConsistence) {
            logger.info("[注意] 博文一致性检测完成");
        }
    }
}

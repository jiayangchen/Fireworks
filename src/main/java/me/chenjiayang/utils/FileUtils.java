package me.chenjiayang.utils;

import me.chenjiayang.entity.Blog;
import me.chenjiayang.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.*;

/**
 * create by chenjiayang on 2018/3/23
 */
public class FileUtils {

    //private static final String path = "/data/tomcat/apache-tomcat-8.0.50/webapps/fireworks-web-1.0-SNAPSHOT/assets/md";
    private static final String path = "/Users/chenjiayang/Documents/jiayangchen/fireworks/src/main/webapp/assets/md";

    public static String buildCompleteBlogName(String blogName) {
        return blogName + ".md";
    }

    public static Set<String> traverseFolder() {
        Set<String> fileNameList = new HashSet<>();
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if(files != null) {
                for (File file2 : files) {
                    fileNameList.add(file2.getName());
                }
            }
        }
        return fileNameList;
    }
}

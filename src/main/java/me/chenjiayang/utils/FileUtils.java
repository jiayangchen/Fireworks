package me.chenjiayang.utils;

import me.chenjiayang.entity.Blog;
import me.chenjiayang.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.LinkedList;

/**
 * create by chenjiayang on 2018/3/23
 */
public class FileUtils {

    private static final String path = "/Users/chenjiayang/Documents/blog/jiayangchen.github.io/_posts";

    @Autowired
    private BlogService blogService;

    public void traverseFolder() {
        int fileNum = 0, folderNum = 0;
        File file = new File(path);
        if (file.exists()) {
            LinkedList<File> list = new LinkedList<>();
            File[] files = file.listFiles();
            for (File file2 : files) {
                Blog blog = new Blog();
                blog.setBlogContent("");
                blog.setBlogTag("");
                blog.setBlogTitle(file2.getName());
                blog.setCreateTime(getCreateTime(file2.getName()));
                blogService.addBlog(blog);
                folderNum++;
            }
        } else {
            System.out.println("文件不存在!");
        }
        System.out.println("文件夹共有:" + folderNum + ",文件共有:" + fileNum);
    }

    private String getCreateTime (String fileName) {
        String[] item = fileName.split("-");
        return item[0] + "-" + item[1] + "-" + item[2];
    }
}

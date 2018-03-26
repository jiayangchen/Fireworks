package me.chenjiayang.utils;

/**
 * create by chenjiayang on 2018/3/26
 */
public class StringUtils {
    public static boolean isEmpty(String input) {
        return input == null || input.isEmpty() || input.equals("");
    }
}

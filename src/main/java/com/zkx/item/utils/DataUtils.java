package com.zkx.item.utils;

import java.util.Random;

/**
 * 参数工具类
 */
public class DataUtils {

    /**
     * @param digit 位数
     * @return 随机生成digit位数的数字
     */
    public static long getNum(int digit) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < digit; i++) {
            if (i == 0 && digit > 1)
                str.append(new Random().nextInt(9) + 1);
            else
                str.append(new Random().nextInt(10));
        }
        return Long.valueOf(str.toString());
    }
}

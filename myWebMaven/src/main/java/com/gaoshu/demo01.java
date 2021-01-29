package com.gaoshu;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.convert.Converter;
import cn.hutool.core.util.StrUtil;
import com.sun.deploy.util.StringUtils;

/**
 * @author ：MJ
 * @ClassName ：demo01
 * @date ：Created in 2021/1/27 12:01
 * @description：新类
 * @version: 01$
 */
public class demo01 {
    public static void main(String[] args) {
        Object defaultLanguageCode = null;
        if (BeanUtil.isEmpty(defaultLanguageCode)) {
            System.out.println(123);
        }
        String cc = null;
        if (StrUtil.isEmpty(cc)) {
            cc = "zh-CN";
        }

//        if (!StrUtil.isEmpty(a.toString())) {
//            System.out.println(1);
//        }else {
//            System.out.println(2);
//        }
        System.out.println("cc:"+cc);
    }
}

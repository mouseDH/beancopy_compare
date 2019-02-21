package com.exmaple;

import org.springframework.beans.BeanUtils;

/**
 * spring framework copy bean.
 *
 * @author yzq
 * @date 2018/01/16
 */
public class SpringBeanCopy implements BeanCopyFacade<SourceBean, TargetBean> {

    public void copyBean(SourceBean sourceBean, TargetBean targetBean) throws Exception {
        long start = System.nanoTime();
        BeanUtils.copyProperties(sourceBean, targetBean);
        long end = System.nanoTime();

//        System.out.println(String.format("%s consume %d microsecond", "spring copyProperties", (end - start) / 1000));
    }
}

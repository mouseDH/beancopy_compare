package com.exmaple;

import org.apache.commons.beanutils.BeanUtils;

/**
 * apache copyProperties.
 *
 * @author yzq
 * @date 2018/01/16
 */
public class ApacheBeanCopy implements BeanCopyFacade<SourceBean, TargetBean> {

    public void copyBean(SourceBean sourceBean, TargetBean targetBean) throws Exception {
        long start = System.nanoTime();
        BeanUtils.copyProperties(targetBean, sourceBean);
        long end = System.nanoTime();

//        System.out.println(String.format("%s consume %d microsecond", "apache  copy property", (end - start) / 1000));
    }
}

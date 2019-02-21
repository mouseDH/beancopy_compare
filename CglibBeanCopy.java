package com.exmaple;

import net.sf.cglib.beans.BeanCopier;

/**
 * cglib BeanCopier copy.
 *
 * @author yzq
 * @date 2018/01/16
 */
public class CglibBeanCopy implements BeanCopyFacade<SourceBean, TargetBean> {

    private BeanCopier beanCopier = BeanCopier.create(SourceBean.class, TargetBean.class, false);

    public void copyBean(SourceBean sourceBean, TargetBean targetBean) throws Exception {
        long start = System.nanoTime();
        beanCopier.copy(sourceBean, targetBean, null);
        long end = System.nanoTime();

//        System.out.println(String.format("%s consume %d microsecond", "cglib BeanCopier", (end - start) / 1000));
    }
}

package com.exmaple;


import com.github.dozermapper.core.DozerBeanMapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

/**
 * apache copyProperties.
 *
 * @author yzq
 * @date 2018/01/16
 */
public class DozerCopy implements BeanCopyFacade<SourceBean, TargetBean> {

    private static final Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public void copyBean(SourceBean sourceBean, TargetBean targetBean) throws Exception {

        mapper.map(sourceBean,targetBean);
//        System.out.println(String.format("%s consume %d microsecond", "apache  copy property", (end - start) / 1000));
    }
}

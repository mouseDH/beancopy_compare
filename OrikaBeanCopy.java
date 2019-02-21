package com.exmaple;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class OrikaBeanCopy implements BeanCopyFacade<SourceBean,TargetBean> {
    private static final MapperFacade mapper;
    private static final BoundMapperFacade<SourceBean, TargetBean> boundmapper;
    static {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapper = mapperFactory.getMapperFacade();
        boundmapper = mapperFactory.getMapperFacade(SourceBean.class,TargetBean.class);
    }
    public void copyBean(SourceBean sourceBean, TargetBean targetBean) throws Exception {
        long start = System.nanoTime();
        mapper.map(sourceBean,targetBean);
        long end = System.nanoTime();

//        System.out.println(String.format("%s consume %d microsecond", "orika copy property", (end - start) / 1000));
    }
}

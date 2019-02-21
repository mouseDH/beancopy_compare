package com.exmaple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BeanCopy {
    //apache,cglib,spring bean copy,orika
    private static BeanCopyFacade apacheBeanCopy;
    private static BeanCopyFacade cglibBeanCopy;
    private static BeanCopyFacade springBeanCopy;
    private static BeanCopyFacade javaBeanCopy;
    private static BeanCopyFacade orikaBeanCopy;
    private static DozerCopy dozerCopy;

    static {
        apacheBeanCopy = new ApacheBeanCopy();
        cglibBeanCopy = new CglibBeanCopy();
        springBeanCopy = new SpringBeanCopy();
        javaBeanCopy = new JavaBeanCopy();
        orikaBeanCopy = new OrikaBeanCopy();
        dozerCopy = new DozerCopy();
    }

    public static void main(String[] args) throws Exception {
        final Integer loopCount = 1500000;

        SourceBean sourceBean = new SourceBean();
        sourceBean.setId(1);
        sourceBean.setName("yzq");
        sourceBean.setResult(Boolean.TRUE);
        sourceBean.setContent("bean copy test.");

        TargetBean targetBean = new TargetBean();

//        multiThread(loopCount, sourceBean, targetBean);

        singleThreadTest(loopCount, sourceBean, targetBean);
    }

    private static void multiThread(Integer loopCount, final SourceBean sourceBean, final TargetBean targetBean) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < loopCount; i++) {
            executorService.submit(new Runnable() {
                public void run() {
                    try {
                        apacheBeanCopy.copyBean(sourceBean, targetBean);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private static void singleThreadTest(Integer loopCount, SourceBean sourceBean, TargetBean targetBean)
            throws Exception {

        System.out.println("---------------- apache ----------------------");
        long start = System.nanoTime();
        for (int i = 0; i < loopCount; i++) {

            apacheBeanCopy.copyBean(sourceBean, targetBean);
        }
        long end = System.nanoTime();
        System.out.println(String.format("%s consume %d microsecond", "apache  copy property", (end - start) / 1000 / 1000));

        System.out.println("---------------- cglib ----------------------");
        start = System.nanoTime();
        for (int i = 0; i < loopCount; i++) {
            cglibBeanCopy.copyBean(sourceBean, targetBean);
        }
        end = System.nanoTime();
        System.out.println(String.format("%s consume %d microsecond", "cglib  copy property", (end - start) / 1000 / 1000));

        System.out.println("----------------- spring ---------------------");
        start = System.nanoTime();
        for (int i = 0; i < loopCount; i++) {
            springBeanCopy.copyBean(sourceBean, targetBean);
        }
        end = System.nanoTime();
        System.out.println(String.format("%s consume %d microsecond", "spring  copy property", (end - start) / 1000 / 1000));

        System.out.println("----------------- setter ---------------------");
        start = System.nanoTime();
        for (int i = 0; i < loopCount; i++) {
            javaBeanCopy.copyBean(sourceBean, targetBean);
        }
        end = System.nanoTime();
        System.out.println(String.format("%s consume %d microsecond", "setter  copy property", (end - start) / 1000 / 1000));
        System.out.println("----------------- orika ---------------------");

        start = System.nanoTime();
        for (int i = 0; i < loopCount; i++) {
            orikaBeanCopy.copyBean(sourceBean, targetBean);
        }
        end = System.nanoTime();
        System.out.println(String.format("%s consume %d microsecond", "orika  copy property", (end - start) / 1000 / 1000));

        System.out.println("----------------- dozer ---------------------");

        start = System.nanoTime();
        for (int i = 0; i < loopCount; i++) {
            dozerCopy.copyBean(sourceBean, targetBean);
        }
        end = System.nanoTime();
        System.out.println(String.format("%s consume %d microsecond", "dozerCopy  copy property", (end - start) / 1000 / 1000));
    }
}

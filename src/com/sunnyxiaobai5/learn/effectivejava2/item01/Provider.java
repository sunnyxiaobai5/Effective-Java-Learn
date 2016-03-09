package com.sunnyxiaobai5.learn.effectivejava2.item01;

/**
 * Service provider interface（服务提供者接口）
 */
public interface Provider {

    /**
     * 获取服务接口实例
     *
     * @return Service
     */
    Service newService();
}

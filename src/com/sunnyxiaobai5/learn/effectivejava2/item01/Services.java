package com.sunnyxiaobai5.learn.effectivejava2.item01;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Noninstantiable class for service registration and access（用于服务注册和服务访问的不可实例化类）
 */
public class Services {

    private Services() {
    }

    private static final Map<String, Provider> providers = new ConcurrentHashMap<>();

    /**
     * 默认注册的Provider名称
     */
    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    /**
     * Provider registration API（提供者注册API）<br>
     * 注册默认的 Provider
     *
     * @param provider Provider
     */
    public static void registerDefaultProvider(Provider provider) {
        registerProvider(DEFAULT_PROVIDER_NAME, provider);
    }

    /**
     * Provider registration API（提供者注册API）<br>
     * 注册 Provider
     *
     * @param name     Provider注册名
     * @param provider Provider
     */
    public static void registerProvider(String name, Provider provider) {
        providers.put(name, provider);
    }

    /**
     * Service access API（服务访问API）<br>
     * 获取 Service
     *
     * @return Service
     */
    public static Service newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }


    /**
     * Service access API（服务访问API）<br>
     * 获取Service
     *
     * @param name 要通过名称为name的Provider获取Service
     * @return Service
     */
    public static Service newInstance(String name) {
        Provider provider = providers.get(name);
        if (null == provider)
            throw new IllegalArgumentException("No provider registered with name" + name);
        return provider.newService();
    }
}

package com.sunnyxiaobai5.learn.effectivejava2.item01;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Noninstantiable class for service registration and access�����ڷ���ע��ͷ�����ʵĲ���ʵ�����ࣩ
 */
public class Services {

    private Services() {
    }

    private static final Map<String, Provider> providers = new ConcurrentHashMap<>();

    /**
     * Ĭ��ע���Provider����
     */
    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    /**
     * Provider registration API���ṩ��ע��API��<br>
     * ע��Ĭ�ϵ� Provider
     *
     * @param provider Provider
     */
    public static void registerDefaultProvider(Provider provider) {
        registerProvider(DEFAULT_PROVIDER_NAME, provider);
    }

    /**
     * Provider registration API���ṩ��ע��API��<br>
     * ע�� Provider
     *
     * @param name     Providerע����
     * @param provider Provider
     */
    public static void registerProvider(String name, Provider provider) {
        providers.put(name, provider);
    }

    /**
     * Service access API���������API��<br>
     * ��ȡ Service
     *
     * @return Service
     */
    public static Service newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }


    /**
     * Service access API���������API��<br>
     * ��ȡService
     *
     * @param name Ҫͨ������Ϊname��Provider��ȡService
     * @return Service
     */
    public static Service newInstance(String name) {
        Provider provider = providers.get(name);
        if (null == provider)
            throw new IllegalArgumentException("No provider registered with name" + name);
        return provider.newService();
    }
}

package com.sunnyxiaobai5.learn.effectivejava2.item01;

/**
 * Service provider interface�������ṩ�߽ӿڣ�
 */
public interface Provider {

    /**
     * ��ȡ����ӿ�ʵ��
     *
     * @return Service
     */
    Service newService();
}

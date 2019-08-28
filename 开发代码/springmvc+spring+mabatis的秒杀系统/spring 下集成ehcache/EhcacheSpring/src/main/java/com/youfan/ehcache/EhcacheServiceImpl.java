package com.youfan.ehcache;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;



@Service
public class EhcacheServiceImpl implements EhcacheService{

    // value��ֵ��ehcache.xml�е����ñ���һ��
    @Cacheable(value="HelloWorldCache", key="#param")
    @Override
    public String getTimestamp(String param) {
        Long timestamp = System.currentTimeMillis();
        return timestamp.toString();
    }

    @Cacheable(value="HelloWorldCache", key="#key")
    @Override
    public String getDataFromDB(String key) {
        System.out.println("�����ݿ��л�ȡ����...");
        return key + ":" + String.valueOf(Math.round(Math.random()*1000000));
    }

    @CacheEvict(value="HelloWorldCache", key="#key")
    @Override
    public void removeDataAtDB(String key) {
        System.out.println("�����ݿ���ɾ������");
    }

    @CachePut(value="HelloWorldCache", key="#key")
    @Override
    public String refreshData(String key) {
        System.out.println("ģ������ݿ��м�������");
        return key + "::" + String.valueOf(Math.round(Math.random()*1000000));
    }

    // ------------------------------------------------------------------------
    @Cacheable(value="UserCache", key="'user:' + #userId")    
    public User findById(String userId) {  
        System.out.println("ģ������ݿ��в�ѯ����");
        return new User(1, "mengdee");           
    }  

    @Cacheable(value="UserCache", condition="#userId.length()<12")    
    public boolean isReserved(String userId) {    
        System.out.println("UserCache:"+userId);    
        return false;    
    }

    //�����UserCache��ĳ��ָ��key�Ļ���    
    @CacheEvict(value="UserCache",key="'user:' + #userId")    
    public void removeUser(String userId) {    
        System.out.println("UserCache remove:"+ userId);    
    }    

    //�����UserCache��ȫ���Ļ���    
    @CacheEvict(value="UserCache", allEntries=true)    
    public void removeAllUser() {    
       System.out.println("UserCache delete all");    
    }
}

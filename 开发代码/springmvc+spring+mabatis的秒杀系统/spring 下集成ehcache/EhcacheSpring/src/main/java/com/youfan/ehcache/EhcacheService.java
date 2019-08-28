package com.youfan.ehcache;
public interface EhcacheService {

    // ����ʧЧ�������Ч��Ϊ5��
    public String getTimestamp(String param);

    public String getDataFromDB(String key);

    public void removeDataAtDB(String key);

    public String refreshData(String key);


    public User findById(String userId);

    public boolean isReserved(String userId);

    public void removeUser(String userId);

    public void removeAllUser();
}

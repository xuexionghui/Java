package com.youfan.test;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.youfan.ehcache.EhcacheService;



public class EhcacheServiceTest extends SpringTestCase{

    @Autowired
    private EhcacheService ehcacheService;

    // ��Чʱ����5�룬��һ�κ͵ڶ��λ�ȡ��ֵ��һ���ģ����������5��֮�����Ի��ȡ�µ�ֵ
    @Test
    public void testTimestamp() throws InterruptedException{
        System.out.println("��һ�ε��ã�" + ehcacheService.getTimestamp("param"));
        Thread.sleep(2000);
        System.out.println("2��֮����ã�" + ehcacheService.getTimestamp("param"));
        Thread.sleep(4000);
        System.out.println("�ٹ�4��֮����ã�" + ehcacheService.getTimestamp("param"));
    }

    @Test
    public void testCache(){
        String key = "zhangsan";
        String value = ehcacheService.getDataFromDB(key); // �����ݿ��л�ȡ����...
        ehcacheService.getDataFromDB(key);  // �ӻ����л�ȡ���ݣ����Բ�ִ�и÷�����
        ehcacheService.removeDataAtDB(key); // �����ݿ���ɾ������
        ehcacheService.getDataFromDB(key);  // �����ݿ��л�ȡ����...����������ɾ���ˣ�����Ҫ���»�ȡ��ִ�з����壩
    }

    @Test
    public void testPut(){
        String key = "mengdee";
        ehcacheService.refreshData(key);  // ģ������ݿ��м�������
        String data = ehcacheService.getDataFromDB(key);
        System.out.println("data:" + data); // data:mengdee::103385

        ehcacheService.refreshData(key);  // ģ������ݿ��м�������
        String data2 = ehcacheService.getDataFromDB(key);
        System.out.println("data2:" + data2);   // data2:mengdee::180538    
    }


    @Test
    public void testFindById(){
        ehcacheService.findById("2"); // ģ������ݿ��в�ѯ����
        ehcacheService.findById("2");
    }

    @Test
    public void testIsReserved(){
        ehcacheService.isReserved("123");
        ehcacheService.isReserved("123");
    }

    @Test
    public void testRemoveUser(){
        // ����ӵ�����
        ehcacheService.findById("1");

        // ��ɾ��
        ehcacheService.removeUser("1");

        // ��������ڻ�ִ�з�����
        ehcacheService.findById("1");
    }

    @Test
    public void testRemoveAllUser(){
        ehcacheService.findById("1");
        ehcacheService.findById("2");

        ehcacheService.removeAllUser();

        ehcacheService.findById("1");
        ehcacheService.findById("2");

//      ģ������ݿ��в�ѯ����
//      ģ������ݿ��в�ѯ����
//      UserCache delete all
//      ģ������ݿ��в�ѯ����
//      ģ������ݿ��в�ѯ����
    }

}

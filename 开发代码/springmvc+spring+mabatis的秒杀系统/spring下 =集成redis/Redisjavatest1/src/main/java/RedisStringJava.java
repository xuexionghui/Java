import redis.clients.jedis.Jedis;
 
public class RedisStringJava {
    public static void main(String[] args) {
        //���ӱ��ص� Redis ����
        Jedis jedis = new Jedis("192.168.253.142");
        System.out.println("���ӳɹ�");
        //���� redis �ַ�������
        jedis.set("key1", "value1");
        // ��ȡ�洢�����ݲ����
        System.out.println("redis �洢���ַ���Ϊ: "+ jedis.get("key1"));
    }
}

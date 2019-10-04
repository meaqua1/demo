package jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import utils.JedisPoolUtils;

/**
 * @author hh
 * @create 2019-08-12 11:07
 */
public class JedisTest {
    @Test
    public void Test(){
        Jedis jedis = new Jedis("localhost",6379);
        jedis.set("username","张三");
        jedis.setex("checkCode",30,"9527");//将key value存入redis并且30s后删除
        jedis.close();
    }

    @Test
    public void Test2(){
        JedisPool jedisPool = new JedisPool();
        Jedis jedis = jedisPool.getResource();
        jedis.set("username","张三");
        jedis.close();
    }
    @Test
    public void Test3(){
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.set("username","张三");
        jedis.close();
    }
}

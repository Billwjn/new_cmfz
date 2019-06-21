package com.baizhi.cache;

import com.baizhi.util.SerializeUtils;
import com.baizhi.util.SpringContextUtil;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.locks.ReadWriteLock;

public class MybatisCache implements Cache {
    private String id;

    public MybatisCache(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        System.out.println("==========将结果放入缓存==========");
        StringRedisTemplate stringRedisTemplate = (StringRedisTemplate) SpringContextUtil.getBean(StringRedisTemplate.class);
        stringRedisTemplate.opsForHash().put(id,key.toString(), SerializeUtils.serialize(value));
    }

    @Override
    public Object getObject(Object key) {

        StringRedisTemplate stringRedisTemplate = (StringRedisTemplate) SpringContextUtil.getBean(StringRedisTemplate.class);
        //先判断当前查询在缓存中是否存在，如果存在，直接取，如果不存在，return null放行
        Boolean aBoolean = stringRedisTemplate.opsForHash().hasKey(id, key.toString());
        if (aBoolean){
            System.out.println("==========从缓存中取出数据==========");
            String o = (String) stringRedisTemplate.opsForHash().get(id, key.toString());
            Object o1 = SerializeUtils.serializeToObject(o);
            return o1;
        }
        return null;
    }

    @Override
    public Object removeObject(Object key) {
        return null;
    }

    @Override
    public void clear() {
        System.out.println("==========清除指定key下的缓存==========");
        StringRedisTemplate stringRedisTemplate = (StringRedisTemplate) SpringContextUtil.getBean(StringRedisTemplate.class);
        stringRedisTemplate.delete(id);
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }
}

package pers.god.demo.hazelcast.executor;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IExecutorService;

/**
 * @Author chuhao
 * @Date 2021/10/9
 * @Version 1.0.0
 */
public class SecondMember {

    public static void main(String[] args) throws Exception {
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        IExecutorService executorService = instance.getExecutorService("executor");
    }
}

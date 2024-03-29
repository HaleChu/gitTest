package pers.god.demo.hazelcast.executor;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IExecutorService;

import java.util.concurrent.Future;

/**
 * @Author chuhao
 * @Date 2021/9/30
 * @Version 1.0.0
 */
public class MasterMember {

    public static void main(String[] args) throws Exception {
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        IExecutorService executorService = instance.getExecutorService("executor");
        for (int i = 0; i < 100; i++) {
            Future<String> future = executorService.submit(new Echo("myinput"));
            //while it is executing, do some useful stuff
            //when ready, get the result of your execution
            String result = future.get();
            System.out.println(result);
        }
    }
}

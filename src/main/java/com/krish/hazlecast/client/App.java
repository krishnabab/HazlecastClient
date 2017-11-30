package com.krish.hazlecast.client;

import java.util.Iterator;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ClientConfig config = new ClientConfig();
        GroupConfig groupConfig = config.getGroupConfig();
        groupConfig.setName("cacheQ");
        groupConfig.setPassword("password");
        HazelcastInstance hazelcastInstanceClient = HazelcastClient.newHazelcastClient(config);
        IQueue<String> objQ = hazelcastInstanceClient.getQueue("ecoQ");
        Iterator<String> it = objQ.iterator();
        System.out.println("Q items:");
		while (it.hasNext()) {
			System.out.println("\n"+it.next());
		}
    }
}

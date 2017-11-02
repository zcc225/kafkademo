package com.zccpro.demo.consume;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.zccpro.demo.model.User;
import com.zccpro.demo.produce.KafkaProduce;
import com.zccpro.demo.util.JsonUtils;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.serializer.StringDecoder;
import kafka.utils.VerifiableProperties;

public class KafkaConsume {

    private final static String TOPIC = "testzcc001";

    private static Properties properties;

    static {
        properties = new Properties();
//        String path = KafkaConsume.class.getResource("/").getFile().toString()
//                + "kafka.properties";
        try {
//            FileInputStream fis = new FileInputStream(new File(path));
//            properties.load(fis);
        	 properties.load(KafkaConsume.class.getResourceAsStream("/kafka.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取消息
     * 
     * @throws Exception
     */
    public void getMsg() throws Exception {
        ConsumerConfig config = new ConsumerConfig(properties);

        ConsumerConnector consumer = kafka.consumer.Consumer
                .createJavaConsumerConnector(config);

        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();

        topicCountMap.put(TOPIC, new Integer(1));

        StringDecoder keyDecoder = new StringDecoder(new VerifiableProperties());

        StringDecoder valueDecoder = new StringDecoder(
                new VerifiableProperties());

        Map<String, List<KafkaStream<String, String>>> consumerMap = consumer
                .createMessageStreams(topicCountMap, keyDecoder, valueDecoder);

        KafkaStream<String, String> stream = consumerMap.get(TOPIC).get(0);

        ConsumerIterator<String, String> it = stream.iterator();

        while (it.hasNext()) {
            String json = it.next().message();
            	String string = new String(json.getBytes(),"UTF-8");
//            User user = (User) JsonUtils.JsonToObj(json, User.class);
            System.out.println(string);
        }
    }
}
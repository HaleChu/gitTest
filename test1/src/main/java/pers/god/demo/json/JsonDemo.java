package pers.god.demo.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import pers.god.demo.password.PasswordEncoderHelper;

/**
 * @Author chuhao
 * @Date 2024/9/4
 * @Version 1.0.0
 */
public class JsonDemo {

    public static void main(String[] args) throws JsonProcessingException {
        Person person = new Person("王五", 21, "教授");
        System.out.println(person);
        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writeValueAsString(person);
        System.out.println(str);
        System.out.println("漂亮打印");
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        System.out.println(str);
        String json = "{\"name\":\"李四\",\"age\":22,\"job\":\"CEO\"}";
        Person person1 = objectMapper.readValue(json, Person.class);
        System.out.println(person1);

        System.out.println(PasswordEncoderHelper.decryptByDES("dbMBRKUz9osSNuEu6sLvOuHGkxrWzqML"));

    }
}

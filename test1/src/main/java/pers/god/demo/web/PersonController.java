package pers.god.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.god.demo.domain.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author GodChu
 * @Date ${DATE}
 */
@RestController
@RequestMapping("person")
public class PersonController {

    @GetMapping("personList")
    public List<Person> personList() {
        Person p1 = new Person("张三", 20, "男");
        Person p2 = new Person("李四", 19, "女");
        Person p3 = new Person("王五", 21, "男");
        List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        return personList;
    }
}

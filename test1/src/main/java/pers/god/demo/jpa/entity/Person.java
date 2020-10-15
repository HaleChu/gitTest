package pers.god.demo.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class Person {

    @Id
    @GeneratedValue
    private String id;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private Integer age;

}

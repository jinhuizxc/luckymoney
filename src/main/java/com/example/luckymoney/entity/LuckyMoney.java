package com.example.luckymoney.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 *
 * * @Entity：@Table(name=”“)：
 *  表明这是一个实体类。一般用于jpa这两个注解一般一块使用，但是如果表名和实体类名相同的话，@Table可以省略
 *
 *  @Id：表示该属性为主键。
 *
 *  @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = “repair_seq”)：
 *  表示主键生成策略是sequence（可以为Auto、IDENTITY、native等，Auto表示可在多个数据库间切换），指定sequence的名字是repair_seq。
 *
 * @Id
 * @GeneratedValue： 自增
 */
@Entity
public class LuckyMoney {

    // 红包id
    @Id
    @GeneratedValue
    private Integer id;

    // 金额
    private BigDecimal money;

    // 发送方
    private String producer;

    // 接收方
    private String consumer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }
}

package com.example.luckymoney;

import com.example.luckymoney.entity.LuckyMoney;
import com.example.luckymoney.repository.LuckymoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @Service：一般用于修饰service层的组件
 */
@Service
public class LuckymoneyService {

    // @AutoWired：自动导入依赖的bean。byType方式。把配置好的Bean拿来用，完成属性、方法的组装，
    // 它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。当加上（required=false）时，
    // 就算找不到bean也不报错。
    @Autowired
    private LuckymoneyRepository repository;


    // 创建2个红包
    // 事务管理 事务 指数据库事务
    // 扣库存 > 创建订单
    // @Transactional 注解只能应用到 public 方法才有效。
    @Transactional
    public void createTwo() {
        LuckyMoney luckyMoney1 = new LuckyMoney();
        luckyMoney1.setProducer("廖师兄");
        luckyMoney1.setMoney(new BigDecimal("520"));
        repository.save(luckyMoney1);

        LuckyMoney luckyMoney2 = new LuckyMoney();
        luckyMoney2.setProducer("廖师兄");
        luckyMoney2.setMoney(new BigDecimal("1314"));
        repository.save(luckyMoney2);
    }
}

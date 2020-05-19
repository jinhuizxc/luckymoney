package com.example.luckymoney.controller;

import com.example.luckymoney.entity.LuckyMoney;
import com.example.luckymoney.LuckymoneyService;
import com.example.luckymoney.repository.LuckymoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckymoneyController {

    @Autowired
    private LuckymoneyRepository repository;

    @Autowired
    private LuckymoneyService luckymoneyService;

    /**
     * 获取红包列表
     *
     * @return
     */
    @GetMapping("/luckymoneys/getlist")
    public List<LuckyMoney> getMoneylist() {
        return repository.findAll();
    }

    /**
     * 创建红包(发红包)
     * <p>
     * 发红包的人, 发了多少钱
     */
    @PostMapping("/luckymoneys/create")
    public LuckyMoney create(@RequestParam("producer") String producer,
                             @RequestParam("money") BigDecimal money) {
        LuckyMoney luckyMoney = new LuckyMoney();
        luckyMoney.setProducer(producer);
        luckyMoney.setMoney(money);
        return repository.save(luckyMoney);
    }

    /**
     * 通过id查询红包
     */
    @GetMapping("/luckymoneys/{id}")
    public LuckyMoney getMoneyById(@PathVariable("id") Integer id){
        return repository.findById(id).orElse(null);
    }

    /**
     * 更新红包（领红包）
     */
    @PutMapping("/luckymoneys/{id}")
    public LuckyMoney update(@PathVariable("id") Integer id,
                             @RequestParam("consumer") String consumer){
        // 先查询数据在更新
        Optional<LuckyMoney> optional = repository.findById(id);
        if (optional.isPresent()){
            LuckyMoney luckyMoney = optional.get();
            luckyMoney.setConsumer(consumer);
            return  repository.save(luckyMoney);
        }
        return null;
    }

    // 调用方法
    @PostMapping("/luckymoneys/two")
    public void createTwo(){
        luckymoneyService.createTwo();
    }


}

package com.example.luckymoney.repository;

import com.example.luckymoney.entity.LuckyMoney;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 定义接口
 *
 *  JpaRepository处理数据
 */
public interface LuckymoneyRepository extends JpaRepository<LuckyMoney, Integer> {
}

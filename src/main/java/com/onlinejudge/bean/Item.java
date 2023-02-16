package com.onlinejudge.bean;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;

import java.sql.Wrapper;

public interface Item {
   UpdateWrapper getSetSQL();
}

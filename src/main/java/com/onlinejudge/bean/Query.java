package com.onlinejudge.bean;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

public interface Query {
    QueryWrapper getQuerySQL();
}

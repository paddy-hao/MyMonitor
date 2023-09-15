package com.example.mymonitorbackend.mapper;

import com.example.mymonitorbackend.domain.Resources;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* @author bohao
* @description Mapper for database operations on table [Resources
* @Entity com.example.mymonitorbackend.domain.Resources
*/
@Mapper
public interface ResourcesMapper extends BaseMapper<Resources> {

}





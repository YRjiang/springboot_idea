package com.example.springboot.mapper;

import com.example.springboot.model.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserInfoMapper {

    @Select("select * from user_info where id=#{id}")
    public UserInfo getUserInfoById(Integer id);

    @Insert("insert into user_info(username, mobile) values(#{username}, #{mobile})")
    public void insertUserInfo(UserInfo userInfo);

    @Select("select * from user_info")
    public List<UserInfo> findAllUserInfo();

}

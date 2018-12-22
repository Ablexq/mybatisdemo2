package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void test(){
        System.out.println("----- baseMapper 自带分页 ------");
        Page<User> page = new Page<>(1, 5);
        IPage<User> userIPage = userMapper.selectPage(page, new QueryWrapper<User>()
                .eq("age", 20).eq("name", "Jack"));
        Assert.assertSame(page, userIPage);
        System.out.println("总条数 ------> " + userIPage.getTotal());
        System.out.println("当前页数 ------> " + userIPage.getCurrent());
        System.out.println("当前每页显示数 ------> " + userIPage.getSize());
        System.out.println(userIPage.getRecords());
        System.out.println("----- baseMapper 自带分页 ------");
    }

    @Test
    public void test1(){
        System.out.println("----- baseMapper 自带分页 ------");
        Page<User> page = new Page<>(1, 5);
        IPage<User> userIPage = userMapper.selectPage(page,null);
        Assert.assertSame(page, userIPage);
        System.out.println("总条数 ------> " + userIPage.getTotal());
        System.out.println("当前页数 ------> " + userIPage.getCurrent());
        System.out.println("当前每页显示数 ------> " + userIPage.getSize());
        List<User> records = userIPage.getRecords();
        records.forEach(System.out::println);
        System.out.println("----- baseMapper 自带分页 ------");
    }

    @Test
    public void test2(){
        System.out.println("----- baseMapper 自带分页 ------");
        Page<User> page = new Page<>(2, 5);
        IPage<User> userIPage = userMapper.selectPage(page,null);
        Assert.assertSame(page, userIPage);
        System.out.println("总条数 ------> " + userIPage.getTotal());
        System.out.println("当前页数 ------> " + userIPage.getCurrent());
        System.out.println("当前每页显示数 ------> " + userIPage.getSize());
        List<User> records = userIPage.getRecords();
        records.forEach(System.out::println);
        System.out.println("----- baseMapper 自带分页 ------");
    }
}


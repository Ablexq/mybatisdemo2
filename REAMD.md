

# MyBatis-Plus简介


MyBatis-Plus（简称 MP）是一个 MyBatis 的增强工具，在 MyBatis 的基础上只做增强不做改变，为简化开发、提高效率而生。

[MyBatis-Plus官网](https://mp.baomidou.com/guide/#%E7%89%B9%E6%80%A7)

# 依赖

``` 
<!--lombok-->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>
<!--mybatis-plus-->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.0.6</version>
</dependency>
<!--mysql-->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
    <version>8.0.13</version>
</dependency>
```
# 创建并配置数据库
``` 
use mydb;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id`    int(11) NOT NULL AUTO_INCREMENT,
  `name`  varchar(255)     DEFAULT NULL,
  `age`   varchar(255)     DEFAULT NULL,
  `email` varchar(255)     DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = MyISAM
  AUTO_INCREMENT = 19
  DEFAULT CHARSET = utf8;

INSERT INTO `user` (id, name, age, email)
VALUES (1, 'Jone', 18, 'test1@baomidou.com'),
       (2, 'Jack', 20, 'test2@baomidou.com'),
       (3, 'Tom', 28, 'test3@baomidou.com'),
       (4, 'Sandy', 21, 'test4@baomidou.com'),
       (5, 'Billie', 24, 'test5@baomidou.com');
```
application.properties：
``` 
# database
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/mydb?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT
spring.datasource.username=root
spring.datasource.password=admin
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```
# 编写实体类
``` 
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
```
# 编写Mapper类
``` 
public interface UserMapper extends BaseMapper<User> {

}
```
在 Spring Boot 启动类中添加 @MapperScan 注解，扫描 Mapper 文件夹：
``` 
@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

```
# 开始使用

``` 
@Resource
private UserMapper userMapper;

@Test
public void testSelect() {
    System.out.println(("----- selectAll method test ------"));
    List<User> userList = userMapper.selectList(null);
    Assert.assertEquals(5, userList.size());
    userList.forEach(System.out::println);
}
```
打印结果：

``` 
----- selectAll method test ------
User(id=1, name=Jone, age=18, email=test1@baomidou.com)
User(id=2, name=Jack, age=20, email=test2@baomidou.com)
User(id=3, name=Tom, age=28, email=test3@baomidou.com)
User(id=4, name=Sandy, age=21, email=test4@baomidou.com)
User(id=5, name=Billie, age=24, email=test5@baomidou.com)
```


























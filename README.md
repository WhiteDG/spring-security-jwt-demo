# spring-security-jwt-demo


### 介绍
这是一个使用 Spring Boot2 + Spring Security + JSON Web Token（JWT）实现 REST API token 验证的 demo。

### 构建环境
- JDK 1.8
- Gradle 4.7

### 运行步骤
1. 导入数据库，执行 db.sql
2. idea 导入项目，使用 Gradle 同步项目，导入依赖包
3. 修改 application.yml 中数据库连接配置
4. 启动 SpringSecurityJwtDemoApplication

### 示例
#### 登录获取 token
请求方式 | url | 请求头 | 参数  | 说明
---|--- |--- |--- |--- 
POST | http://127.0.0.1:8080/login | Content-Type=application/x-www-form-urlencoded | username=WHITE&password=123456 | 登录获取 token

![image](https://github.com/WhiteDG/spring-security-jwt-demo/blob/master/image/login.jpg)

#### token 校验通过
请求方式 | url | 请求头 | 参数  | 说明
---|--- |--- |--- |--- 
GET | http://127.0.0.1:8080/user | Authorization=Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiZXhwIjoxNTU0MTk1NDcwLCJpYXQiOjE1NTMzMzE0NzB9.ywEoftigVn9M58RBN5owABZgs6cDe2NQ1PelZ6YlWTycuJV6dNC-KTfqxe_NRZsMn2f95FPFQP4hlRdEWuiz-w | / | 获取已登录用户信息

![image](https://github.com/WhiteDG/spring-security-jwt-demo/blob/master/image/user.jpg)

#### token 校验失败
请求方式 | url | 请求头 | 参数  | 说明
---|--- |--- |--- |--- 
GET | http://127.0.0.1:8080/user | / | / | 获取已登录用户信息

![image](https://github.com/WhiteDG/spring-security-jwt-demo/blob/master/image/error_token.jpg)

### 引用的开源库
项目名 | 项目地址 | 说明 | 
---|--- |--- 
Spring Boot | https://github.com/spring-projects/spring-boot | 容器+MVC框架
Spring Security | https://github.com/spring-projects/spring-security | 认证和授权框架
MyBatis | https://github.com/mybatis/mybatis-3 | ORM 框架
Druid | https://github.com/alibaba/druid | 数据库连接池
jjwt | https://github.com/jwtk/jjwt | java jwt 实现


### LICENSE
[MIT License](https://github.com/WhiteDG/CountDownButton/blob/master/LICENSE.txt) @[Wh1te](https://github.com/WhiteDG)
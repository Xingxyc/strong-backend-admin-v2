
![架构图](https://static.iocoder.cn/ruoyi-vue-pro-architecture.png?imageView2/2/format/webp)

## 🐨 技术栈

### 模块

| 项目                                                                       | 说明      |
|--------------------------------------------------------------------------|---------|
| `strong-dependencies`                                                     | Maven 依赖版本管理 |
| `strong-framework`                                                        | Java 框架拓展 |
| `strong-server`                                                           | 管理后的服务端 |
| `strong-module-system`                                                    | 系统功能的 Module 模块 |
| `strong-module-infra`                                                     | 基础设施的 Module 模块 |

### 框架

| 框架                                                                                          | 说明               | 版本          | 学习指南                                                           |
|---------------------------------------------------------------------------------------------|------------------|-------------|----------------------------------------------------------------|
| [Spring Boot](https://spring.io/projects/spring-boot)                                       | 应用开发框架           | 2.7.13      | [文档](https://github.com/YunaiV/SpringBoot-Labs)                |
| [MySQL](https://www.mysql.com/cn/)                                                          | 数据库服务器           | 5.7 / 8.0+  |                                                                |
| [Druid](https://github.com/alibaba/druid)                                                   | JDBC 连接池、监控组件    | 1.2.18      | [文档](http://www.iocoder.cn/Spring-Boot/datasource-pool/?strong) |
| [MyBatis Plus](https://mp.baomidou.com/)                                                    | MyBatis 增强工具包    | 3.5.3.1     | [文档](http://www.iocoder.cn/Spring-Boot/MyBatis/?strong)         |
| [Dynamic Datasource](https://dynamic-datasource.com/)                                       | 动态数据源            | 3.6.1       | [文档](http://www.iocoder.cn/Spring-Boot/datasource-pool/?strong) |
| [Redis](https://redis.io/)                                                                  | key-value 数据库    | 5.0 / 6.0   |                                                                |
| [Redisson](https://github.com/redisson/redisson)                                            | Redis 客户端        | 3.18.0      | [文档](http://www.iocoder.cn/Spring-Boot/Redis/?strong)           |
| [Spring MVC](https://github.com/spring-projects/spring-framework/tree/master/spring-webmvc) | MVC 框架           | 5.3.24      | [文档](http://www.iocoder.cn/SpringMVC/MVC/?strong)               |
| [Spring Security](https://github.com/spring-projects/spring-security)                       | Spring 安全框架      | 5.7.6       | [文档](http://www.iocoder.cn/Spring-Boot/Spring-Security/?strong) |
| [Hibernate Validator](https://github.com/hibernate/hibernate-validator)                     | 参数校验组件           | 6.2.5       | [文档](http://www.iocoder.cn/Spring-Boot/Validation/?strong)      |
| [Flowable](https://github.com/flowable/flowable-engine)                                     | 工作流引擎            | 6.8.0       | [文档](https://doc.iocoder.cn/bpm/)                              |
| [Quartz](https://github.com/quartz-scheduler)                                               | 任务调度组件           | 2.3.2       | [文档](http://www.iocoder.cn/Spring-Boot/Job/?strong)             |
| [Springdoc](https://springdoc.org/)                                                         | Swagger 文档       | 1.6.15      | [文档](http://www.iocoder.cn/Spring-Boot/Swagger/?strong)         |
| [Resilience4j](https://github.com/resilience4j/resilience4j)                                | 服务保障组件           | 1.7.1       | [文档](http://www.iocoder.cn/Spring-Boot/Resilience4j/?strong)    |
| [SkyWalking](https://skywalking.apache.org/)                                                | 分布式应用追踪系统        | 8.12.0      | [文档](http://www.iocoder.cn/Spring-Boot/SkyWalking/?strong)      |
| [Spring Boot Admin](https://github.com/codecentric/spring-boot-admin)                       | Spring Boot 监控平台 | 2.7.10      | [文档](http://www.iocoder.cn/Spring-Boot/Admin/?strong)           |
| [Jackson](https://github.com/FasterXML/jackson)                                             | JSON 工具库         | 2.13.3      |                                                                |
| [MapStruct](https://mapstruct.org/)                                                         | Java Bean 转换     | 1.5.5.Final | [文档](http://www.iocoder.cn/Spring-Boot/MapStruct/?strong)       |
| [Lombok](https://projectlombok.org/)                                                        | 消除冗长的 Java 代码    | 1.18.28     | [文档](http://www.iocoder.cn/Spring-Boot/Lombok/?strong)          |
| [JUnit](https://junit.org/junit5/)                                                          | Java 单元测试框架      | 5.8.2       | -                                                              |
| [Mockito](https://github.com/mockito/mockito)                                               | Java Mock 框架     | 4.8.0       | -                                                              |


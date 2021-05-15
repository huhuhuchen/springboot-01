1、值的写法

#### 字面量：普通的值（数字，字符串，布尔）

	k: v：字面直接来写；

		字符串默认不用加上单引号或者双引号；

		""：双引号；不会转义字符串里面的特殊字符；特殊字符会作为本身想表示的意思

				name:   "zhangsan \n lisi"：输出；zhangsan 换行  lisi

		''：单引号；会转义特殊字符，特殊字符最终只是一个普通的字符串数据

				name:   ‘zhangsan \n lisi’：输出；zhangsan \n  lisi



#### 对象、Map（属性和值）（键值对）：

	k: v：在下一行来写对象的属性和值的关系；注意缩进

		对象还是k: v的方式

```yaml
friends:
		lastName: zhangsan
		age: 20
```

行内写法：

```yaml
friends: {lastName: zhangsan,age: 18}
```



#### 数组（List、Set）：

用- 值表示数组中的一个元素

```yaml
pets:
 - cat
 - dog
 - pig
```

行内写法

```yaml
pets: [cat,dog,pig]
```


2、@Value获取值和@ConfigurationProperties获取值比较

|            | @ConfigurationProperties | @Value |
| ---------- | ------------------------ | ------ |
| 功能         | 批量注入配置文件中的属性             | 一个个指定  |
| 松散绑定（松散语法） | 支持                       | 不支持    |
| SpEL       | 不支持                      | 支持     |
| JSR303数据校验 | 支持                       | 不支持    |
| 复杂类型封装     | 支持                       | 不支持    |


配置文件yml还是properties他们都能获取到值；

如果说，我们只是在某个业务逻辑中需要获取一下配置文件中的某项值，使用@Value；

如果说，我们专门编写了一个javaBean来和配置文件进行映射，我们就直接使用@ConfigurationProperties；

4、@PropertySource&@ImportResource&@Bean

@**PropertySource**：加载指定的配置文件；





@**ImportResource**：导入Spring的配置文件，让配置文件里面的内容生效；

Spring Boot里面没有Spring的配置文件，我们自己编写的配置文件，也不能自动识别；

想让Spring的配置文件生效，加载进来；@**ImportResource**标注在一个配置类上

导入Spring的配置文件让其生效
```java
@ImportResource(locations = {"classpath:beans.xml"})

```



不来编写Spring的配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">


    <bean id="helloService" class="com.huchen.springboot.service.HelloService"></bean>
</beans>
```

4、配置文件占位符

### 1、随机数

```java
${random.value}、${random.int}、${random.long}
${random.int(10)}、${random.int[1024,65536]}

```



### 2、占位符获取之前配置的值，如果没有可以是用:指定默认值

```properties
person.last-name=张三${random.uuid}
person.age=${random.int}
person.birth=2017/12/15
person.boss=false
person.maps.k1=v1
person.maps.k2=14
person.lists=a,b,c
person.dog.name=${person.hello:hello}_dog
person.dog.age=15
```

5、Profile

### 1、多Profile文件

我们在主配置文件编写的时候，文件名可以是   application-{profile}.properties/yml

默认使用application.properties的配置；



### 2、yml支持多文档块方式

```yml

server:
  port: 8081
spring:
  profiles:
    active: prod

---
server:
  port: 8083
spring:
  profiles: dev


---

server:
  port: 8084
spring:
  profiles: prod  #指定属于哪个环境
```





### 3、激活指定profile

	1、在配置文件中指定  spring.profiles.active=dev

	2、命令行：

		java -jar spring-boot-02-config-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev；

		可以直接在测试的时候，配置传入命令行参数

	3、虚拟机参数；

		-Dspring.profiles.active=dev

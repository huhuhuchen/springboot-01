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
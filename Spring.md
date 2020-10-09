### 注解系列

除去常用的四种注解：@Controller，@Service，@Repository，@Component，@Mapper之外有：

1.@Bean（注：以上5个注解用于自己写的类，而@Bean用于第三方包里面的组件。 可以指定initMethod和destroyMethod，但是destroyMethod需要手动调用IOC容器的close方法才会被调用，直接关闭程序是无法调用的）

2.@Scope

3.@Lazy

注：@Scope和@Lazy只是延迟第一次被调用的时机，但是系统初始化的时候就已经被Spring扫描注册进入IOC容器了

4.@Condition

5.@Import（注：使用该注解的类需要被Spring 容器管理）

6.@PostConstruct和@PreDestroy。但是需要注意的是这两个注解是java提供的，而不是Spring提供。并且名称翻译过来，是：构造之后和销毁之前。



### 类系列

有一个盲区，继承或实现Spring的内置接口和类并不代表其被Spring管理了，该加上的注解还是要加的。

1.FactoryBean<T>

注：通过getBean(id)获取到的是T的bean对象，而在id前面加上&则获取到的是factoryBean本身，例：getBean("&" + id)

2.AnnotationConfigApplicationContext起始是创建IOC容器，也就是说spring boot的SpringApplication.run()也是创建的Spring IOC容器。

3.InitializingBean相当于initMethod，DisposableBean相当于destroyMethod

4.BeanPostProcessor。有两个方法

5.执行顺序是：构造函数，postProcessBeforeInitialization，init方法/@PostConstruct，postProcessAfterInitialization，

```
构造函数
postProcessBeforeInitialization  com.config.Car@6d17914a  car
重写的InitializingBean方法
initMethod
postProcessAfterInitialization  com.config.Car@6d17914a  car
```

```
构造函数
postProcessBeforeInitialization  com.config.Car@3ad847f8  car
@PostConstruct  #这个比上面多一个的原因是因为此处在postProcessBeforeInitializatin中return 了bean
重写的InitializingBean方法
initMethod
postProcessAfterInitialization  com.config.Car@3ad847f8  car
```

```
@PreDestroy
重写的DisposableBean方法
destroyMethod
```



//TODO :Spring 生命周期
# springcloud-nacos-demo
### 为什么要用nacos？

学习nacos的主要原因是因为eureka2.x的闭源策略，无论其基于什么原因吧，总之长久来看eureka貌似不是最好的选择，这种情况下是时候悄悄的接触nacos了。

### 近期关于springcloud组件的抽象理解

其实注册中心使用nacos并不会影响到我们应用层多少的，仔细看看，其实还是我该怎样调用怎样调用，跟用不用Nacos没啥关系，确实是这样，对于Spring Cloud老手来说，就算我们更换了Nacos作为新的服务注册中心，其实对于我们应用层面的代码是没有影响的。那么为什么Spring Cloud可以带给我们这样的完美编码体验呢？实际上，这完全归功于Spring Cloud Common的封装，由于在服务注册与发现、客户端负载均衡等方面都做了很好的抽象，而上层应用方面依赖的都是这些抽象接口，而非针对某个具体中间件的实现。所以，在Spring Cloud中，我们可以很方便的去切换服务治理方面的中间件。

在服务启动之前，先去nacos官网下载nacos服务中心压缩包，通过指定脚本启动服务。
# 三个分支
## common-jar
- 一个普通的jar包，提供了一个类：Person

## ark-plugin
- 一个ark-plugin，提供了一个类：ArkClass
- ArkClass有一个output方法，以common-jar中的Person作为参数

## spring-boot
- 一个集成了spring-boot ark的工程，调用了ArkClass的output方法，传了一个参数person。

# 报错
- 在访问[http://localhost:8080/test](http://localhost:8080/test)的时候，报错堆栈如下：
```
2018-08-17 16:28:13.795 ERROR 4263 --- [nio-8080-exec-1] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Handler dispatch failed; nested exception is java.lang.LinkageError: loader constraint violation: loader (instance of com/alipay/sofa/ark/container/service/classloader/PluginClassLoader) previously initiated loading for a different type with name "com/guozhaotong/myself/Person"] with root cause

java.lang.LinkageError: loader constraint violation: loader (instance of com/alipay/sofa/ark/container/service/classloader/PluginClassLoader) previously initiated loading for a different type with name "com/guozhaotong/myself/Person"
	at java.lang.ClassLoader.defineClass1(Native Method) ~[na:1.8.0_171]
	at java.lang.ClassLoader.defineClass(ClassLoader.java:763) ~[na:1.8.0_171]
	at java.security.SecureClassLoader.defineClass(SecureClassLoader.java:142) ~[na:1.8.0_171]
	at java.net.URLClassLoader.defineClass(URLClassLoader.java:467) ~[na:1.8.0_171]
	at java.net.URLClassLoader.access$100(URLClassLoader.java:73) ~[na:1.8.0_171]
	at java.net.URLClassLoader$1.run(URLClassLoader.java:368) ~[na:1.8.0_171]
	at java.net.URLClassLoader$1.run(URLClassLoader.java:362) ~[na:1.8.0_171]
	at java.security.AccessController.doPrivileged(Native Method) ~[na:1.8.0_171]
	at java.net.URLClassLoader.findClass(URLClassLoader.java:361) ~[na:1.8.0_171]
	at com.alipay.sofa.ark.container.service.classloader.AbstractClasspathClassloader.resolveLocalClass(AbstractClasspathClassloader.java:183) ~[na:na]
	at com.alipay.sofa.ark.container.service.classloader.PluginClassLoader.loadClassInternal(PluginClassLoader.java:79) ~[na:na]
	at com.alipay.sofa.ark.container.service.classloader.AbstractClasspathClassloader.loadClass(AbstractClasspathClassloader.java:59) ~[na:na]
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357) ~[na:1.8.0_171]
	at com.guozhaotong.arkplugin.ArkClass.output(ArkClass.java:7) ~[ark-plugin-1.0.jar!/:na]
	at com.guozhaotong.springbootarkdemo.controller.Controller.version1(Controller.java:14) ~[classes/:na]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_171]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_171]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_171]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_171]
	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:220) ~[spring-web-4.3.4.RELEASE.jar:4.3.4.RELEASE]
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:134) ~[spring-web-4.3.4.RELEASE.jar:4.3.4.RELEASE]
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:116) ~[spring-webmvc-4.3.4.RELEASE.jar:4.3.4.RELEASE]
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:827) ~[spring-webmvc-4.3.4.RELEASE.jar:4.3.4.RELEASE]
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:738) ~[spring-webmvc-4.3.4.RELEASE.jar:4.3.4.RELEASE]
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:85) ~[spring-webmvc-4.3.4.RELEASE.jar:4.3.4.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:963) ~[spring-webmvc-4.3.4.RELEASE.jar:4.3.4.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:897) ~[spring-webmvc-4.3.4.RELEASE.jar:4.3.4.RELEASE]
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:970) ~[spring-webmvc-4.3.4.RELEASE.jar:4.3.4.RELEASE]
	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:861) ~[spring-webmvc-4.3.4.RELEASE.jar:4.3.4.RELEASE]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:622) ~[tomcat-embed-core-8.5.6.jar:8.5.6]
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:846) ~[spring-webmvc-4.3.4.RELEASE.jar:4.3.4.RELEASE]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:729) ~[tomcat-embed-core-8.5.6.jar:8.5.6]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:230) ~[tomcat-embed-core-8.5.6.jar:8.5.6]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165) ~[tomcat-embed-core-8.5.6.jar:8.5.6]
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52) ~[tomcat-embed-websocket-8.5.6.jar:8.5.6]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192) ~[tomcat-embed-core-8.5.6.jar:8.5.6]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165) ~[tomcat-embed-core-8.5.6.jar:8.5.6]
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:99) ~[spring-web-4.3.4.RELEASE.jar:4.3.4.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-4.3.4.RELEASE.jar:4.3.4.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192) ~[tomcat-embed-core-8.5.6.jar:8.5.6]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165) ~[tomcat-embed-core-8.5.6.jar:8.5.6]
	at org.springframework.web.filter.HttpPutFormContentFilter.doFilterInternal(HttpPutFormContentFilter.java:89) ~[spring-web-4.3.4.RELEASE.jar:4.3.4.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-4.3.4.RELEASE.jar:4.3.4.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192) ~[tomcat-embed-core-8.5.6.jar:8.5.6]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165) ~[tomcat-embed-core-8.5.6.jar:8.5.6]
	at org.springframework.web.filter.HiddenHttpMethodFilter.doFilterInternal(HiddenHttpMethodFilter.java:77) ~[spring-web-4.3.4.RELEASE.jar:4.3.4.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-4.3.4.RELEASE.jar:4.3.4.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192) ~[tomcat-embed-core-8.5.6.jar:8.5.6]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165) ~[tomcat-embed-core-8.5.6.jar:8.5.6]
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:197) ~[spring-web-4.3.4.RELEASE.jar:4.3.4.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-4.3.4.RELEASE.jar:4.3.4.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192) ~[tomcat-embed-core-8.5.6.jar:8.5.6]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165) ~[tomcat-embed-core-8.5.6.jar:8.5.6]
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:198) ~[tomcat-embed-core-8.5.6.jar:8.5.6]
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:108) [tomcat-embed-core-8.5.6.jar:8.5.6]
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:472) [tomcat-embed-core-8.5.6.jar:8.5.6]
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:140) [tomcat-embed-core-8.5.6.jar:8.5.6]
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:79) [tomcat-embed-core-8.5.6.jar:8.5.6]
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:87) [tomcat-embed-core-8.5.6.jar:8.5.6]
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:349) [tomcat-embed-core-8.5.6.jar:8.5.6]
	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:784) [tomcat-embed-core-8.5.6.jar:8.5.6]
	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:66) [tomcat-embed-core-8.5.6.jar:8.5.6]
	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:802) [tomcat-embed-core-8.5.6.jar:8.5.6]
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1410) [tomcat-embed-core-8.5.6.jar:8.5.6]
	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49) [tomcat-embed-core-8.5.6.jar:8.5.6]
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149) [na:1.8.0_171]
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624) [na:1.8.0_171]
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) [tomcat-embed-core-8.5.6.jar:8.5.6]
	at java.lang.Thread.run(Thread.java:748) [na:1.8.0_171]
```

# 我的疑问
- spring-boot依赖了common-jar中的Person，ArkClass也依赖了common-jar中的Person。
- 我的理解：Ark-plugin是打fat jar的，把common-jar的Person打在了里面。那么spring-boot中的Person和Ark-plugin中的Person就是两个不同的类加载器在加载。导致了冲突
- 我的疑问：这个问题有办法解决吗？
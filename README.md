# XHandler
XHandler, handler的正确使用姿势与消息传递机制

>
MultiThreading and task running are old subjects. Java itself has java.util.concurrent package and Fork/Join framework to facilitate it. Several libraries have been written to streamline asynchronous operations. RxJava is the most popular library today for reactive programming and designing an asynchronous application.

>Looper, Handler, and HandlerThread are the Android’s way of solving the problems of asynchronous programming. They are not old school, but a neat structure on which a complex android framework is built.


Looper,Handler,HandlerThread是android异步编程的基本解决方法。

MessageQueue 是一个队列，该队列由待处理的message

MessageQueue is a queue that has tasks called messages which should be processed.

Handler enqueues task in the MessageQueue using Looper and also executes them when the task comes out of the MessageQueue.

Looper is a worker that keeps a thread alive, loops through MessageQueue and sends messages to the corresponding handler to process.

Finally Thread gets terminated by calling Looper’s quit() method.



参考这篇文章
https://blog.mindorks.com/android-core-looper-handler-and-handlerthread-bd54d69fe91a
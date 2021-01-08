Executor  执行某个任务  execute
ExecutorService  submit
          Callable  -   Runable

Executors 操作 Executor 工具类

ThreadPool  


六大线程池
    示例地址 ： https://blog.csdn.net/qq_26963495/article/details/79056391

①：FixedThreadPool，特点：固定池子中线程的个数。
                         使用静态方法newFixedThreadPool()创建线程池的时候指定线程池个数。
ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

②：CachedThreadPool（弹性缓存线程池），特点：用newCachedThreadPool()方法创建该线程池对象，
创建之初里面一个线程都没有，当execute方法或submit方法向线程池提交任务时，会自动新建线程；
如果线程池中有空余线程，则不会新建；这种线程池一般最多情况可以容纳几万个线程，里面的线程空余60s会被回收。

ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

③：SingleThreadPool（单线程线程池），特点：池中只有一个线程，
如果扔5个任务进来，那么有4个任务将排队；作用是保证任务的顺序执行。

ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

④：ScheduledThreadpool（定时器线程池）

⑤WorkStealingPool

⑥ForkJoinPool

核心 ThreadPoolExecutor





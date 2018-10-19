package james.multithread.sharDataInThread;

/**
 * Created by James on 2018/10/19.
 */
public class VolatileDemo implements Runnable{
    // 仅能保证线程间数据共享，但不能保证原子性、有序性，需要使用 synchronized
    // 当前线程的修改立即同步到主内存，但其他线程依然需要从主线程中获取数据，时间差
    private volatile int anInt;

    @Override
    public synchronized void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("threadName:"+Thread.currentThread().getName()+" >>>"+anInt++);
    }
}

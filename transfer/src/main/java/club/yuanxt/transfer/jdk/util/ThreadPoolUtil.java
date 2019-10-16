package club.yuanxt.transfer.jdk.util;

import java.util.concurrent.*;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author renhy
 * @version 1.0
 * @date Created in 2019年10月16日 16:06
 * @since 1.0
 */
public class ThreadPoolUtil {
    private static ThreadPoolExecutor threadPool;

    /**
     * 无返回值
     *
     * @param runnable
     */
    public static void execute(Runnable runnable) {
        getThreadPool().execute(runnable);
    }

    /**
     * 有返回值
     *
     * @param callable
     */
    public static <T> Future<T> submit(Callable<T> callable) {
        return getThreadPool().submit(callable);
    }


    /**
     * dcs获取线程池
     *
     * @return 线程池对象
     */
    private static ThreadPoolExecutor getThreadPool() {
        if (threadPool != null) {
            return threadPool;
        } else {
            synchronized (ThreadPoolUtil.class) {
                if (threadPool == null) {
                    threadPool = new ThreadPoolExecutor(4, 8, 60, TimeUnit.SECONDS,
                            new LinkedBlockingQueue<>(32), new ThreadPoolExecutor.CallerRunsPolicy());
                }
                return threadPool;
            }
        }
    }
}

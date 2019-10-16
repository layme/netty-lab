package club.yuanxt.transfer;

import club.yuanxt.transfer.netty.nio.NettyNioServer;

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
 * @date Created in 2019年10月16日 20:08
 * @since 1.0
 */
public class ServerStater {
    public static void main(String[] args) throws Exception {
        // jdk 非阻塞模式
//        new PlainNioServer().serve(60000);

        // netty 阻塞模式
//        new NettyOioServer().serve(60000);

        // netty 非阻塞模式
        new NettyNioServer().serve(60000);
    }
}

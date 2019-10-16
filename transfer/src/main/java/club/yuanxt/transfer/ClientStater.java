package club.yuanxt.transfer;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

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
public class ClientStater {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 60000);
        InputStream in = socket.getInputStream();
        int len;
        byte[] buffer = new byte[1024];
        StringBuilder msg = new StringBuilder();
        while ((len = in.read(buffer)) != -1) {
            msg.append(new String(buffer, 0, len, StandardCharsets.UTF_8));
        }
        System.out.println(msg.toString());
        in.close();
        socket.close();
    }
}

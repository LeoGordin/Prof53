package lesson23;

import java.io.*;
import java.net.Socket;

public class SocketTester {
    public static void main(String[] args) { // http://colormind.io/list/
        // tcp 1-65535
        // udp 1-65535
        // http 80/tcp
        // https 443/tcp
        String server = "colormind.io";
        int port = 80;
        String service = "/list/";
        try (
                Socket socket = new Socket(server, port);
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                OutputStreamWriter osr = new OutputStreamWriter(os);
        ) {
            osr.write("GET http://colormind.io/list/ HTTP/1.0\n\n");
            osr.flush();
            br.lines().forEach(System.out::println);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

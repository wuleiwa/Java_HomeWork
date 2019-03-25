
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    private static int port = 8883;
    private static Socket accept;
    private static ServerSocket socket;
    private static BufferedWriter bw;
    public static void main(String[] args) throws Exception {
        socket = new ServerSocket(port);
        System.out.println("服务器开启，等待连接....");
        while (true){
            accept = socket.accept();
            InputStreamReader r = new InputStreamReader(accept.getInputStream());
            System.out.println("浏览器请求成功!");
            BufferedReader br = new BufferedReader(r);
            String readLine = br.readLine();
            System.out.println("---------------------");
            //打印请求消息
            String filePath="src";
//
            String resource = handleString(readLine);
            // 获取位置处理请求头
            StringBuffer responseMsg = new StringBuffer();
            //发送响应
            responseMsg = response(resource);
            send(responseMsg, socket);
            System.out.println("----------------------");
            //发送响应请求
            System.out.println(filePath);
//            writeHtml(filePath);
        }
    }



    public static String handleString(String requestHead) {
        String[] res = requestHead.split(" ");
        @SuppressWarnings("unused")
        String method = res[0];// 请求方法
        String resource = "";// 请求资源名
        if (res[1].contains("/")) {
            String[] s = res[1].split("/");

            resource = s[s.length - 1];
			System.out.println(resource);
        }
        return resource;
    }
    public static void send(StringBuffer msg, ServerSocket socket) throws IOException {
        OutputStream os = accept.getOutputStream();
        os.write(msg.toString().getBytes());
        os.close();
    }

    public static StringBuffer response(String resource) throws IOException {
        StringBuffer msg = new StringBuffer();
        if(resource.equals("test")) {
            msg.append("HTTP/1.1 200 OK\n\r");
            msg.append("Content-Type:text/html\n\n");
            String data = "";
            data = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
                    + "<title>JAVA WEB</title>\r\n" +
                    "</head>\r\n" + "<body>\r\n" +
                    "	JAVA第二次作业\r\n" +
                    " <button >完成</button>\n"+
                    "</body>\r\n"
                    + "</html>";
            msg.append(data);
//			System.out.println("ok");
        }

        return msg;

    }

}









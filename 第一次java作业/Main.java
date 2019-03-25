
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
            int i=0;
            while(readLine != null && !readLine.equals("")){
                System.out.println(readLine);
                if (i==0){
                    String[] split = readLine.split(" ");
                    if (split[1].endsWith("html")) {
                        filePath += split[1];
                    }
                }
                i++;
                readLine=br.readLine();
            }
            System.out.println("----------------------");
            //发送响应请求
            System.out.println(filePath);
            writeHtml(filePath);
        }
    }

    public static void writeHtml(String filePath) throws Exception{
        if (!"src/log/index.html".equals(filePath)){
            filePath="src/404.html";
        }
        FileInputStream fis = new FileInputStream(filePath);
        int len=0;
        byte[] b = new byte[1024];
        StringBuilder sb = new StringBuilder();
        //拼装http响应的数据格式
        sb.append("http/1.1 200 ok").append("\n\n");
        while ((len=fis.read(b))!=-1){
            sb.append(new String(b,0,len));
        }
        bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}












//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//        int port = 8000;
//        DataInputStream in;
//        DataOutputStream out;
//        ServerSocket server;
//        Socket socket;
//        System.out.println("服务器连接中....");
//        try {
//            server = new ServerSocket(port);
//            socket = server.accept();
//            System.out.println(socket.getInetAddress()+"已经成功连接");
//
//            in = new DataInputStream(socket.getInputStream());
//            out = new DataOutputStream(socket.getOutputStream());
//            System.out.println(in.readAllBytes());
//        } catch (IOException ex) {
//
//        }
//    }
//}

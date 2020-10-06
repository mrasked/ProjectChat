package ChatServer;

import java.io.*;
import java.net.*;
import java.util.Random;

public class Server {
    //Intellij Idea при длинной записи оператора сама будет выставлять переносы строк, нет необходимости нажимать Enter по середине записи строки.
    int n = 6;

    public void go() {
        try {
            //Приложение будет отслеживать клиентские запросы на порту 5000 на том же компьютере, где выполняется данный код
            ServerSocket serverSock = new ServerSocket(5000);
            //Сервер входит в постоянный цикл, ожидая клиентских подключений
            while(true) {
                Socket sock = serverSock.accept();
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    } // Закрываем go

    private String getAdvice() {
        String str = "";
        for (int i = 0; i < n; i++) {
            str = str+"L" + i +": "; // следующая строка типа \n не даёт перенос на клиенте ???? //
            for (int j = 0; j < n; j++) {
                str = (str) + " " +(Integer.toString(0+(int)(Math.random()*10)));
            }
            str = str + ";  ";
        }
        return str;
    }
    public static void main(String[] args) {
        Server server = new Server();
        server.go();
    }
}

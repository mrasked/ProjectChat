package ChatClient;

import java.io.*;
import java.net.*;

public class Client {


    public void go() {
        try {// отлавливаем исключения
            Socket s = new Socket("127.0.0.1", 5000);
            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            String str = reader.readLine();
            System.out.println("Пример строки:" + str);
            reader. close (); //Закрываем все потоки
        } catch(IOException ex) { //обрабатываем исключение ввода/вывода
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Client client = new Client();
        client.go();
    }
}

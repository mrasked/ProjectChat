import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
public class Server {
    public Server() {
    }

    public static void main(String[] args) {
            try {
                ServerSocket serverSocket = new ServerSocket(6001);
                Socket s = serverSocket.accept();
                InputStream is = s.getInputStream(); // вхідний потік сокета
                OutputStream os = s.getOutputStream();
                ObjectInputStream ois = new ObjectInputStream(is);
                //ObjectOutputStream oos = new ObjectOutputStream(os);
                Matrix object = (Matrix) ois.readObject();
                int[][] recivedMas = object.getMassive();
                for (int i = 0; i < recivedMas.length; i++) {
                    for (int j = 0; j < recivedMas.length; j++) {
                        int i1 = recivedMas[i][j];
                        System.out.println("[" + i + "][ " + j + "] " + i1);
                    }
                }
                ObjectOutputStream oos = new ObjectOutputStream(os);
                oos.writeObject(object);
                oos.flush();
            } catch (
                    IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (ClassNotFoundException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
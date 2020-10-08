import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.naming.Name;
import javax.naming.NameParser;
import java.net.Socket;
import java.io.*;
public class Client {
    public Client() {
    }
    public void start(Stage stage){

        GridPane grid = new GridPane();



        Scene scene = new Scene(grid, 300,200);
        stage.setScene(scene);
        stage.setTitle("Матрица в FX");
    }

    public static void main(String[] args) {
        try {
            Matrix object = new Matrix();
            Socket s = new Socket("localhost", 6001);
            InputStream is = s.getInputStream(); // вхідний потік сокета
            OutputStream os = s.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(object);
            oos.flush();
            // oos.close();
            ObjectInputStream ois = new ObjectInputStream(is);
            object = (Matrix) ois.readObject();
            int[][] recivedMas = object.getMassive();
            for (int i = 0; i < recivedMas.length; i++) {
                for (int j = 0; j < recivedMas.length; j++) {
                    int i1 = recivedMas[i][j];
                    System.out.println("[" + i + "][ " + j + "] " + i1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
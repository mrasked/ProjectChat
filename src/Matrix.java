import java.io.*;
public class Matrix implements Serializable{
    int n = 5;
    private int[][] mas;
    public Matrix() {
        mas = new int[n][n];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                mas[i][j] = i+j;
            }
        }
    }
    public int[][] getMassive(){
        return mas;
    }
}
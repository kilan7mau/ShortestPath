package org.code;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomGraphGenerator {

    public static void main(String[] args) {
        Random rand = new Random();
        int numNodes = rand.nextInt(10) + 5; // 5 đến 14 đỉnh

        String filePath = "C:\\hadoop\\ShortestPath2\\input_" + numNodes + ".txt";

        try (FileWriter writer = new FileWriter(filePath)) {
            // Đỉnh đầu tiên với trọng số 0
            writer.write("{" + 1 + ",0,UNMARKED}");

            int numEdges = rand.nextInt(5) + 1;
            for (int j = 2; j <= 1 + numEdges && j <= numNodes; j++) {
                int weight = rand.nextInt(101); // Trọng số từ 0 đến 100
                writer.write("\t{" + j + "," + weight + "}");
            }
            writer.write("\n");

            // Các đỉnh còn lại
            for (int i = 2; i <= numNodes; i++) {
                writer.write("{" + i + ",INFINITY,UNMARKED}");
                numEdges = rand.nextInt(5) + 1;
                for (int j = 1; j <= numEdges; j++) {
                    int neighbor = rand.nextInt(numNodes) + 1;
                    int weight = rand.nextInt(101);
                    writer.write("\t{" + neighbor + "," + weight + "}");
                }
                writer.write("\n");
            }

            System.out.println("Tạo file thành công: " + filePath);
        } catch (IOException e) {
            System.err.println("Lỗi ghi file: " + e.getMessage());
        }
    }
}


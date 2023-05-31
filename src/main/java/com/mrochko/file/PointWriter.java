package com.mrochko.file;

import com.mrochko.Point;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author Pavlo Mrochko
 */
public class PointWriter {
    public static void writePointsToFile(String filePath, List<Point> points) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Point point : points) {
                writer.write(point.getX() + "," + point.getY() + "," + point.getWeight());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

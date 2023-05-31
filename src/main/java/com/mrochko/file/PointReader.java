package com.mrochko.file;

import com.mrochko.Point;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavlo Mrochko
 */
public class PointReader {
    public static List<Point> readPointsFromFile(String filePath) {
        List<Point> points = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                int weight = Integer.parseInt(parts[2]);
                points.add(new Point(x, y, weight));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return points;
    }
}

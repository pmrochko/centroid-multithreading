package com.mrochko;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Pavlo Mrochko
 */
@Getter
@Setter
@ToString
public class Point {

    private int x;
    private int y;
    private int weight;

    public Point(int x, int y, int weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }

    public static List<Point> generateRandomList(long size) {
        List<Point> points = new ArrayList<>();
        Random random = new Random();
        for (long i = 0; i < size; i++) {
            int x = random.nextInt(201) - 100;    // random from -100 to 100
            int y = random.nextInt(201) - 100;    // random from -100 to 100
            int weight = random.nextInt(50) + 1;  // random from    1 to 50
            points.add(new Point(x, y, weight));
        }
        return points;
    }

}

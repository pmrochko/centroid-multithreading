package com.mrochko;

import com.mrochko.file.PointReader;
import com.mrochko.file.PointWriter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Pavlo Mrochko
 */
public class Main {

    private static final String filePath = "src/main/resources/savePoints.txt";

    public static void main(String[] args) throws InterruptedException {

        Scanner input = new Scanner(System.in);

        System.out.print(
                "\n Оберіть спосіб введення даних:\n" +
                "  Зчитати набір точок з файлу - 1\n" +
                "  Згенерувати випадкові точки - 2\n .."
        );

        int choice = 0;
        while (choice != 1 && choice != 2) {
            choice = input.nextInt();
        }

        List<Point> points = new ArrayList<>();

        // вибір способу введення даних (точок)
        switch (choice) {
            case 1 -> points = PointReader.readPointsFromFile(filePath);
            case 2 -> {
                System.out.print(" Введіть кількість генерованих точок: ");
                BigInteger size = input.nextBigInteger();
                points = Point.generateRandomList(size.longValue());
            }
        }

        // розрахунки центру тяжіння точок з використанням 1, 2 та 4 потоків
        if (!points.isEmpty()) {
            singleThread(points);
            multiThreading(points, 2);
            multiThreading(points, 3);
            multiThreading(points, 4);
            multiThreading(points, 5);
            multiThreading(points, 6);

            // збереження нового набору згенерованих точок у файл
            if (choice == 2) {
                System.out.print("\n Зберегти згенеровані точки у файл?\n" +
                        "  Так - 1\n" +
                        "   Ні - 2\n ..");
                choice = input.nextInt();
                if (choice == 1) PointWriter.writePointsToFile(filePath, points);
            }
        }
    }

    private static void singleThread(List<Point> points) {
        System.out.print("\n [1 Потік]");
        long startTime = System.currentTimeMillis();

        Centroid centroid = Centroid.calculateCentroidWithSingleThread(points);

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println(
                "\n Центр тяжіння знаходиться в точці {" +
                        "x = " + centroid.getX() +
                        ", y = " + centroid.getY() +
                        '}'
        );
        System.out.println(" Час виконання: " + totalTime + " мс");
    }

    private static void multiThreading(List<Point> points, int nThreads) throws InterruptedException {
        if (nThreads < 5)
            System.out.print("\n [" + nThreads + " Потоки]");
        else
            System.out.print("\n [" + nThreads + " Потоків]");

        long startTime = System.currentTimeMillis();

        Centroid centroid = Centroid.calculateCentroid(points, nThreads);

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        assert centroid != null;
        System.out.println(
                "\n Центр тяжіння знаходиться в точці {" +
                        "x = " + centroid.getX() +
                        ", y = " + centroid.getY() +
                        '}'
        );
        System.out.println(" Час виконання: " + totalTime + " мс");
    }

}
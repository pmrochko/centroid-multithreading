package com.mrochko;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavlo Mrochko
 */
@Getter
@AllArgsConstructor
public class Centroid {

    private double x;
    private double y;

    public static Centroid calculateCentroidWithSingleThread(List<Point> points) {
        // розрахунок центру тяжіння
        double centroidX = 0;
        double centroidY = 0;
        double totalWeight = 0;

        // Знаходимо сумарну вагу всіх точок
        for (Point point : points) {
            totalWeight += point.getWeight();
        }

        // Знаходимо координати центра тяжіння за формулою
        for (Point point : points) {
            centroidX += point.getX() * point.getWeight();
            centroidY += point.getY() * point.getWeight();
        }

        centroidX /= totalWeight;
        centroidY /= totalWeight;
        return new Centroid(centroidX, centroidY);
    }

    public static Centroid calculateCentroid(List<Point> points, int numThreads) throws InterruptedException {

        int chunkSize = (int) Math.ceil(points.size() / (double) numThreads);
        List<List<Point>> chunks = new ArrayList<>();
        // розділення списку точок на частини
        for (int i = 0; i < points.size(); i += chunkSize) {
            chunks.add(points.subList(i, Math.min(i + chunkSize, points.size())));
        }

        List<Thread> threads = new ArrayList<>();
        List<CentroidCalculatorThread> calculatorThreads = new ArrayList<>();
        // розподіл частин точок по потокам
        for (List<Point> chunk : chunks) {
            CentroidCalculatorThread thread = new CentroidCalculatorThread(chunk);
            Thread t = new Thread(thread);
            threads.add(t);
            calculatorThreads.add(thread);
            t.start();
        }

        // запуск розрахунків в кожному потоці
        for (Thread thread : threads) {
            thread.join();
        }

        double totalWeight = 0;
        double totalX = 0;
        double totalY = 0;
        // об'єднання результатів
        for (CentroidCalculatorThread calculatorThread : calculatorThreads) {
            totalWeight += calculatorThread.getTotalWeight();
            totalX += calculatorThread.getTotalX();
            totalY += calculatorThread.getTotalY();
        }

        // загальний результат
        if (totalWeight != 0) {
            double centroidX = totalX / totalWeight;
            double centroidY = totalY / totalWeight;
            return new Centroid(centroidX, centroidY);
        }

        return null;
    }

    private static class CentroidCalculatorThread implements Runnable {
        private final List<Point> points;
        private double totalWeight;
        private double totalX;
        private double totalY;

        public CentroidCalculatorThread(List<Point> points) {
            this.points = points;
        }
        public double getTotalWeight() {
            return totalWeight;
        }
        public double getTotalX() {
            return totalX;
        }
        public double getTotalY() {
            return totalY;
        }

        @Override
        public void run() {
            for (Point point : points) {
                totalWeight += point.getWeight();
                totalX += point.getX() * point.getWeight();
                totalY += point.getY() * point.getWeight();
            }
        }
    }

}
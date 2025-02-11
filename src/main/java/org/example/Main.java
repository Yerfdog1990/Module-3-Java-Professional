package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<Float> stockPricesList = new ArrayList<>();

        try(Scanner userInput = new Scanner(System.in)){
            System.out.print("Enter stock prices separated by commas: ");
            String stockPricesString = userInput.nextLine();
            String[] stockPricesArray = stockPricesString.split(",");
            float[] stockPrices = new float[stockPricesArray.length];
            System.out.print("Enter the target price: ");
            int targetPrice = userInput.nextInt();
            System.out.println("Stock prices list: "+stockPricesString);
            for (int i = 0; i < stockPricesArray.length; i++) {
                stockPrices[i] = Float.parseFloat(stockPricesArray[i]);
                stockPricesList.add(stockPrices[i]);
            }
            StockAnalysis stockAnalysis = new StockAnalysis(stockPrices, stockPricesList);
            if (stockAnalysis.countOccurrences(stockPrices, targetPrice) < 0) {
                throw new IllegalArgumentException("Target price not found");
            }else{
                System.out.println("Average Price: " + stockAnalysis.calculateAveragePrice(stockPrices));
                System.out.println("Maximum Price: " + stockAnalysis.findMaximumPrice(stockPrices));
                System.out.println("Minimum Price: " + stockAnalysis.findMinimumPrice(stockPrices));
                System.out.println("Median Price: " + stockAnalysis.findMedianPrice(stockPrices));
                System.out.println("Mode Price: " + stockAnalysis.findModePrice(stockPrices));
                System.out.println("Range Price: " + stockAnalysis.findRangePrice(stockPrices));
                System.out.println("Number of occurrences of " +targetPrice+ " : " + stockAnalysis.countOccurrences(stockPrices, 30));
                System.out.println("Cumulative Sum: " + stockAnalysis.computeCumulativeSum(stockPricesList));
            }
        }
    }
}
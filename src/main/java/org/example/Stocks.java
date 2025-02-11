package org.example;
import java.util.ArrayList;
public interface Stocks {
    float calculateAveragePrice(float[]stockPrices);
    float findMaximumPrice(float[]stockPrices);
    float findMinimumPrice(float[]stockPrices);
    float findMedianPrice(float[]stockPrices);
    float findModePrice(float[]stockPrices);
    float findRangePrice(float[]stockPrices);
    int countOccurrences(float[]stockPrices, int targetPrices);
    ArrayList<Float> computeCumulativeSum(ArrayList<Float> stockPrices);
}

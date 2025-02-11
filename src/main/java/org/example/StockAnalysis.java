package org.example;
import java.util.ArrayList;

public record StockAnalysis(float[] stockPrices, ArrayList<Float> stockPricesList) implements Stocks {
//Parametrized constructor

    @Override
    public float calculateAveragePrice(float[] stockPrices) {
        float sum = 0;
        for (float price : stockPrices) {
            sum += price;
        }
        return sum / stockPrices.length;
    }

    @Override
    public float findMaximumPrice(float[] stockPrices) {
        float maxPrice = stockPrices[0];
        for (float price : stockPrices) {
            if (price > maxPrice) {
                maxPrice = price;
            }
        }
        return maxPrice;
    }

    @Override
    public float findMinimumPrice(float[] stockPrices) {
        float minPrice = stockPrices[0];
        for (float price : stockPrices) {
            if (price < minPrice) {
                minPrice = price;
            }
        }
        return minPrice;
    }

    @Override
    public float findMedianPrice(float[] stockPrices) {
        if (stockPrices.length % 2 == 0) {
            return (stockPrices[stockPrices.length / 2] + stockPrices[stockPrices.length / 2 - 1]) / 2;
        }
        return stockPrices[stockPrices.length / 2];
    }

    @Override
    public float findModePrice(float[] stockPrices) {
        float modePrice = stockPrices[0];
        int maxOccurrences = 0;
        for (float price : stockPrices) {
            int occurrences = 0;
            for (float comparePrice : stockPrices) {
                if (price == comparePrice) {
                    occurrences++;
                }
            }
            if (occurrences > maxOccurrences) {
                maxOccurrences = occurrences;
                modePrice = price;
            }
        }
        return modePrice;
    }

    @Override
    public float findRangePrice(float[] stockPrices) {
        float minPrice = findMinimumPrice(stockPrices);
        float maxPrice = findMaximumPrice(stockPrices);
        return maxPrice - minPrice;
    }

    @Override
    public int countOccurrences(float[] stockPrices, int targetPrices) {
        int count = 0;
        for (float price : stockPrices) {
            if (price == targetPrices) {
                count++;
            }
        }
        return count;
    }

    @Override
    public ArrayList<Float> computeCumulativeSum(ArrayList<Float> stockPrices) {
        ArrayList<Float> cumulativeSum = new ArrayList<>();
        float sum = 0;
        for (float price : stockPrices) {
            sum += price;
            cumulativeSum.add(sum);
        }
        return cumulativeSum;
    }
}

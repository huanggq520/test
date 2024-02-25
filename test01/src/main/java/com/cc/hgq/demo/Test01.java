package com.cc.hgq.demo;

public class Test01 {
    private static final double APPLE_PRICE = 8.0; // 苹果单价
    private static final double STRAWBERRY_PRICE = 13.0; // 草莓单价
    private static final double MANGO_PRICE = 20.0;// 芒果单价
    private static final double DISCOUNT_RATE_STRAWBERRY = 0.8; // 草莓折扣率
    private static final double DISCOUNT_THRESHOLD = 100.0;// 满减阈值
    private static final double DISCOUNT_AMOUNT = 10.0;// 满减金额

    public static double calculateTotalPriceCustomerA(int appleWeight, int strawberryWeight) {
        validateInput(appleWeight, strawberryWeight);
        return appleWeight * APPLE_PRICE + strawberryWeight * STRAWBERRY_PRICE;
    }

    public static double calculateTotalPriceCustomerB(int appleWeight, int strawberryWeight, int mangoWeight) {
        validateInput(appleWeight, strawberryWeight, mangoWeight);
        return appleWeight * APPLE_PRICE + strawberryWeight * STRAWBERRY_PRICE + mangoWeight * MANGO_PRICE;
    }

    public static double calculateTotalPriceCustomerC(int appleWeight, int strawberryWeight, int mangoWeight) {
        validateInput(appleWeight, strawberryWeight, mangoWeight);
        double strawberryPrice = STRAWBERRY_PRICE * DISCOUNT_RATE_STRAWBERRY;
        return appleWeight * APPLE_PRICE + strawberryWeight * strawberryPrice + mangoWeight * MANGO_PRICE;
    }

    public static double calculateTotalPriceCustomerD(int appleWeight, int strawberryWeight, int mangoWeight) {
        validateInput(appleWeight, strawberryWeight, mangoWeight);
        double totalPrice = appleWeight * APPLE_PRICE + strawberryWeight * STRAWBERRY_PRICE + mangoWeight * MANGO_PRICE;
        if (totalPrice >= DISCOUNT_THRESHOLD) {
            totalPrice -= DISCOUNT_AMOUNT;
        }
        return totalPrice;
    }

    private static void validateInput(int... weights) {
        for (int weight : weights) {
            if (weight < 0) {
                throw new IllegalArgumentException("水果重量不能为负数");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("顾客A 购买的水果总价为: " + calculateTotalPriceCustomerA(2, 3));
        System.out.println("顾客B 购买的水果总价为: " + calculateTotalPriceCustomerB(1, 2, 4));
        System.out.println("顾客C 购买的水果总价为: " + calculateTotalPriceCustomerC(3, 5, 2));
        System.out.println("顾客D 购买的水果总价为: " + calculateTotalPriceCustomerD(4, 6, 1));
    }
}

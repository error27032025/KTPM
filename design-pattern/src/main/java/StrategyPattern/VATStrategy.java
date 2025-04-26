package StrategyPattern;

public class VATStrategy implements TaxStrategy {
    @Override
    public double calculateTax(double price) {
        return price * 0.1;
    }
}
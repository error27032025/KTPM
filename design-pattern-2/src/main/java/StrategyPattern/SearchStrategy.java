package StrategyPattern;

import FactoryMethodPattern.Book;

import java.util.List;

public interface SearchStrategy {
    List<Book> search(List<Book> books, String query);
}

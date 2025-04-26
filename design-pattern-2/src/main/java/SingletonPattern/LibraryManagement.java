package SingletonPattern;

import DecoratorPattern.*;
import FactoryMethodPattern.*;
import ObserverPattern.*;
import StrategyPattern.*;

public class LibraryManagement {
    static Book[] books;

    public static void main(String[] args) {
        Library library = Library.getInstance();
        library.registerObserver(new User("An Dep Trai"));
        dataModel();
        for (Book book : books) library.addBook(book);
        System.out.println("\nSearch Results: ");
        new BookSearcher(new SearchByTitle()).search(library.getBooks(), "e")
                .forEach(b -> System.out.println(b.getTitle()));
        System.out.println("\nBorrowing Details:");
        for (Book book : books) {
            System.out.println(new ExtendedBorrowing(new Borrowing(book)).getDetails());
        }
    }
    public static void dataModel() {
        books = new Book[]{
                BookFactory.createBook("audiobook", "Atomic Habits", "James Clear", "Self-help"),
                BookFactory.createBook("ebook", "The Alchemist", "Paulo Coelho", "Fiction"),
                BookFactory.createBook("physical", "Sapiens: A Brief History of Humankind", "Yuval Noah Harari", "History"),
                BookFactory.createBook("audiobook", "Thinking, Fast and Slow", "Daniel Kahneman", "Psychology"),
                BookFactory.createBook("ebook", "The Power of Habit", "Charles Duhigg", "Self-help"),
                BookFactory.createBook("physical", "Educated", "Tara Westover", "Memoir"),
                BookFactory.createBook("audiobook", "Becoming", "Michelle Obama", "Biography"),
                BookFactory.createBook("ebook", "The Silent Patient", "Alex Michaelides", "Thriller"),
                BookFactory.createBook("physical", "Pride and Prejudice", "Jane Austen", "Classic"),
                BookFactory.createBook("audiobook", "Rich Dad Poor Dad", "Robert Kiyosaki", "Finance"),
        };
    }
}
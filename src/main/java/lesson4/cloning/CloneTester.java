package lesson4.cloning;

import lesson2.crossword.A;
import lesson2.crossword.B;

public class CloneTester {
    public static void main(String[] args) throws CloneNotSupportedException {

        Author leo = new Author("Leo Tolstoy");

        Book warAndPeace = new Book("War and Peace", 1825, leo);
        // Book someBook = warAndPeace;
        // someBook.setYear(1984);
        // System.out.println(warAndPeace);

        Book anotherBook = warAndPeace.clone();
        anotherBook.setYear(2023);
        Author author = anotherBook.getAuthor();
        author.setName("George Orwell");
        anotherBook.setAuthor(author);
        //anotherBook.setName("Another");

        System.out.println(anotherBook);
        System.out.println(warAndPeace);

    }
}

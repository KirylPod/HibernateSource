package by.java.hibernate.training;

import by.java.hibernate.training.entity.Book;
import by.java.hibernate.training.entity.Charters;
import org.hibernate.Session;

public class Start {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        for (Book book : new BookHelper().getBooksList()) {
            System.out.println(
                    book.getId() + " | " + book.getName() + " | " + book.getTitle());
        }
        System.out.println("Выбирите номер сборник");
        for (Book book : new BookHelper().getBookList()) {
            System.out.println(
                    book.getId() + " | " + book.getName() + " | " + book.getTitle());
        }

        System.out.println("Выбирите вид работ");
        for (Charters charters : new ChartersHelper().getChartersList()) {
            System.out.println(
                    charters.getId() + " | " + charters.getSection());
        }

    }
}

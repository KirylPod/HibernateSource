package by.java.hibernate.training;

import by.java.hibernate.training.entity.Book;
import by.java.hibernate.training.entity.Charters;
import by.java.hibernate.training.entity.Nzt;
import org.hibernate.Session;

public class Start {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        new BookHelper().getBook(24);

//        for (Book book : new BookHelper().getBooksList()) {
//            System.out.println(
//                    book.getId() + " | " + book.getName() + " | " + book.getTitle());
//        }
//        System.out.println("Выбирите номер сборник");
//        for (Book book : new BookHelper().getBookList()) {
//            System.out.println(
//                    book.getId() + " | " + book.getName() + " | " + book.getTitle());
//        }
//
//        System.out.println("Выбирите вид работ");
//        for (Charters charters : new ChartersHelper().getChartersList()) {
//            System.out.println(
//                    charters.getId() + " | " + charters.getSection());
//        }
//
//        System.out.println("Выбирите вид работ");
//        for (Nzt nzt : new NztHelper().getNztList()) {
//            System.out.println(
//                    nzt.getIndic() + " | " + nzt.getDifficulty() + " | " + nzt.getVal());
//        }

    }
}

package by.java.hibernate.training;

import by.java.hibernate.training.entity.Book;
import org.hibernate.Session;

import javax.persistence.criteria.Selection;
import java.util.Scanner;

public class Start {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
          int operatBook = 24;
//        String operatCharter = "";
//        double xOb, nztB, xMin, xMax, nztMin, nztMax;
        Session session = HibernateUtil.getSessionFactory().openSession();


        for (Book book : new BookHelper().getBookList()) {
            System.out.println(
                    book.getId() + " | " + book.getName() + " | " + book.getTitle());
        }

//        for (Book book : new BookHelper().getBookList()) {
//            System.out.println("Выберите сборник");
//            operatBook = sc.nextInt();
//            System.out.println("Вы выбрали");
//            System.out.println(book.getId() + " | " + book.getName() + " | " + book.getTitle());
//        }
//
//        for (Charters charters : new ChartersHelper().getChartersList()) {
//
//        }



    }
}

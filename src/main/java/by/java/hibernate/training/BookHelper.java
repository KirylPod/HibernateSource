package by.java.hibernate.training;

import by.java.hibernate.training.entity.Book;
import by.java.hibernate.training.entity.Book_;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

public class BookHelper {

    private SessionFactory sessionFactory;

    public BookHelper() {

        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Book> getBookList() {
        // 1 ЭТАП
        Session session = sessionFactory.openSession();  // Открываем сессию для манипуляций с персист объектами

//      session.get(Book.class, 1); // получение объета по Id

        // 2 ЭТАП ПОДГОТОВКИ ЗАПРОСА

        CriteriaBuilder cb = session.getCriteriaBuilder(); // создаем объект-конструктор запросов Criteria API
        CriteriaQuery cq = cb.createQuery(Book.class); // при помощи sq будут формироваться запросы
        Root<Book> root = cq.from(Book.class); // основная таблица, корневой entity (в sql запросе - from)


        cq.select(root).where(cb.equal(root.get(Book_.id), Scan.sc.nextInt()) );

        // 3 ЭТАП ВЫПОЛНЕНИЯ ЗАПРОСА

        Query query = session.createQuery(cq);

        List<Book> bookList = query.getResultList(); // Создаем коллекцию

        session.close();
        return bookList;

    }
}






//    Selection[] selection = {root.get(Book_.id), root.get(Book_.name), root.get(Book_.title)};
//
//    ParameterExpression<String> nameParam = cb.parameter(String.class, "name");
//
//       cq.select(cb.construct(Book.class, selection)).where(cb.like(root.get(Book_.name), nameParam));

//       query.setParameter("name", "СНЗТ%");
package by.java.hibernate.training;

import by.java.hibernate.training.HibernateUtil;
import by.java.hibernate.training.entity.Book;
import by.java.hibernate.training.entity.Book_;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

public class BookHelper {

    private SessionFactory sessionFactory;

    public BookHelper() { sessionFactory = HibernateUtil.getSessionFactory(); }

    public List<Book> getBookList() {
        // 1 ЭТАП
        Session session = sessionFactory.openSession();  // Открываем сессию для манипуляций с персист объектами

        session.get(Book.class, 1); // получение объета по Id

        // 2 ЭТАП ПОДГОТОВКИ ЗАПРОСА

        CriteriaBuilder cb = session.getCriteriaBuilder(); // создаем объект-конструктор запросов Criteria API
        CriteriaQuery cq = cb.createQuery(Book.class); // при помощи sq будут формироваться запросы
        Root<Book> root = cq.from(Book.class); // основная таблица, корневой entity (в sql запросе - from)

        Selection[] selection = {root.get(Book_.ID), root.get(Book_.NAME), root.get(Book_.TITLE)};

        ParameterExpression<String> nameParam = cb.parameter(String.class, "id");

        cq.select(cb.construct(Book.class, selection)).where(cb.like(root.get(Book_.ID), nameParam));

        // 3 ЭТАП ВЫПОЛНЕНИЯ ЗАПРОСА

        Query query = session.createQuery(cq);
        query.setParameter("id", 24);
        List<Book> boolList = query.getResultList(); // Создаем коллекцию
        session.close();
        return boolList;

    }
}

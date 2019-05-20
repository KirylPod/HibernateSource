package by.java.hibernate.training;

import by.java.hibernate.training.entity.Book;
import by.java.hibernate.training.entity.Nzt;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class NztHelper {

    private SessionFactory sessionFactory;

    public NztHelper() {

        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Nzt> getNztList() {
        // 1 ЭТАП
        Session session = sessionFactory.openSession();  // Открываем сессию для манипуляций с персист объектами

        // 2 ЭТАП ПОДГОТОВКИ ЗАПРОСА
        CriteriaBuilder cb = session.getCriteriaBuilder(); // создаем объект-конструктор запросов Criteria API
        CriteriaQuery cq = cb.createQuery(Nzt.class); // при помощи sq будут формироваться запросы
        Root<Nzt> root = cq.from(Nzt.class); // основная таблица, корневой entity (в sql запросе - from)

        cq.select(root);

        // 3 ЭТАП ВЫПОЛНЕНИЯ ЗАПРОСА
        Query query = session.createQuery(cq);
        List<Nzt> nztList = query.getResultList(); // Создаем коллекцию
        session.close();
        return nztList;

    }
}

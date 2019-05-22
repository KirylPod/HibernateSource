package by.java.hibernate.training;

import by.java.hibernate.training.entity.Book;
import by.java.hibernate.training.entity.Charters;
import by.java.hibernate.training.entity.Charters_;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ChartersHelper {

    private SessionFactory sessionFactory;

    public ChartersHelper() {

        sessionFactory = HibernateUtil.getSessionFactory();
}

    public List<Charters> getChartersList() {
        // 1 ЭТАП
        Session session = sessionFactory.openSession();  // Открываем сессию для манипуляций с персист объектами

        // 2 ЭТАП ПОДГОТОВКИ ЗАПРОСА
        CriteriaBuilder cb = session.getCriteriaBuilder(); // создаем объект-конструктор запросов Criteria API
        CriteriaQuery cq = cb.createQuery(Charters.class); // при помощи sq будут формироваться запросы
        Root<Charters> root = cq.from(Charters.class); // основная таблица, корневой entity (в sql запросе - from)

        cq.select(root);

        // 3 ЭТАП ВЫПОЛНЕНИЯ ЗАПРОСА
        Query query = session.createQuery(cq);
        List<Charters> chartersList = query.getResultList(); // Создаем коллекцию
        session.close();
        return chartersList;

    }

//    public Charters getCharters (){
//
//        Session session = sessionFactory.openSession();
//
//        Charters charters = session.get(Charters.class);
//
//
//    }
}

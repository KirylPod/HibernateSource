package by.java.hibernate.training;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    public static SessionFactory sessionFactory; // объявление переменной sessionFactory настройка и работа с сессией (фабрика сессий)

    static {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder() // объявление переменной registry для получение реесотров сервисов
                .configure()  //настройки с hibernate.cfg.xml
                .build();     // проинициализируем (собираем)

        try {
            // MetadataSources - для работы с метаданными, маппинг объектов
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        }
        catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);  // Если что-то не так, то разрушаем (удаляем)
            System.out.println("Проверьте hibernate.cfg.xml");
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;

    }
}

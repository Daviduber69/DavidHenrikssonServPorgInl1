import com.fasterxml.classmate.AnnotationOverrides;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.w3c.dom.ls.LSOutput;
import se.yrgo.domain.Student;
import se.yrgo.domain.Tutor;

import java.util.Map;
import java.util.Set;


public class HibernateTest {
    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Tutor tutor = new Tutor("1337DH","David Henriksson",42000);
        Student student1 = new Student("Bosse Hanssoon",10);
        Student student2 = new Student("Lena Handen",5);
        Student student3 = new Student("Pelle Perkele",69);

        tutor.addStudentToTeachingGroup(student1);
        tutor.addStudentToTeachingGroup(student2);
        tutor.addStudentToTeachingGroup(student3);

        session.save(tutor);
        session.save(student1);
        session.save(student2);
        session.save(student3);

        //i mitt lokala fall är ID:t för Tutor 32 men kanske skiljer sig för dig när du kör :)
        Tutor myTutor = session.get(Tutor.class,32);

        myTutor.getTeachingGroup().forEach(System.out::println);


        tx.commit();
        session.close();


    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration config = new Configuration();
            config.configure();
            sessionFactory = config.buildSessionFactory();
        }
        return sessionFactory;
    }
}

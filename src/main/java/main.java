import EjbPrac.DatabaseConnection;
import model.Student;

import javax.persistence.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class main {
//    private static EntityManager entityManager;
//    private static EntityManagerFactory emf;
    private static Connection connection_d=null;
    public static void  main(String[] args) throws IOException, InterruptedException, SQLException {
//        Connection conn= DatabaseConnection.getConnection();
//        if(conn==null) System.out.println("Connection unsuccess");
//        else System.out.println("success");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("student_pu");
        EntityManager entityManager= emf.createEntityManager();

//        EntityTransaction entityTransaction=entityManager.getTransaction();
//        entityTransaction.begin();
//        Student student=new Student();
//        student.setFirstName("Fahim");
//        student.setLastName("Rasahd");
//        student.setCgpa(3);
//
//        Student student1=new Student();
//        student1.setFirstName("Fahim2");
//        student1.setLastName("Rasahd2");
//        student1.setCgpa(4);
//
//        entityManager.persist(student);
//        entityManager.persist(student1);
//        entityTransaction.commit();


        Student student=entityManager.find(Student.class,5L);
        if(student!=null){
            System.out.println(student.toString());
        }



//        EntityTransaction entityTransaction=entityManager.getTransaction();
//        entityTransaction.begin();
//        Student student=entityManager.find(Student.class,1L);
////        student.setFirstName("ALan");
////        student.setLastName("bold");
//        entityManager.remove(student);
//        Student student1=entityManager.find(Student.class,2L);
//        entityManager.remove(student1);
//        entityTransaction.commit();


//        Query query = entityManager.createQuery("Select s.firstName from Student s");
//        List<String> students=query.getResultList();
//
//        for(String studentFirstName:students){
//            System.out.println(studentFirstName);
//        }
        entityManager.close();
        emf.close();
    }

}

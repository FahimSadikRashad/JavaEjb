package EjbPrac;

import model.Student;

import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Local(WelcomeMsg.class)
@Stateful
public class WelcomeMsgBean implements WelcomeMsg{
    @Override
    public String returnWelcomeMsg() {

//        String driver="com.mysql.cj.jdbc.Driver";
//        String databaseUrl="jdbc:mysql://localhost:3307/shopcart";
//        String user="root";
//        String password="";
////        try {
////            Class.forName(driver);
////        } catch (ClassNotFoundException e) {
////            throw new RuntimeException(e);
////        }
//        Connection conn= null;
//        try {
//            conn = DriverManager.getConnection(databaseUrl,user,password);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
/*
        Connection conn= DatabaseConnection.getConnection();
        return "This is the new ejb test";
*/
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("student_pu");
        EntityManager entityManager= emf.createEntityManager();

        EntityTransaction entityTransaction=entityManager.getTransaction();
//        entityTransaction.begin();
//        Student student=new Student();
//        student.setFirstName("Fahim");
//        student.setLastName("Rasahd");
//
//        entityManager.persist(student);
        Student student=entityManager.find(Student.class,5L);
        return student.toString();
//        entityTransaction.commit();
//        if(conn==null) return "fail";
//        else return "success";
    }
}

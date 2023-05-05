package Assignment;

import model.Student;
import model.StudentNew;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/student")
public class StudentBean {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String addStudent(@QueryParam("name") String nm,@QueryParam("id") int sid,@QueryParam("section") String sec,@QueryParam("cgpa") double cg){
        String temp="";
        temp+=(sid+" "+nm+" "+sec+" "+cg+" ");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("student_pu");
        EntityManager entityManager= emf.createEntityManager();

        EntityTransaction entityTransaction=entityManager.getTransaction();
        entityTransaction.begin();
        StudentNew student=new StudentNew();
        student.setId(sid);
        student.setName(nm);
        student.setSection(sec);
        student.setCgpa(cg);


        entityManager.persist(student);
        entityTransaction.commit();

        return temp;
    }
    public StudentNew findById(int id) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("student_pu");
        EntityManager entityManager= emf.createEntityManager();

        Query query = entityManager.createNamedQuery("find student by id");
        query.setParameter("id", id);
        return (StudentNew) query.getSingleResult();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getName(@PathParam("id") int studentId){
        String temp="Id received " ;
        temp+=studentId;
        return findById(studentId).getName();
    }
    @GET
    @Path("/hcg")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHighestCg(@QueryParam("id1") int id_1,@QueryParam("id2") int id_2 ){
        String temp="The highest cgpa is";
        temp+=(id_1+" "+id_2);
        StudentNew studentNew_1=findById(id_1);
        StudentNew studentNew_2=findById(id_2);
        if(studentNew_1.getCgpa()>studentNew_2.getCgpa()) return studentNew_1.toString();
        else return studentNew_2.toString();

    }

    @GET
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public String updateEntry(@QueryParam("id") int sid,@QueryParam("name") String nm ){
        String temp="Update the entry of";
        temp+=(sid+" "+nm);


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("student_pu");
        EntityManager entityManager= emf.createEntityManager();
        EntityTransaction entityTransaction=entityManager.getTransaction();
        entityTransaction.begin();
        StudentNew student=entityManager.find(StudentNew.class,sid);
        student.setName(nm);
        entityTransaction.commit();
        return temp;
    }
}

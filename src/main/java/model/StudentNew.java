package model;

import javax.persistence.*;

@Entity
@Table
//@NamedNativeQuery(name = "StudentNew.findHighestCGPA", query = "SELECT * FROM studentnew WHERE id = ?", resultClass = StudentNew.class)
@NamedQuery(name = "find student by id" ,query = "Select s from StudentNew  s where s.id = :id")
@NamedQuery(name = "find student by cg" ,query = "Select s from StudentNew  s where s.cgpa = (select max(cgpa) from StudentNew )")
public class StudentNew {
    @Id
    @Column(name = "id")
    private  int id;
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "section", nullable = false, length = 150)
    private String section;

    @Column(name = "cgpa")
    private double cgpa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", Section='" + section + '\'' +
                ", Cgpa='" + cgpa +'\''+
                '}';
    }
}

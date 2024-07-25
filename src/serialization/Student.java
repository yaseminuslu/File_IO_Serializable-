package serialization;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID=1L;
    private String name;
    private String surname;
    private Course course;

    public Student(String name, String surname, Course course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", course=" + course +
                '}';
    }
}

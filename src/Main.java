import java.time.LocalDate;

import br.com.dio.desafio.dominio.Contents;
import br.com.dio.desafio.dominio.Course;
import br.com.dio.desafio.dominio.Mentorship;

public class Main {
    public static void main(String[] args) {
        Course course1 = new Course();
        course1.setTitle("Java Course");
        course1.setDescription("Java course description");
        course1.setWorkload(8);

        Course course2 = new Course();
        course2.setTitle("JavaScript Course");
        course2.setDescription("JavaScript course description");
        course2.setWorkload(4);

        Mentorship mentorship = new Mentorship();
        mentorship.setTitle("Java Mentoring");
        mentorship.setDescription("Java mentoring description");
        mentorship.setData(LocalDate.now());

        System.out.println(course1);
        System.out.println(course2);
        System.out.println(mentorship);
    }
}

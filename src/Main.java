import java.time.LocalDate;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Contents;
import br.com.dio.desafio.dominio.Course;
import br.com.dio.desafio.dominio.Dev;
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

        // System.out.println(course1);
        // System.out.println(course2);
        // System.out.println(mentorship);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setName("Bootcamp Java Developer");
        bootcamp.setDescription("Bootcamp Java Developer description");
        bootcamp.getContents().add(course1);
        bootcamp.getContents().add(course2);
        bootcamp.getContents().add(mentorship);

        Dev devOne = new Dev();
        devOne.setName("One");
        devOne.subscribeBootcamp(bootcamp);
        System.out.println("Subscribed Contents One: " + devOne.getSubscribedContent());
        devOne.progress();
        devOne.progress();
        System.out.println("-");
        System.out.println("Subscribed Contents One: " + devOne.getSubscribedContent());
        System.out.println("Concluded Contents One: " + devOne.getConcludedContents());
        System.out.println("XP: " + devOne.calculateTotalXp());

        System.out.println("---------------");

        Dev devTwo = new Dev();
        devTwo.setName("Two");
        devTwo.subscribeBootcamp(bootcamp);
        System.out.println("Subscribed Contents Two: " + devTwo.getSubscribedContent());
        devTwo.progress();
        devTwo.progress();
        devTwo.progress();
        System.out.println("-");
        System.out.println("Subscribed Contents Two: " + devTwo.getSubscribedContent());
        System.out.println("Concluded Contents Two: " + devTwo.getConcludedContents());
        System.out.println("XP: " + devTwo.calculateTotalXp());

    }
}

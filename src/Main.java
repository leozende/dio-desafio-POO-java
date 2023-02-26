import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.jar.Attributes.Name;

import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument.Content;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.ChangeInformation;
import br.com.dio.desafio.dominio.Contents;
import br.com.dio.desafio.dominio.Course;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentorship;
import br.com.dio.desafio.dominio.Organizer;


public class Main {

    private static final String BOOTCAMP = "Bootcamp";
    private static final String COURSE = "Course";
    private static final String MENTORING = "Mentoring";

    private static Set<Course> courseList = new LinkedHashSet<>();
    private static Set<Mentorship> mentorList = new LinkedHashSet<>();
    private static Set<Bootcamp> bootcampList = new LinkedHashSet<>();
    

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.println("What are you, a student or organizer? (Write leave if you want to finish the program) ");
            String answer = scan.nextLine();
            if(answer.equalsIgnoreCase("organizer")) {
                loading();
                System.out.println("---------------------------");
                organizeBootcamp(scan);
            } else if (answer.equalsIgnoreCase("student")) {
                loading();
                System.out.println("---------------------------");
                isRegister(scan);
            } else if(answer.equalsIgnoreCase("leave")) {
                break; 
            } else {
                loading();
                System.out.println("Invalid answer, please try again...");
            }
        }



        // System.out.println(course1);
        // System.out.println(course2);
        // System.out.println(mentorship);

        /*Dev devOne = new Dev();
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
        System.out.println("XP: " + devTwo.calculateTotalXp());*/

                    /*Course course = new Course();
            course.setTitle();
            course.setDescription("Java course description");
            course.setWorkload(8); */
        
        /*Bootcamp bootcamp = new Organizer();
        bootcamp.setName("Bootcamp Java Developer");
        bootcamp.setDescription("Bootcamp Java Developer description");
        bootcamp.getContents().add(course1);
        bootcamp.getContents().add(course2);
        bootcamp.getContents().add(mentorship);*/

    }

    private static void organizeBootcamp(Scanner scan) {
        while(true) {
            System.out.println("What you want to do? Create a bootcamp or modify one? (Write leave if you want to get out)");
            String answer = scan.nextLine();
            if(answer.equalsIgnoreCase("create")) {
                loading();
                System.out.println("---------------------------");
                createBootcamp(scan);
            } else if (answer.equalsIgnoreCase("modify")) {
                loading();
                System.out.println("---------------------------");
                modifyBootcamp(scan);
            } else if(answer.equalsIgnoreCase("leave")) {
                break; 
            } else {
                loading();
                System.out.println("Invalid answer, please try again...");
            }
        }
    }

    private static void createBootcamp(Scanner scan) {
        String bootcampName = ChangeInformation.changeName(scan, BOOTCAMP);
        loading();
        System.out.println("---------------------------");
        String bootcampDescription = ChangeInformation.changeDescription(scan, BOOTCAMP);
        
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setName(bootcampName);
        bootcamp.setDescription(bootcampDescription);
        
        loading();
        System.out.println("---------------------------");
        whichContent(scan, bootcamp);
        bootcampList.add(bootcamp);
    }

    private static void whichContent(Scanner scan, Bootcamp bootcamp) {
        while(true) {
            System.out.println("Do you want to create or choose ready-made content? (Write leave if you want to get out) ");
            String answer = scan.nextLine();
            if(answer.equalsIgnoreCase("create")) {
                loading();
                System.out.println("---------------------------");
                createContent(scan, bootcamp);
            } else if (answer.equalsIgnoreCase("choose")) {
                loading();
                System.out.println("---------------------------");
                chooseContent(scan, bootcamp);
            } else if(answer.equalsIgnoreCase("leave")) {
                break;
            } else {
                loading();
                System.out.println("Invalid answer, please try again...");
            }
        }
    }

    private static void createContent(Scanner scan, Bootcamp bootcamp) {
        while(true) {
            System.out.println("Do you want to create a new course or a mentorship? (Write leave if you want to get out)");
            String answer = scan.nextLine();
            if(answer.equalsIgnoreCase("course")) {
                loading();
                System.out.println("---------------------------");
                Course createCourse = createCourse(scan);
                bootcamp.getContents().add(createCourse);
                break;
            } else if (answer.equalsIgnoreCase("mentorship")) {
                loading();
                System.out.println("---------------------------");
                Mentorship createMentorship = createMentorship(scan);
                bootcamp.getContents().add(createMentorship);
                break;
            } else if(answer.equalsIgnoreCase("leave")) {
                break; 
            } else {
                loading();
                System.out.println("Invalid answer, please try again...");
            }
        }
    }

    private static Course createCourse(Scanner scan) {
        String name =  ChangeInformation.changeName(scan, COURSE);
        loading();
        System.out.println("---------------------------");
        String description =  ChangeInformation.changeDescription(scan, COURSE);
        loading();
        System.out.println("---------------------------");
        Integer workload = ChangeInformation.changeWorkload(scan);

        Course course = new Course();
        course.setTitle(name);
        course.setDescription(description);
        course.setWorkload(workload);
        courseList.add(course);

        return course;
    }

    private static Mentorship createMentorship(Scanner scan) {
        String name =  ChangeInformation.changeName(scan, MENTORING);
        loading();
        System.out.println("---------------------------");
        String description =  ChangeInformation.changeDescription(scan, MENTORING);

        Mentorship mentorship = new Mentorship();
        mentorship.setTitle(name);
        mentorship.setDescription(description);
        mentorship.setData(LocalDate.now());
        mentorList.add(mentorship);

        return mentorship;
    }

    private static void chooseContent(Scanner scan, Bootcamp bootcamp) {
        while(true) {
            System.out.println("What content do you want to choose? A course or a mentorship? (Write leave if you want to get out)");
            String answer = scan.nextLine();
            if(answer.equalsIgnoreCase("course")) {
                loading();
                System.out.println("---------------------------");
                Course chooseCourse = chooseCourse(scan);
                bootcamp.getContents().add(chooseCourse);
                break;
            } else if (answer.equalsIgnoreCase("mentorship")) {
                loading();
                System.out.println("---------------------------");
                Mentorship chooseMentorship = chooseMentorship(scan);
                bootcamp.getContents().add(chooseMentorship);
                break;
            } else if(answer.equalsIgnoreCase("leave")) {
                break; 
            } else {
                loading();
                System.out.println("Invalid answer, please try again...");
            }
        }
    }

    private static Course chooseCourse(Scanner scan) {
        while(true) {
            if (courseList.isEmpty()) {
                System.out.println("There is no courses.");
                return null;
            }

            System.out.println("Choose the course you want from those on the list: (Write leave if you want to get out)");
            courseList.forEach(t -> System.out.println("Name : " + t.getTitle() + "\nDescription : " + t.getDescription() + "\nWorkload : " + t.getWorkload()));

            String answer = scan.nextLine();

            Iterator<Course> iterator = courseList.iterator();
            while(iterator.hasNext()) {
                Course course = iterator.next();
                if(course.getTitle().equalsIgnoreCase(answer))
                    return course;
                else if(answer.equalsIgnoreCase("leave"))
                    return null;
                }
                System.out.println("Invalid answer, please try again...");
            }
    }

    private static Mentorship chooseMentorship(Scanner scan) {
        while(true) {
            if (mentorList.isEmpty()) {
                System.out.println("There is no mentoring.");
                return null;
            }

            System.out.println("Choose the mentoring you want from those on the list: (Write leave if you want to get out)");
            mentorList.forEach(t -> System.out.println("Name : " + t.getTitle() + "\nDescription : " + t.getDescription()));

            String answer = scan.nextLine();

            Iterator<Mentorship> iterator = mentorList.iterator();
            while(iterator.hasNext()) {
                Mentorship mentor = iterator.next();
                if(mentor.getTitle().equalsIgnoreCase(answer))
                    return mentor;
                else if(answer.equalsIgnoreCase("leave"))
                    return null;
            }
            System.out.println("Invalid answer, please try again...");
        }
    }

    private static void modifyBootcamp(Scanner scan) {
        while(true) {
            boolean confirm = false;

            if (bootcampList.isEmpty()) {
                System.out.println("There is no Bootcamps.");
                break;
            }

            System.out.println("Choose the Bootcamp you want to modify from those on the list: (Write leave if you want to get out)");
            System.out.println("--------------------------------------------------------");
            for (Bootcamp readBootcamp : bootcampList) {
                System.out.println("Name : " + readBootcamp.getName() + "\nDescription : " + readBootcamp.getDescription() + "\nInicial Date : " + readBootcamp.getInitialDate() + "\nFinal Date : " + readBootcamp.getFinalDate() + "\nContents : ");
                Iterator<Contents> iterator = readBootcamp.getContents().iterator();
                while(iterator.hasNext()) {
                    if(iterator != null)
                        System.out.println(iterator.next());
                }
                System.out.println("--------------------------------------------------------");
            }
            
            String answer = scan.nextLine();
            if(answer.equalsIgnoreCase("leave"))
                break;

            Iterator<Bootcamp> iterator = bootcampList.iterator();
            while(iterator.hasNext()) {
                Bootcamp bootcamp = iterator.next();
                if(bootcamp.getName().equalsIgnoreCase(answer)){
                    eraseOrChange(scan, bootcamp);
                    confirm = true;
                    }
                }
                if(!confirm)
                    System.out.println("Invalid answer, please try again...");
            }
    }

    private static void eraseOrChange(Scanner scan, Bootcamp bootcamp) {
        Bootcamp newBootcamp;
        while(true) {
            System.out.println("Do you want to change or erase the bootcamp?(Write leave if you want to get out) ");
            String answer = scan.nextLine();
            if(answer.equalsIgnoreCase("change")) {
                newBootcamp = bootcamp;
                bootcampList.remove(bootcamp);
                whatChange(scan, newBootcamp);
                bootcampList.add(newBootcamp);
                break;
            } else if (answer.equalsIgnoreCase("erase")) {
                bootcampList.remove(bootcamp);
                break;
            } else if (answer.equalsIgnoreCase("leave")) {
                break;
            } else {
                loading();
                System.out.println("Invalid answer, please try again...");
            }
        }
    }

    private static Bootcamp whatChange(Scanner scan, Bootcamp bootcamp) {
        loading();
        Boolean chooseOptions = true;

        
        do{
            System.out.println("Bootcamp Informations: ");
            System.out.println("Name : " + bootcamp.getName() + "\nDescription : " + bootcamp.getDescription() + "\nContents : ");
            Iterator<Contents> iterator = bootcamp.getContents().iterator();
                while(iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            System.out.println("--------------------------------------------------------");
            System.out.println("What do you want to change? (Write leave if you want to get out)");
            String answer = scan.nextLine().toLowerCase();
            
            switch (answer) {
                case "name":
                    loading();
                    String newName = ChangeInformation.changeName(scan, BOOTCAMP);
                    bootcamp.setName(newName);
                    break;
                case "description":
                    loading();
                    String newDescription = ChangeInformation.changeDescription(scan, BOOTCAMP);
                    bootcamp.setDescription(newDescription);
                    break;    
                case "contents":
                    loading();
                    changeContent(scan, bootcamp);
                    break;
                case "leave":
                    chooseOptions = false;
                    break;

                default:
                    loading();
                    System.out.println("Invalid Answer, try again.");
                    System.out.println("---------------------------");
            }
        } while(chooseOptions);
        return bootcamp;
    }

    private static void changeContent(Scanner scan, Bootcamp bootcamp) {
        System.out.println("Bootcamp Contents : ");
        Iterator<Contents> iterator = bootcamp.getContents().iterator();
                while(iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
        System.out.println("--------------------------------------------------------");

        while(true) {
            System.out.println("Do you want to modify, add or erase a content from the bootcamp? (Write leave if you want to get out) ");
            String answer = scan.nextLine();
            if(answer.equalsIgnoreCase("add")) {
                whichContent(scan, bootcamp);
            } else if (answer.equalsIgnoreCase("modify")) {
                modifyContent(scan, bootcamp);
            } else if(answer.equalsIgnoreCase("erase")) {
                eraseContent(scan, bootcamp);
            } else if (answer.equalsIgnoreCase("leave")) {
                break;
            } else {
                loading();
                System.out.println("Invalid answer, please try again...");
            }
        }
    }

    private static void modifyContent(Scanner scan, Bootcamp bootcamp) {
        loading();
        while(true) {
            System.out.println("What content do you want to modify? A course or a mentorship? (Write leave if you want to get out)");
            String answer = scan.nextLine();
            if(answer.equalsIgnoreCase("course")) {
                Course chooseCourse = chooseBootcampCourse(scan, bootcamp);
                modifyCourse(scan, chooseCourse);
                bootcamp.getContents().add(chooseCourse);
                break;
            } else if (answer.equalsIgnoreCase("mentorship")) {
                Mentorship chooseMentorship = chooseBootcampMentorship(scan, bootcamp);
                modifyMentor(scan, chooseMentorship);
                bootcamp.getContents().add(chooseMentorship);
                break;
            } else if(answer.equalsIgnoreCase("leave")) {
                break; 
            } else {
                loading();
                System.out.println("Invalid answer, please try again...");
            }
        }
    }

    private static Course chooseBootcampCourse(Scanner scan, Bootcamp bootcamp) {
        loading();
        while(true) {
            System.out.println("Choose the course you want from those on the list: (Write leave if you want to get out)");
            Iterator<Course> iterator = courseList.iterator();
            while(iterator.hasNext()) {
                Course course = iterator.next();
                if (!bootcamp.getContents().contains(course)) {
                    System.out.println("There is no courses.");
                    return null;
                } else if (bootcamp.getContents().contains(course)) {
                    System.out.println(course.getTitle() + " - " + course.getDescription() + " - " + course.getWorkload());
                }
            }
            String answer = scan.nextLine();

            Iterator<Course> iterator1 = courseList.iterator();
            while(iterator1.hasNext()) {
                Course course = iterator1.next();
                if(course.getTitle().equalsIgnoreCase(answer) && bootcamp.getContents().contains(course))
                    return course;
                else if(answer.equalsIgnoreCase("leave"))
                    return null;
                }
                System.out.println("Invalid answer, please try again...");
        }
    }

    private static Mentorship chooseBootcampMentorship(Scanner scan, Bootcamp bootcamp) {
        loading();
        while(true) {
            System.out.println("Choose the course you want from those on the list: (Write leave if you want to get out)");
            Iterator<Mentorship> iterator = mentorList.iterator();
            while(iterator.hasNext()) {
                Mentorship mentorship = iterator.next();
                if (!bootcamp.getContents().contains(mentorship)) {
                    System.out.println("There is no courses.");
                    return null;
                } else if (bootcamp.getContents().contains(mentorship)) {
                    System.out.println(mentorship.getTitle() + " - " + mentorship.getDescription());
                }
            }
            String answer = scan.nextLine();

            Iterator<Mentorship> iterator1 = mentorList.iterator();
            while(iterator1.hasNext()) {
                Mentorship mentorship = iterator1.next();
                if(mentorship.getTitle().equalsIgnoreCase(answer) && bootcamp.getContents().contains(mentorship))
                    return mentorship;
                else if(answer.equalsIgnoreCase("leave"))
                    return null;
                }
                System.out.println("Invalid answer, please try again...");
        }
    }

    private static Course modifyCourse(Scanner scan, Course course) {
        loading();
        Boolean chooseOptions = true;
        do{
            System.out.println("What do you want to modify? Name, Description or Workload? (Write leave if you want to get out)");
            String answer = scan.nextLine().toLowerCase();
            
            switch (answer) {
                case "name":
                    loading();
                    String newName = ChangeInformation.changeName(scan, COURSE);
                    course.setTitle(newName);
                    break;
                case "description":
                    loading();
                    String newDescription = ChangeInformation.changeDescription(scan, COURSE);
                    course.setDescription(newDescription);
                    break;    
                case "workload":
                    loading();
                    Integer newWorkload = ChangeInformation.changeWorkload(scan);
                    course.setWorkload(newWorkload);
                    break;
                case "leave":
                    chooseOptions = false;
                    break;

                default:
                    loading();
                    System.out.println("Invalid Answer, try again.");
                    System.out.println("---------------------------");
            }
        } while(chooseOptions);
        return course;
    }

    private static Mentorship modifyMentor(Scanner scan, Mentorship mentor) {
        loading();
        Boolean chooseOptions = true;
        do{
            System.out.println("What do you want to modify? Name or Description? (Write leave if you want to get out)");
            String answer = scan.nextLine().toLowerCase();
            
            switch (answer) {
                case "name":
                    loading();
                    String newName = ChangeInformation.changeName(scan, MENTORING);
                    mentor.setTitle(newName);
                    break;
                case "description":
                    loading();
                    String newDescription = ChangeInformation.changeDescription(scan, MENTORING);
                    mentor.setDescription(newDescription);
                    break;    
                case "leave":
                    chooseOptions = false;
                    break;

                default:
                    loading();
                    System.out.println("Invalid Answer, try again.");
                    System.out.println("---------------------------");
            }
        } while(chooseOptions);
        return mentor;
    }

    private static void eraseContent(Scanner scan, Bootcamp bootcamp) {
        loading();
        while(true) {
            System.out.println("What content do you want to erase? A course or a mentorship? (Write leave if you want to get out)");
            String answer = scan.nextLine();
            if(answer.equalsIgnoreCase("course")) {
                Course chooseCourse = chooseBootcampCourse(scan, bootcamp);
                bootcamp.getContents().remove(chooseCourse);
                break;
            } else if (answer.equalsIgnoreCase("mentorship")) {
                Mentorship chooseMentorship = chooseBootcampMentorship(scan, bootcamp);
                bootcamp.getContents().remove(chooseMentorship);
                break;
            } else if(answer.equalsIgnoreCase("leave")) {
                break; 
            } else {
                loading();
                System.out.println("Invalid answer, please try again...");
            }
        }
    }

    private static void isRegister(Scanner scan) {

        while(true) {
            if (bootcampList.isEmpty()) {
                System.out.println("There is no Bootcamps.");
                break;
            }
            System.out.println("Are you already registered? Answer with yes or no. (Write leave if you want to get out)");
            String answer = scan.nextLine();
            if(answer.equalsIgnoreCase("yes")) {
                loading();
                System.out.println("---------------------------");
                System.out.println("Select one of the options bellow: ");
                break;
            } else if (answer.equalsIgnoreCase("no")) {
                loading();
                System.out.println("---------------------------");
                firstRegister(scan);
                break;
            } else if(answer.equalsIgnoreCase("leave")) {
                break; 
            } else {
                loading();
                System.out.println("---------------------------");
                System.out.println("Invalid answer, please try again...");
            }
        }
    }

    private static void firstRegister(Scanner scan) {
        System.out.println("You need to register!");

        System.out.print("Write your name: ");
        String name = scan.nextLine();
        
        Dev newDev = new Dev(null, null);
        bootcampRegister(scan);

        System.out.println("Registration completed, your information : ");

    }

    private static Bootcamp bootcampRegister(Scanner scan) {
        while (true) {
            System.out.print("\nSelect the bootcamp do you want to register: \n");
            Iterator<Bootcamp> iterator = bootcampList.iterator();
            while(iterator.hasNext()) {
                Bootcamp bootcamp = iterator.next();
                System.out.println("Name : " + bootcamp.getName() + "\nDescription : " + bootcamp.getDescription() + "\nContents : ");
                Iterator<Contents> iterator1 = bootcamp.getContents().iterator();
                    while(iterator1.hasNext()) {
                        System.out.println(iterator1.next());
                    }
                System.out.println("---------------------------");
            }
            System.out.println("---------------------------");

            String answer = scan.nextLine();

            Iterator<Bootcamp> iterator2 = bootcampList.iterator();
            while(iterator.hasNext()) {
                Bootcamp bootcamp = iterator2.next();
                if(bootcamp.getName().equalsIgnoreCase(answer))
                    return bootcamp;
                else if(answer.equalsIgnoreCase("leave"))
                    return null;
                }
            System.out.println("Invalid answer, please try again...");
        }
    }
        /*Map<Integer,Dev> newDev = new HashMap<>() {{
            put(newDev.size() + 1, new Dev(name, bootcamp ));
        }};
        

        devOne.setName("One");
        devOne.subscribeBootcamp(bootcamp);
        System.out.println("Subscribed Contents One: " + devOne.getSubscribedContent());
        devOne.progress();
        devOne.progress();
        System.out.println("-");
        System.out.println("Subscribed Contents One: " + devOne.getSubscribedContent());
        System.out.println("Concluded Contents One: " + devOne.getConcludedContents());
        System.out.println("XP: " + devOne.calculateTotalXp());
        
        Dev devRegister = new Dev();*/

    private static void loading() {
        System.out.print("Loading");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(100);
                System.out.print(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("");
    }

}

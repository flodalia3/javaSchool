package it.accenture.school.ui;

import it.accenture.school.data.SchoolRepository;
import it.accenture.school.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    public static void main(String[] args) {
        //test methods in here
        Console c = new Console();
        Scanner s = new Scanner(System.in);

        //testing all methods
        SchoolRepository.SchoolDB.populateCourses();
        SchoolRepository.SchoolDB.populateInstructors();
        SchoolRepository.SchoolDB.populateEditions();

        c.printAllCourses();
        //c.printEditions(s);
        //c.printCoursesContainingString(s);
        //c.printInstructor(s);
        //c.printExpertInstructor(s);
        //c.insertInstructor(s);
        //c.assignInstructor(s);

    }

    public static void printAllCourses(){
        List<Course> courses = SchoolRepository.SchoolDB.getCourses();
        //System.out.println(courses.isEmpty()); //returns true
        //either courses in SchoolDB is empty or line 30 doesn't work
        for(Course c : courses){
            System.out.println(c.toString());
        }
    }

    public void printEditions(Scanner s){
        System.out.println("Insert course id: ");
        long courseId = s.nextLong();
        List<Edition> editions = SchoolRepository.SchoolDB.getEditions();
        for(Edition e : editions){
            if(e.getId() == courseId){
                System.out.println(e.toString());
            }
        }
    }

    public void printCoursesContainingString(Scanner s){ //stringa contenuta nel titolo
        System.out.println("Insert string contained in the course's title: "); //catch exception not contained?
        String portion = s.nextLine();
        List<Course> courses = SchoolRepository.SchoolDB.getCourses();
        for(Course c : courses){
            if(c.getTitle().contains(portion)){ //used String.contains()
                System.out.println(c.toString());
            }
        }
    }

    public void printInstructor(Scanner s){ //non può essere più di uno se associato a edition.id, o no?
        System.out.println("Insert edition id: ");
        long editionId = s.nextLong();
        System.out.println("Insert course area (ALL CAPS): ");
        String areaTemp = s.nextLine();
        Area courseArea = null;
        while(courseArea == null){ //keeps cycling until it receives a valid value
            switch (areaTemp){
                case "GRAPHICS":
                    courseArea = Area.GRAPHICS;
                    break;
                case "OFFICE":
                    courseArea = Area.OFFICE;
                    break;
                case "DEVELOPMENT":
                    courseArea = Area.DEVELOPMENT;
                    break;
                default:
                    System.out.println("Inserted wrong Area type!");
            }
        }
        System.out.println("Insert course level (ALL CAPS): ");
        String levelTemp = s.nextLine();
        Level courseLevel = null;
        while(courseLevel == null){ //keeps cycling until it receives a valid value
            switch (levelTemp){
                case "BASIC":
                    courseLevel = Level.BASIC;
                    break;
                case "ADVANCED":
                    courseLevel = Level.ADVANCED;
                    break;
                case "GURU":
                    courseLevel = Level.GURU;
                    break;
                default:
                    System.out.println("Inserted wrong Level type!");
            }
        }

        List<Edition> editions = SchoolRepository.SchoolDB.getEditions();

        for(Edition e : editions){
            if(e.getId() == editionId) {
                if(e.getCourse().getArea() == courseArea && e.getCourse().getLevel() == courseLevel) {
                    System.out.println(e.getInstructor().toString());
                };
                break;
            }
        }
    }

    public void printExpertInstructor(Scanner s){
        System.out.println("Insert instructor's birth date (format: YYYY-MM-DD): "); //catch exception wrong format
        String birthday = s.nextLine();
        LocalDate ld = LocalDate.parse(birthday);
        List<Instructor> instructors = SchoolRepository.SchoolDB.getInstructors();
        for(Instructor i : instructors){
            if(i.getBirthDate().isAfter(ld) && i.getAreas().size() >= 2){
                System.out.println(i.toString());
            }
        }

    }

    public void insertInstructor(Scanner s){
        System.out.println("Insert instructor's id: ");
        long id = s.nextLong();
        System.out.println("Insert instructor's name: ");
        String name = s.nextLine();
        System.out.println("Insert instructor's surname: ");
        String surname = s.nextLine();
        System.out.println("Insert instructor's birth date (format: YYYY-MM-DD): ");
        String bd = s.nextLine();
        LocalDate birthDate = LocalDate.parse(bd);
        System.out.println("Insert instructor's email: ");
        String email = s.nextLine();
        String areaTemp = "";
        List<Area> areas = new ArrayList<>();
        while(areaTemp != "-1") {
            System.out.println("Insert instructor's areas (insert at least one area, -1 to end cycle): "); //exception min/max to be caught
            areaTemp = s.nextLine();
            if(areaTemp == "-1") {break;}
            switch (areaTemp){
                case "GRAPHICS":
                    areas.add(Area.GRAPHICS);
                    break;
                case "OFFICE":
                    areas.add(Area.OFFICE);
                    break;
                case "DEVELOPMENT":
                    areas.add(Area.DEVELOPMENT);
                    break;
                default:
                    System.out.println("Inserted wrong Area type!");
            }
        }
        Instructor i = new Instructor(id, name, surname, birthDate, email, areas);

    }

    public void assignInstructor(Scanner s){
        System.out.println("Insert instructor's id: ");
        long instructorId = s.nextLong();
        System.out.println("Insert edition id: ");
        long editionId = s.nextLong();
        Instructor instructor = null;
        List<Edition> editions = SchoolRepository.SchoolDB.getEditions();
        List<Instructor> instructors = SchoolRepository.SchoolDB.getInstructors();
        for(Instructor i : instructors){
            if(i.getId() == instructorId) {
                instructor = i;
            }
        }
        for(Edition e : editions){
            if(e.getId() == editionId) {
                e.setInstructor(instructor);
            }
        }
    }
}

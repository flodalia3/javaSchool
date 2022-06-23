package it.accenture.school.ui;

import it.accenture.school.data.SchoolRepository;
import it.accenture.school.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Console {

    public static void main(String[] args) {
        //test methods in here
    }

    public void printAllCourses(){
        List<Course> courses = SchoolRepository.SchoolDB.getCourses();
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
    //String string
    public void printCoursesContainingString(Scanner s){ //stringa contenuta nel titolo
        System.out.println("Insert string contained in the course's title: ");
        String portion = s.nextLine();
        List<Course> courses = SchoolRepository.SchoolDB.getCourses();
        for(Course c : courses){
            if(c.getTitle().contains(portion)){ //used String.contains()
                System.out.println(c.toString());
            }
        }
    }

    public void printInstructors(Scanner s){
        System.out.println("Insert edition id: ");
        long editionId = s.nextLong();
        System.out.println("Insert edition area (ALL CAPS): ");
        String areaTemp = s.nextLine();
        Area editionArea = null;
        while(editionArea == null){ //keeps cycling until it receives a valid value
            switch (areaTemp){
                case "GRAPHICS":
                    editionArea = Area.GRAPHICS;
                    break;
                case "OFFICE":
                    editionArea = Area.OFFICE;
                    break;
                case "DEVELOPMENT":
                    editionArea = Area.DEVELOPMENT;
                    break;
                default:
                    System.out.println("Inserted wrong Area type!");
            }
        }
        System.out.println("Insert edition level (ALL CAPS): ");
        String levelTemp = s.nextLine();
        Level editionLevel = null;
        while(editionLevel == null){ //keeps cycling until it receives a valid value
            switch (levelTemp){
                case "BASIC":
                    editionLevel = Level.BASIC;
                    break;
                case "ADVANCED":
                    editionLevel = Level.ADVANCED;
                    break;
                case "GURU":
                    editionLevel = Level.GURU;
                    break;
                default:
                    System.out.println("Inserted wrong Level type!");
            }
        }

        // DA SMONTARE
        //ISTRUTTORE STA IN EDIZIONE, NON VICEVERSA
        //TROVARE ISTRUTTORE A PARTIRE DA E.ID, E.COURSE.AREA, E.COURSE.LEVEL

        List<Instructor> instructors = SchoolRepository.SchoolDB.getInstructors();
        //getEditions? getCourses?
        for(Instructor i : instructors){
            /*if( ??? ){
                System.out.println(i.toString());
            }

             */
        }
    }
    //LocalDate data
    public void printExpertInstructors(){

    }
    //long instructorId, String name, String surname,
    public void insertInstructor(){

    }

    public void assignInstructor(){

    }


}

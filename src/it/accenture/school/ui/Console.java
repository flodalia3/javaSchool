package it.accenture.school.ui;

import it.accenture.school.data.SchoolRepository;
import it.accenture.school.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Console {

    public static void main(String[] args) {

    }

    public void printCourses(){

        List<Course> courses = SchoolRepository.SchoolDB.getCourses();
        for(Course c : courses){
            System.out.println(c.toString());
        }
    }
    //long courseId
    public void printAllEditions(Scanner s){
        System.out.println("Insert course id: ");
        long idCourse = s.nextLong();

        List<Edition> editions = SchoolRepository.SchoolDB.getEditions();
        for(Edition e : editions){
            if(e.getId()==idCourse){
                System.out.println(e.toString());
            }
        }
    }
    //String string
    public void printAllCourses(){ //stringa contenuta nel titolo

    }
    //long editionId, String area, String level
    public void printAllInstructors(){

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

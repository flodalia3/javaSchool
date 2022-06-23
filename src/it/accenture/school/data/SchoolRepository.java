package it.accenture.school.data;

import it.accenture.school.model.*;

import java.util.ArrayList;
import java.util.List;

public class SchoolRepository {

    public static class SchoolDB{

        private static List<Instructor> instructors = new ArrayList<>();
        private static List<Course> courses = new ArrayList<>();
        private static List<Edition> editions = new ArrayList<>();

        public static List<Course> getCourses(){
            return courses;
        }

        public static List<Edition> getEditions(){
            return editions;
        }

        public static List<Instructor> getInstructors(){
            return instructors;
        }

        public void addInstructor(){

        }

        public void remove(){

        }
    }


}

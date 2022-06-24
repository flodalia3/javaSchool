package it.accenture.school.data;

import it.accenture.school.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SchoolRepository {

    public static class SchoolDB{

        //change to sortedset?
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


        public static List<Course> populateCourses() {
            courses.add(new Course(01,"JavaMeister", 200, Area.DEVELOPMENT, Level.GURU));
            courses.add(new Course(02, "Blender: How To", 250, Area.GRAPHICS, Level.ADVANCED));
            courses.add(new Course(03, "MS Office Best Practices", 100, Area.OFFICE, Level.BASIC));

            return courses;
        }

        public static List<Instructor> populateInstructors(){
            //prepare Area Lists for instructors
            List<Area> fRomano = new ArrayList<>();
            fRomano.add(Area.OFFICE);
            fRomano.add(Area.DEVELOPMENT);
            List<Area> aGallo = new ArrayList<>();
            aGallo.add(Area.GRAPHICS);

            //populate instructors
            instructors.add(new Instructor(01, "Fabio", "Romano", LocalDate.of(1967,5,14), "fromano@fakemail.com", fRomano));
            instructors.add(new Instructor(02, "Andrea", "Gallo", LocalDate.of(1978,11,23), "agallo@fakemail.com", aGallo));

            return instructors;
        }

        public static List<Edition> populateEditions(){
            //populate editions
            editions.add(new Edition(01, courses.get(0), LocalDate.of(2022,9,8), LocalDate.of(2022,10,22), 250, instructors.get(0)));
            editions.add(new Edition(02, courses.get(1), LocalDate.of(2023,3,2), LocalDate.of(2023,4,10), 200, instructors.get(1)));
            editions.add(new Edition(03, courses.get(2), LocalDate.of(2022,10,24), LocalDate.of(2022,11,25), 150, instructors.get(0)));

            return editions;
        }

        //method: sort by id or title? for courses
        //method: sort by id or full name (surname, then name)? for instructors

    }


}

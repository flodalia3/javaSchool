package it.accenture.school.model;

import java.time.LocalDate;

public class Edition {

    long id;
    Course course;
    LocalDate startDate;
    LocalDate endDate;
    double cost;
    Instructor instructor;

    public Edition(long id, Course course, LocalDate startDate, LocalDate endDate, double cost, Instructor instructor){
        this.id = id;
        this.course = course;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
        this.instructor = instructor;
    }

    @Override
    public String toString(){
        String s = "Id: "+this.id+"\n";
        s = s+"Course Id: "+this.course.getId()+"\n";
        s = s+"Course Title: "+this.course.getTitle()+"\n";
        s = s+"Start Date: "+this.startDate.toString()+"\n";
        s = s+"End Date: "+this.endDate.toString()+"\n";
        s = s+"Cost: "+this.cost+"\n";
        s = s+"Instructor's Id: "+this.instructor.getId()+"\n";
        s = s+"Instructor's Name: "+this.instructor.getName()+" "+this.instructor.getSurname()+"\n \n";
        return s;
    }

    public long getId(){
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {this.instructor = instructor;}
}

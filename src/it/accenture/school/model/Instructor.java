package it.accenture.school.model;

import java.time.LocalDate;
//import java.util.ArrayList; //maybe change with list after some tests
import java.util.Iterator;
import java.util.List;

public class Instructor {

    long id;
    String name;
    String surname;
    LocalDate birthDate;
    String email;
    List<Area> areas;

    public Instructor(long id, String name, String surname, LocalDate birthDate, String email, List<Area> areas){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.email = email;
        this.areas = areas;
    }

    @Override
    public String toString(){
        String strA = "";
        for(Iterator<Area> it = this.areas.iterator(); it.hasNext();){
            Area d = it.next();
            if(d == null){
                strA += d.name();
            }
            else {
                strA += d.name() + ", ";
            }
        }

        String s = "Id: "+this.id+"%n";
        s = s+"Name: "+this.name+"%n";
        s = s+"Surname: "+this.surname+"%n";
        s = s+"Birth Date: "+this.birthDate+"%n";
        s = s+"Email: "+this.email+"%n";
        s = s+"Areas: "+ strA+"%n%n";
        return s;
    }

    public long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public LocalDate getBirthDate() {return birthDate;}

    public String getEmail() {return email;}

    public List<Area> getAreas() {return areas;} //changed from arraylist to list, check later!
}

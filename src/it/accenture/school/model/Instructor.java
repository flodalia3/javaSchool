package it.accenture.school.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Instructor {

    long id;
    String name;
    String surname;
    LocalDate birthDate;
    String email;
    ArrayList<Area> areas;

    public Instructor(long id, String name, String surname, LocalDate birthDate, String email, ArrayList<Area> areas){
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
        s = s+"BirthDate: "+this.birthDate+"%n";
        s = s+"Email: "+this.email+"%n";
        s = s+"Areas: "+ strA;
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
}

package it.accenture.school.model;

public class Course {

    private long id; //final? maybe
    private String title;
    private int hours;
    private Area area;
    private Level level;

    public Course(long id, String title, int hours, Area area, Level level){
        this.id = id;
        this.title = title;
        this.hours = hours;
        this.area = area;
        this.level = level;
    }

    @Override
    public String toString(){  //change it so that it prints on just one line?
        String s = "Id: "+this.id+"%n";
        s = s+"Title: "+this.title+"%n";
        s = s+"Hours: "+this.hours+"%n";
        s = s+"Area: "+this.area.name()+"%n";
        s = s+"Level: "+this.level.name()+"%n%n"; //is this enough separation?
        return s;
    }

    public long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public int getHours() {
        return hours;
    }

    public Area getArea() {
        return this.area;
    }

    public Level getLevel() {
        return this.level;
    }


}

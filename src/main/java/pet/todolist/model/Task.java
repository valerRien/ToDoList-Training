package pet.todolist.model;


import java.sql.Date;



public class Task {

    private int id;
    private String text;
    private Date date;
    private boolean isDone;

    public Task() {
    }

    public Task(String text, Date date, boolean isDone) {
        this.text = text;
        this.date = date;
        this.isDone = isDone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}

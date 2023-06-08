package pet.todolist.model;

import lombok.Data;
import lombok.ToString;

import java.sql.Date;



@Data
public class Task {

    @ToString.Exclude
    private int id;
    private String text;
    private Date date;
    private boolean isDone;
}

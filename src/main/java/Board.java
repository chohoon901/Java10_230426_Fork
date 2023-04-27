import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
@Entity
@Table(name = "post")
// Table : 'id' 'WRITER' 'WRITING'
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(nullable = false, length = 10)
    private String WRITER;

    @Column(nullable = false, length = 100)
    private String WRITING;

    // get
    public int getID(){
        return ID;
    }
    public String getWRITER(){
        return WRITER;
    }
    public String getWRITING(){
        return WRITING;
    }

    // set
    public void setID(int ID){
        this.ID = ID;
    }
    public void setWRITER(String WRITER){
        this.WRITER = WRITER;
    }
    public void setWRITING(String WRITING) {
        this.WRITING = WRITING;
    }

    public Board(String WRITER, String WRITING){
        this.WRITER = WRITER;
        this.WRITING = WRITING;
    }

}

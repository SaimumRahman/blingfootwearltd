package khan.solution.blingfootwearltd.data.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Data
@Entity
@Table
@Getter
@Setter
public class RawMaterial {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    private String rawMaterialId;
    private String nameRM;
    private String costRM;
    private String quantityRM;
    private String boughtFromRM;
    private String dateRM;

    public RawMaterial() {

        Calendar callForDate=Calendar.getInstance();
        SimpleDateFormat currentDate=new SimpleDateFormat("MM dd, yyyy");
        String saveCurrentDateMs=currentDate.format(callForDate.getTime());

        this.dateRM=saveCurrentDateMs;

    }

}

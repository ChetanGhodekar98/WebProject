package StudentApplication.WebProject.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    private int studentRollNumber;
    private String studentName;
    private String studentContactNumber;
    private String studentAddress;
    private int studentTotalMarks;
    private int studentObtainMarks;
}

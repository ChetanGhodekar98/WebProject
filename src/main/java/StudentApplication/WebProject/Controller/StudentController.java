package StudentApplication.WebProject.Controller;

import StudentApplication.WebProject.Model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    List<Student> studentList=new ArrayList<>();

    {
        studentList.add(new Student(1,"ANIKET","12345","PUNE",500,400));
        studentList.add(new Student(2,"ROHAN","54321","MUMBAI",1500,400));
        studentList.add(new Student(3,"MANISH","67890","DELHI",1800,1000));
        studentList.add(new Student(4,"AKSHAY","13579","BANGLORE",1500,450));
        studentList.add(new Student(5,"ADITYA","97531","NOIDA",500,400));
    }

    @GetMapping("/display")
    public String displayStudentData(Model model){
        model.addAttribute("studentData",studentList);
        return "displayStudentData";
    }
}

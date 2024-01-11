package StudentApplication.WebProject.Controller;

import StudentApplication.WebProject.Model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/addStudent")
    public String createObject(Model model){
        model.addAttribute("studentObject",new Student());
        return "studentForm";
    }
    @PostMapping("/saveStudent")
    public String saveStudent(Student student){
        studentList.add(student);
        return "redirect:/display";
    }

    @GetMapping("/updateStudent/{id}")
    public String fetchObject(@PathVariable int id,Model model){
       for(Student s:studentList){
           if(s.getStudentRollNumber()==id){
               model.addAttribute("matchObject",s);
               break;
           }
       }
       return "updateStudent";
    }

    @PostMapping("/updateStudentData")
    public String updateStudent(Student student){
        for(Student s:studentList){
            if(s.getStudentRollNumber()==student.getStudentRollNumber()){
                studentList.set(studentList.indexOf(s),student);
                break;
            }
        }
        return "redirect:/display";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id){
        for(Student s:studentList){
            if(s.getStudentRollNumber()==id){
                studentList.remove(s);
                break;
            }
        }
        return "redirect:/display";
    }
}

    package com.thotholani.sms.controller;

    import com.thotholani.sms.entity.Student;
    import com.thotholani.sms.service.StudentService;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.ModelAttribute;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;

    @Controller
    public class StudentController {
        private StudentService studentService;

        public StudentController(StudentService studentService) {
            super();
            this.studentService = studentService;
        }

            //handler method to handle list students and return model and view
        @GetMapping("/members")
        public String listStudents(Model model) {
            model.addAttribute("students",studentService.getAllStudents());
            return "students";
        }

        @GetMapping("/members/new")
        public String createStudentForm(Model model) {
            //create student object to hold student form data
            Student student = new Student();
            model.addAttribute("student",student);
            return "create_student";
        }

        @PostMapping("/members")
        public String saveStudent(@ModelAttribute("student") Student student) {
            studentService.saveStudent(student);
            return "redirect:/members";
        }

        @GetMapping("/members/edit/{id}")
        public String editStudentForm(@PathVariable long id, Model model) {
            model.addAttribute("student",studentService.getStudentById(id));
            return  "edit_student";
        }

        @PostMapping("/members/{id}")
        public String updateStudent(@ModelAttribute("student") Student student) {
            studentService.updateStudent(student);
            return "redirect:/members";
        }

        @GetMapping("/members/delete/{id}")
        public String deleteStudent(@ModelAttribute("student") Student student) {
            studentService.deleteStudent(student);
            return "redirect:/members";
        }
    }

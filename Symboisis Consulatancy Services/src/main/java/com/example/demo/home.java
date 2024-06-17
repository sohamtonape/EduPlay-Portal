package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class home {

    private List<StudentData> students = new ArrayList<>();

    @GetMapping("/nav")
    public String getNav() {
        return "nav";
    }

    @GetMapping("/form")
    public String form() {
        return "form";
    }

    @PostMapping("/form")
    public String addStudent(@RequestParam("name") String name, @RequestParam("id") int id, @RequestParam("age") int age, Model model) {
        students.add(new StudentData(id, name, age));
        model.addAttribute("students", students);
        return "showData";
    }

    @GetMapping("/updateStudents")
    public String updateStudents(Model model) {
        model.addAttribute("students", students);
        return "updateStudents";
    }

    @PostMapping("/updateStudents")
    public String updateStudent(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("age") int age, Model model) {
        for (StudentData student : students) {
            if (student.getId() == id) {
                student.setName(name);
                student.setAge(age);
            }
        }
        model.addAttribute("students", students);
        return "showData";
    }

    @GetMapping("/deleteStudents")
    public String deleteStudents(Model model) {
        model.addAttribute("students", students);
        return "deleteStudents";
    }

    @PostMapping("/deleteStudents")
    public String deleteStudent(@RequestParam("id") int id, Model model) {
        students.removeIf(student -> student.getId() == id);
        model.addAttribute("students", students);
        return "showData";
    }

    @GetMapping("/showData")
    public String showData(Model model) {
        model.addAttribute("students", students);
        return "showData";
    }
    
    //new 
    
//    @GetMapping("/nav")
//    public String nav() {
//        return "nav";
//    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/games")
    public String games() {
        return "games";
    }
    
    //mapping for games
    @GetMapping("/games/tictactoe")
    public String ticTacToe() {
        return "tictactoe";
    }

    @GetMapping("/games/snake")
    public String snakeGame() {
        return "snake";
    }

    @GetMapping("/games/rockpaperscissors")
    public String rockPaperScissors() {
        return "rockpaperscissors";
    }
    
    @GetMapping("/games/typing_speed")
    public String typing_speed() {
        return "typing_speed";
    }
    
    @GetMapping("/games/ping_pong")
    public String ping_pong() {
        return "ping_pong";
    }
    
    @GetMapping("/games/archery")
    public String archery() {
        return "archery";
    }
    ///end games mapping

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contacts")
    public String contacts() {
        return "contacts";
    }

//    @GetMapping("/students")
//    public String student() {
//        return "nav";
//    }
}

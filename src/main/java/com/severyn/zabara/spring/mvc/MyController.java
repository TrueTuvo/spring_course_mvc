package com.severyn.zabara.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/employee")
public class MyController {
    @RequestMapping("/")
    public String showFirsView() {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model) {
//        Employee employee = new Employee();
//        employee.setName("Ivan");
//        employee.setSurName("Petrov");
//        employee.setSalary(500);
        model.addAttribute("employee", new Employee());
        return "ask-emp-details-view";
    }
//    @RequestMapping("/show-details")
//    public String showEmpDetails(){
//        return "show-emp-details-view";
//    }

//    @RequestMapping("/show-details")
//    public String showEmpDetails(HttpServletRequest request, Model model){
//        String empName = request.getParameter("employeeName");
//        empName = "Mr. "+ empName;
//        model.addAttribute("nameAttribute", empName);
//        model.addAttribute("desccription", "- java developer");
//
//
//        return "show-emp-details-view";
//    }


    @RequestMapping("/showDetails")
    public String showEmpDetails(@ModelAttribute("employee") Employee employee) {

        String name = employee.getName();
        employee.setName("Mr " + name);

        String surName = employee.getSurName();
        employee.setSurName(surName + "!");

        int salary = employee.getSalary();
        employee.setSalary(salary*10);

        return "show-emp-details-view";
    }
}

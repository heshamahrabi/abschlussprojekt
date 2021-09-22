package de.denkformat.employee.controller;

import de.denkformat.employee.domain.EmployeeRepository;
import de.denkformat.employee.domain.Project;
import de.denkformat.employee.domain.Employee;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.denkformat.employee.domain.ProjectRepository;

@Controller
public class EmployeeController {
	@Autowired
    private EmployeeRepository repository;

	@Autowired
    private ProjectRepository crepository;

	@RequestMapping("/login")
	public String login() {
    	return "login";
    }

	@RequestMapping("/employees")
	public String index(Model model) {
		List<Employee> employees = (List<Employee>) repository.findAll();
		model.addAttribute("employees", employees);
    	return "employees";
    }

    @RequestMapping(value = "add")
    public String addEmployee(Model model){
    	model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editEmployee(@PathVariable("id") Long employeeId, Model model){
    	model.addAttribute("employee", repository.findById(employeeId));
        return "editEmployee";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Employee employee){
        repository.save(employee);
    	return "redirect:/employees";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable("id") Long employeeId, Model model) {
    	repository.deleteById(employeeId);
        return "redirect:/employees";
    }

    @RequestMapping(value = "addEmployeeProject/{id}", method = RequestMethod.GET)
    public String addProject(@PathVariable("id") Long employeetId, Model model){

    		model.addAttribute("projects", crepository.findAll());
    		model.addAttribute("employee", repository.findById(employeetId).get());
    		return "addEmployeeProject";
    }


    @RequestMapping(value="/employee/{id}/projects", method=RequestMethod.GET)
	public String employeesAddProject(@RequestParam(value="action", required=true) String action, @PathVariable Long id, @RequestParam Long projectId, Model model) {
    	Optional<Project> project = crepository.findById(projectId);
		Optional<Employee> employee = repository.findById(id);

		if (employee.isPresent() && action.equalsIgnoreCase("save")) {
			if (!employee.get().hasProject(project.get())) {
				employee.get().getProjects().add(project.get());
			}
			repository.save(employee.get());
			model.addAttribute("employee", crepository.findById(id));
			model.addAttribute("projects", crepository.findAll());
			return "redirect:/employees";
		}

		model.addAttribute("developers", repository.findAll());
		return "redirect:/employees";

	}

    @RequestMapping(value = "getEmployees", method = RequestMethod.GET)
    public @ResponseBody List<Employee> getEmployees() {
            return (List<Employee>)repository.findAll();
    }
}

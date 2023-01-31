package com.codeclan.example.employeeservice;

import com.codeclan.example.employeeservice.models.Department;
import com.codeclan.example.employeeservice.models.Employee;
import com.codeclan.example.employeeservice.models.Project;
import com.codeclan.example.employeeservice.repositories.DepartmentRepository;
import com.codeclan.example.employeeservice.repositories.EmployeeRepository;
import com.codeclan.example.employeeservice.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootTest
class EmployeeserviceApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createEmployeeAndDepartmentAndProjects(){
		Department sales = new Department("Sales");
		departmentRepository.save(sales);

		Project makeMoney = new Project("make more money",3 );
		Project makeCode = new Project("make more code",10 );
		projectRepository.save(makeCode);

		Employee jack = new Employee("Jack Smith", 25, 1234, "jack@gmail.com", sales);
		jack.addProjectToEmployee(makeCode);
		makeMoney.addEmployeeToProject(jack);
		employeeRepository.save(jack);
		projectRepository.save(makeMoney);


//		ArrayList<Project> projectList = new ArrayList<>(Arrays.asList(makeMoney));//creates array list with makeMoney
//		jack.setProjects(projectList);






	}

//	@Test
//	public void addEmpoyee(){
//
//		Department sales = new Department("Sales");
//		departmentRepository.save(sales);
//
//		Employee jack = new Employee("Jack Smith", 25, 1234, "jack@gmail.com", sales);
//		employeeRepository.save(jack);
//
//	}

}

package de.denkformat.employee.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Employee {
	private long id;
	private String firstName;
	private String lastName;
	private String department;
    private String email;

	private Set<Project> cours = new HashSet<Project>(0);

    public Employee() {
    }

	public Employee(String firstName, String lastName, String department, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.email = email;
	}

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

    @Column(name = "firstname")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

    @Column(name = "lastname")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

    @Column(name = "department")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

    @Column(name = "email")
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "employee_project", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = { @JoinColumn(name = "projectId") })
	public Set<Project> getProjects() {
		return this.cours;
	}

	public void setProjects(Set<Project> projects) {
		this.cours = projects;
	}

	public boolean hasProject(Project employee) {
		for (Project employeeProject : getProjects()) {
			if (employeeProject.getProjectId() == employee.getProjectId()) {
				return true;
			}
		}
		return false;
	}
}

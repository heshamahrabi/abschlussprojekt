package de.denkformat.employee.domain;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long projectId;

    @Column(name="project_name")
	private String name;

    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees;

    public Project() {
	}

	public Project(String name) {
		this.name = name;
	}

    public long getProjectId() {
		return projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}

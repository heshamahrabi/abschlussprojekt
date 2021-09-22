package de.denkformat.employee;

import de.denkformat.employee.domain.EmployeeRepository;
import de.denkformat.employee.domain.User;
import org.junit.Test;
import org.junit.runner.*;

import static org.junit.Assert.*;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.denkformat.employee.domain.Employee;
import de.denkformat.employee.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CrudbootApplicationTests {


	private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Test
    public void addUser() {
    	User user = new User("testuser", "testuser", "USER");

    	assertNull(user.getId());
    	userRepository.save(user);
    	assertNotNull(user.getId());
    }

	@Test
    public void addEmployee() {
		Employee employee = new Employee("Test", "Employee", "IT", "test@test.com");

		employeeRepository.save(employee);
		Optional<Employee> findEmployee = employeeRepository.findById(employee.getId());
		assertTrue(findEmployee.isPresent());
    }

}

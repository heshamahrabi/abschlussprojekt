package de.denkformat.employee.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface IpAdressRepository extends CrudRepository<IpAdress, Long> {

    List<IpAdress> findByIpLanAndIpVm(String ipLan, String ipVm);

}

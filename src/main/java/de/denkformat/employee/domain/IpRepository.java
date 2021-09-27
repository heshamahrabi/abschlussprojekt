package de.denkformat.employee.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface IpRepository extends CrudRepository<Ip, Long> {

    List<Ip> findByIpPc (String ipPrivat);
}

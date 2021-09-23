package de.denkformat.employee.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
public class IpAdress {
	private long id;
	private String ipLan;
	private String ipVpn;
	private String ipVm;
    private String ddiscription;


	public IpAdress(long id, String ipLan, String ipVpn, String ipVm, String ddiscription) {
		this.id = id;
		this.ipLan = ipLan;
		this.ipVpn = ipVpn;
		this.ipVm = ipVm;
		this.ddiscription = ddiscription;
	}

	public IpAdress() {

	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

    @Column(name = "iplan")
	public String getIpLan() {
		return ipLan;
	}

	public void setIpLan(String firstName) {
		this.ipLan = firstName;
	}

    @Column(name = "ipvpn")
	public String getIpVpn() {
		return ipVpn;
	}

	public void setIpVpn(String lastName) {
		this.ipVpn = lastName;
	}

    @Column(name = "ipvm")
	public String getIpVm() {
		return ipVm;
	}

	public void setIpVm(String department) {
		this.ipVm = department;
	}

    @Column(name = "deiscription")
    public String getDdiscription() {
		return ddiscription;
	}


	public void setDdiscription(String email) {
		this.ddiscription = email;
	}

	@Override
	public String toString() {
		return "IpAdress{" +
				"id=" + id +
				", ipLan='" + ipLan + '\'' +
				", ipVpn='" + ipVpn + '\'' +
				", ipVm='" + ipVm + '\'' +
				", ddiscription='" + ddiscription + '\'' +
				'}';
	}
}




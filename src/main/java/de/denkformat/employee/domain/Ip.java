package de.denkformat.employee.domain;

import javax.persistence.*;

@Entity
public class Ip {
    private long id;
    private String ipPc;
    private String ipVw;
    private String ipPrivat;
    private String description;






    public Ip(long id, String ipPc, String ipVw, String ipPrivat, String description) {
        this.id = id;
        this.ipPc = ipPc;
        this.ipVw = ipVw;
        this.ipPrivat = ipPrivat;
        this.description = description;
    }

    public Ip() {

    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "ip_pc")
    public String getIpPc() {
        return ipPc;
    }

    public void setIpPc(String ipPc) {
        this.ipPc = ipPc;
    }

    @Column(name = "ip_vw")
    public String getIpVw() {
        return ipVw;
    }

    public void setIpVw(String ipVw) {
        this.ipVw = ipVw;
    }

    @Column(name = "ip_privat")
    public String getIpPrivat() {
        return ipPrivat;
    }

    public void setIpPrivat(String ipPrivat) {
        this.ipPrivat = ipPrivat;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

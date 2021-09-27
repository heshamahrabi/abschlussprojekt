package de.denkformat.employee.controller;

import de.denkformat.employee.domain.Ip;
import de.denkformat.employee.domain.IpRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IpController {

    @Autowired
    private IpRepository ipRepository;

    @RequestMapping("/ips")
    public String index(Model model) {
        List<Ip> ips = (List<Ip>) ipRepository.findAll();
        model.addAttribute("ips", ips);
        return "ip";
    }
}

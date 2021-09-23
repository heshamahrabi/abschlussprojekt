package de.denkformat.employee.controller;

import org.springframework.ui.Model;
import de.denkformat.employee.domain.IpAdress;
import de.denkformat.employee.domain.IpAdressRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IpAdressController {

    @Autowired
    private IpAdressRepository ipRepo;

    @RequestMapping("/ips")
    public String listIp(Model model) {
        List<IpAdress> ipAdresses = (List<IpAdress>) ipRepo.findAll();
        model.addAttribute("ipAdresses", ipAdresses);
        return "ips";
    }
    @RequestMapping(value = "addIp")
    public String addIpAdress(Model model){
        model.addAttribute("ipAdress", new IpAdress());
        return "addIp";
    }
    @RequestMapping(value = "ips", method = RequestMethod.POST)
    public String saveIp(IpAdress ipAdress){
        ipRepo.save(ipAdress);
        return "redirect:/ips";
    }
    @RequestMapping(value = "/editIp/{id}")
    public String editIpAdress(@PathVariable("id") Long ipAdressId, Model model){
        model.addAttribute("ipAdress", ipRepo.findById(ipAdressId));
        return "editIpAdress";
    }
}



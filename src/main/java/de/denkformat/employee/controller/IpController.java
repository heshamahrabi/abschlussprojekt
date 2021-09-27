package de.denkformat.employee.controller;

import de.denkformat.employee.domain.Employee;
import de.denkformat.employee.domain.Ip;
import de.denkformat.employee.domain.IpRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @RequestMapping(value = "addIp")
    public String addIp(Model model){
        model.addAttribute("ip", new Ip());
        return "addIp";
    }
    @RequestMapping(value = "saveIp", method = RequestMethod.POST)
    public String save(Ip ip){
        ipRepository.save(ip);
        return "redirect:/ips";
    }
    @RequestMapping(value = "/editIp/{id}")
    public String editIp(@PathVariable("id") Long ipId, Model model){
        model.addAttribute("ip", ipRepository.findById(ipId));
        return "editIp";
    }
    @RequestMapping(value = "/deleteIp/{id}", method = RequestMethod.GET)
    public String deleteIp(@PathVariable("id") Long ipId, Model model) {
        ipRepository.deleteById(ipId);
        return "redirect:/ips";
    }
}

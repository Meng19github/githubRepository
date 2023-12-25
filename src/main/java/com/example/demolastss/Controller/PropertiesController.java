
package com.example.demolastss.Controller;

import com.example.demolastss.model.Client;
import com.example.demolastss.model.Properties;
import com.example.demolastss.repository.ClientRepository;
import com.example.demolastss.repository.PropertiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Controller
public class PropertiesController {

    @Autowired
    PropertiesRepository PropertiesRepository;

    @Autowired
    ClientRepository ClientRepository;
    @RequestMapping(value = "/Properties/new", method = RequestMethod.GET)
    public String newOrdersForm(Model model){
        Properties Properties=new Properties();
        model.addAttribute("Properties", Properties);
        List<Client> Client= ClientRepository.findAll();
        model.addAttribute("Client",Client);
        return "Properties/new";
    }
    @RequestMapping(value = "/Properties/new", method = RequestMethod.POST)
    public String saveProperties(Model model, Properties Properties){

        PropertiesRepository.save(Properties);

        model.addAttribute("Properties", Properties);
        return "redirect:/Properties/list";

    }
    @RequestMapping(value = "/Properties/list", method = RequestMethod.GET)
    public String findAllProperties(Model model){

        List<Properties> Properties= PropertiesRepository.findAll();

        model.addAttribute("Properties", Properties);

        return "Properties/list";
    }
    @RequestMapping(value = "/Properties/edit/{id}", method = RequestMethod.GET)
    public String editOrders(Model model,@PathVariable Long id){
        Properties Properties= PropertiesRepository.findById(id).orElse(null);
        model.addAttribute("Properties", Properties);
        List< Client >Client= ClientRepository.findAll();
        model.addAttribute("Client", Client);

        return "Properties/edit";
    }


    @RequestMapping(value = "/Properties/edit", method = RequestMethod.POST)
    public String updateProperties(Model model,Properties Properties){
        PropertiesRepository.save(Properties);
        model.addAttribute("Properties", Properties);
        return "redirect:/Properties/list";
    }

    @RequestMapping(value = "/Properties/delete/{id}", method = RequestMethod.GET)
    public String deleteProperties(@PathVariable Long id){
        PropertiesRepository.deleteById(id);
        return "redirect:/Properties/list";
    }
}

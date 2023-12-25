package com.example.demolastss.Controller;

import com.example.demolastss.model.Client;
import com.example.demolastss.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    ClientRepository ClientRepository;


    @RequestMapping(value = "/Client/new", method = RequestMethod.GET)
    public String newClientForm(Model model){
        model.addAttribute("Client", new Client());
        return "Client/new";
    }
    @RequestMapping(value = "/Client/new", method = RequestMethod.POST)
    public String saveClient(Model model, Client Client){
        ClientRepository.save(Client);
        model.addAttribute("Client", Client);
        return "redirect:/Client/list";

    }
    @RequestMapping(value = "/Client/list", method = RequestMethod.GET)
    public String findAllClient(Model model){

        List<Client> Client= ClientRepository.findAll();
        model.addAttribute("Client", Client);
        return "Client/list";
    }
    @RequestMapping(value = "/Client/edit/{id}", method = RequestMethod.GET)
    public String editClient(Model model,@PathVariable Long id){
        Client Client= ClientRepository.findById(id).orElse(null);
        model.addAttribute("Client", Client);
        return "Client/edit";
    }


    @RequestMapping(value = "/Client/edit", method = RequestMethod.POST)
    public String updateClient(Model model,Client Client){
        ClientRepository.save(Client);
        model.addAttribute("Client", Client);
        return "redirect:/Client/list";
    }

    @RequestMapping(value = "/Client/delete/{id}", method = RequestMethod.GET)
    public String deleteClient(@PathVariable Long id){
        ClientRepository.deleteById(id);
        return "redirect:/Client/list";
    }
}

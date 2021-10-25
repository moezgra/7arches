package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.CustomLoginSuccessHandler;
import com.example.demo.model.Client;
import com.example.demo.service.ClientService;
import com.example.demo.service.SecurityService;
import com.example.demo.validator.ClientValidator;

@Controller
public class ConnexionController {
	
	@Autowired
	ClientService clientService;

	@Autowired
    private ClientValidator clientValidator;
	
	@Autowired
    private SecurityService securityService;
	
	public final static String SHOW_ARTICLES_PATH = "/showArticles";
	
	/*
	 * @GetMapping("connexion") public String connexion(Model model) {
	 * model.addAttribute("client", new Client()); return "connexion/connexion"; }
	 */
	
	
	@RequestMapping(value = "/addClient", method = RequestMethod.GET)
    public String addClient(Model model) {
        model.addAttribute("client", new Client());

        return "addClient";
    }
	
	@RequestMapping(value = "/addClient", method = RequestMethod.POST)
    public String addClient(@ModelAttribute("client") Client clientForm, BindingResult bindingResult, Model model) {
        clientValidator.validate(clientForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "redirect:/addClient";
        }

        clientService.save(clientForm);

//        securityService.autologin(clientForm.getEmail(), clientForm.getMotDePasse());
        
        return "redirect:/showArticles";
    }
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(HttpServletRequest request, Model model) {
//	    String referer = request.getHeader("Referer");
	    
		
	    request.getSession().setAttribute("url_articles", SHOW_ARTICLES_PATH);
	    // some other stuff
	    return "login";
	}
	
}
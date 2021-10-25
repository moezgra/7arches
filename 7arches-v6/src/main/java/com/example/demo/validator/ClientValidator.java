package com.example.demo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.demo.dao.ClientRepository;
import com.example.demo.model.Client;
import com.example.demo.service.ClientService;

/**
 *To provide input-data validation for /registration controller with 
 * Spring Validator, we implement org.springframework.validation.Validator. 
 * Error codes, e.g. Size.userForm.username, are defined 
 * by validation.properties
 * 
 * @author raitis
 */
@Component
public class ClientValidator implements Validator{
    @Autowired
    private ClientService clientService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Client.class.equals(aClass);
}
    @Override
    public void validate(Object o, Errors errors) {
     Client client = (Client) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", "NotEmpty");
//        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
//            errors.rejectValue("username", "Size.userForm.username");
//        }
        if (clientService.findByEmail(client.getEmail()) != null) {
            errors.rejectValue("client", "Duplicate.clientForm.user");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "motDePasse", "NotEmpty");
//        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
//            errors.rejectValue("password", "Size.userForm.password");
//        }

        if (!client.getMotDePasse().equals(client.getPasseConfirmer())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }   
    }
    
}

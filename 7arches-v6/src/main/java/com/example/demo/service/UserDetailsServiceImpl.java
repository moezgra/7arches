package com.example.demo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ClientRepository;
import com.example.demo.model.Client;
import com.example.demo.model.Role;

/**
*To implement login/authentication with Spring Security, 
* we need to implement org.springframework.security.core.userdetails.UserDetailsService interface
*
 * @author raitis
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private ClientRepository clientRepository;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
    	
        Client client = clientRepository.findByEmail(username);

        if (client == null) {
            throw new UsernameNotFoundException("Not found!");
        }
        
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : client.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(client.getEmail(), client.getMotDePasse(), grantedAuthorities);
  
    }
    
}

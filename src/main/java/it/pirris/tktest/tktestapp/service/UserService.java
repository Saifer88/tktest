package it.pirris.tktest.tktestapp.service;


import it.pirris.tktest.tktestapp.entity.User;
import it.pirris.tktest.tktestapp.repository.UserRepository;
import it.pirris.tktest.tktestapp.service.spec.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService extends AbstractService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;



    public String getPrincipalName()
    {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }


    public User getByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    public User getPrincipal() throws UsernameNotFoundException
    {
        return getByUsername(getPrincipalName());
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s);
    }
}

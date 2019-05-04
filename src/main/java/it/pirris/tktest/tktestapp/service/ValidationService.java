package it.pirris.tktest.tktestapp.service;

import it.pirris.tktest.tktestapp.service.spec.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationService extends AbstractService {

    @Autowired
    UserService userService;

    public boolean canUserAccessServer(int id)
    {
        return userService
                .getPrincipal()
                .getServers()
                .stream()
                .anyMatch(s -> s.getId()==id);
    }

}
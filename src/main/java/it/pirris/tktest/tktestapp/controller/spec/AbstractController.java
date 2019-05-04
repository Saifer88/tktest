package it.pirris.tktest.tktestapp.controller.spec;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class AbstractController {


    @Autowired
    protected Logger logger;

    public String getPrincipal()
    {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}

package it.pirris.tktest.tktestapp.controller;


import it.pirris.tktest.tktestapp.controller.spec.AbstractController;
import it.pirris.tktest.tktestapp.entity.Server;
import it.pirris.tktest.tktestapp.service.ServerService;
import it.pirris.tktest.tktestapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("api/v1/server")
public class ServerController extends AbstractController {

    @Autowired
    UserService userService;

    @Autowired
    ServerService serverService;

    @GetMapping
    public List<Server> getAll()
    {
        return userService.getPrincipal().getServers();
    }

    @GetMapping("/{id}/state")
    @PreAuthorize("@validationService.canUserAccessServer(#id)")
    public String getServerState(@PathVariable int id) throws ParseException
    {
        return serverService.fetchServerState(id);
    }


}

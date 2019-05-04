package it.pirris.tktest.tktestapp.service.spec;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService {


    @Autowired
    protected Logger logger;
}

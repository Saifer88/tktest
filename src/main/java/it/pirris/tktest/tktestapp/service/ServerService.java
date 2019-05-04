package it.pirris.tktest.tktestapp.service;


import it.pirris.tktest.tktestapp.entity.Carico;
import it.pirris.tktest.tktestapp.entity.Server;
import it.pirris.tktest.tktestapp.repository.CaricoRepository;
import it.pirris.tktest.tktestapp.repository.ServerRepository;
import it.pirris.tktest.tktestapp.service.spec.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ServerService extends AbstractService{


    @Autowired
    ServerRepository serverRepository;

    @Autowired
    CaricoRepository caricoRepository;


    public List<Server> getAll()
    {
        return serverRepository.findAll();
    }

    public String fetchServerState(int id) throws ParseException
    {
        Server server = serverRepository.getOne(id);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy/hh/mm/ss");
        Date current;
        List<Carico> carichiCorrenti;
        int tempSum = 0;
        int overheating = 0;

        for (int i = 1; i<=31 ; i++)
        {
            current = sdf.parse(i + "/08/2018/02/00/00");
            for (int j = 0; j < 24; j++)
            {
                carichiCorrenti = caricoRepository.findByServerAndDataAndOra(server, current, j);
                for (Carico c : carichiCorrenti)
                    tempSum += c.getCaricoMedio();

                if (tempSum / 60 > 85)
                    overheating++;

                tempSum = 0;
            }
        }

        logger.info("Per agosto 2018, sul server " + server.getId() + " si sono verificati " + overheating + " overheat");

        if (overheating == 0)
            return "verde";
        else if(overheating <= 3)
            return "giallo";
        else
            return "rosso";
    }


}

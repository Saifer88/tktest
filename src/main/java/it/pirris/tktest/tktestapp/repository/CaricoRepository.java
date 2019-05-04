package it.pirris.tktest.tktestapp.repository;

import it.pirris.tktest.tktestapp.entity.Carico;
import it.pirris.tktest.tktestapp.entity.CaricoId;
import it.pirris.tktest.tktestapp.entity.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CaricoRepository extends JpaRepository<Carico, CaricoId> {

    List<Carico> findByServerAndDataAndOra(Server server, Date data, Integer ora);

}

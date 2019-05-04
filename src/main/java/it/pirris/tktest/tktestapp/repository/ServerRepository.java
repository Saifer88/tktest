package it.pirris.tktest.tktestapp.repository;

import it.pirris.tktest.tktestapp.entity.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerRepository extends JpaRepository<Server, Integer> {
}

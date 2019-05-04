package it.pirris.tktest.tktestapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity(name = "server")
public class Server {

    @Id
    int id;

    String nome;
    String ip;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "id_server")
    List<Carico> stati;

    public List<Carico> getStati() {
        return stati;
    }

    public void setStati(List<Carico> stati) {
        this.stati = stati;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}

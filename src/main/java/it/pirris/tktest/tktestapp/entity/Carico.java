package it.pirris.tktest.tktestapp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "dati_carico_server")
@IdClass(CaricoId.class)
public class Carico implements Serializable
{

    @ManyToOne
    @JoinColumn(name = "id_server")
    @Id
    Server server;

    @Id
    Date data;

    @Id
    @Column(columnDefinition = "TINYINT(2)")
    Integer ora;

    @Id
    @Column(columnDefinition = "TINYINT(2)")
    Integer minuto;

    @Column(name = "carico_medio_cpu_percent", columnDefinition = "TINYINT(2)")
    Integer caricoMedio;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getOra() {
        return ora;
    }

    public void setOra(Integer ora) {
        this.ora = ora;
    }

    public Integer getMinuto() {
        return minuto;
    }

    public void setMinuto(Integer minuto) {
        this.minuto = minuto;
    }

    public Integer getCaricoMedio() {
        return caricoMedio;
    }

    public void setCaricoMedio(Integer caricoMedio) {
        this.caricoMedio = caricoMedio;
    }
}

package dev.esdras.Entities;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

    private Timestamp momento;
    private String remetente;
    private String conteudo;

    public Message(Timestamp momento, String remetente, String conteudo) {
        this.setMomento(momento);
        this.setRemetente(remetente);
        this.setConteudo(conteudo);
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Timestamp momento) {
        this.momento = momento;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getHoraFormatada() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(this.getMomento());
    }
}

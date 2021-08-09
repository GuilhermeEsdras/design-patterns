package dev.esdras.padroes.adapter;

import com.katyusco.padroes.adpater.servicos.Fio;
import com.katyusco.padroes.adpater.servicos.ServicoTomada3Pinos;

public class ClientePlugParaTomada2Pinos {

    private Fio pinoFase;
    private Fio pinoNeutro;

    public ClientePlugParaTomada2Pinos(Fio pinoFase, Fio pinoNeutro) {
        this.pinoFase = pinoFase;
        this.pinoNeutro = pinoNeutro;
    }

    private void acoplaPlug() {
        ServicoTomada3Pinos servicoTomada3Pinos = new Plug2PinosAdapter(pinoFase, pinoNeutro);
        servicoTomada3Pinos.forneceEnergia();
    }

    public static void main(String[] args) {
        ClientePlugParaTomada2Pinos plug2Pinos = new ClientePlugParaTomada2Pinos(Fio.FASE, Fio.NEUTRO);
        plug2Pinos.acoplaPlug();
    }
}

package dev.esdras.padroes.adapter;

import com.katyusco.padroes.adpater.servicos.Fio;
import com.katyusco.padroes.adpater.servicos.ServicoTomada3Pinos;

public class Plug2PinosAdapter extends ServicoTomada3Pinos implements ServicoTomadaAlvoIF {

    public Plug2PinosAdapter(Fio fioVermelho, Fio fioAzulClaro) {
        super(fioVermelho, fioAzulClaro, Fio.TERRA);
    }
}

package dev.esdras.padroes.adapter;

import com.katyusco.padroes.adpater.servicos.Fio;

/**
 * Esta interface tem como objetivo servir como "protocolo" (daí o nome Protocol) para todas as tomadas de 3 pinos.
 * Todos os adaptadores devem implementar esta interface, pois a mesma diz o padrão de fios necessários para
 * fornecimento de energia em tomadas de três pinos.
 *
 * @author guilhermeesdras
 */
public interface ServicoTomada3PinosProtocol {

    /**
     * Fornece a energia necessária a partir da conexão com três fios.
     *
     * @param pinoFase      Fio vermelho
     * @param pinoNeutro    Fio Azul Claro
     * @param pinoTerra     Fio Verde Amarelo
     */
    void forneceEnergia(Fio pinoFase, Fio pinoNeutro, Fio pinoTerra);
}

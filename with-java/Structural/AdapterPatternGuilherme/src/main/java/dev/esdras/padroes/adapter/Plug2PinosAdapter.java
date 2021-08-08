package dev.esdras.padroes.adapter;

import com.katyusco.padroes.adpater.servicos.Fio;
import com.katyusco.padroes.adpater.servicos.ServicoTomada3Pinos;

/**
 * Esta classe tem como principal objetivo servir como adaptador para tomadas de 2 pinos.
 * Ela garante o terceiro pino (Fio Terra) as tomadas antigas que não a possui.
 * Também faz o trabalho de conectar a tomada antiga (de 2 pinos) na tomada moderna (de 3 pinos) e estabelecer o
 * fornecimento de energia a mesma.
 *
 * @author guilhermeesdras
 */
public class Plug2PinosAdapter implements ServicoTomada3PinosProtocol {

    /**
     * O Fio Terra ausente em tomadas de 2 pinos agora é garantido pelo adaptador.
     *
     * @params args
     */
    private Fio pinoTerra;

    /**
     * Ao conectar o plug no adaptador, o mesmo fornece a terceira conexão necessária na tomada de 3 pinos.
     */
    public Plug2PinosAdapter() {
        this.pinoTerra = Fio.TERRA;
    }

    /**
     * A tomada "pega" o terceira pino do adaptador, e não do plug.
     *
     * @return pinoTerra
     */
    public Fio getPinoTerra() {
        return pinoTerra;
    }

    /**
     * O adaptador agora que fica encarregado de estabelecer a conexão do aparelho a energia elétrica da tomada.
     * Dessa forma, quem garante o fornecimento de energia ao plug de 2 pinos é o adaptador.
     * Na ausência deste, o plug de 2 pinos para de funcionar.
     *
     * @param pinoFase      Fio vermelho
     * @param pinoNeutro    Fio Azul Claro
     * @param pinoTerra     Fio Verde Amarelo
     */
    @Override
    public void forneceEnergia(Fio pinoFase, Fio pinoNeutro, Fio pinoTerra) {
        ServicoTomada3Pinos tomada3Pinos = new ServicoTomada3Pinos(pinoFase, pinoNeutro, pinoTerra);
        tomada3Pinos.forneceEnergia();
    }
}

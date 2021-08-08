package dev.esdras.padroes.adapter;

import com.katyusco.padroes.adpater.servicos.Fio;

/**
 * Esta classe fica encarregada de estabelecer a conexão do plug de 2 pinos a uma tomada de 3 pinos através do uso
 * de um Adapter.
 *
 * @author guilhermeesdras
 */
public class ClientePlugParaTomada2Pinos extends Plug2PinosAdapter {

    /**
     * Ela detém apenas de 2 conexões/fios.
     * Por isso é necessário o Adaptador para fornecer a conexão/fio 3 na tomada.
     *
     * @params args
     */
    private Fio pinoFase;
    private Fio pinoNeutro;

    /**
     * Ela recebe apenas os 2 fios Fase e Neutro.
     * O terceiro fio (Terra), é fornecido pelo adaptador.
     *
     * @param pinoFase      Fio Vermelho
     * @param pinoNeutro    Fio Azul Claro
     */
    public ClientePlugParaTomada2Pinos(Fio pinoFase, Fio pinoNeutro) {
        super();
        this.pinoFase = pinoFase;
        this.pinoNeutro = pinoNeutro;
    }

    /**
     * Função responsável por acoplar o plug direto na tomada (caso fosse compatível).
     * Mas nesse caso, a conexão é feita através de um adaptador.
     *
     * @param adaptador
     */
    public void acoplaPlug(ServicoTomada3PinosProtocol adaptador) {
        adaptador.forneceEnergia(this.pinoFase, this.pinoNeutro, this.getPinoTerra());
    }

    public static void main(String[] args) {

        // Aqui o plug de 2 pinos é criado com suas duas entradas padrões.
        ClientePlugParaTomada2Pinos plug2Pinos = new ClientePlugParaTomada2Pinos(Fio.FASE, Fio.NEUTRO);

        // Para conectar com a tomada, agora é preciso um Adapter.
        plug2Pinos.acoplaPlug(new Plug2PinosAdapter());
    }
}

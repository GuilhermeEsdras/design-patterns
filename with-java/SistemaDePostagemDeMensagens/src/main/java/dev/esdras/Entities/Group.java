package dev.esdras.Entities;

import dev.esdras.Impl.ObserverImpl;
import dev.esdras.Processors.DataBaseProcessor;


public class Group extends ObserverImpl {

    private DataBaseProcessor dataBaseProcessor;

    public DataBaseProcessor useDataBaseProcessor() {
        return dataBaseProcessor;
    }

    public void startDataBaseProcessor(DataBaseProcessor dataBaseProcessor) {
        this.dataBaseProcessor = dataBaseProcessor;
    }

    public void mensagem(Message msg) {
        System.out.printf("%s enviou [em %s]: %s\n", msg.getRemetente(), msg.getHoraFormatada(), msg.getConteudo());
        System.out.println("A mensagem está sendo entregue...");
        System.out.println("---");
        this.notificaTodos(msg);
    }

}

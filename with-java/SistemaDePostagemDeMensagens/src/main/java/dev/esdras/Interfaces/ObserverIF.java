package dev.esdras.Interfaces;

import dev.esdras.Entities.Message;
import dev.esdras.Entities.User;

public interface ObserverIF {

    void adiciona(ObservableIF observavel);
    void remove(String email);
    void notificaTodos(Message message);
    void listaTodos();

}

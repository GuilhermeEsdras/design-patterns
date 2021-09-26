package dev.esdras.Impl;

import dev.esdras.Entities.Message;
import dev.esdras.Interfaces.ObservableIF;
import dev.esdras.Interfaces.ObserverIF;

import java.util.List;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ObserverImpl implements ObserverIF {

    public List<ObservableIF> observaveis;

    public ObserverImpl() {
        this.setObservaveis(new LinkedList<>());
    }

    @Override
    public void adiciona(ObservableIF observavel) {
        AtomicBoolean existe = new AtomicBoolean(false);

        if (!observaveis.isEmpty()) {
            this.getObservaveis().forEach(user -> {
                if (user.getEmail().equals(observavel.getEmail())) {
                    existe.set(true);
                }
            });
        }

        if (!existe.get()) {
            this.getObservaveis().add(observavel);
        }
    }

    @Override
    public void remove(String email) {
        this.getObservaveis().removeIf(u -> u.getEmail().equals(email));
    }

    @Override
    public void notificaTodos(Message message) {
        this.getObservaveis().forEach(user -> user.update(message));
    }

    @Override
    public void listaTodos() {
        this.getObservaveis().forEach(System.out::println);
    }

    public List<ObservableIF> getObservaveis() {
        return observaveis;
    }

    private void setObservaveis(List<ObservableIF> observaveis) {
        this.observaveis = observaveis;
    }
}

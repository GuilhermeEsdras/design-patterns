package dev.esdras.Interfaces;

import dev.esdras.Entities.Message;

public interface ObservableIF {

    void update(Message msg);
    String getEmail();
}

package dev.esdras.Entities;

import dev.esdras.Interfaces.ObservableIF;

import java.util.Objects;

public class User implements ObservableIF {

    private String email;

    public User(String email) {
        this.setEmail(email);
    }

    @Override
    public void update(Message msg) {
        if (!(msg.getRemetente().equals(this.getEmail()))) {
            System.out.printf(
                    "Mensagem: \"%s\" enviada por \"%s\" | Recebida em [%s] por %s\n",
                    msg.getConteudo(), msg.getRemetente(), msg.getHoraFormatada(), this.getEmail()
            );
        }
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getEmail().equals(user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail());
    }

    @Override
    public String toString() {
        return "- " + getEmail();
    }
}

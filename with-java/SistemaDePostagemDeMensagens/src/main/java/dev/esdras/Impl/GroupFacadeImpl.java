package dev.esdras.Impl;

import dev.esdras.Entities.Group;
import dev.esdras.Entities.Message;
import dev.esdras.Entities.User;
import dev.esdras.Exceptions.ArgumentoInvalidoException;
import dev.esdras.Interfaces.GroupFacadeIF;
import dev.esdras.Processors.DataBaseProcessor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Locale;

public class GroupFacadeImpl implements GroupFacadeIF {

    private Group group;

    private Group getGroup() {
        return group;
    }

    private void setGroup(Group group) {
        this.group = group;
    }

    public void initialize() {
        System.out.println("> Abrindo grupo...");
        this.setGroup(new Group());

        System.out.println("> Iniciando DataBase...");
        this.getGroup().startDataBaseProcessor(new DataBaseProcessor("postagem-guilherme-db", "users.txt"));
        this.getGroup().useDataBaseProcessor().readUserTable().forEach(databaseUser -> {
            this.getGroup().adiciona(databaseUser);
        });

        System.out.println("> Registrando membros...");
        User exemplo1 = new User("examplo1@email1.com");
        this.getGroup().adiciona(exemplo1);

        User exemplo2 = new User("examplo2@email2.com");
        this.getGroup().adiciona(exemplo2);

        User exemplo3 = new User("examplo3@email3.com");
        this.getGroup().adiciona(exemplo3);

        this.getGroup().getObservaveis().forEach(user -> {
            this.getGroup().useDataBaseProcessor().updateUserTable("add", user.getEmail());
        });

        System.out.println("> Grupo iniciado!");
    }

    public void run(String[] args) {

        System.out.println();

        if (args.length < 1) {
            throw new ArgumentoInvalidoException("Você deve informar um comando!");
        }

        String comando = args[0].toLowerCase(Locale.ROOT);
        String email = "";

        if (args.length > 1) {
            email = args[1];
        }

        System.out.println("> Rodando comando: " + comando + "\n---");
        switch (comando) {
            case "add":
                if (email.isEmpty()) {
                    System.out.println("Você deve informar um email!");
                } else {
                    System.out.println("Adicionando: " + email);
                    User usuario = new User(email);
                    this.getGroup().adiciona(usuario);
                    this.getGroup().useDataBaseProcessor().updateUserTable(comando, email);
                    System.out.println("Usuário adicionado!");
                    System.out.println("Lista de Usuários:");
                    this.getGroup().listaTodos();
                }
                break;

            case "del":
                if (email.isEmpty()) {
                    System.out.println("Você deve informar um email!");
                } else {
                    System.out.println("Deletando usuário " + email + "!");
                    this.getGroup().remove(email);
                    this.getGroup().useDataBaseProcessor().updateUserTable(comando, email);
                    this.getGroup().listaTodos();
                }
                break;

            case "msg":
                if (!(args.length == 3)) {
                    System.out.println("Erro na quantidade de argumentos!");
                    System.out.println("Lembre-se de inserir uma mensagem entre aspas no terceiro argumento");
                } else {
                    String msg = args[2];
                    if (this.getGroup().useDataBaseProcessor().existInUserTable(email)) {
                        System.out.println("Usuário: " + email);
                        System.out.println("Mensagem: " + msg);
                        System.out.println("-");
                        this.getGroup().mensagem(
                                new Message(
                                        new Timestamp(new Date().getTime()),
                                        email,
                                        msg
                                )
                        );
                    } else {
                        System.out.println("Ops, este usuário não está neste grupo!");
                    }
                }
                break;

            case "lst":
                System.out.println("Listando todos os usuários:");
                this.getGroup().listaTodos();
                break;

            default:
                throw new ArgumentoInvalidoException();
        }
    }
}

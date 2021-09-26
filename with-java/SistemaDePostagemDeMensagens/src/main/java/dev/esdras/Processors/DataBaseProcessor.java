package dev.esdras.Processors;

import dev.esdras.Entities.User;
import dev.esdras.Interfaces.ObservableIF;
import jdk.dynalink.StandardOperation;

import java.io.*;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class DataBaseProcessor {

    private String databaseName;
    private String userTableName;

    public DataBaseProcessor(String databaseName, String userTableName) {
        this.setDatabaseName(databaseName);
        this.setUserTableName(userTableName);
        this.constroiDataBaseIfNotExists(this.getDatabaseName());
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getUserTableName() {
        return userTableName;
    }

    public void setUserTableName(String userTableName) {
        this.userTableName = userTableName;
    }

    private boolean constroiDataBaseIfNotExists(String dirName) {
        File dir = new File(dirName);
        if (!(dir.exists())) {
            return dir.mkdir();
        }
        return false;
    }

    public boolean existInUserTable(String email) {
        String path = this.getDatabaseName() + "/" + this.getUserTableName();
        File file = new File(path);
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String linha = br.readLine();
                while (linha != null) {
                    if (linha.equalsIgnoreCase(email)) {
                        return true;
                    }
                    linha = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public List<User> readUserTable() {
        List<User> databaseUsers = new LinkedList<>();

        String path = this.getDatabaseName() + "/" + this.getUserTableName();
        File file = new File(path);
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String linha = br.readLine();
                while (linha != null) {
                    databaseUsers.add(new User(linha));
                    linha = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return databaseUsers;
    }

    public void updateUserTable(String action, String email) {

        boolean userExist = false;

        String path = this.getDatabaseName() + "/" + this.getUserTableName();
        File file = new File(path);
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String linha = br.readLine();
                while (linha != null) {
                    if (linha.equalsIgnoreCase(email)) {
                        userExist = true;
                        break;
                    }
                    linha = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        switch (action) {
            case "add":

                if (!userExist) {
                    try (FileWriter fw = new FileWriter(path, true);
                         BufferedWriter bw = new BufferedWriter(fw);
                         PrintWriter out = new PrintWriter(bw)
                    ) {
                        out.println(email);
                    } catch (IOException e) {
                        System.out.println("Ocorreu erro ao salvar na tabela!");
                        e.printStackTrace();
                    }
                }

                break;

            case "del":

                if (userExist) {
                    File tempFile = new File(file.getAbsolutePath() + ".tmp");
                    try (BufferedReader br = new BufferedReader(new FileReader(file));
                         PrintWriter pw = new PrintWriter(new PrintWriter(tempFile));
                    ) {
                        String linha = null;
                        while ((linha = br.readLine()) != null) {
                            if (!linha.trim().equals(email)) {
                                pw.println(linha);
                                pw.flush();
                            }
                        }

                        if(!file.delete()) {
                            System.out.println("Ops, houve um erro ao fazer atualização do banco de dados");
                            return;
                        }

                        if (!tempFile.renameTo(file)) {
                            System.out.println("Ops, houve um erro ao atualizar banco de dados");
                            return;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Ops, este usuário não está registrado no banco!");
                }
                break;
        }



    }
}

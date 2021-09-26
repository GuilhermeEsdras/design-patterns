package dev.esdras.Client;


import dev.esdras.Impl.GroupFacadeImpl;
import dev.esdras.Interfaces.GroupFacadeIF;

public class WhatsApp
{
    public static void main( String[] args )
    {

        GroupFacadeIF grupoFachada = new GroupFacadeImpl();
        grupoFachada.initialize();
        grupoFachada.run(args);

    }
}

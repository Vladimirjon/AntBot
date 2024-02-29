package McAntBot;

import McInteligenciaArtificial.IAbot;

public class MchormigaSoldado implements IgenerarSerie, IgenerarCodigo {

    public void mostrar(){
        System.out.println("La hormiga soldado esta lista");
        System.out.println("Codigo de seguridad: " + generaCodigo()  +" Codigo de serie: "+ generaSerie());
    }

    
}

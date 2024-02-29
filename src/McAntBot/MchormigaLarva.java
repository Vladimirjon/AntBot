package McAntBot;

import McInteligenciaArtificial.IAbot;

public class MchormigaLarva implements IgenerarSerie, IgenerarCodigo {

    public void mostrar(){
        System.out.println("La hormiga Larva esta lista con su numero de serie: "+ generaSerie() );
        System.out.println("Codigo de seguridad: " + generaCodigo()  );
    }

  
}

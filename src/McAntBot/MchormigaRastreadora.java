package McAntBot;

public class MchormigaRastreadora implements IgenerarSerie, IgenerarCodigo {
    public void mostrar(){
        System.out.println("La hormiga rastreadora esta lista ");
        System.out.println("Codigo de seguridad: " + generaCodigo()  +" Codigo de serie: "+ generaSerie());
    }

}

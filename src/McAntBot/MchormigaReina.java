package McAntBot;

public class MchormigaReina implements IgenerarSerie, IgenerarCodigo {
    private String codigoSerie;

    public MchormigaReina() {
        this.codigoSerie = generaSerie();
    }

    public void mostrar() {
        System.out.println("La hormiga reina está lista ");
        System.out.println("Codigo de seguridad: " + generaCodigo());
    }
}

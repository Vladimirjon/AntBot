package McInteligenciaArtificial;

public class IAbot {
    private static IAbot instance;
    private static String nombre;

    private IAbot() {}

    protected IAbot(IAbot iAbot) {
        if (iAbot  !=null)
            instance = iAbot;
    }

    public static IAbot getInstance(String nombre) {
        if (instance == null) {
            instance = new IAbot();
            instance.setNombre(nombre);
        }
        return instance;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

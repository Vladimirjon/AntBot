package Hormiga;
public abstract class Alimento {
    
    private String TJcomida;

    // Constructor de la clase abstracta Alimento
    public Alimento(int TJopcionComida){
        String[] TJtipoComida = { "Carnivoro", "Herbivoro", "Omnivoro", "Insectivoro"};
        this.TJcomida = TJtipoComida[TJopcionComida];
    }

    // Getters y setters (pueden ser necesarios)

    public String getTJcomida() {
        return TJcomida;
    }

    public void setTJcomida(String TJcomida) {
        this.TJcomida = TJcomida;
    }
}


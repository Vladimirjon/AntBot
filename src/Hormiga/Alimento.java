package Hormiga;

public abstract class Alimento implements IHormiga, IIA{
    
    private String TJcomida;
    private String TJcomidaAceptada = "Carnivoro";
    
    public Alimento(int TJopcionComida){
        
        String[] TJtipoComida = { "Carnivoro", "Herbivoro", "Omnivoro", "Insectivoro"};
        this.TJcomida = TJtipoComida[TJopcionComida];
    }

    public boolean comer(String TJcomida) {

        if (TJcomida.equals(TJcomidaAceptada)) {
            
        }


        return true;
    }
}

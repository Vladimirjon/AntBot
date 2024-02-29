package Hormiga;

public class IaBot implements MenteControl, IIngles, IRuso{
    
    @Override
    public void Instrucciones(String raza){

        System.out.println("Iniciando protocolo de control mental para " + raza);

        System.out.println("Sensores listos!");
        System.out.println("Antena lista!");
        System.out.println("Radio lista!");


    }

    public void IdiomarRuso(){
        System.out.println("--->  Ruso tecnico.... lexico, gramatica, fonetica transferida al ANTBOT");
    }

    public void IdiomarIngles(){
        System.out.println("--->  Ingles tecnico.... lexico, gramatica, fonetica transferida al ANTBOT");
    }

}

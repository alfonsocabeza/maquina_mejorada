public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    
    private boolean premioVeinticinco;
    
    private int numeroMaximoBillete;
    
    public int numeroBilletesVendidos;
    public MaquinaExpendedoraMejorada(boolean trueofalse, int billetes) {
        precioBillete = 4;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        premioVeinticinco = trueofalse;
        estacionOrigen = "Leon";
        numeroMaximoBillete = billetes;
        estacionDestino = "Astorga";
        
    }
   
    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean trueofalse) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        numeroBilletesVendidos = 0;
        totalDineroAcumulado = 0;
        premioVeinticinco = trueofalse;
        estacionOrigen = origen;
        estacionDestino = destino;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }
    
    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }
    
    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        
        if (numeroBilletesVendidos < numeroMaximoBillete) {
            balanceClienteActual = balanceClienteActual + cantidadIntroducida;
        }
        else {
            System.out.println(cantidadIntroducida + "ya no puedes introducir mas dinero");
        }        
    }
    
    public int vaciarDineroDeLaMaquina(){
        int vaciarDineroDeLaMaquina= balanceClienteActual + totalDineroAcumulado;
        if (balanceClienteActual > 0) {
            vaciarDineroDeLaMaquina = -1;
        }
        else{
            totalDineroAcumulado = 0;
        }
        return vaciarDineroDeLaMaquina;
    }
    
        
    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta;
        cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        if (numeroBilletesVendidos < numeroMaximoBillete){
            if (cantidadDeDineroQueFalta <= 0) {        
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();         
    
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                numeroBilletesVendidos= numeroBilletesVendidos +1;
                if (premioVeinticinco == true) {
                 System.out.println("has recibido " + (precioBillete*0.25) + "€");
                }
                else{
                 System.out.println(); 
                 
                }
        }
        else {
            System.out.println("necesitas " + cantidadDeDineroQueFalta + " euros mas");   
        }  
    }
    else{
            System.out.println("ya no puedes imprimir mas billetes");
        }
}
    public void imprimirNumeroBilletesVendidos(){
        System.out.println(numeroBilletesVendidos + " billetes vendidos");
    }
    public int getNumeroBilletesVendidos(){
        return numeroBilletesVendidos;
    }
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
}
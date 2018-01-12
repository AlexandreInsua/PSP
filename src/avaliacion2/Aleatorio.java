package avaliacion2;


// Clase Random
//
// CONSTRUCCION: con (a) ninguna inicialización o (b) un entero
//     que especifica el estado inicial del generador
//
// **********************PUBLIC OPERATIONS*************************
//     Devuelve un número aleatorio siguiendo una cierta distribución
// int randomInt( )                    --> Uniforme, 1 a 2^31-1
// double randomReal( )                --> Uniforme, 0..1
// int randomInt int linf, int lsup )  --> Uniforme linf..lsup
// int poisson( double expectedVal )   --> Poisson
// double negExp( double expectedVal ) --> Exponential Negativa
//     Un método estático relacionado:
// void permute( Object [ ] a )        --> Permutación aleatoria

/**
 * Clase de números aleatorios que emplea un  
 * generador lineal de congruencias 31-bit.
 * Obsérvese que java.util contiene una clase Random,
 * por lo que se deben vigilar los conflictos de nombres.
 */
public class Aleatorio
{
    
/**
 * Construcción de un objeto Aleatorio cuyo
 * estado inicial se obtiene del reloj del sistema.
 */
public Aleatorio( )
{
    this( (int) ( System.currentTimeMillis( ) 
                  % Integer.MAX_VALUE ) );
}

/**
 * Construcción de un objeto Aleatorio 
 * especificando un estado inicial.
 * @param valorInicial el estado inicial.
 */
public Aleatorio( int valorInicial )
{
    if( valorInicial < 0 )
        valorInicial += M;

    estado = valorInicial;
    if( estado == 0 )
        estado = 1;
}
    
private static final int A = 48271;
private static final int M = 2147483647;
private static final int Q = M / A;
private static final int R = M % A;

/**
 * Devuelve un entero pseudoaleatorio y cambia el
 * estado interno.
 * @return un entero pseudoaleatorio.
 */    
public int randomInt( )
{
    int estadoTmp = A * ( estado % Q ) - R * ( estado / Q );
    if( estadoTmp >= 0 )
        estado = estadoTmp;
    else
        estado = estadoTmp + M;
    return estado;
}
   
    
public double randomReal( ) {
    return randomInt( ) / ( double ) M;
}
public int randomInt( int linf, int lsup )   { /* Figura 9.8 */ 
    Double d=new Double(randomReal()*(lsup-linf+1)-0.5);
    return d.intValue();
}  
    //    public int poisson( double valorEsperado )
    
/**
 * Devuelve un entero usando una distribución de Poisson y
 * cambia el estado interno.
 * @param valorEsperado la media de la distribución.
 * @return el int pseudoaleatorio.
 */
public int poisson( double valorEsperado )
{
    double limite = -valorEsperado;
    double producto = Math.log( randomReal( ) );
    int contador;

    for( contador = 0; producto > limite; contador++ )
        producto += Math.log( randomReal( ) );

    return contador;
}


//    public double negExp( double valorEsperado )

/**
 * Devuelve un valor de tipo double que sigue una distribución 
 * exponencial y cambia el estado interno.
 * @param valorEsperado la media de la distribución.
 * @return el double pseudoaleatorio.
 */
public double negExp( double valorEsperado )
{
    return - valorEsperado * Math.log( randomReal( ) );
}


//    public static final void permute( Object [ ] a )

/**
 * Reordena un vector de forma aleatoria.
 * Los números aleatorios empleados dependen de la hora y el día.
 * @param a el vector.
 */


    private int estado;
}

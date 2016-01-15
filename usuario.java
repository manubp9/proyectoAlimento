
/**
 * Usuario que puede comer una cantidad variable de alimentos
 * A partir del código final de la actividad 0289, crea una nueva clase llamada Usuario 
 * y codifica el código necesario para poder crear objetos de la clase Usuario. 
 * Estos objetos de tipo Usuario representan a personas que usan nuestra aplicación.
 */
import java.util.ArrayList;

public class usuario
{
    // instance variables - replace the example below with your own
    private String nombre;
    private float gramosTotales;
    private float proteinasTotales;
    private float carbohidratosTotales;
    private float grasasTotales;
    private float caloriasTotales;
    private float masCalorico;
    private float alimentosComidos;
    private Alimento alimentoc;//en este atributo guarda el alimento mas calorico ingerido hasta el momento
    private ArrayList<Alimento> listaDeAlimentos;//este atributo guarda en una lista los alimentos ingeridos

    /**
     * inicializa el nombre del usuario y la cantidad de alimento con sus nutrientes
     */
    public usuario(String nombre)
    {
        this.nombre = nombre;
        gramosTotales = 0;
        proteinasTotales = 0;
        carbohidratosTotales =0;
        grasasTotales =0;
        caloriasTotales =0;
        masCalorico = 0;
        alimentosComidos = 0;
        alimentoc = null;
        listaDeAlimentos = new ArrayList<Alimento>();//crea un objeto lista de alimentos de tipo alimento

    }

    /**
     * Metodo que da de comer al usuario alimentos
     */
    public void comer(Alimento alimentoQueCome,float gramosDeAlimento)
    { 
        proteinasTotales = proteinasTotales + alimentoQueCome.verProteinas()*(gramosDeAlimento/100);
        carbohidratosTotales = carbohidratosTotales+alimentoQueCome.verCarbohidratos()*(gramosDeAlimento/100);
        grasasTotales = grasasTotales + alimentoQueCome.verGrasas()*(gramosDeAlimento/100);
        caloriasTotales = caloriasTotales + alimentoQueCome.verCalorias()*(gramosDeAlimento/100);
        gramosTotales = gramosTotales + gramosDeAlimento;
        alimentosComidos =+ 1;
        if(alimentoc != null){
            if (alimentoc.verCalorias()<= alimentoQueCome.verCalorias())
            {
                alimentoc = alimentoQueCome;
            }
        }else
        {
            alimentoc =alimentoQueCome;
        }
        listaDeAlimentos.add(alimentoQueCome);//añade el alimento que come a la lista de alimentos.

    }

    /**
     * imprime el alimento mas calorico ingerido
     */
    public void alimentoMasCalorico()
    {
        if (alimentosComidos == 0)
        {
            System.out.println("No se ha ingerido ningun alimento");
        }
        else {System.out.println("Alimento más calórico ingerido por este usuario hasta el momento: "+alimentoc.getNombre()+ "("+alimentoc.verCalorias()+" calorias por cada 100 gramos");
        }
    }

    /**
     * metodo que muestra los datos completos de todos los atributos del alimento que ha comido
     */
    public void mostrarDatos()
    {
        System.out.println("Nombre:                                     "+nombre);
        System.out.println("Gramos totales de proteinas ingeridos:      "+proteinasTotales);
        System.out.println("Gramos totales de carbohidratos ingeridos:  "+carbohidratosTotales);
        System.out.println("Gramos totales de grasas ingeridos:         "+grasasTotales);
        System.out.println("Calorias totales ingeridas:                 "+caloriasTotales);
    }

    /**
     * metodo para comparar la ingesta de calorias entre dos usuarios
     */
    public void compararCalorias(usuario usuarioAComparar)
    {
        if (caloriasTotales == usuarioAComparar.getCalorias())
        {
            System.out.println( usuarioAComparar.getNombre()+" ha consumido las mismas calorias que "+nombre+"("+ usuarioAComparar.getCalorias()+ "frente a "+caloriasTotales+")");
        }
        else if(caloriasTotales < usuarioAComparar.getCalorias())
        {
            System.out.println( usuarioAComparar.getNombre()+" ha consumido mas calorias que "+nombre+"("+ usuarioAComparar.getCalorias()+ "frente a "+caloriasTotales+")");
        }
        else 
        {
            System.out.println(nombre+" ha consumido mas calorias que "+usuarioAComparar.getNombre()+"("+caloriasTotales+ "frente a "+ usuarioAComparar.getCalorias()+")");
        }

    }

    /**
     * devuelve el nombre del usuario
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * devuelve el numero de calorias
     */
    public float getCalorias()
    {
        return caloriasTotales;
    }

    /**
     * muestra los valores del alimento que escojas introduciendo el numero que ocupa por orden.
     */
    public void seleccionarAlimentoConsumido(int lugar)
    {
        if (( lugar >0) && (lugar <= listaDeAlimentos.size()))
        {
            int index = lugar - 1 ;//variable local indice
            Alimento alimentoSeleccionado = listaDeAlimentos.get(index);
            alimentoSeleccionado.muestraDatos();
        }
        else 
        {
            System.out.println("El numero introducido no esta en la lista");
        }
    }

    /**
     * metodo que permita pasar como parámetro el nombre de un alimento ,
     * indique si el usuario ha comido ese alimento más de una vez o no y, 
     * en caso afirmativo, cuántas veces lo ha hecho.
     */
    public void comprobarAlimento(String nombreDeAlimento)
    { int contador = 0;
        for ( Alimento alimentoComprobado : listaDeAlimentos )//
        {
            if ( alimentoComprobado.getNombre().contains(nombreDeAlimento))
            {
                contador ++;
                          
            }
        }
        if (contador >1)
        {
         System.out.println("el alimento "+ nombreDeAlimento+" se ha comido "+contador+" veces" );
        }
        else 
        if (contador == 1 )
        {
             System.out.println("el alimento "+ nombreDeAlimento+" se ha comido "+contador+" vez" );
            
        }
        else
        {
            System.out.println("El alimento "+nombreDeAlimento+" no se ha comido todavia");
        }
    }
}


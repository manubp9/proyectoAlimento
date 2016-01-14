/**
 * 
 * Se desea realizar una aplicación destinada a personas que están a dieta y que necesitan contar la calorías 
 * y los macronutrientes de los alimentos que ingieren.
 * Los alimentos están constituidos por 3 tipos de macronutrientes: 
 * proteínas, carbohidratos y grasas. 
 * En las etiquetas de los productos se pueden ver los gramos de proteínas, 
 * carbohidratos y grasas que tiene cada alimento por cada 100 gramos de alimento.
 * Las calorías de un alimento se pueden saber teniendo en cuenta que 
 * --cada gramo de proteínas 
 * o de carbohidratos aporta 4 calorías y que cada gramo de 
 * --grasa aporta 9 calorías.
 * Crea un nuevo proyecto en BlueJ y luego crea un repositorio git en la carpeta correspondiente a dicho proyecto.
 * Codifica el código necesario para poder crear objetos de la clase Alimento. 
 * 1--Al crear un alimento se proporciona únicamente el nombre del alimento y los gramos de proteínas, 
 * carbohidratos y grasas por cada 100 gramos de alimento en ese orden. 
 * 2--Consideramos que los gramos de proteínas, carbohidratos y grasas vienen dados como float.
 * 3--Una vez creados los alimentos debemos ser capaces de visualizar su información nutricional invocando un método 
 * llamado muestraDatos, La información que debe mostrarse incluye el 
 * --nombre del alimento, 
 * --la cantidad de gramos de proteínas, 
 * --carbohidratos y 
 * --grasas por cada 100 gramos de alimento, 
 * la cantidad de calorías por cada 100 gramos y el tipo de macronutriente mayoritario. 
 * En caso de que haya más de un macronutriente mayoritario debe indicarse cuáles son.
 * En caso de empate se muestran los empatados
 * Un ejemplo de visualización por pantalla de estos datos es:

 *      Nombre:                            Pollo
 *      Proteinas por cada 100 gramos:     25.0
 *      Carbohidratos por cada 100 gramos: 0.0
 *      Grasas por cada 100 gramos:        13.0
 *      Calorias:                          217.0
 *      Componente/s mayoritario/s:        Proteinas
 *      Sube el proyecto a GitHub e indica la URL del último commit.
 */
public class alimento
{
    // instance variables - replace the example below with your own
    private String nombre;
    private float proteinas;
    private float carbohidratos;
    private float grasas;
    private float calorias;

    /**
     * Constructor for objects of class alimento
     */
    public alimento(String nombre,float proteinas,float carbohidratos,float grasas)
    {
        this.nombre = nombre;
        this.proteinas = proteinas;
        this.carbohidratos = carbohidratos;
        this.grasas = grasas;
        calorias = (proteinas*4 )+ (carbohidratos*4)+(grasas*9);
    }
     /**
     * compara que nutriente es el mayor o mayores
     */
    public void mayorComp()
    {
        if ((proteinas == carbohidratos) && (proteinas == grasas))
        {
            System.out.println("Componente/s mayoritario/s:         proteinas, carbohidratos y grasas");
        }
        else 
        {
            if (proteinas == carbohidratos && carbohidratos > grasas)
            {
                System.out.println("Componente/s mayoritario/s:         proteinas y carbohidratos");
            }
            else 
            {
                if (proteinas == grasas && grasas > carbohidratos)
                {
                    System.out.println("Componente/s mayoritario/s:         proteinas y grasas");
                }
                else 
                {
                    if ( carbohidratos == grasas && grasas > proteinas)
                    {
                        System.out.println("Componente/s mayoritario/s:         carbohidratos y grasas");
                    }
                    else 
                    {
                        if (proteinas > carbohidratos && proteinas > grasas)
                        {
                            System.out.println("Componente/s mayoritario/s:         proteinas");
                        }
                        else 
                        {
                            if (carbohidratos > proteinas && carbohidratos > grasas)
                            {
                                System.out.println("Componente/s mayoritario/s:         carbohidratos");
                            }
                            else 
                            {
                                System.out.println("Componente/s mayoritario/s:         grasas");
                            }
                        }
                    }
                }
            }
        }
    }
    /**
     * nos da la informacion nutricional del alimento
     */
    public void muestraDatos()
    {
        System.out.println("Nombre:                             "+nombre);
        System.out.println("Proteinas por cada 100 gramos:      "+proteinas);
        System.out.println("Carbohidratos por cada 100 gramos:  "+carbohidratos);
        System.out.println("Grasas por cada 100 gramos:         "+grasas);
        System.out.println("Calorias:                           "+calorias);     
        mayorComp();
    }
    /**
     * nos da la informacion proteica
     */
    public float verProteinas()
    {
        return proteinas;
    }
    /**
     * nos da la informacion carbohidraica
     */
    public float verCarbohidratos()
    {
        return carbohidratos;
    }
    /**
     * nos da la informacion de la grasa
     */
    public float verGrasas()
    {
        return grasas;
    }
     /**
     * nos da la informacion calorica
     */
    public float verCalorias()
    {
        return calorias;
    }
    /**
     * devuelve el nombre del alimento
     */
    public String getNombre()
    {
        return nombre;
    }
    
}    

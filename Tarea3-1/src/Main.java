import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static ArrayList<Comida> entrada = new ArrayList();
    private static ArrayList<Comida> principal = new ArrayList();
    private static ArrayList<Comida> postre = new ArrayList();
    private static Scanner sc = new Scanner(System.in);
    private static int limitecalorias = 600;
    private static int contadorcalorias = 0;
    private static Comida ultimoentrada = null; //estos 3 guardan la ultima seleccion del usuario
    private static Comida ultimoprincipal= null;
    private static Comida ultimopostre = null  ;
    public static void main(String[] args) {
        cargarmenu(); //carga los platos en listas
        mostrarmenu(); //inicia la interaccion con el usuario
    }
    public static void cargarmenu(){
        //Entrada
        entrada.add(new Comida("paella", 200, "entrada"));
        entrada.add(new Comida("gazpacho",150, " entrada"));
        entrada.add(new Comida("Pasta", 300, " entrada"));
        entrada.add(new Comida("Ensalada cesar", 180, " entrada"));
        entrada.add(new Comida("Sopa de verduras", 120, " entrada"));
        //principal
        principal.add(new Comida("filete de cerdo", 400, "princial"));
        principal.add(new Comida("pollo asado", 280, "plato pincipal"));
        principal.add(new Comida("bisteck a lo pobre", 500, "plato principal"));
        principal.add(new Comida("Trucha ", 160, "plato pincipal"));
        principal.add(new Comida("Bacalao", 300, "plato pincipal"));
        principal.add(new Comida("Salmon a la plancha ", 350, "plato pincipal"));
        principal.add(new Comida("Lasaña", 450, "plato pincipal"));
        //postre
        postre.add(new Comida("flan",200,"postre"));
        postre.add(new Comida("naranja",50,"postre"));
        postre.add(new Comida("nueces ",500,"postre"));
        postre.add(new Comida("Yogurt",100,"postre"));
        postre.add(new Comida("Helado",250,"postre"));
    }
    // Interfaz  que muestra menú y recibe opciones del usuario
    public static void mostrarmenu(){
        System.out.println("----Bienvenido a Mi Mejor Comida----");
        System.out.println("\n¡MPORTANTE! Si su pedido excede el limite de calorias se cancelara automaticamente \n");
        boolean salir = false;

        while(!salir && contadorcalorias < limitecalorias){
            System.out.println("\nCalorias dispnibles " +(limitecalorias - contadorcalorias));
            System.out.println("Calorias Totales " + contadorcalorias);
            if (limitecalorias <= contadorcalorias){
                System.out.print(" (¡No válida! Se excluye automáticamente)\n");
                return;
            }
            System.out.println("1. Entradas. ");
            System.out.println("2. Platos principales.");
            System.out.println("3. Postres.");
            System.out.println("4. Combinaciones de platillos bajos en calorias.");
            System.out.println("5. Finalizar pedido.");
            System.out.print("---Selecciones su comida: ");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1:
                    mostrarEntrada();
                    break;
                case 2:
                    mostrarPrincipal();
                    break;
                case 3:
                    mostrarPostre();
                    break;
                case 4:
                    combinacionesbajascal();
                    break;
                case 5:
                    salir = true;
                    System.out.println("Gracias por su visita");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

               //muestra lo platos que fueron seleccionados por el usuario
        }    if (ultimoentrada != null || ultimoprincipal != null || ultimopostre != null) {
            System.out.println("Resumen del pedido: ");
            if (ultimoentrada != null) {
                System.out.println("- Entrada: " + ultimoentrada.getNombre() + " (" + ultimoentrada.getCalorias() + " calorías)");
            }
            if (ultimoprincipal != null) {
                System.out.println("- Plato principal: " + ultimoprincipal.getNombre() + " (" + ultimoprincipal.getCalorias() + " calorías)");
            }
            if (ultimopostre != null) {
                System.out.println("- Postre: " + ultimopostre.getNombre() + " (" + ultimopostre.getCalorias() + " calorías)");
            }
        }
    }

    //platillo de entrada (en general mostrarEntrada/mostrarPrincipal/mostrarPostre tienen la misma estructura)
    public static void mostrarEntrada() {
        System.out.println("\nPlatillos de entrada");
        //genera alternativas dependiendo de cuantas hayan en el ArrayList
        for (int i = 0; i < entrada.size(); i++) {
            System.out.println((i + 1) + ". " + entrada.get(i));
        }
        System.out.print("\n----Seleccione un platillo: ");
        int opcion = sc.nextInt();

        if (opcion >= 1 && opcion <= entrada.size()) {
            Comida seleccionada = entrada.get(opcion - 1);
            ultimoentrada = seleccionada;
            // Verificar límite de calorías antes de agregar
            if (contadorcalorias + seleccionada.getCalorias() <= limitecalorias) {
                contadorcalorias += seleccionada.getCalorias();
                System.out.println("Ha seleccionado " + seleccionada.getNombre() +
                        " (" + seleccionada.getCalorias() + " calorías)");
            } else {
                System.out.println("¡Excede el límite de calorías! (" +  (contadorcalorias + seleccionada.getCalorias()) + "/" + limitecalorias + ")");

            }
        } else {
            System.out.println("Opción no válida");
        }
    }
    //platillo principal
    public static void mostrarPrincipal(){
        System.out.println("Plato principal");

        for (int i = 0; i < principal.size(); i++) {
            System.out.println((i + 1) + ". " + principal.get(i));
        }
        System.out.print("\n----Seleccion un platillo: ");
        int opcion = sc.nextInt();
        if (opcion >= 1 && opcion <= principal.size()) {
            Comida seleccionada = principal.get(opcion - 1);
            ultimoprincipal = seleccionada;
            //verifica si no se superan la calorias
            if(contadorcalorias + seleccionada.getCalorias() <= limitecalorias){
                contadorcalorias += seleccionada.getCalorias();
                System.out.println("Ha seleccionado " + seleccionada.getNombre() + "(" + seleccionada.getCalorias()+ ")");
            }
            else{System.out.println("¡Excede el límite de calorías! " + (contadorcalorias + seleccionada.getCalorias()) + "/" + limitecalorias + ")");

            }

        }else{System.out.println("Opcion no valida");}
    }
    //Postre
    public static void mostrarPostre(){
        System.out.println("Plato postre");
        for (int i = 0; i < postre.size(); i++) {
            System.out.println((i + 1) + ". " + postre.get(i));
        }
        System.out.print("\n----Seleccion un platillo: ");
        int opcion = sc.nextInt();

        if (opcion >= 1 && opcion <= postre.size()){
            Comida seleccionada = postre.get(opcion - 1);
            ultimopostre = seleccionada;
            if(contadorcalorias + seleccionada.getCalorias() <= limitecalorias){
                contadorcalorias += seleccionada.getCalorias();
                System.out.println("Ha seleccionado " + seleccionada.getNombre() + "(" + seleccionada.getCalorias()+ ")");
            }
            else{System.out.println("¡Excede el límite de calorías! " + (contadorcalorias + seleccionada.getCalorias()) + "/" + limitecalorias + ")");

            }

        }else{System.out.println("Opcion no valida");}

 }

    // Muestra todas las combinaciones posibles de entrada + principal + postre que no superen el límite de calorías (programación funcional con streams)
 public static void combinacionesbajascal() {
     System.out.println("Combinaciones que no superan las " + limitecalorias + " calorias");
     entrada.stream().forEach(e -> principal.stream().forEach(p -> postre.stream().forEach(po -> {
                         int total = e.getCalorias() + p.getCalorias() + po.getCalorias();
                         if (total < limitecalorias) {
                             System.out.println("- Entrada: " + e.getNombre() + " - Plato Princicpal:" + p.getNombre() + " - Postre" + po.getNombre() + "TOTAL =>" + total + "calorias");

                         }
                     })
             )
     );
 }
}



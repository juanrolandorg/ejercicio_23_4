public class App {
    public static void main(String[] args) throws Exception {
        // datos:
        // Ivas: IVAgen=21%; IVA red: 10%; IVAsuperred: 4%
        //promociones pueden ser: no, mitad, menos 5 (menos 5 euros), 5%

    //pedimos el precio sin IVA
    System.out.println("Por favor introduzca el precio sin el IVA");
    float precioNorm = Float.parseFloat(System.console().readLine());

    //pedimos el IVA
    System.out.println(
        """
    Introduzca el tipo de IVA usando el número indicado:
    1: General
    2: Reducido
    3: Superreducido
    """);
    String tipoIVA = System.console().readLine();
    int IVANum = 0;

    //creamos el condicional para ver que descuento se aplica
   switch (tipoIVA) { 
    case "1": 
        IVANum = 21;
        break;
    case "2":
        IVANum = 10;
        break;
    case "3":
        IVANum = 4;
        break;
    default: System.out.println("Por favor introduzca el tipo de IVA según el menú numérico");
        break;}

   //Calculamos el IVA y lo añadimos al precio sin descuento
   float IVA = precioNorm * IVANum / 100;
   float preNoDesc = precioNorm + IVA;

   //tenemos en cuenta el decuento, primero lo pedimos
   System.out.print(""" 
    Por favor introduzca el tipo de descuento:
    1: No hay decuento
    2: Mitad de precio, es decir, 50%
    3: Descuento de 5 euros
    4: Descuento del 5%  
           """);
    
    //aplicamos el condicional para el descuento
    String valorDescu = System.console().readLine();
    float descu = 0;
    switch (valorDescu) {
        case "1":
            break;
        case "2":
            descu = 0.5f;
            break;
        case "3":
            descu = 5f;
            break;
        case"4":
            descu =0.05f;
            break;    
        default: System.out.println("Por favor introduzca el tipo de descuento según el menú numérico");
            break;}
    //calculamos el descuento
    float total = preNoDesc - descu;

    //"dibujamos el ticket"
    System.out.printf("%-19s %.2f\n", "Base Imponible:", precioNorm);
    System.out.printf("%-19s %.2f\n", "IVA (" + IVANum + "%):", IVA);
    System.out.printf("%-19s %.2f\n", "Precio con IVA:", preNoDesc);
    System.out.printf("%-19s %.2f\n", "Descuento aplicado:", preNoDesc - total);
    System.out.printf("%-19s %.2f\n", "TOTAL:", total);
    }
}

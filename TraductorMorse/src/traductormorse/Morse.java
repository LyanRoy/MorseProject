package traductormorse;

/**
 *
 * @author Heydi y sus cabras del monte
 */
public class Morse {
    
    /*
    * Inicializamos el morse y que sea de tipo estático para que sus variables
    * no cambien para el resto de las clases y los métodos.
    */
    static String morse[] = new String[210];
    
    /*
    * El método código le asigna los valores en morse a su respectiva letra, 
    * para hacer tal cosa, se toma como referencia el código ASCII en el cual
    * por ejemplo la 'A' su valor como entero es el número 65.
    */
    public void codigo() {
        morse[32] = "/"; //espacio en blanco
        morse[65] = ".-"; //A
        morse[66] = "-.."; //B
        morse[67] = "-.-."; //C
        morse[68] = "-.."; //D
        morse[69] = "."; //E
        morse[70] = "..-."; //F
        morse[71] = "--."; //G
        morse[72] = "...."; //H
        morse[73] = ".."; //I
        morse[74] = ".---"; //J
        morse[75] = "-.-"; //K
        morse[76] = ".-.."; //L
        morse[77] = "--"; //M
        morse[78] = "-."; //N
        morse[209] = "--.--"; //Ñ
        morse[79] = "---"; //O
        morse[80] = ".--."; //P
        morse[81] = "--.-"; //Q
        morse[82] = ".-."; //R
        morse[83] = "..."; //S
        morse[84] = "-"; //T
        morse[85] = "..-"; //U
        morse[86] = "...-"; //V
        morse[87] = ".--"; //W
        morse[88] = "-..-"; //X
        morse[89] = "-.--"; //Y
        morse[90] = "--.."; //Z
        morse[48] = "-----"; //0
        morse[49] = ".---"; //1
        morse[50] = "..---"; //2
        morse[51] = "...--"; //3
        morse[52] = "....-"; //4
        morse[53] = "....."; //5
        morse[54] = "-...."; //6
        morse[55] = "--..."; //7
        morse[56] = "---.."; //8
        morse[57] = "-----"; //9
        morse[46] = ".-.-.-"; //.
        morse[44] = "--..--"; //,
        morse[63] = "..--.."; //?
        morse[34] = ".-..-."; //"
        morse[33] = "-.-.--"; //!
    }
    
    /*
    * Se inicializan las variables ORIGINAL y REEMPLAZO, las cuales serán 
    * de tipo privada, estáticas y finales, y serán llamadas por el método 
    * quitarAcentos(); para que cambien las letras que tengan acentos por
    * letras que no los tengan para que se pueda hacer su traducción al morse.
    */
    private static final String ORIGINAL
            = "ÁáÉéÍíÓóÚúÜü¿¡";
    private static final String REEMPLAZO
            = "AaEeIiOoUuUu?!";

    private static String quitarAcentos(String temp) {
        if (temp == null) {
            return null;
        }
        char[] texto = temp.toCharArray();
        for (int i = 0; i < texto.length; i++) {
            int pos = ORIGINAL.indexOf(texto[i]);
            if (pos > -1) {
                texto[i] = REEMPLAZO.charAt(pos);
            }
        }
        return new String(texto);
    }

    /*
    * En este método mandamos a llamar quitarAcentos() y después caractér por 
    * caractér convertimos a mayúsculas para su posterior traducción. 
    */
    public String convertir(String texto) {
        String texto2 = quitarAcentos(texto);
        texto = "";
        for (int i = 0; i < texto2.length(); i++) {
            char temp = Character.toUpperCase(texto2.charAt(i));
            System.out.println(texto2.charAt(i));
            System.out.println(Integer.toString(temp));
            texto += morse[temp]+" ";
            System.out.println(texto);
        }
        return texto;
    }
}

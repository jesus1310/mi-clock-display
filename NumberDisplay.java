
/**
 * Un constructor que recibe por parámetro el límite del display y 
 * que fija el valor actual del display a 0.
 * Un método setter que fija el valor actual del display al valor pasado como parámetro 
 * (nombre del método: setValue).
 * Un método que devuelve el valor actual del display en forma de cadena de 2 caracteres 
 * (nombre del método: getDisplayValue).
 * Un método que devuelve el valor actual del display como entero 
 * (nombre del método: getValue),
 * Un método que incrementa en 1 al display y lo hace volver al principio si alcanza el límite 
 * (nombre del método: increment)
 */
public class NumberDisplay
{
    // Atributo para controlar el valor de los objetos
    private int value;
    // Atributo para controlar el límite del valor
    private int limit;

    /**
     * Establece los valores iniciales y el límite
     */
    public NumberDisplay(int maximo)
    {
        value = 0;
        limit = maximo;
   }
    
    /**
     * Método que permite fijar el valor pasado por parámetro.
     */  
    public void setValue(int newValue)
    {
        if (newValue >=0 && newValue <= limit) {
            value = newValue;
        }
    }
    
    /**
     *  Método que devuelve un String de dos caracteres
     */
    public String getDisplayValue()
    {
        String display = Integer.toString(value);
        if (display.length() == 1 ){
            display = "0" + value;
        }
        return display;
    }
    
    /**
     * Método que devuelve un int con el valor actual del display 
     */
    public int getValue()
    {
        return value;
    }
}

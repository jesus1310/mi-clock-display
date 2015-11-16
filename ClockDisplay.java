
/**
 * Write a description of class ClockDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClockDisplay
{
    // Atributo de la clase NumberDisplay que controla las horas
    private NumberDisplay horas;
    // Atributo de la clase NumberDisplay que controla los minutos
    private NumberDisplay minutos;
    // Atributo que controla una cadena de 5 caracteres
    private String horaActual;
    /**
     * Constructor que fija la hora a 00:00 y establece el límite.
     */
    public ClockDisplay()
    {
        horas = new NumberDisplay(24);
        minutos = new NumberDisplay(60);
    }
    
    /**
     * Constructor que permite fijar la hora por parámetros.
     */
    public ClockDisplay(int nuevaHora,int nuevoMinuto)
    {
        horas = new NumberDisplay(24);
        horas.setValue(nuevaHora);
        minutos = new NumberDisplay(60);
        minutos.setValue(nuevoMinuto);
    }
    
    /**
     * Método que permite fijar horas y minutos introducidos por parámetro.
     */
    
    public void setTime(int h,int m)
    {
        horas.setValue(h);
        minutos.setValue(m);
    }
    
    /**
     * Método que devuelve una cadena de 5 caracteres con formato "00:00"
     */
    public String getTime()
    {
        horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
        return horaActual;
    }
    
    /**
     * Método que aumenta en 1 el valor de los minutos.
     */
    
    public void timeTick()
    {
        minutos.increment();
        if (minutos.getValue() == 0){
            horas.increment();
        }
    }
}

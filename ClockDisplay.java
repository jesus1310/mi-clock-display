
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
        horas = new NumberDisplay(23);
        minutos = new NumberDisplay(59);
        horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
    }
    
    /**
     * Constructor que permite fijar la hora por parámetros.
     */
    public ClockDisplay(int nuevaHora,int nuevoMinuto)
    {
        horas = new NumberDisplay(23);
        horas.setValue(nuevaHora);
        minutos = new NumberDisplay(59);
        minutos.setValue(nuevoMinuto);
        horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
    }
    
    /**
     * Método que permite fijar horas y minutos introducidos por parámetro.
     */
    
    public void setTime(int h,int m)
    {
        horas.setValue(h);
        minutos.setValue(m);
        horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
    }
}

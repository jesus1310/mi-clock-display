
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
        horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
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
        if (nuevaHora>=0 && nuevaHora<12){
            horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue() + " A.M.";
        }
        else if(nuevaHora==12){
            horaActual = nuevaHora + ":" + minutos.getDisplayValue() + " P.M.";
        }
        else{
            nuevaHora=nuevaHora-12;
            if (nuevaHora>9){
                horaActual = nuevaHora + ":" + minutos.getDisplayValue() + " P.M.";
            }
            else{
                horaActual = "0" + nuevaHora + ":" + minutos.getDisplayValue() + " P.M.";
            }
        }
    }
    
    /**
     * Método que permite fijar horas y minutos introducidos por parámetro.
     */
    
    public void setTime(int h,int m)
    {
        horas.setValue(h);
        minutos.setValue(m);
        if (h>=0 && h<12){
            horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue() + " A.M.";
        }
        else if(h==12){
            horaActual = h + ":" + minutos.getDisplayValue() + " P.M.";
        }
        else{
            h=h-12;
            if (h>9){
                horaActual = h + ":" + minutos.getDisplayValue() + " P.M.";
            }
            else{
                horaActual = "0" + h + ":" + minutos.getDisplayValue() + " P.M.";
            }
        }
    }
    
    /**
     * Método que devuelve una cadena de 5 caracteres con formato "00:00"
     */
    public String getTime()
    {
        return horaActual;
    }
    
    /**
     * Método que aumenta en 1 el valor de los minutos.
     */
    
    public void timeTick()
    {
        int horaAmPm = horas.getValue()-12;
        int minAmPm = minutos.getValue() + 1;
        minutos.increment();
        if (minAmPm == 60){
            minAmPm = 0;
            horaAmPm = horaAmPm + 1;
        }
        if (horaAmPm == 12){
            horaAmPm = 0;
            horaActual = "0" + horaAmPm + ":" + "0" + minAmPm + " A.M.";
        }
        if (horas.getValue()<12){
            if (horaAmPm<10 && minAmPm<10){
                horaActual = "0" + horaAmPm + ":" + "0" + minAmPm + " A.M.";
            }
            else if (horaAmPm<10 && minAmPm>=10){
                horaActual = "0" + horaAmPm + ":" + minAmPm + " A.M.";
            }
            else if (horaAmPm>=10 && minAmPm<10){
                horaActual = horaAmPm + ":" + "0" + minAmPm + " A.M.";
            }
            else{
                horaActual = horaAmPm + ":" + minAmPm + " A.M.";
            }
        }
        else{
            if (horaAmPm<10 && minAmPm<10){
                horaActual = "0" + horaAmPm + ":" + "0" + minAmPm + " P.M.";
            }
            else if (horaAmPm<10 && minAmPm>=10){
                horaActual = "0" + horaAmPm + ":" + minAmPm + " P.M.";
            }
            else if (horaAmPm>=10 && minAmPm<10){
                horaActual = horaAmPm + ":" + "0" + minAmPm + " P.M.";
            }
            else{
                horaActual = horaAmPm + ":" + minAmPm + " P.M.";
            }
        }
    }
}


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
   // Atributo que permite elegir si se utilizará el reloj en formato 12h o 24h
   private boolean formato;
   // Atributo que controla el día
   private NumberDisplay dia;
   // Atributo que controla el mes
   private NumberDisplay mes;
   // Atributo que controla el año
   private NumberDisplay anno;
   // Atributo que muestra la fecha en formato dd/mm/aa
   private String fechaActual;
   
   /**
    * Constructor que fija la hora a 00:00 y establece el límite.
    * Se le pasa por parámetro una variable booleana.
    * Si es true, el formato del reloj es 12h, si es false, el formato es 24h.
    * Se le añaden objetos día, mes, año con valores iniciales para una fecha determinada.
    * y se muestran en un string con formato dd/mm/aa
    */
   public ClockDisplay(boolean tipoReloj)
   {
       horas = new NumberDisplay(24);
       minutos = new NumberDisplay(60);
       horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
       formato = tipoReloj;
       dia = new NumberDisplay(31);
       dia.setValue(20);
       mes = new NumberDisplay(13);
       mes.setValue(11);
       anno = new NumberDisplay(100);
       anno.setValue(15);
       fechaActual = dia.getDisplayValue() + "/" + mes.getDisplayValue() + "/" + anno.getDisplayValue();
   }
   
   /**
    * Constructor que permite fijar la hora por parámetros.
    * Se le añade además como parámetro una variable booleana.
    * Si es true, el formato del reloj es 12h, si es false, el formato es 24h.
    */
   public ClockDisplay(int nuevaHora,int nuevoMinuto,boolean tipoReloj,int diaInicio,int mesInicio,int annoInicio)
   {
       horas = new NumberDisplay(24);
       horas.setValue(nuevaHora);
       minutos = new NumberDisplay(60);
       minutos.setValue(nuevoMinuto);
       horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
       formato = tipoReloj;
       dia = new NumberDisplay(31);
       dia.setValue(diaInicio);
       mes = new NumberDisplay(13);
       mes.setValue(mesInicio);
       anno = new NumberDisplay(100);
       anno.setValue(annoInicio);
       fechaActual = dia.getDisplayValue() + "/" + mes.getDisplayValue() + "/" + anno.getDisplayValue();
   }
   
   /**
    * Método que permite fijar horas y minutos introducidos por parámetro.
    */
   
   public void setTime(int h,int m,int nuevoDia,int nuevoMes,int nuevoAnno)
   {
       horas.setValue(h);
       minutos.setValue(m);
       dia.setValue(nuevoDia);
       mes.setValue(nuevoMes);
       anno.setValue(nuevoAnno);
       horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
       fechaActual = dia.getDisplayValue() + "/" + mes.getDisplayValue() + "/" + anno.getDisplayValue();
   }
   
   /**
    * Método que devuelve una cadena de 5 caracteres con formato "00:00"
    */
   public String getTime()
   {
       horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
       if (formato==true){
           update();
       }
       return horaActual + " " + fechaActual;
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
       horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
   }
    
   /**
    * Actualiza la hora en formato 12 horas (AM/PM)
    */
   public void update()
   {
      if (horas.getValue()>12){
           int actualiza = horas.getValue()-12;
           if (actualiza<10){
               horaActual = "0" + actualiza + ":" + minutos.getDisplayValue() + " P.M.";
           }
           else{
               horaActual = actualiza + ":" + minutos.getDisplayValue() + " P.M.";
           }
      }
      else if (horas.getValue()==12){
          if (minutos.getValue()==0){
              horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue() + " M.";
          }
          else{
              horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue() + " P.M.";
          }
      }
      else if (horas.getValue()==0){
           horaActual = "12" + ":" + minutos.getDisplayValue() + " A.M.";
      }
      else{ //La hora es menor que 12 y mayor que 0
          horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue() + " A.M.";
      }
   }
   
   /**
    * Método que permite alternar entre los dos tipos de formato.
    */
   public void cambiarFormato(){
       formato = !formato;
   }
}

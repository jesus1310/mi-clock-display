
/**
 * Write a description of class ClockDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

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
   // Atributo que muestra la fecha de hoy en formato dd/mm/aa
   private String fechaActual;
   // Atributo que muestra la fecha nueva en formato dd/mm/aa
   private String fechaNueva;
   // Atributo de tipo Date para guardar la fecha
   private Date hoy = new Date();
   // Atributo para dar formato a la fecha
   private SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy");
   /**
    * Constructor que fija la hora a 00:00 y establece el límite.
    * Se le pasa por parámetro una variable booleana.
    * Si es true, el formato del reloj es 12h, si es false, el formato es 24h.
    * Se le añaden día, mes, año con valores iniciales para una fecha determinada
    * y se muestran en un string con formato dd/mm/aa
    */
   public ClockDisplay(boolean tipoReloj)
   {
       // Creamos un objeto de la clase Calendar y tres variables locales para para que siempre muestre la fecha actual.
       Calendar fechaHoy = Calendar.getInstance();
       int diaHoy = fechaHoy.get(Calendar.DATE);
       int mesHoy = fechaHoy.get(Calendar.MONTH) + 1;
       int annoHoy = fechaHoy.get(Calendar.YEAR);
       // Establecemos los límites de las horas y los minutos, mostramos la hora y seleccionamos el tipo de formato de hora que usaremos.
       horas = new NumberDisplay(24);
       minutos = new NumberDisplay(60);
       horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
       formato = tipoReloj;
       // Establecemos los límites del día, mes y año, los inicializamos con los valores de hoy y mostramos la fecha en formato dd/mm/aa.
       dia = new NumberDisplay(31);
       dia.setValue(diaHoy);
       mes = new NumberDisplay(13);
       mes.setValue(mesHoy);
       anno = new NumberDisplay(100);
       anno.setValue(annoHoy);
       fechaActual = formatoFecha.format(hoy);
   }
   
   /**
    * Constructor que permite fijar la hora por parámetros.
    * Se le añade además como parámetro una variable booleana.
    * Si es true, el formato del reloj es 12h, si es false, el formato es 24h.
    * Se le añaden día, mes, año como parámetros
    * y se muestran en un string con formato dd/mm/aa
    */
   public ClockDisplay(int nuevaHora,int nuevoMinuto,boolean tipoReloj,int diaInicio,int mesInicio,int annoInicio)
   {
       // Establecemos los límites de las horas y los minutos, los inicializamos con valores pasados por parámetro.
       // Mostramos la hora con esos valores y el formato elegido
       horas = new NumberDisplay(24);
       horas.setValue(nuevaHora);
       minutos = new NumberDisplay(60);
       minutos.setValue(nuevoMinuto);
       horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
       formato = tipoReloj;
       // Establecemos los límites del día, mes y año, los inicializamos con valores pasados por parámetro y mostramos la fecha en formato dd/mm/aa.
       dia = new NumberDisplay(31);
       dia.setValue(diaInicio);
       mes = new NumberDisplay(13);
       mes.setValue(mesInicio);
       anno = new NumberDisplay(100);
       anno.setValue(annoInicio);
       fechaNueva = dia.getDisplayValue() + "/" + mes.getDisplayValue() + "/" + anno.getDisplayValue();
   }
   
   /**
    * Método que permite fijar horas, minutos, día, mes y año introducidos por parámetro.
    */
   
   public void setTime(int h,int m,int nuevoDia,int nuevoMes,int nuevoAnno)
   {
       // Modificamos la hora y la fecha con valores pasados por parámetro.
       horas.setValue(h);
       minutos.setValue(m);
       dia.setValue(nuevoDia);
       mes.setValue(nuevoMes);
       anno.setValue(nuevoAnno);
       horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
       fechaNueva = dia.getDisplayValue() + "/" + mes.getDisplayValue() + "/" + anno.getDisplayValue();
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
       if (fechaNueva == null){
           return horaActual + " " + fechaActual;
       }
       else{
           return horaActual + " " + fechaNueva;
       }
   }
   
   /**
    * Método que aumenta en 1 el valor de los minutos.
    */
   
   public void timeTick()
   {
       minutos.increment();
       if (minutos.getValue() == 0){
           horas.increment();
           if (horas.getValue() == 0){
               if (dia.getValue() == 30){
                   dia.increment();
                   dia.increment();
                   if (dia.getValue() == 1){
                       if (mes.getValue() == 12){
                           mes.increment();
                           mes.increment();
                           if (mes.getValue() == 1){
                               anno.increment();
                           }
                       }
                       else{
                           mes.increment();
                       }
                   }
               }
               else {
                   dia.increment();
               }
           }
       }
       horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
       fechaNueva = dia.getDisplayValue() + "/" + mes.getDisplayValue() + "/" + anno.getDisplayValue();
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

/*
 * Participante.java
 *
 * Creada el 02-dic-2010, 20:04:47
 *
 * Clase Java desarrollada por Alex para el blog http://javatutoriales.blogspot.com/ el día 02-dic-2010
 *
 * Para informacion sobre el uso de esta clase, asi como bugs, actualizaciones, o mejoras enviar un mail a
 * programadorjavablog@gmail.com
 *
 * No olviden hacerse fans del grupo de Java Tutoriales en facebook  http://www.facebook.com/pages/Java-Tutoriales/121935157864634
 *
 */
package controller;

/**
 * @author Alex
 * @version 1.0
 * @author-mail programadorjavablog@gmail.com
 * @date 02-dic-2010
 */
public class Participante
{
   private int id_disponibilidad;
    private int id_materia;
    private int id_docente ;
    private String dia;
    private int horaini;
    private int horafin;
    private String observaciones;
    private int puntos;

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Participante()
    {
    }

    public Participante(int id_materia, int id_docente, String dia, int horaini, int horafin, String observaciones) {
//        this.id_disponibilidad = id_disponibilidad;
        this.id_materia = id_materia;
        this.id_docente = id_docente;
        this.dia = dia;
        this.horaini = horaini;
        this.horafin = horafin;
        this.observaciones = observaciones;
    }

    public int getId_disponibilidad() {
        return id_disponibilidad;
    }

    public void setId_disponibilidad(int id_disponibilidad) {
        this.id_disponibilidad = id_disponibilidad;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public int getId_docente() {
        return id_docente;
    }

    public void setId_docente(int id_docente) {
        this.id_docente = id_docente;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getHoraini() {
        return horaini;
    }

    public void setHoraini(int horaini) {
        this.horaini = horaini;
    }

    public int getHorafin() {
        return horafin;
    }

    public void setHorafin(int horafin) {
        this.horafin = horafin;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}

package SISTEMA;

import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//import java.util.Calendar;
class Revision {
  // Calendar fecha= Calendar.getInstance();
  // int codigo_mostrado;
  int codigo_permiso;
  private String rev_fecha;
  private String rev_hora;
  Scanner revi= new Scanner(System.in);
  public Revision() {
  }

  public void nueva_revision(ArrayList<Residente> l, int cod, String sist_fecha, String sist_hora) {
    this.rev_fecha = sist_fecha;
    this.rev_hora = sist_hora;
    // revisar codigo
    for (int i = 0; i < l.size(); i++) {
      Residente res = l.get(i);
      for (int j = 0; j < res.getPermiso().size(); j++) {
        Permiso permi = res.getPermiso().get(j);
        int codigo_permiso = permi.getCodigo();
        System.out.println(codigo_permiso);
        if (cod == codigo_permiso) {
          // obtener datos del prermiso
          long ced = permi.getCed();
          System.out.println("\n Informacion del visitante: ");
          System.out.println("Cedula del visitante: " + ced);
          System.out.println("Nombre: " + permi.getVisitante());
          // comparar fechas
          try {
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            Date fecha_revision = formato.parse(rev_fecha);
            String fecha_permiso = permi.getIngreso();
            Date fecha_registrada = formato.parse(fecha_permiso);
            if (fecha_revision.equals(fecha_registrada)) {
              // comparar horas
              SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
              Date hora_reg = hora.parse(permi.getHora());
              Date hora_rev = hora.parse(rev_hora);
              long milisegundos = hora_rev.getTime() - hora_reg.getTime();
              int diferencia = (int) (milisegundos / (1000 * 60));
              if (diferencia < -15) {
                System.out.println("- Antes de tiempo -");
                System.out.println("Estado: " + permi.getEstado());
              }
              // Actualizacion de estado
              if (diferencia >= -15 & diferencia <= 15) {
                System.out.println("- tiempo correcto -");
                System.out.println("Estado: " + permi.getEstado());
                if (permi.getEstado() == "ACTIVO") {
                  permi.setEstado("USADO");
                  System.out.println("Ingrese observacion");
                  String obser= revi.nextLine();
                  permi.setObservacion(obser);
                  System.out.println("Ingrese usuario de autorizacion");
                  String guard= revi.next();
                  permi.setGuardia(guard);
                }
              } if(diferencia>15) {
                System.out.println("Hora caducada");
                permi.setEstado("CADUCADO");
              }
            }else{
              System.out.println("Fecha caducada");
                permi.setEstado("CADUCADO");
            }
          } catch (ParseException ex) {
          }
        }
      }
    }
  }

  public void reviMenu() {
    System.out.println("MENU:" + "\n1. Iniciar revision" + "\n2. Salir \n");
    System.out.print("Ingrese el numero de la opcion:");
  }
}

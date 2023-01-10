package SISTEMA;
/*Con el número de cédula del Residente se podrá consultar la lista de permisos que ha
generado, estado, visitante y observación. */
import java.util.ArrayList;

public class Reportes extends Residentes {
//Listas generales de reportes y permisos (todos en una lista no por residente)
  ArrayList<Reporte> lista_reportes = new ArrayList<>();
  ArrayList<Permiso> base_permisos = new ArrayList<>();
  
//Metodos para la lista reportes cargar-mostrar-buscar y menu general
  public Reportes(ArrayList<Residente> l ) {
    for (int i = 0; i < l.size(); i++) {
      Residente res = l.get(i);
      for (int j = 0; j < res.getPermiso().size(); j++) {
        Permiso permi = res.getPermiso().get(j);
        permi.setCedula(res.getCedula());
        base_permisos.add(permi);
      }
    }
    for (int i = 0; i < base_permisos.size(); i++) {
      Permiso per = base_permisos.get(i);
      Reporte rep = new Reporte(per.getResidente(), per.getCed(),  per.getEstado(), per.getVisitante());
      lista_reportes.add(rep);
      rep.setObs(per.getObservacion());
      rep.setAutorizador(per.getGuardia());
    }
  }   
  public void mostrar_reportes(){
    for (int i= 0; i<lista_reportes.size(); i++){
lista_reportes.get(i).mostrar_info();
  }
  }
  public void buscar_reportes(long c){
    for (int i= 0; i<lista_reportes.size(); i++){
      System.out.println(lista_reportes.get(i).getCed());
      if (c ==lista_reportes.get(i).getCed()){
        lista_reportes.get(i).mostrar_info();
      }
    }
  }  
  public void reportMenu(){
    System.out.println("MENU:"+ "\n1. Mostrar Reportes" + "\n2. Buscar Reportes" + "\n3. Salir \n");
  }
}

class Reporte extends Residentes {
  private String resident;
  private long cedu;
  private String estado;
  private String visit;
  private String obser;
  private String usuario_autorizador;
  
//Metodos
  public Reporte(String res,long ced, String est,String vis){
  this.resident=res;
  this.estado=est;
  this.visit=vis;
  this.cedu= ced;
}
  public void mostrar_info(){
    System.out.println("Autoriza: " + resident + " - Cedula: " + cedu + " - Visitante: "+ visit +" - Estado: " + estado + " - Observacion: " + obser+ "- Guardia: "+ usuario_autorizador);
  }
//Getters y setters
  public long getCed(){
  return cedu;
}
  public void setAutorizador(String a){
    this.usuario_autorizador=a;
  }
  public void setCedu(long ced){
  this.cedu=ced;
}   
  public void setObs(String obs){
  this.obser=obs;
}
}

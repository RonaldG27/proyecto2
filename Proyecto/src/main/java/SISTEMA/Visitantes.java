package SISTEMA;

import java.util.ArrayList;
import java.util.Scanner;
//lista
class Visitantes{
  ArrayList<Visitante> lista_visitantes;
  //Genera la lista(hay que ingresar residentes al inicializar el sistema)
  public Visitantes(){
    lista_visitantes=new ArrayList <>();
  } 
  
  //Metodos para la lista visitantes
  public void sumar_Visitante(Visitante v){
  lista_visitantes.add(v);
  }
  public void mostrar_Visitantes(){
    System.out.println("\n Lista de visitantes");
    for(int i= 0; i<lista_visitantes.size(); i++){
      int indice= i+1;
      System.out.println(indice+". " + lista_visitantes.get(i).getNombre());
    }
  } 
  public ArrayList<Visitante> getLista(){
    return lista_visitantes;
  }
  //retorna un objeto visitante de la lista
  public Visitante get_Visitante(int ind){
    Visitante visi_selec=lista_visitantes.get(ind);
    return visi_selec;
  }
}

//Objeto
class Visitante{
  private long cedula;
  private String nombre;
  private long telefono;
  private String email;
  private String empresa;
  private String sanciones; 
  private Permiso permiso;
  Scanner visi = new Scanner(System.in);
  Scanner texto = new Scanner(System.in);
  
//Constructores por consola y por sistema
  public Visitante(){
    System.out.println("Registrar cedula");
    this.cedula=visi.nextLong();
    System.out.println("Registrar nombre");
    this.nombre=texto.nextLine();
    System.out.println("Registrar telefono");
    this.telefono=visi.nextLong();
    System.out.println("Registrar correo");
    this.email=texto.nextLine();
    System.out.println("Registrar empresa (en caso de ser repartidor)");
    this.empresa = texto.nextLine();
    System.out.println("Registrar Sanciones");
    this.sanciones=texto.nextLine();
  } 
  public Visitante(long ced, String nom, long tel, String mail, String emp, String san ){
    this.cedula=ced;
    this.nombre=nom;
    this.telefono=tel;
    this.email=mail;
    this.empresa=emp;
    this.sanciones=san;

  }
////Metodos para cada objeto visitante
  public void visiMenu(){
    System.out.println("MENU:"+ "\n1. Mostrar Informacion" + "\n2. Modificar Informacion" +"\n3. Salir \n");
  }
  public void modificar_visiInfo(){
    int modi=0;
    System.out.println("MENU:"+ "\n1. Cedula" + "\n2. Nombre" + "\n3. Telefono"+"\n4. Email" + "\n5. Empresa(repartidor)"+"\n6. Sanciones" + "\n7. Salir \n");
    while (modi != 7 ){
    System.out.println("Ingrese el numero de la opcion: ");
    modi = visi.nextInt();
    while(modi<0){
      System.out.println("INGRESE UNA OPCION VALIDA (DEL 1 AL 8)");
      modi = visi.nextInt();
    }
    while(modi>8){
      System.out.println("INGRESE UNA OPCION VALIDA (DEL 1 AL 8)");
      modi = visi.nextInt();
    }  
      if (modi == 1){
      System.out.println("Prohibido modificar cedula, contacte a la administracion");
      }
      if (modi == 2){
      System.out.println("Ingrese el nuevo Nombre");
      this.nombre=texto.nextLine();
      }
      if (modi == 3){
      System.out.println("Ingrese el nuevo Telefono");
      this.telefono=visi.nextLong();
      }
      if (modi == 4){
      System.out.println("Ingrese el nuevo Correo");
      this.email=texto.nextLine();
      }
      if (modi == 5){
      System.out.println("Ingrese la nueva empresa (solo repartidores)");
      this.empresa=texto.nextLine();
      }
      if (modi == 6){
      System.out.println("Ingrese la nueva sancion");
      this.sanciones=texto.nextLine();
      }
      if (modi == 7){
      System.out.println("SALIENDO DEL MODIFICADOR... \n FUERA DEL MODIFICADOR");
      }
    }
  }
  public void mostrar_visiInfo(){
    System.out.println("INFORMACION:"+ "\n Cedula: " +cedula+ "\n Nombre: " +nombre+ "\n Telefono: "+telefono+"\n Email: "+email + "\n Empresa: "+empresa+"\n Sanciones: "+sanciones+"\n");
  }
  public String getNombre(){
    return nombre;
  }
  public long getCedula(){
    return cedula;
  }
  public void setPermiso(Permiso p){
    this.permiso=p;
  }
  public String getSanciones(){
    return sanciones;
  }
}
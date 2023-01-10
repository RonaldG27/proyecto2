package SISTEMA;

import java.util.ArrayList;
import java.util.Scanner;
//lista
class Colaboradores{
  ArrayList<Colaborador> lista_colaboradores;
//Genera la lista(hay que ingresar residentes al inicializar el sistema)
  public Colaboradores(){
    lista_colaboradores=new ArrayList <>();
  } 
//Metodos para la lista colaboradores
  public void sumar_Colaborador(Colaborador c){
  lista_colaboradores.add(c);
  }
  public void mostrar_Colaboradores(){
    System.out.println("\n Lista de colaboradores");
    for(int i= 0; i<lista_colaboradores.size(); i++){
      int indice= i+1;
      System.out.println(indice+". " + lista_colaboradores.get(i).getNombre());
    }
  } 
  
//retorna un objeto residente de la lista
  public Colaborador get_Colaborador(int ind){
    Colaborador cola_selec=lista_colaboradores.get(ind);
    return cola_selec;
  }
}

//Objeto
class Colaborador{
  private long cedula;
  private String nombre;
  private long telefono;
  private String email;
  private String puesto;
  private String tipo; 
  private String estado;
  private long inicio_actividades;
  Scanner cola = new Scanner(System.in);
  Scanner colamodi = new Scanner(System.in);
  
//Constructor por consola y por sistema
  public Colaborador(){
    System.out.println("Registrar cedula");
    this.cedula=cola.nextLong();
    System.out.println("Registrar nombre");
    this.nombre= colamodi.nextLine();
    System.out.println("Registrar telefono");
    this.telefono=cola.nextLong();
    System.out.println("Registrar correo");
    this.email=colamodi.nextLine();
    System.out.println("Registrar puesto");
    this.puesto = colamodi.nextLine();
    System.out.println("Registrar tipo");
    this.tipo=colamodi.nextLine();
    System.out.println("Estado ACTIVO");
    this.estado="ACTIVO";
    System.out.println("Registrar fecha de inicio");
    this.inicio_actividades=cola.nextLong();
  } 
  public Colaborador(long ced, String nom, long tel, String mail, String pues, String tip , long inicio){
    this.cedula=ced;
    this.nombre=nom;
    this.telefono=tel;
    this.email=mail;
    this.puesto=pues;
    this.tipo=tip;
    this.estado= "ACTIVO";
    this.inicio_actividades= inicio;

  }

//Metodos para cada colaborador
  public void colaMenu(){
    System.out.println("MENU:"+ "\n1. Mostrar Informacion" + "\n2. Modificar Informacion" +"\n3. Salir \n");
  }
  public void modificar_colaInfo(){
    int modi=0;
    System.out.println("MENU:"+ "\n1. Cedula" + "\n2. Nombre" + "\n3. Telefono"+"\n4. Email" + "\n5. Puesto(Jefe o planta)"+"\n6. Tipo" + "\n7. Salir \n");
    while (modi != 7 ){
    System.out.println("Ingrese el numero de la opcion: ");
    modi = cola.nextInt();
    while(modi<0){
      System.out.println("INGRESE UNA OPCION VALIDA (DEL 1 AL 8)");
      modi = cola.nextInt();
    }
    while(modi>8){
      System.out.println("INGRESE UNA OPCION VALIDA (DEL 1 AL 8)");
      modi = cola.nextInt();
    }  
      if (modi == 1){
      System.out.println("Prohibido modificar cedula, contacte a la administracion");
      }
      if (modi == 2){
      System.out.println("Ingrese el nuevo Nombre");
      this.nombre=colamodi.nextLine();
      }
      if (modi == 3){
      System.out.println("Ingrese el nuevo Telefono");
      this.telefono=cola.nextInt();
      }
      if (modi == 4){
      System.out.println("Ingrese el nuevo Correo");
      this.email=colamodi.nextLine();
      }
      if (modi == 5){
      System.out.println("Ingrese el nuevo puesto (jefe o planta)");
      this.puesto=colamodi.nextLine();
      }
      if (modi == 6){
      System.out.println("Ingrese el nuevo tipo");
      this.tipo=colamodi.nextLine();
      }
      if (modi == 7){
      System.out.println("SALIENDO DEL MODIFICADOR... \n FUERA DEL MODIFICADOR");
      }
    }
  }
  public void mostrar_colaInfo(){
    System.out.println("INFORMACION:"+ "\n Cedula: " +cedula+ "\n Nombre: " +nombre+ "\n Telefono: "+telefono+"\n Email: "+email + "\n Cargo: "+puesto+"\n Tipo: "+tipo+"\n");
  }
  public String getNombre(){
    return nombre;
  }

}



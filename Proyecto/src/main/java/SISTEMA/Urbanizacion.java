package SISTEMA;

import java.util.Scanner;
class Urbanizacion{
  private String nombre;
  private int etapa;
  private String email;
  private String direccion;
  private String constructora;
  private String responsable;
  Scanner urba = new Scanner(System.in);
  Scanner texto = new Scanner(System.in);
//Constructor por consola y por sistema
  public Urbanizacion(){
    System.out.println("Registrar nombre");
    this.nombre=texto.nextLine();
    System.out.println("Registrar etapa (solo numero)");
    this.etapa=urba.nextInt();
    System.out.println("Registrar correo");
    this.email=texto.nextLine();
    System.out.println("Registrar direccion:");
    this.direccion=texto.nextLine();
    System.out.println("Registrar constructora");
    this.constructora = texto.nextLine();
    System.out.println("Registrar responsable (administrador)");
    this.responsable=texto.nextLine();
  } 
  public Urbanizacion(String nom, int etap, String mail, String direcc, String construct, String admin){
    this.nombre=nom;
    this.etapa=etap;
    this.email=mail;
    this.direccion=direcc;
    this.constructora = construct;
    this.responsable=admin;
  } 

//Menu general para la urbanizacion (no para el sistema)
  public void urbaMenu(){
    System.out.println("MENU:"+ "\n1. Mostrar Informacion" + "\n2. Modificar Informacion" + "\n3. Salir \n");
  }
  
//Metodos
  public void modificar_UrbaInfo(){
    int modi=0;
    System.out.println("MENU:"+ "\n1. Nombre" + "\n2. Etapa" + "\n3. Email"+"\n4. Direccion" + "\n5. Constructora"+"\n6. Responsable" + "\n7. Salir \n");
    while (modi != 7 ){
    System.out.println("Ingrese el numero de la opcion: ");
    modi = urba.nextInt();
    while(modi<0){
      System.out.println("INGRESE UNA OPCION VALIDA (DEL 1 AL 7)");
      modi = urba.nextInt();
    }
    while(modi>7){
      System.out.println("INGRESE UNA OPCION VALIDA (DEL 1 AL 7)");
      modi = urba.nextInt();
    }  
      if (modi == 1){
      System.out.println("Ingrese el nuevo Nombre");
      this.nombre= texto.nextLine();
      }
      if (modi == 2){
      System.out.println("Ingrese la nueva Etapa");
      this.etapa= urba.nextInt();
      }
      if (modi == 3){
      System.out.println("Ingrese el nuevo Email");
      this.email= texto.nextLine();
      }
      if (modi == 4){
      System.out.println("Ingrese la nueva Direccion");
      this.direccion= texto.nextLine();
      }
      if (modi == 5){
      System.out.println("Ingrese la nueva Constructora");
      this.constructora= texto.nextLine();
      }
      if (modi == 6){
      System.out.println("Ingrese el nuevo Responsable");
      this.responsable= texto.nextLine();
      }
      if (modi == 7){
      System.out.println("SALIENDO DEL MODIFICADOR... \n FUERA DEL MODIFICADOR");
      }
    }
  }
  public void mostrar_UrbaInfo(){
    System.out.println("Informacion de la urbanizacion:"+ "\n Nombre: " + nombre+"\n Etapa: "+ etapa + "\n Email: "+ email +"\n Direccion: "+ direccion + "\n Constructora: "+ constructora +"\n Responsable: "+ responsable);
  }

}

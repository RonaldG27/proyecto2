package SISTEMA;

import java.util.Scanner;

class Sist {
  public static void main(String[] args) {
    // inicializarSistema();
    String fecha_sist = "05-12-2022";
    String hora_sist = "10:00";
    System.out.println("BIENVENID@ PROYECTO URBASEGURA SISTEMS\n");
    Urbanizacion u = new Urbanizacion("UrbAP", 2, "administracion@UrbaAp.com",
        "Km 5 y 1/2 via a espol, Guayaquil - Ecuador", "ConstrupolSA", "Jefecito");
    Residentes lista = new Residentes();
    Residente r1 = new Residente(1202400907, "Residente1", 0102030405, "residente1@mail.com", 2, 3, 0);
    Residente r2 = new Residente(58, "Residente2", 0504030201, "residente2@mail.com", 4, 5, 0);
    lista.sumar_Residente(r1);
    lista.sumar_Residente(r2);
    Visitantes listaV = new Visitantes();
    Visitante v1 = new Visitante(11111111, "Visitante1", 01010101, "visitante1@mail.com", "pedidosYa", "NINGUNA");
    Visitante v2 = new Visitante(22222222, "visitante2", 02020202, "visitante2@mail.com", "visitante",
        "VETADO DE AREAS COMUNES");
    listaV.sumar_Visitante(v1);
    listaV.sumar_Visitante(v2);
    Colaboradores listaC = new Colaboradores();
    Colaborador c1 = new Colaborador(987654, "Bodicito", 2266132, "colaborador1@mail.com", "wachiman", "Guardia",
        01022023);
    Colaborador c2 = new Colaborador(123456, "Jefecito", 3355321, "colaborador2@mail.com", "Jefe", "Administrador",
        15122022);
    listaC.sumar_Colaborador(c1);
    listaC.sumar_Colaborador(c2);
    Permiso per = new Permiso(fecha_sist, "10:17", "Residente1", "Visitante1", "01-12-2022", "11:15", 5);
    Permiso per1 = new Permiso(fecha_sist, "16:30", "Residente1", "Visitante2", "05-12-2022", "10:05", 5);
    r1.nuevo_permiso(per, listaV.getLista());
    r1.nuevo_permiso(per1, listaV.getLista());

    // Menu principal del sistema
    Scanner entrada = new Scanner(System.in);
    int opcion = 0;
    while (opcion != 8) {
      System.out.println("\n \n-------MENU:-------");
      System.out
          .println("\n1. Urbanización" + "\n2. Residentes" + "\n3. Visitantes" + "\n4. Colaboradores de la urbanización"
              + "\n5. Permisos de entrada" + "\n6. Revisión de entrada" + "\n7. Reportes" + "\n8. Salir \n");
      System.out.println("Ingrese el numero de la opcion: ");
      opcion = entrada.nextInt();
      // comprobacion
      while (opcion < 0) {
        System.out.println("INGRESE UNA OPCION VALIDA (DEL 1 AL 8)");
        opcion = entrada.nextInt();
      }
      while (opcion > 8) {
        System.out.println("INGRESE UNA OPCION VALIDA (DEL 1 AL 8)");
        opcion = entrada.nextInt();
      }

      // Accseso a Urbanizacion
      while (opcion == 1) {
        System.out.println("Opcion 1 seleccionada, mostrando Urbanizacion....\n");
        u.urbaMenu();
        int uM = entrada.nextInt();
        if (uM == 1) {
          u.mostrar_UrbaInfo();
        }
        if (uM == 2) {
          u.modificar_UrbaInfo();
        }
        // Retorno al menu principal
        if (uM == 3) {
          opcion = 0;
        }
      }
      // Accseso a Residentes
      while (opcion == 2) {
        System.out.println("Opcion 2 seleccionada, mostrando Residentes.... \n");
        lista.mostrar_Residentes();
        // Acceso a cada residente y sus opciones
        System.out.println("Ingrese el numero del residente");
        System.out.println("Ingrese 0 (cero) para volver al menu principal: ");
        int ind_residente = entrada.nextInt();
        // Retorno al menu principal
        if (ind_residente == 0) {
          opcion = 0;
        }
        // Menu para cada residente
        if (ind_residente > 0) {
          Residente selec = lista.get_Residente(ind_residente - 1);
          selec.resiMenu();
          int rM = entrada.nextInt();
          if (rM == 1) {
            selec.mostrar_resiInfo();
          }
          if (rM == 2) {
            selec.modificar_resiInfo();
          }
          if (rM == 3) {
            selec.eliminar_residente();
          }
          // Retorno al menu principal
          if (rM == 4) {
            opcion = 0;
          }
        }

      }
      // Accseso a Visitantes
      while (opcion == 3) {
        System.out.println("Opcion 3 seleccionada, mostrando visitantes registrados....\n");
        listaV.mostrar_Visitantes();
        // Acceso a cada visitante y sus opciones
        System.out.println("Ingrese el numero del Visitante");
        System.out.println("Ingrese 0 (cero)para volver al menu principal");
        int ind_visitante = entrada.nextInt();
        // Retorno al menu principal
        if (ind_visitante == 0) {
          opcion = 0;
        }
        // Menu para cada residente
        if (ind_visitante > 0) {
          Visitante selec = listaV.get_Visitante(ind_visitante - 1);
          selec.visiMenu();
          int vM = entrada.nextInt();
          if (vM == 1) {
            selec.mostrar_visiInfo();
          }
          if (vM == 2) {
            selec.modificar_visiInfo();
          }
          // Retorno al menu principal
          if (vM == 3) {
            opcion = 0;
          }
        }
      }
      // Accseso a Colaboradores
      while (opcion == 4) {
        System.out.println("Opcion 4 seleccionada, mostrando colaboradores.... \n");
        listaC.mostrar_Colaboradores();
        // Acceso a cada residente y sus opciones
        System.out.println("Ingrese el numero del colaborador");
        System.out.println("Ingrese 0 (cero)para volver al menu principal");
        int ind_colaborador = entrada.nextInt();
        // Retorno al menu principal
        if (ind_colaborador == 0) {
          opcion = 0;
        }
        // Menu para cada residente
        if (ind_colaborador > 0) {
          Colaborador selec = listaC.get_Colaborador(ind_colaborador - 1);
          selec.colaMenu();
          int cM = entrada.nextInt();
          if (cM == 1) {
            selec.mostrar_colaInfo();
          }
          if (cM == 2) {
            selec.modificar_colaInfo();
          }
          // Retorno al menu principal
          if (cM == 3) {
            opcion = 0;
          }
        }

      }
      // Accseso a Permisos
      while (opcion == 5) {
        System.out.println("Opcion 5 seleccionada, mostrando menu.... \n");
        lista.permiMenu();
        int ind_Perm = entrada.nextInt();
        // nuevo permiso
        if (ind_Perm == 1) {
          lista.sumar_Permiso(fecha_sist, hora_sist, listaV.getLista());
        }
        // eliminar permiso
        if (ind_Perm == 2) {
          lista.eliminar_Permiso();
        }
        if (ind_Perm == 3) {
          System.out.print("Ingrese el numero de la Manzana:");
          int mz = entrada.nextInt();
          System.out.print("Ingrese el numero de la Villa:");
          int vill = entrada.nextInt();
          lista.buscar_Permiso(mz, vill);
        }
        if (ind_Perm == 4) {
          opcion = 0;
        }
      }
      // Accseso a Revision
      while (opcion == 6) {
        System.out.println("Opcion 6 seleccionada... \n mostrando menu....");
        Revision rev = new Revision();
        rev.reviMenu();
        int rM = entrada.nextInt();
        if (rM == 1) {
          System.out.println("Iniciando Revision");
          System.out.println("Ingrese el codigo del permiso");
          int cod = entrada.nextInt();
          rev.nueva_revision(lista.getLista(), cod, fecha_sist, hora_sist);
        }
        if (rM == 2) {
          opcion = 0;
        }
      }
      // Accseso a Reportes
      while (opcion == 7) {
        System.out.println("Opcion 7 seleccionada... \n accediendo a Reportes....\n");
        Reportes Report = new Reportes(lista.getLista());
        Report.reportMenu();
        System.out.println("Ingrese el numero de la opcion deseada ");
        int rM = entrada.nextInt();
        if (rM == 1) {
          Report.mostrar_reportes();
        }
        if (rM == 2) {
          System.out.println("Ingrese numero de cedula del recidente a visitar");
          long ced = entrada.nextLong();
          Report.buscar_reportes(ced);
        }
        if (rM == 3) {
          opcion = 0;
        }
      }
      // Cierre del sistema
      if (opcion == 8) {
        System.out.println("SALIENDO DEL SISTEMA... \n ---FUERA DEL SISTEMA---");
      }
    }
  }
}


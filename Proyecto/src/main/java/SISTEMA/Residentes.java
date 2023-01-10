package SISTEMA;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//lista de residentes
class Residentes {
  ArrayList<Residente> lista_residentes;

  // Genera la lista(hay que ingresar residentes al inicializar el sistema)
  public Residentes() {
    lista_residentes = new ArrayList<>();
  }

  // Metodos para la lista residente
  public void sumar_Residente(Residente r) {
    lista_residentes.add(r);
  }

  public void mostrar_Residentes() {
    System.out.println("\n Lista de residentes");
    for (int i = 0; i < lista_residentes.size(); i++) {
      int indice = i + 1;
      System.out.println(indice + ". " + lista_residentes.get(i).getNombre());
    }
  }

  public ArrayList<Residente> getLista() {
    return lista_residentes;
  }

  // Obtener un residente
  public Residente get_Residente(int ind) {
    Residente resi_selec = lista_residentes.get(ind);
    return resi_selec;
  }

  // PERMISOS
  Scanner permi = new Scanner(System.in);
  Scanner modi = new Scanner(System.in);

  public void permiMenu() {
    System.out.println("MENU:" + "\n1. Crear permiso de entrada" + "\n2. Eliminar permiso de entrada"
        + "\n3. Consultar permisos por manzana y villa" + "\n4. Salir \n");
    System.out.print("Ingrese el numero de la opcion:");
  }

  public void sumar_Permiso(String systFecha, String systHora, ArrayList<Visitante> l) {
    System.out.println("\n Ingrese nombre del residente");
    String nombre_ingresado = modi.nextLine();
    // Comprueba residente
    for (int i = 0; i < lista_residentes.size(); i++) {
      Residente resi = get_Residente(i);
      String nombre_registrado = resi.getNombre();
      if (nombre_ingresado.equals(nombre_registrado)) {
        // Comprueba fecha
        try {
          SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
          Date fecha_sistema = formato.parse(systFecha);
          System.out.println("Ingrese fecha de visita con el formato: DIA-MES-AÑO");
          System.out.println("EJEMPLO: 01-02-2022 ");
          String fecha_permiso = modi.nextLine();
          Date fecha_registrada = formato.parse(fecha_permiso);
          if (fecha_sistema.equals(fecha_registrada)) {
            // Comprueba visitante
            System.out.println("Ingrese el nombre del visitante");
            String visitante_ingresado = modi.nextLine();
            for (int j = 0; j < l.size(); j++) {
              Visitante visi = l.get(j);
              String visitante_registrado = visi.getNombre();
             // System.out.println(visitante_registrado);
              //System.out.println(visitante_ingresado);
              if (visitante_ingresado.equals(visitante_registrado)) {
                // Comprueba sanciones
                System.out.println("Sanciones: " + visi.getSanciones());
                if (visi.getSanciones().equals("NINGUNA")) {
                  // Genera el permiso o no
                  Permiso creado = new Permiso(systFecha, systHora);
                  creado.setResidente(nombre_registrado);
                  creado.setIngre_fecha(fecha_permiso);
                  creado.setVisitante(visitante_ingresado);
                  resi.nuevo_permiso(creado, l);
                  
                } else {
                  System.out.println("Sanciones: " + visi.getSanciones());
                  System.out.println("No es posible crear prmiso SANCION");
                }
              } 
            }
          } else {
            System.out.println("No es posible crear prmiso FECHA");
          }
        } catch (ParseException ex) {
          System.out.println("FECHA MAL ESCRITA");
        }
      }
    }
  }

  public void eliminar_Permiso() {
    System.out.println("Ingrese cedula");
    long ced_ingresado = permi.nextLong();
    for (int i = 0; i < lista_residentes.size(); i++) {
      Residente resi = get_Residente(i);
      long ced_registrado = resi.getCedula();
      if (ced_ingresado == ced_registrado) {
        resi.eliminar_permiso();
      } else
        System.out.println("Residente no coincide");
    }
  }

  public void buscar_Permiso(int mz, int vill) {
    for (int i = 0; i < lista_residentes.size(); i++) {
      Residente resi = lista_residentes.get(i);
      if (resi.getManzana() == mz) {
        if (resi.getVilla() == vill) {
          System.out.println("Mostrando permisos");
          resi.mostrar_permiso();
        }
      }
    }
  }
}

// Objeto residente (con lista de permisos)
class Residente {
  private int cedula;
  private String nombre;
  private int telefono;
  private String email;
  private int manzana;
  private int villa;
  private int roomies;
  private String urbanizacion;
  private String estado;
  ArrayList<Permiso> lista_permisos = new ArrayList<>();

  Scanner resi = new Scanner(System.in);
  Scanner resimodi = new Scanner(System.in);

  // Constructor por consola y por sistema
  public Residente() {
    System.out.println("Registrar cedula");
    this.cedula = resi.nextInt();
    System.out.println("Registrar nombre");
    this.nombre = resimodi.nextLine();
    System.out.println("Registrar telefono");
    this.telefono = resi.nextInt();
    System.out.println("Registrar correo");
    this.email = resimodi.nextLine();
    System.out.println("Registrar manzana (solo numero)");
    this.manzana = resi.nextInt();
    System.out.println("Registrar villa (solo numero)");
    this.villa = resi.nextInt();
    System.out.println("Registrar roomies (cantidad)");
    this.roomies = resi.nextInt();
    System.out.println("Registrado en UrbAP");
    this.urbanizacion = "UrbaAP";
    System.out.println("Estado actual: ACTIVO");
    this.estado = "ACTIVO";
  }

  public Residente(int ced, String nom, int tel, String mail, int mz, int vill, int roo) {
    this.cedula = ced;
    this.nombre = nom;
    this.telefono = tel;
    this.email = mail;
    this.manzana = mz;
    this.villa = vill;
    this.roomies = roo;
    this.urbanizacion = "UrbaAP";
    this.estado = "ACTIVO";
  }

  // Metodos para cada residente
  public void resiMenu() {
    System.out.println(
        "MENU:" + "\n1. Mostrar Informacion" + "\n2. Modificar Informacion" + "\n3. Eliminar" + "\n4. Salir \n");
    System.out.print("Ingrese el numero de la opcion:");
  }

  public void modificar_resiInfo() {
    int modi = 0;
    System.out.println("MENU:" + "\n1. Cedula" + "\n2. Nombre" + "\n3. Telefono" + "\n4. Email" + "\n5. Manzana"
        + "\n6. Villa" + "\n7. Roomies" + "\n8. Salir \n");
    while (modi != 8) {
      System.out.println("Ingrese el numero de la opcion: ");
      modi = resi.nextInt();
      while (modi < 0) {
        System.out.println("INGRESE UNA OPCION VALIDA (DEL 1 AL 8)");
        modi = resi.nextInt();
      }
      while (modi > 8) {
        System.out.println("INGRESE UNA OPCION VALIDA (DEL 1 AL 8)");
        modi = resi.nextInt();
      }
      if (modi == 1) {
        System.out.println("Ingrese la nueva Cedula");
        this.cedula = resi.nextInt();
      }
      if (modi == 2) {
        System.out.println("Ingrese el nuevo Nombre");
        this.nombre = resimodi.nextLine();
      }
      if (modi == 3) {
        System.out.println("Ingrese el nuevo Telefono");
        this.telefono = resi.nextInt();
      }
      if (modi == 4) {
        System.out.println("Ingrese el nuevo Correo");
        this.email = resimodi.nextLine();
      }
      if (modi == 5) {
        System.out.println("Ingrese la nueva manzana (solo numero)");
        this.manzana = resi.nextInt();
      }
      if (modi == 6) {
        System.out.println("Ingrese la nueva villa (solo numero)");
        this.villa = resi.nextInt();
      }
      if (modi == 7) {
        System.out.println("Ingrese la cantidad de roomies");
        this.roomies = resi.nextInt();
      }
      if (modi == 8) {
        System.out.println("SALIENDO DEL MODIFICADOR... \n FUERA DEL MODIFICADOR");
      }
    }
  }

  public void mostrar_resiInfo() {
    System.out.println("INFORMACION:" + "\n Cedula: " + cedula + "\n Nombre: " + nombre + "\n Telefono: " + telefono
        + "\n Email: " + email + "\n Manzana: " + manzana + "\n Villa: " + villa + "\n Roomies: " + roomies
        + "\n Urbanizacion: " + urbanizacion + "\n Estado: " + estado);
  }

  public void eliminar_residente() {
    System.out.println("Estado actual: INACTIVO");
    this.estado = "INACTIVO";
    for (int i = 0; i < lista_permisos.size(); i++) {
      lista_permisos.get(i).setEstado("INACTIVO");
    }
  }

  // Getters y Setters
  public String getNombre() {
    return nombre;
  }

  public long getCedula() {
    return cedula;
  }

  public int getManzana() {
    return manzana;
  }

  public int getVilla() {
    return villa;
  }

  // PERMISOS
  public void nuevo_permiso(String F, String H) {
    lista_permisos.add(new Permiso(F, H));
  }

  public void nuevo_permiso(Permiso p, ArrayList<Visitante> l) {
    lista_permisos.add(p);
    for (int i = 0; i < l.size(); i++) {
      String nombre_ingresado = p.getVisitante();
      Visitante visi = l.get(i);
      String nombre_registrado = visi.getNombre();
      if (nombre_ingresado.equals(nombre_registrado)) {
        visi.setPermiso(p);
        long ced = visi.getCedula();
        p.setCedula(ced);
      }

    }
  }

  public void eliminar_permiso() {
    System.out.println("Permisos autorizados por: " + nombre + ": \n");
    for (int i = 0; i < lista_permisos.size(); i++) {
      System.out
          .println((i + 1) + ". " + lista_permisos.get(i).getVisitante() + " - " + lista_permisos.get(i).getEstado());
    }
    System.out.println("Ingrese el numero del permiso selesccionado:");
    System.out.println("Ingrese 0 (cero) para salir\n");
    int indice = resi.nextInt();
    if (indice == 0) {
      System.out.println("Saliendo...");
    }
    if (indice != 0) {
      if (indice < lista_permisos.size() + 1) {
        Permiso permi = lista_permisos.get(indice - 1);
        permi.setEstado("INACTIVO");
      } else {
        System.out.println("Ingrese un numero valido");
      }
    }
  }

  public void mostrar_permiso() {
    System.out.println("Permisos organizados por fecha: \n");
    for (int i = 0; i < lista_permisos.size(); i++) {
      System.out.println(lista_permisos.get(i).getFecha() + " - " + lista_permisos.get(i).getVisitante() + " - "
          + lista_permisos.get(i).getHora() + " - " + lista_permisos.get(i).getEstado() + " - SOLICITADO POR: " + nombre
          + " - " + lista_permisos.get(i).getCodigo());
    }
  }

  public ArrayList<Permiso> getPermiso() {
    return lista_permisos;
  }
}
/*
 * Al iniciar esta opción el usuario podrá visualizar la información de los
 * residentes.
 * De cada persona se registra su cédula, nombre, teléfono, email,
 * estado(Activo,/Inactivo),
 * mz, villa, cantidad de personas que viven con el residente , urbanización)
 * Se podrán agregar residentes, editar y eliminar. La acción de eliminar lo que
 * hará es cambiar
 * el estado a Inactivo y además pondrá en estado inactivo algún permiso que
 * haya sido creado
 * por ese residente.
 * Por ahora solo un residente por casa.
 */

// Objeto permiso
class Permiso {
  private String crea_fecha;
  private String crea_hora;
  private String residente;
  private long cedula;
  private String visitante;
  private String ingre_fecha;
  private String ingre_hora;
  private int duracion;
  private String estado;
  private int codigo;
  private String guardia;
  private String observacion;
  Scanner permi = new Scanner(System.in);
  Random azar = new Random();

  // constructor por consola y por sistema
  public Permiso(String creaFecha, String creaHora) {
    this.crea_fecha = creaFecha;
    this.crea_hora = creaHora;
    System.out.println("Ingrese la hora de llegada CON ':' Y SIN ESPACIOS ej: 14:15");
    this.ingre_hora = permi.next();
    System.out.println("Ingrese duracion de la visita (cantidad de horas)");
    this.duracion = permi.nextInt();
    this.estado = "ACTIVO";
    this.codigo = (azar.nextInt(9999 - 1000 + 1) + 1000);
  }

  public Permiso(String creafech, String creahor, String resi, String visi, String ingrefech, String ingrehor,
      int dura) {
    this.residente = resi;
    this.crea_fecha = creafech;
    this.crea_hora = creahor;
    this.visitante = visi;
    this.ingre_fecha = ingrefech;
    this.ingre_hora = ingrehor;
    this.duracion = dura;
    this.estado = "ACTIVO";
    this.codigo = (azar.nextInt(9999 - 1000 + 1) + 1000);
  }

  // Getters y Setters
  public String getVisitante() {
    return visitante;
  }
  public String getResidente() {
    return residente;
  }
  public String getEstado() {
    return estado;
  }
  public String getFecha() {
    return crea_fecha;
  }
  public String getHora() {
    return ingre_hora;
  }
  public long getCed() {
    return cedula;
  }
  public int getCodigo() {
    return codigo;
  }
  public String getIngreso() {
    return ingre_fecha;
  }
  public String getGuardia() {
    return guardia;
  }
  public String getObservacion() {
    return observacion;
  }
  public void setCedula(long c) {
    this.cedula = c;
  }
  public void setEstado(String e) {
    this.estado = e;
  }
  public void setObservacion(String obser) {
    this.observacion = obser;
  }
  public void setGuardia(String guardiaNomb) {
    this.guardia = guardiaNomb;
  }
  public void setResidente(String r) {
    this.residente = r;
  }
  public void setIngre_fecha(String f) {
    this.ingre_fecha = f;
  }
  public void setCrea_fecha(String f) {
    this.crea_fecha = f;
  }
  public void setVisitante(String v) {
    this.visitante = v;
  }

}

/*
 * Al seleccionar esta opción el usuario podrá visualizar un submenú
 * 1. Crear permiso de entrada
 * 2. Eliminar permiso de entrada
 * 3. Consultar permisos por manzana y villa
 * El permiso tendrá el estado de: activo, inactivo, caducado, usado.
 */
/*
 * 1. Crear permiso de entrada
 * Se registra la fecha y hora de creación del permiso, se registrará al
 * residente que aprueba y
 * crea el permiso, persona(visitante) que va a ingresar, fecha que va a
 * ingresar, hora que va a
 * ingresar (dar un rango de 15 minutos antes y después), duración aproximada de
 * visita,
 * creación de código único.
 * Aquí se debe verificar que el visitante no tenga ninguna sanción y que la
 * fecha en la que se
 * concede el permiso sea la fecha actual (no se pueden crear permisos
 * anticipados de más de
 * un día)
 */
/*
 * 2. Eliminar permiso
 * Se pedirá la cédula del residente para poder mostrar sus permisos activos y
 * poder eliminar
 * alguna de ellos. ( el estado cambiará a inactivo)
 */
/*
 * 3. Consultar permisos por manzana y villa
 * Se pedirá la manzana y villa del residente y se mostrarán los permisos
 * ordenados por fecha
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.primer_parcial;
import java.util.ArrayList;
import java.util.List;

public class Catedratico {
    private static int contador = 1;
    private int numero;
    private String nombre;
    private String direccion;
    private String telefono;
    private String profesion;

    public Catedratico(String nombre, String direccion, String telefono, String profesion) {
        this.numero = contador++;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.profesion = profesion;
    }

    public void imprimirDatos() {
        System.out.println("Número de Catedrático: " + numero);
        System.out.println("Nombre: " + nombre);
        System.out.println("Dirección: " + direccion);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Profesión: " + profesion);
    }
}
public class Alumno {
    private static int contador = 1;
    private int carnet;
    private String nombre;
    private String direccion;
    private String telefono;
    private String edad;

    public Alumno(String nombre, String direccion, String telefono, String edad) {
        this.carnet = contador++;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void imprimirDatos() {
        System.out.println("Carnet: " + carnet);
        System.out.println("Nombre: " + nombre);
        System.out.println("Dirección: " + direccion);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Edad: " + edad);
    }
}


public class Curso {
    private int id;
    private String titulo;
    private String nombre;
    private int maxAlumnos;
    private int alumnosAsignados;

    public Curso(int id, String titulo, String nombre, int maxAlumnos) {
        this.id = id;
        this.titulo = titulo;
        this.nombre = nombre;
        this.maxAlumnos = maxAlumnos;
        this.alumnosAsignados = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getMaxAlumnos() {
        return maxAlumnos;
    }

    public void setMaxAlumnos(int maxAlumnos) {
        this.maxAlumnos = maxAlumnos;
    }

    public int getAlumnosAsignados() {
        return alumnosAsignados;
    }

    public void setAlumnosAsignados(int alumnosAsignados) {
        this.alumnosAsignados = alumnosAsignados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean verificaEspacio() {
        return alumnosAsignados < maxAlumnos;
    }

    public void inscribirAlumno() {
        if (verificaEspacio()) {
            alumnosAsignados++;
        } else {
            System.out.println("No hay espacio en el curso " + nombre);
        }
    }

    public class Asignacion {
        private Alumno alumno;
        private List<Curso> cursos;

        public Asignacion(Alumno alumno) {
            this.alumno = alumno;
            this.cursos = new ArrayList<>();
        }

        public void addCurso(Curso curso) {
            if (curso.verificaEspacio()) {
                cursos.add(curso);
                curso.inscribirAlumno();
                System.out.println("Curso " + curso.getNombre() + " asignado a " + alumno.getNombre());
            } else {
                System.out.println("No se puede asignar el curso " + curso.getNombre() + " a " + alumno.getNombre());
            }
        }
    }
}
public class Primer_parcial {
    public static void main(String[] args) {
        // Crear instancias de Catedrático
        Catedratico c1 = new Catedratico("Carlos Gómez", "Dirección 1", "1234567890", "Profesor de Matemáticas");
        Catedratico c2 = new Catedratico("Ana Martínez", "Dirección 2", "0987654321", "Profesora de Historia");
        Catedratico c3 = new Catedratico("Luis Fernández", "Dirección 3", "5555555555", "Profesor de Ciencias");

        // Crear Cursos
        Curso curso1 = new Curso(1, "Matemáticas", "Curso de Matemáticas Básicas", 30);
        Curso curso2 = new Curso(2, "Historia", "Curso de Historia General", 30);
        Curso curso3 = new Curso(3, "Ciencias", "Curso de Ciencias Naturales", 30);

        // Crear Alumnos
        Alumno a1 = new Alumno("Pedro Pérez", "Dirección A", "1111111111", "20");
        Alumno a2 = new Alumno("Laura Ruiz", "Dirección B", "2222222222", "22");
        Alumno a3 = new Alumno("Sofia López", "Dirección C", "3333333333", "21");

        // Crear Asignaciones
        Curso.Asignacion asignacion1 = curso1.new Asignacion(a1);
        Curso.Asignacion asignacion2 = curso2.new Asignacion(a2);
        Curso.Asignacion asignacion3 = curso3.new Asignacion(a3);

        // Asignar Cursos
        asignacion1.addCurso(curso1);
        asignacion1.addCurso(curso2);

        asignacion2.addCurso(curso2);
        asignacion2.addCurso(curso3);

        asignacion3.addCurso(curso3);

        // Imprimir Datos
        c1.imprimirDatos();
        c2.imprimirDatos();
        c3.imprimirDatos();

        a1.imprimirDatos();
        a2.imprimirDatos();
        a3.imprimirDatos();
    }
}
package ClasesPersonaje

import Utiles.Escritor

/**
 *
 * Clase Hobbit hereda de Personaje que contiene los metodos que le permiten ponerse
 * y quitarse su anillo
 *
 * @param anillo boolean true si lo tiene puesto, false sino
 * @param nombre String con el nombre del Hobbit
 * @param vivo boolean con el estado del personaje
 *
 * @author Diego
 *
 */
class Hobbit (var anillo : Boolean, nombre : String, vivo : Boolean) : Personaje(nombre, vivo){

    fun ponerseAnillo(){

        this.anillo = true;

        Escritor.escribirFichero("$nombre se ha puesto el anillo debe tener cuidado o su poder" +
                " le cambiara por completo\n")

    }

    fun quitarseAnillo(){

        this.anillo = false;
        Escritor.escribirFichero("$nombre no ha soportado más el poder del anillo y se lo ha quitado\n")

    }

}
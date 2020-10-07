package ClasesPersonaje

import Utiles.Constantes
import Utiles.Escritor

/**
 *
 * Clase Mago hereda de Personaje que contiene los metodos que le permiten recargar su vara
 * y usar su vara
 *
 * @param vara int con la cantidad de poder de la vara
 * @param nombre String con el nombre del Mago
 * @param vivo boolean con el estado del personaje
 *
 * @author DIego
 *
 */
class Mago(var vara : Int, nombre : String, vivo : Boolean) : Personaje(nombre, vivo) {

     fun recargarVara(energia: Int){

        vara += energia

        if (vara > Constantes.CARGAMAXVARAGANDALF ) vara = Constantes.CARGAMAXVARAGANDALF

         Escritor.escribirFichero("$nombre recarga la vara con $energia puntos de energía, quedando con un total de " +
                 "$vara puntos de energía en su vara\n")

    }

    fun poderVara() : Int{

        return vara

    }

}
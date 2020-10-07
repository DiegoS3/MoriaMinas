package Moria

import ClasesPersonaje.Elfo
import ClasesPersonaje.Hobbit
import ClasesPersonaje.Mago
import Sala.Peligro
import Sala.Sala
import Utiles.Constantes
import Utiles.Escritor
import Utiles.Metodos
import java.util.Date

/**
 *
 * Es el main de nuestra aplicación, creamos los diferentes personajes
 * y generamos las salas de una manera aleatoria mientras los 3 sigan vivos
 *
 * @author Diego
 *
 */
fun main(){

    //Atributos
    var fecha = Date()
    var gandalf = Mago(Metodos.generarNumAleatorio(Constantes.CARGAMINVARAGANDALF, Constantes.CARGAMAXVARAGANDALF), "Gandalf", true)
    var legolas = Elfo(Metodos.generarNumAleatorio(Constantes.MINFLECHASLEGOLAS, Constantes.MAXFLECHASLEGOLAS), "Legolas", true)
    var frodo = Hobbit(false,"Frodo", true)

    Escritor.escribirFichero("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
            "++++++++++++++++ NUESTROS AVENTUREROS COMIENZAN EL VIAJE A TRAVES DE MORIA ++++++++++++++++\n" +
            "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
            "Con fecha ${fecha.toString()}\n")

    //vamos recorriendo y creando las salas mientras alguno de nuestros aventureros este vivo
    principal@ for (sala in 1..Constantes.NUMSALAS) {

        Escritor.escribirFichero("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
                "++++++++++++++++++++++++++++ HAN ENTRADO EN LA SALA $sala +++++++++++++++++++++++++++++++++\n" +
                "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n \n")

        var ale = Metodos.generarNumAleatorio(1, 3) //Generamos numero aleatorio para ver que tipo de sala tendremos

        when (ale) {
            1 -> { //Sala con peligro de accion
                var salaAccion = Sala(sala, Peligro.ACCION, legolas)
                Thread.sleep(500)

            }
            2 -> { //Sala con peligro de habilidad
                var salaHabil = Sala(sala, Peligro.HABILIDAD, frodo)
                Thread.sleep(500)

            }
            3 -> { //Sala con peligro de magia
                var salaMagic = Sala(sala, Peligro.MAGICO, gandalf)
                Thread.sleep(500)

            }
        }

        //Si alguno muere paramos el for
        if (!gandalf.vivo || !legolas.vivo || !frodo.vivo) break@principal
    }

    Escritor.escribirFichero("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
            "Se han superado ${Sala.victorias} salas y han fallado en ${Sala.derrotas} salas. Con fecha ${fecha.toString()}\n" +
            "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
            "+++++++++++++++++ FIN DEL VIAJE A TRAVES DE LAS PELIGROSAS MINAS DE MORIA +++++++++++++++++\n" +
            "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n \n")
}
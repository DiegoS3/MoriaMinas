package Moria

import ClasesPersonaje.Elfo
import ClasesPersonaje.Hobbit
import ClasesPersonaje.Mago
import Sala.Peligro
import Sala.Sala
import Utiles.Constantes
import Utiles.Escritor
import Utiles.Metodos
import java.util.*

fun main(){

    var fecha = Date()
    var gandalf = Mago(Metodos.generarNumAleatorio(Constantes.CARGAMINVARAGANDALF, Constantes.CARGAMAXVARAGANDALF), "Gandalf", true)
    var legolas = Elfo(Metodos.generarNumAleatorio(Constantes.MINFLECHASLEGOLAS, Constantes.MAXFLECHASLEGOLAS), "Legolas", true)
    var frodo = Hobbit(false,"Frodo", true)

    Escritor.escribirFichero("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
            "++++++++++++++++ NUESTROS AVENTUREROS COMIENZAN EL VIAJE A TRAVES DE MORIA ++++++++++++++++\n" +
            "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
            "Con fecha ${fecha.toString()}\n")


    principal@ for (sala in 1..Constantes.NUMSALAS) {

        Escritor.escribirFichero("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
                "++++++++++++++++++++++++++++ HAN ENTRADO EN LA SALA $sala +++++++++++++++++++++++++++++++++\n" +
                "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n \n")

        var ale = Metodos.generarNumAleatorio(1, 3)

        when (ale) {
            1 -> { //Sala con peligro MAGICO
                var salaMagic = Sala(sala, Peligro.MAGICO, gandalf)
                Thread.sleep(500)

            }
            2 -> { //Sala con peligro ACCION
                var salaAccion = Sala(sala, Peligro.ACCION, legolas)
                Thread.sleep(500)

            }
            3 -> { //Sala con peligro HABILIDAD
                var salaHabil = Sala(sala, Peligro.HABILIDAD, frodo)
                Thread.sleep(500)

            }
        }

        if (!gandalf.vivo || !legolas.vivo || !frodo.vivo) break@principal
    }

    Escritor.escribirFichero("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
            "Se han superado ${Sala.victorias} salas y han fallado en ${Sala.derrotas} salas. Con fecha ${fecha.toString()}\n" +
            "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
            "+++++++++++++++++ FIN DEL VIAJE A TRAVES DE LAS PELIGROSAS MINAS DE MORIA +++++++++++++++++\n" +
            "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n \n")
}
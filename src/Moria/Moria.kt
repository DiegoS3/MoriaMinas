package Moria

import ClasesPersonaje.*
import Sala.Peligro
import Sala.Sala
import Utiles.Constantes
import Utiles.Metodos
import java.util.*
import kotlin.math.min

class Moria (){

    var minasMoria: Queue<Sala> = LinkedList<Sala>()
    private var gandalf = Mago(Metodos.generarNumAleatorio(Constantes.CARGAMINVARAGANDALF, Constantes.CARGAMAXVARAGANDALF), "Gandalf", true)
    private var legolas = Elfo(Metodos.generarNumAleatorio(Constantes.MINFLECHASLEGOLAS, Constantes.MAXFLECHASLEGOLAS), "Legolas", true)
    private var frodo = Hobbit(false,"Frodo", true)

    init {

        for (i in 1..Constantes.NUMSALAS){

            var ale = Metodos.generarNumAleatorio(1, 3)

            when (ale){

                1 -> minasMoria.add(Sala(i, Peligro.ACCION, legolas))
                2 -> minasMoria.add(Sala(i, Peligro.HABILIDAD, frodo))
                3 -> minasMoria.add(Sala(i, Peligro.MAGICO, gandalf))

            }

        }

        for (sala in minasMoria){

            println(sala.numero)

        }

    }

}
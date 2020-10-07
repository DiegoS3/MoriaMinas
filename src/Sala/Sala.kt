package Sala

import ClasesPersonaje.*
import Utiles.Constantes
import Utiles.Escritor
import Utiles.Metodos
import kotlin.math.E

class Sala constructor(var numero: Int, var peligro : Peligro, var p : Personaje){

    companion object{

        var victorias = 0
        var derrotas = 0

    }

    init {

        Escritor.escribirFichero("\nNuestros amigos entran en la sala número $numero en la que afrontaran un peligro de ${peligro.toString()} \n")
        when(peligro){

            Peligro.ACCION -> accion()

            Peligro.HABILIDAD -> habilidad()

            Peligro.MAGICO -> magico()

        }

    }

    private fun superarPeligro(): Int {return Metodos.porcentaje()}

    private fun huir(){

        Escritor.escribirFichero("Nuestros amigos de aventura intentan huir de la sala \n")
        derrotas++
        if (Metodos.porcentaje() > 80) {

            Escritor.escribirFichero("${p.nombre} ha muerto \n")
            p.vivo = false

        }else{

            Escritor.escribirFichero("Nuestros aventureros huyen con éxito de la sala numero $numero \n")

        }

    }

    private fun accion(){

        var flechasSuelo = 0
        var enemigos = Metodos.generarNumAleatorio(Constantes.MINENEMIGOS, Constantes.MAXENEMIGOS)

        Escritor.escribirFichero("Han aparecido $enemigos enemigos en la sala \n" +
                "mientras ${p.nombre} comprobaba su carcaj que tiene ${(p as Elfo).carcaj} flechas \n")

        while (((p as Elfo).carcaj > 0) and (enemigos > 0)){

            (p as Elfo).lanzarFlecha()
            flechasSuelo++
            enemigos--

        }

        if(enemigos < 1){

            victorias++
            Escritor.escribirFichero("${p.nombre} ha lanzado $flechasSuelo flechas matando a todos sus enemigos \n")

        }else{

            Escritor.escribirFichero("${p.nombre} ha lanzado $flechasSuelo flechas, pero no ha sido" +
                    "suficiente han quedado $enemigos enemigos vivos\n")

            huir()

        }

        if ((p as Elfo).vivo) (p as Elfo).recargarCarcaj(flechasSuelo)

    }

    private fun habilidad(){

        var probAnillo = Metodos.porcentaje()

        if (probAnillo <= 50){

            (p as Hobbit).ponerseAnillo()

            if (superarPeligro() <= 90) {

                Escritor.escribirFichero("Nuestros buenos amigos superan el peligro y pasan a la siguiente sala." +
                        "${p.nombre} ha estado de 10 \n")
                (p as Hobbit).quitarseAnillo()
                victorias++
            }
            else huir()

        }else{

            if (superarPeligro() <= 20){

                Escritor.escribirFichero("Nuestros buenos amigos superan el peligro y pasan a la siguiente sala." +
                        "${p.nombre} ha estado de 10 \n")
                victorias++
            }
            else huir()

        }
    }

    private fun magico(){

        (p as Mago).recargarVara(Metodos.generarNumAleatorio(Constantes.MINVARAGANDALF, Constantes.MAXVARAGANDALF))
        var poderMaligno = Metodos.generarNumAleatorio(Constantes.MINPELIGROSALA, Constantes.MAXPELIGROSALA)
        var poder = (p as Mago).poderVara()

        Escritor.escribirFichero("La sala esta repleta de energía maligna, sera ${p.nombre} capaz de afrontar un total" +
                " de $peligro puntos y ${p.nombre} tiene una energía de $poder en la vara mágica\n")

        if (poder > poderMaligno){

            Escritor.escribirFichero("Nuestros buenos amigos superan el peligro y pasan a la siguiente sala.\n")
            victorias++
        }
        else if(poder == poderMaligno){

            if (superarPeligro() < 60) {

                Escritor.escribirFichero("Nuestros buenos amigos superan el peligro y pasan a la siguiente sala.\n")
                victorias++
            }
            else huir()

        }else{

            if (superarPeligro() < 30) {
                Escritor.escribirFichero("Nuestros buenos amigos superan el peligro y pasan a la siguiente sala.\n")
                victorias++
            }
            else huir()

        }

        (p as Mago).vara -= poderMaligno

    }

}
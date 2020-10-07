package Sala

import ClasesPersonaje.*
import Utiles.Constantes
import Utiles.Escritor
import Utiles.Metodos
import kotlin.math.E

/**
 *
 * Clase sala que contiene los diferentes tipos de sala y las diferentes acciones
 * que se pueden realizar dentro de ella
 *
 * @param numero int que contiene el número de la sala
 * @param peligro Peligro contiene el tipo de peligro de la sala
 * @param p Personaje personaje que dependiendo del tipo de sala sera uno u otro
 *
 * @author Diego
 *
 */
class Sala constructor(var numero: Int, var peligro : Peligro, var p : Personaje){

    //Variables que compartimos con las demas clases, static
    companion object{

        var victorias = 0
        var derrotas = 0

    }

    //Inciamos nuestra sala
    init {

        Escritor.escribirFichero("\nNuestros amigos entran en la sala número $numero en la que afrontaran un peligro de ${peligro.toString()} \n")
        //Segun el peligro llamamos a un metodo u otro
        when(peligro){

            Peligro.ACCION -> accion() //Sala de accion

            Peligro.HABILIDAD -> habilidad() // Sala de habilidad

            Peligro.MAGICO -> magico() //Sala magica

        }

    }

    /**
     *
     * Metodo que genera un porcentaje entre 1 y 100
     *
     * @return int entre 1 y 100
     *
     */
    private fun superarPeligro(): Int {return Metodos.porcentaje()}

    /**
     *
     * Metodo que permite a nuestros aventureros huir de la sala,
     * si lo consiguen todo ira bien, sino el aventurero que se encuentre
     * en la sala morira y acabara su aventura
     *
     */
    private fun huir(){

        Escritor.escribirFichero("Nuestros amigos de aventura intentan huir de la sala \n")

        derrotas++ //Incrementamos derrotas

        //Si el porcentaje es mayor de 80, el personaje muere
        if (Metodos.porcentaje() > 80) {

            Escritor.escribirFichero("${p.nombre} ha muerto \n")
            p.vivo = false

        }else{

            Escritor.escribirFichero("Nuestros aventureros huyen con éxito de la sala numero $numero \n")

        }

    }

    /**
     *
     * Metodo que realizara el Elfo cuando este en una sala de accion
     * llamando a sus metodos de lanzar flechas y recargar
     *
     */
    private fun accion(){

        var flechasSuelo = 0
        var enemigos = Metodos.generarNumAleatorio(Constantes.MINENEMIGOS, Constantes.MAXENEMIGOS)

        Escritor.escribirFichero("Han aparecido $enemigos enemigos en la sala \n" +
                "mientras ${p.nombre} comprobaba su carcaj que tiene ${(p as Elfo).carcaj} flechas \n")

        //Si quedan enemigos y tiene flechas nuestro Elfo dispara, matando enemigos
        while (((p as Elfo).carcaj > 0) and (enemigos > 0)){

            (p as Elfo).lanzarFlecha()
            flechasSuelo++ //Incrementamos fechas que puede recoger
            enemigos--

        }
        //Si mata a todos los enemigos incrementamos victorias
        if(enemigos < 1){

            victorias++
            Escritor.escribirFichero("${p.nombre} ha lanzado $flechasSuelo flechas matando a todos sus enemigos \n")

        }else{ //sino llamamos al metodo huir

            Escritor.escribirFichero("${p.nombre} ha lanzado $flechasSuelo flechas, pero no ha sido" +
                    "suficiente han quedado $enemigos enemigos vivos\n")

            huir()

        }

        //si sigue vivo recarga su carcaj
        if ((p as Elfo).vivo) (p as Elfo).recargarCarcaj(flechasSuelo)

    }

    /**
     *
     * Metodo que sera llamado por nuestro Hobbit, mientras este se
     * encuentre en una sala de habilidad. Si es capaz de ponerse
     * el anillo(50%) triunfara el 90% de las veces, sino soloo el 20%
     * en caso de no conseguirlo intentara huir
     *
     */
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

    /**
     *
     * Metodo al que llamamos cuando nuestros personajes estan en una sala
     * de magia, en este caso actuara el Mago, enfrentandose a un poder maligno
     * que se genera de una manera aleatoria entre 1 y 10, nuestro mago siempre
     * podra comenzar recargando su arma
     *
     */
    private fun magico(){

        //generamos los difereentes valores
        (p as Mago).recargarVara(Metodos.generarNumAleatorio(Constantes.MINVARAGANDALF, Constantes.MAXVARAGANDALF))
        var poderMaligno = Metodos.generarNumAleatorio(Constantes.MINPELIGROSALA, Constantes.MAXPELIGROSALA)
        var poder = (p as Mago).poderVara()

        Escritor.escribirFichero("La sala esta repleta de energía maligna, sera ${p.nombre} capaz de afrontar un total" +
                " de $peligro puntos y ${p.nombre} tiene una energía de $poder en la vara mágica\n")

        //si tiene mas poder que la sala ganara
        if (poder > poderMaligno){

            Escritor.escribirFichero("Nuestros buenos amigos superan el peligro y pasan a la siguiente sala.\n")
            victorias++
        }
        else if(poder == poderMaligno){ //si los poderes son iguales

            if (superarPeligro() < 60) {//60% de superar el peligro

                Escritor.escribirFichero("Nuestros buenos amigos superan el peligro y pasan a la siguiente sala.\n")
                victorias++
            }
            else huir()

        }else{

            if (superarPeligro() < 30) {//si el poder del mago es menor 30% de posibilidades
                Escritor.escribirFichero("Nuestros buenos amigos superan el peligro y pasan a la siguiente sala.\n")
                victorias++
            }
            else huir()

        }

        //restamos el poder que ha gastado a la vara
        (p as Mago).vara -= poderMaligno

    }

}
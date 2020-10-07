package Utiles

import java.io.FileWriter
import java.io.IOException

class Escritor {

    fun escribirFichero(contenido : String){

        try {

            val fw = FileWriter(Constantes.NOMBREFICHERO, true)
            fw.write(contenido)
            fw.close()
        }catch (ioe : IOException){



        }

    }

}
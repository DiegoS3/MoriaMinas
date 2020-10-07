package Utiles

import java.io.FileWriter
import java.io.IOException

class Escritor {
    companion object {
        fun escribirFichero(contenido: String) {

            try {

                val fw = FileWriter(Constantes.NOMBREFICHERO, true)
                fw.write(contenido)
                fw.close()
            } catch (ioe: IOException) {


            }

        }
    }

}
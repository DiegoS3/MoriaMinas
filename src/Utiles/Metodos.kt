package Utiles

/**
 *
 * Metodos que necesitaremos usar varias veces en diferentes
 * clases
 *
 * @author Diego
 *
 */
class Metodos{

        companion object{

            /**
             *
             * genera un numero aleatorio con min y un maximo
             *
             * @param min int con el valor minimo
             * @param max int con el valor maximo
             *
             * @return int con el valor aleatorio
             *
             */
            fun generarNumAleatorio(min : Int, max : Int) : Int{

                return Math.floor(Math.random() * (max - min + 1) + min).toInt()

            }

            /**
             *
             * Genera un porcentaje siempre en 1 y 100
             *
             * @return int con el valor
             *
             */
            fun porcentaje(): Int{

                return generarNumAleatorio(1,100)

            }

        }

}
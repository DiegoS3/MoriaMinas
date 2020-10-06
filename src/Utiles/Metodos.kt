package Utiles

class Metodos{

        companion object{

            fun generarNumAleatorio(min : Int, max : Int) : Int{

                return Math.floor(Math.random() * (max - min + 1) + min).toInt()

            }

            fun porcentaje(): Int{

                return generarNumAleatorio(1,100)

            }

        }

}
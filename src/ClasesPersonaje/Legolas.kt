package ClasesPersonaje

class Legolas (var carcaj : Int, nombre : String, vivo : Boolean) : Personaje(nombre, vivo){

    private fun lanzarFlecha(){

        if(this.carcaj > 0){

            this.carcaj --

        }

    }

    private fun recargarCarcaj(flechas : Int){}

}
package ar.edu.unahur.obj2.semillasAlViento

class Parcela(val ancho: Int, val largo: Int, val horasSolPorDia: Int) {
  val plantas = mutableListOf<Planta>()

  fun parcelaTieneComplicaciones(parcela: Parcela) =
    parcela.plantas.any { it.horasDeSolQueTolera() < parcela.horasSolPorDia }
  fun superficie() = ancho * largo
  fun cantidadMaximaPlantas() =
    if (ancho > largo) superficie() / 5 else superficie() / 3 + largo

  fun plantar(planta: Planta) {
    if (plantas.size == this.cantidadMaximaPlantas()) {
      throw error("LA PARCELA ESTA LLENA ")
    } else if (horasSolPorDia > planta.horasDeSolQueTolera() + 2) {
      println("No se puede plantar esto acá, se va a quemar")
    } else {
      plantas.add(planta)

    }
  }
}

class Agricultora(val parcelas: MutableList<Parcela>) {

  fun parcelasSemilleras() =
    parcelas.filter { parcela -> parcela.plantas.all {
        planta -> planta.daSemillas()
      }
    }


 // fun laElegida():Parcela= parcelas.maxBy { it.cantidadMaximaPlantas() - it.plantas.size } // DEVUELVE LA PARCELA QUE TIENE MAS LUGAR
  //fun plantarEstrategicamente(planta: Planta) = laElegida().plantar(planta)

  }

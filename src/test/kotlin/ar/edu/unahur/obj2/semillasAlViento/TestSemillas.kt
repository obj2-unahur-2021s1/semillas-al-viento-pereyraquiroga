package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class SemillasTest : DescribeSpec({
    // PLANTAS
    var plantaMenta = Menta(2021, 0.5F)
    var plantaSoja= Soja(2020, 0.6F,true)
    //PARCELAS
    var parcelaPlantar=Parcela(20,12,20) // se usa en el metodo plantar
    var parcela=Parcela(12,20,8)
    // LISTAS PARCELAS
    var parcelaLista= mutableListOf<Parcela>()
    var parcelaagricultora=Agricultora(parcelaLista)

    describe("Horas de sol que tolera"){
        it("planta de Menta"){
            plantaMenta.horasDeSolQueTolera().shouldBe(6)
        }
        it("planta de Soja"){
            plantaSoja.horasDeSolQueTolera().shouldBe(14)
        }
    }
    describe ("Es fuerte"){
        it("planta de menta"){
            plantaMenta.esFuerte().shouldBe(false)
        }
        it("planta de Soja"){
            plantaSoja.esFuerte().shouldBe(true)
        }
    }
    describe("da semillas"){
        it("planta de Menta"){
            plantaMenta.daSemillas().shouldBe(true)
        }
        it("planta de soja"){
            plantaSoja.daSemillas().shouldBe(false)
        }
    }
    describe("parcela"){
        it("superficie"){
            parcela.superficie().shouldBe(240)
        }
        it("cantidad Maxima de plantas que tolera"){
            parcela.cantidadMaximaPlantas().shouldBe(100)
        }
        it("Plantar"){
            parcelaPlantar.plantar(plantaSoja) // debe tirar un error.

        }

        it("parcela Agricola es semillera o no "){

            parcelaagricultora.parcelasSemilleras().shouldBe(false) // tiene que dar false ARREGLAR

        }
        it("Plantar estrategicamente"){
            // No se puede hacer el test porque en el metodo plantarEstrategicamente(planta:Planta)
            //NO USA EL METODO PLANTAR, POR LO TANTO AGREGA SIN
            // VERIFICAR LOS PASOS DE PLANTAR() , ANTES DE AGREGAR.
        }


    }


})


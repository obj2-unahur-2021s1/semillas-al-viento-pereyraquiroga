package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class SemillasTest : DescribeSpec({
    // PLANTAS
    val plantaMenta = Menta(2021, 0.5F)
    val plantaSoja= Soja(2020, 0.6F,true)
    //PARCELAS
    val parcelaPlantar=Parcela(20,12,20)
    val parcela=Parcela(12,20,8)
    val parcela2=Parcela(12,20,8)

    // LISTAS PARCELAS
    val parcelaPlantas= mutableListOf<Planta>()
    val parcelaLista= mutableListOf<Parcela>()
    val parcelaAgricultora=Agricultora(parcelaLista)

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
        it ("tiene complicaciones"){
            parcelaPlantas.add(plantaSoja)
            parcela.parcelaTieneComplicaciones(parcela).shouldBe(false)
        }
        it("Plantar"){
            shouldThrowAny {
                parcelaPlantar.plantar(plantaSoja)
            }
        }

        it("parcela Agricola es semillera o no "){
            parcelaAgricultora.parcelasSemilleras().shouldBe(true)
            parcela2.plantar(plantaSoja)
            parcelaLista.add(parcela2)
            parcelaAgricultora.parcelasSemilleras().shouldBe(false)

        }
        it("Plantar estrategicamente"){
            //gyvgvyuyuy
            // No se puede hacer el test porque en el metodo plantarEstrategicamente(planta:Planta)
            //NO USA EL METODO PLANTAR, POR LO TANTO AGREGA SIN
            // VERIFICAR LOS PASOS DE PLANTAR() , ANTES DE AGREGAR.

        }


    }


})


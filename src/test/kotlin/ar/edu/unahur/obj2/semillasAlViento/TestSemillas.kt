package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class SemillasTest : DescribeSpec({

    var planta1 = Menta(2021, 0.5F)

    describe("Horas de sol que tolera"){
        it("planta de Menta"){
            planta1.horasDeSolQueTolera().shouldBe(6)
        }
    }
})
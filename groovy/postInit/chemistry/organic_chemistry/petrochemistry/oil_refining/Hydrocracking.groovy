import globals.Globals
import static globals.Petrochemistry.*

CRACKER = recipemap('cracker')
DT = recipemap('sieve_distillation')

crackables.each { _, crackable ->
    if (crackable.hydro_crackable) {
        CRACKER.recipeBuilder()
            .notConsumable(metaitem('hydrocracking_catalyst'))
            .fluidInputs(crackable.get(4000))
            .fluidInputs(fluid('hydrogen') * (4 * crackable.hydrogen_consumed))
            .fluidOutputs(crackable.getHydro(4000))
            .fluidOutputs(fluid('fuel_gas') * (4 * crackable.gas_produced))
            .duration(200)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()  
    }
}

DT.recipeBuilder()
    .fluidInputs(fluid('hydrocracked_light_gas_oil') * 1000)
    .fluidOutputs(fluid('light_gas_oil') * 320)
    .fluidOutputs(fluid('naphtha') * 1780)
    .duration(50)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('hydrocracked_light_cycle_oil') * 1000)
    .fluidInputs(fluid('furfural') * 40)
    .fluidOutputs(fluid('naphtha') * 450)
    .fluidOutputs(fluid('btex_extract') * 320)
    .duration(50)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('hydrocracked_heavy_gas_oil') * 1000)
    .fluidOutputs(fluid('heavy_gas_oil') * 200)
    .fluidOutputs(fluid('light_gas_oil') * 500)
    .fluidOutputs(fluid('naphtha') * 710)
    .duration(50)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('hydrocracked_atmospheric_oil_residue') * 1000)
    .fluidOutputs(fluid('atmospheric_oil_residue') * 290)
    .fluidOutputs(fluid('heavy_gas_oil') * 640)
    .fluidOutputs(fluid('light_gas_oil') * 895)
    .fluidOutputs(fluid('naphtha') * 480)
    .duration(50)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('hydrocracked_vacuum_oil_residue') * 1000)
    .fluidOutputs(fluid('vacuum_oil_residue') * 270)
    .fluidOutputs(fluid('heavy_gas_oil') * 690)
    .fluidOutputs(fluid('light_gas_oil') * 900)
    .fluidOutputs(fluid('naphtha') * 455)
    .duration(50)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('hydrocracked_synthetic_wax') * 1000)
    .fluidOutputs(fluid('heavy_gas_oil') * 280)
    .fluidOutputs(fluid('light_gas_oil') * 260)
    .fluidOutputs(fluid('kerosene') * 185)
    .fluidOutputs(fluid('naphtha') * 1605)
    .duration(50)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()
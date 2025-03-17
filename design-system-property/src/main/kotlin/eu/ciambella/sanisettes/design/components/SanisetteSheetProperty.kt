package eu.ciambella.sanisettes.design.components

import eu.ciambella.sanisettes.design.atoms.SimpleButtonProperty

data class SanisetteSheetProperty(
    val sanisetteProperty: SanisetteCardProperty,
    val simpleButtonProperty: SimpleButtonProperty,
): Property

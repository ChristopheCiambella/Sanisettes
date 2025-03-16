package eu.ciambella.sanisettes.domain.sanisette.model

data class Sanisettes(
    val sanisettes: List<Sanisette>,
    val nextOffset: Int?,
)

package com.danielvilha.luasapp.data.model

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml

/**
 * Created by danielvilha on 21/06/20
 */
@Xml(name = "stopInfo")
data class StopInfo(
    @Element
    var direction: List<Direction>
)

@Xml
data class Direction(
    @Attribute
    var name: String,
    @Element(name = "tram")
    var trams: List<Tram>
)

@Xml
data class Tram(
    @Attribute
    var dueMins: String,
    @Attribute
    var destination: String
)
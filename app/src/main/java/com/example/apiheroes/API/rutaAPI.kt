package com.example.apiheroes.API

import com.example.apiheroes.Controladores.AgrupacionControl
import com.example.apiheroes.Controladores.EquipoControl
import com.example.apiheroes.Controladores.HeroesControl
import com.example.apiheroes.Controladores.MisionGrupoControl
import com.example.apiheroes.Controladores.MisionSoloControl
import com.example.apiheroes.Controladores.MisionesControl
import com.example.apiheroes.Controladores.PlanetaControl
import com.example.apiheroes.Controladores.PoderesControl
import com.example.apiheroes.Controladores.PoderesHeroesControl
import com.example.apiheroes.Controladores.TipoMisionControl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object rutaAPI {

    private var build = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:8000/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    var builderHeroes = build.create(HeroesControl::class.java)
    var builderAgrupacion = build.create(AgrupacionControl::class.java)
    var builderEquipo = build.create(EquipoControl::class.java)
    var builderMisones = build.create(MisionesControl::class.java)
    var builderMisionSolo = build.create(MisionSoloControl::class.java)
    var builderMisionGrupal = build.create(MisionGrupoControl::class.java)
    var builderTipoMision = build.create(TipoMisionControl::class.java)
    var builderPoderes = build.create(PoderesControl::class.java)
    var builderPoderesHeroes = build.create(PoderesHeroesControl::class.java)
    var builderPlaneta = build.create(PlanetaControl::class.java)
}
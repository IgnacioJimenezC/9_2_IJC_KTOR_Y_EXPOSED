package com.example.DAO

import com.example.Entities.Campo
interface DAOCampos {
    suspend fun obtenerCampos():List<Campo>
    suspend fun obtenerCampo(id:Int):Campo?

    suspend fun editarCampo(id: Int,nombreCampo:String,descripcion:String,sectionID:Int,order:Int):Boolean
    suspend fun  getCamposAssociated(idArticle:Int):List<Campo>
    suspend fun anadirCampo(nombreCampo:String,descripcion:String,sectionID:Int,order:Int):Campo?
    suspend fun borrarCampo(idCampo:Int):Boolean
}
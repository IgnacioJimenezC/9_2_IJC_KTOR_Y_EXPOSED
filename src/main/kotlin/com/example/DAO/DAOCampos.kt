package com.example.DAO

import com.example.Entities.Campo
interface DAOCampos {
    suspend fun obtenerCampos():List<Campo>
    suspend fun obtenerCampo(id:String):Campo?
    suspend fun anadirCampo(id: String,nombreCampo:String,descripcion:String)
    suspend fun borrarCampo(idCampo:String):Boolean
}
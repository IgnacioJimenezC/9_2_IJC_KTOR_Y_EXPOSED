package com.example.DAO

import com.example.Entities.Campo
import com.example.Entities.Campos
import com.example.DAO.DatabaseFactory.dbQuery
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class DAOCamposImpl : DAOCampos {

    private fun resultRowToCampo(row: ResultRow) = Campo(
            id = row[Campos.id].toString(),
            name = row[Campos.name],
            description = row[Campos.description],
            sectionId = row[Campos.sectionId],
            order = row[Campos.order]
    )

    override suspend fun obtenerCampos(): List<Campo> = dbQuery {
        Campos.selectAll().map(::resultRowToCampo)
    }

    override suspend fun obtenerCampo(id:Int): Campo? = dbQuery {
        Campos
                .select { Campos.id eq id }
                .map(::resultRowToCampo)
                .singleOrNull()
    }

    override suspend fun anadirCampo(nombreCampo:String,descripcion:String,sectionID:String,order:Int): Campo? = dbQuery {
        val insertStatement = Campos.insert {
            it[Campos.name] = nombreCampo
            it[Campos.description] = descripcion
            it[Campos.sectionId] = sectionID
            it[Campos.order] = order
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToCampo)
    }

    override suspend fun editarCampo(id: Int,nombreCampo:String,descripcion:String,sectionID:String,order:Int): Boolean = dbQuery {
        Campos.update({ Campos.id eq id }) {
            it[Campos.name] = nombreCampo
            it[Campos.description] = descripcion
            it[Campos.sectionId] = sectionID
            it[Campos.order] = order
        } > 0
    }

    override suspend fun borrarCampo(id:Int): Boolean= dbQuery {
        Campos.deleteWhere { Campos.id eq id } > 0
    }
}
val daoCampos: DAOCampos = DAOCamposImpl().apply {
    runBlocking {
        if(obtenerCampos().isEmpty()) {
            anadirCampo("jijiji", "jojojo.","jeje",0)
        }
    }
}
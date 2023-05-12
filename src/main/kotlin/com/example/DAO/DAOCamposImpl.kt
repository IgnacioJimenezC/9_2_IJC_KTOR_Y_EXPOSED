package com.example.DAO

import com.example.DAO.DatabaseFactory.dbQuery
import com.example.Entities.Campo
import com.example.Entities.Campos
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class DAOCamposImpl : DAOCampos {
    private fun resultRowToCampo(row: ResultRow) = Campo(
            id = row[Campos.id],
            name = row[Campos.name],
            description = row[Campos.description],
            sectionId = row[Campos.sectionId],
            order = row[Campos.order]

    )
    override suspend fun obtenerCampos(): List<Campo> = dbQuery {
        Campos.selectAll().map(::resultRowToCampo)
    }
    override suspend fun obtenerCampo(id: String): Campo? = dbQuery {
        Campos
                .select {Campos.id eq id}
                .map(::resultRowToCampo)
                .singleOrNull()
    }

    override suspend fun anadirCampo(id: String, nombreCampo: String, descripcion: String) {
        val insertSQL = Campos.insert {
            it[Campos.id] = id
            it[Campos.name] = nombreCampo
            it[Campos.description] = descripcion
        }
        insertSQL.resultedValues?.singleOrNull()?.let(::resultRowToCampo)
    }

    override suspend fun borrarCampo(idCampo: String):Boolean = dbQuery {
        Campos.deleteWhere { Campos.id eq idCampo } > 0
    }
}

val daoCampo:DAOCampos = DAOCamposImpl().apply {
    runBlocking {
        if (obtenerCampos().isEmpty()){
            anadirCampo("prueba","prueba","prueba")
        }
    }
}
package com.example.Entities
import org.jetbrains.exposed.sql.*
data class Campo(val id:String,val name:String,val description:String,val sectionId:String,val order:Int)

object Campos:Table(){
    val id = integer("id").autoIncrement()
    val name = varchar("name",1024)
    val description = varchar("description",256)
    val sectionId = varchar("sectionID",32) //futura fk de una entidad section
    val order = integer("order")
    override val primaryKey = PrimaryKey(id)
}

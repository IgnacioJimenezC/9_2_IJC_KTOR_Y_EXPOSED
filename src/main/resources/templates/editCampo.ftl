<#-- @ftlvariable name="campo" type="com.example.Entities.Campos" -->
<#-- @ftlvariable name="articulos" type="kotlin.collections.List<com.example.Entities.Articles>" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>Edit campo</h3>
        <form action="/campo/${campo.id}" method="post">
            <p>
                <input type="text" name="name" value="${campo.name}">
            </p>
            <p>
                <textarea name="description">${campo.description}</textarea>
            </p>
            <p>
                Order: <input type="number" name="order">
            </p>
            <select name="sectionID">
                <#list articulos as articulo>
                    <option value="${articulo.id}">${articulo.title}</option>
                </#list>
            </select>
            <p>
                <input type="submit" name="_action" value="update">
            </p>
        </form>
    </div>
    <div>
        <form action="/campo/${campo.id}" method="post">
            <p>
                <input type="submit" name="_action" value="delete">
            </p>
        </form>
    </div>
</@layout.header>
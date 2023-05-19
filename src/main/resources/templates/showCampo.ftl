<#-- @ftlvariable name="campo" type="com.example.Entities.Campos" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>
            ${campo.name}
        </h3>
        <p>
            ${campo.description}
        </p>
        <hr>
        <p>
            <a href="/campo/${campo.id}/edit">Edit campo</a>
        </p>
    </div>
</@layout.header>
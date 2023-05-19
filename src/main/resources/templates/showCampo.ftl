<#-- @ftlvariable name="campos" type="com.example.Entities.Campos" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>
            ${campos.name}
        </h3>
        <p>
            ${campos.description}
        </p>
        <hr>
        <p>
            <a href="/campo/${campos.id}/edit">Edit campo</a>
        </p>
    </div>
</@layout.header>
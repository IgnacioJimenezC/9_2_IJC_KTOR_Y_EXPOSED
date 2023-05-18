<#-- @ftlvariable name="dolor" type="kotlin.collections.List<com.example.Entities.Campos>" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <#list dolor?reverse as campo>
        <div>
            <h3>
                <a href="/campo/${campo.id}">${campo.name}</a>
            </h3>
            <p>
                ${campo.description}
            </p>
        </div>
    </#list>
    <hr>
    <p>
        al borde de la locura
    </p>
</@layout.header>
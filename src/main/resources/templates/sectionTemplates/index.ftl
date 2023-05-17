<#-- @ftlvariable name="campos" type="kotlin.collections.List<com.example.Entities.Campos>" -->
<#import "../_layout.ftl" as layout />
<@layout.header>
    <#list campos?reverse as campo>
        <div>
            <h3>
                <a href="/section/${campo.id}">${campo.name}</a>
            </h3>
            <p>
                ${campo.description}
            </p>
        </div>
    </#list>
    <hr>
    <p>
    </p>
</@layout.header>
<#-- @ftlvariable name="article" type="com.example.Entities.Article" -->
<#-- @ftlvariable name="camposRelacionados" type="kotlin.collections.List<com.example.Entities.Campos>" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>
            ${article.title}
        </h3>
        <p>
            ${article.body}
        </p>
        <hr>
        <p>Campos relacionados</p>
        <#list camposRelacionados?reverse as campo>
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
            <a href="/articles/${article.id}/edit">Edit article</a>
        </p>
    </div>
</@layout.header>
<#-- @ftlvariable name="artiCULOS" type="kotlin.collections.List<com.example.Entities.Articles>" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>Create campo</h3>
        <form action="/campo" method="post" >
            <p>
                <input type="text" name="name">
            </p>
            <p>
                <textarea name="description"></textarea><br>
            </p>

            <select name="seccionID">
                <#list artiCULOS as artiCULO>
                    <option value="${artiCULO.id}">${artiCULO.title}</option>
                </#list>
            </select>
            <p>
                <input name="order" type="number">
            </p>
            <p>
                <input type="submit">
            </p>
        </form>
    </div>
</@layout.header>
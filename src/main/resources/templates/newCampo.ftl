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

            <p>
            <input type="text" name="sectionID">
            </p>

            <p>
                <input name="order" type="number">
            </p>
            <p>
                <input type="submit">
            </p>
        </form>
    </div>
</@layout.header>
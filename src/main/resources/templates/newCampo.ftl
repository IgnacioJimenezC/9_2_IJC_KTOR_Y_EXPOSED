<#import "_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>Create article</h3>
        <form action="/campo" method="post">
            <p>
                <input type="text" name="name">
            </p>
            <p>
                <textarea name="description"></textarea><br>
                <input type="text" name="sectionID">
                <input type="order" type="number">
            </p>
            <p>
                <input type="submit">
            </p>
        </form>
    </div>
</@layout.header>
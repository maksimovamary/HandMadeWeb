<%-- 
    Document   : shop
    Created on : 26.11.2014, 16:05:57
    Author     : Mary
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>    
    <body>       
        <div id="main">
            <aside class="leftAside">
                <h2>Лучшие товары</h2>
                <ul>
                    <li><a href="#">Товар 1</a></li>
                    <li><a href="#">Товар 2</a></li>
                    <li><a href="#">Товар 3</a></li>
                    <li><a href="#">Товар 3</a></li>
                    
                </ul>
            </aside>
            <section>
                <shop>
                    <h1>${shop.title}</h1>
                    <div class="text-shop">
                        ${shop.text}
                    </div>
                    <div class="fotter-shop">
                        <span class="date-shop">Дата: ${shop.date}</span>
                    </div>
                </shop>
            </section>
        </div>        
    </body>
</html>
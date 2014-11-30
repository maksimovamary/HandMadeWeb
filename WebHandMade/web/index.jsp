<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <body>
        <div id="main">
            <aside class="leftAside">
                <h2>Лучшие товары</h2>
                <ul>
                    <li><a href="#">Товар 1</a></li>
                    <li><a href="#">Товар 2</a></li>
                    <li><a href="#">Товар 3</a></li>
                </ul>
            </aside>
            <section>
                <c:forEach var="shop" items="${shops}">
                    <shop>
                        <h1>${shop.title}</h1>
                        <div class="text-shop">
                            ${fn:substring(shop.text,0,300)} ...
                        </div>
                        <div class="fotter-shop">
                            <span class="read"><a href="shop?id=${shop.id}">

                                    Подробнее...</a></span>
                            <span class="date-shop">Дата: ${shop.date}</span>
                        </div>
                    </shop>
                </c:forEach>
            </section>
        </div>
    </body>
</html>

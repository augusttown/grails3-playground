<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
    </head>
    <body>
        <div id="list-user" class="content scaffold-list" role="main">
            <f:table collection="${userList}" />
            <div class="pagination">
                <g:paginate total="${userCount ?: 0}" />
            </div>
        </div>
    </body>
</html>
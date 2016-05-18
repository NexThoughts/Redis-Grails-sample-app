<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
</head>

<body>
<a href="#list-person" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                             default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        %{--<li><g:link class="create" action="create"><g:message code="default.new.label"--}%
        %{--args="[entityName]"/></g:link></li>--}%
    </ul>
</div>

<div id="list-person" class="content scaffold-list" role="main">
    <h1>Person List</h1>
    <table>
        <thead>
        <tr>
            <g:sortableColumn property="age" title="${message(code: 'person.age.label', default: 'Person')}"/>

            <g:sortableColumn property="name" title="${message(code: 'person.name.label', default: 'ID')}"/>
        </tr>
        </thead>
        <tbody>
        <redis:memoize key="${mykey}" expire="30">
           ${raw(demo.personRecord())}
        </redis:memoize>
        </tbody>
    </table>

    %{--<div class="pagination">--}%
    %{--<g:paginate total="${personInstanceCount ?: 0}"/>--}%
    %{--</div>--}%
</div>

</body>
</html>
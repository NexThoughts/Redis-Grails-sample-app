<g:each in="${personList}" status="i" var="person">

    <tr style="width: 100%;" class="${(i % 2) == 0 ? 'even' : 'odd'}">

        <td>Person is</td>

        <td>${person.id}</td>

    </tr>
</g:each>
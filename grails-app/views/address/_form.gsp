<%@ page import="com.redis.Address" %>



<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'country', 'error')} required">
	<label for="country">
		<g:message code="address.country.label" default="Country" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="country" required="" value="${addressInstance?.country}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'locality', 'error')} required">
	<label for="locality">
		<g:message code="address.locality.label" default="Locality" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="locality" required="" value="${addressInstance?.locality}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'person', 'error')} required">
	<label for="person">
		<g:message code="address.person.label" default="Person" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="person" name="person.id" from="${com.redis.Person.list()}" optionKey="id" required="" value="${addressInstance?.person?.id}" class="many-to-one"/>

</div>


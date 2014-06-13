<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<html>
<body>
 <form:form modelAttribute="person" method="POST">
 <form:label path="firstName"  >First Name</form:label>
 <form:input path="firstName" />
 <input id="submit" type="submit" value="Add Person" />
 Handicapped: 
    <form:radiobuttons  path="handicapped" items="${handicappedOptions}" />

<security:authorize access="hasRole('ROLE_USER')">
TOP SECRET INFO
</security:authorize>
</form:form> 
</body>
</html>
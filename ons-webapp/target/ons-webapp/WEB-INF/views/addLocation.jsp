<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html>
<body>
 <form:form modelAttribute="location" method="POST">
 <input id="submit" type="submit" value="Add Location" />
<%--    <form:radiobuttons  path="handicapped" items="${handicappedOptions}" /> --%>
 </form:form> 
</body>
</html>
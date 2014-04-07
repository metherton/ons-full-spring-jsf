<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="utf-8">
  <title>jQuery UI Tooltip - Default functionality</title>
   <link rel="stylesheet"  href="<c:url value="/resources/jquery-ui.css" />" type="text/css" >
    <script type="text/javascript" src="<c:url value="/resources/jquery-1.10.2.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/jquery-ui.js" />"></script>
  <script>
  $(function() {
    $(".tt").tooltip();
  });
  </script>
</head>
<body>

<h2>Overzicht</h2><br />


<a href="#" title="That&apos;s what this widget is">tooltips</a><br /><br>
<form:form method="POST" action="senddms">
<input type="text" /><br />
<input type="text" /><br />
<input type="text" /><br />
<input type="submit" value="Submit"/><br /><br />
<a class="tt" href="#" title="Is there something you do not understand ?"><img src="<c:url value='/resources/q-small.gif' />" /></a>

</form:form>
</body>
</html>
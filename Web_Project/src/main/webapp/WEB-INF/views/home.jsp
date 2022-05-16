<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head>
	<title>Home</title>
</head>
<body>
	
	<tiles:insertAttribute name="header" />
	
	<div><tiles:insertAttribute name="body" /></div>
	<div><tiles:insertAttribute name="footer" /></div>
	
</body>
</html>

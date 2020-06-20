<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<div
		style="background-image: linear-gradient(to bottom right, #FF8C00, #FFC04C); min-height: 80vh;">
		<main role="main" class="container">
			<div class="row">
				<div class="col-md-8 my-4">
					<div class="card mb-3 px-3 py-3">
						<form class="form-inline mb-3 pb-3"
							style="border-bottom: 1px solid" action="listaLibri" method="post">
							<button type="submit" class="btn btn-primary mb-2" >Visualizza Libri</button>
						</form>
					</div>
				</div>
			</div>
		</main>
	</div>
</body>
</html>
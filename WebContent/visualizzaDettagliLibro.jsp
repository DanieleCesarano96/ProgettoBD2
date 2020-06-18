<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/stile.css">
<title>Dettagli Libro</title>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
</head>
<body>

	<jsp:include page="header.jsp" />

	<div
		style="background-image: linear-gradient(to bottom right, #FF8C00, #FFC04C); min-height: 80vh;">
		<main role="main" class="container">

		<div class="row">
			<div class="col-md-8 my-4">
				<div class="card mb-3">
					<div class="card-body">
						<div class="container emp-profile">
							<div class="row">
								<div class="col-md-4">
									<div class="profile-img">
										<img alt="load" src="img/logo.png" width="100%">
									</div>
								</div>
								<div class="col-md-6">
									<div class="profile-head">
										<h5 class="card-title"></h5>
										<ul class="nav nav-tabs" id="myTab" role="tablist">
											<li class="nav-item"> <a class="nav-link active"
												id="home-tab" data-toggle="tab" role="tab"
												aria-controls="home" aria-selected="true">Informazioni
													del libro</a></li>
										</ul>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-8">
									<div class="tab-content profile-tab" id="myTabContent">
										<div class="tab-pane fade show active" id="home"
											role="tabpanel" aria-labelledby="home-tab">
											<div class="row">
												<div class="col-md-6">
													<label>Titolo: </label>
												</div>
												<div class="col-md-6">
													<p>Harry Potter and the Chamber of Secrets (Harry Potter  #2)</p>
												</div>
											</div>

											<div class="row">
												<div class="col-md-6">
													<label>Autore:</label>
												</div>
												<div class="col-md-6">
													<p>J.K. Rowling</p>
												</div>
											</div>

											<div class="row">
												<div class="col-md-6">
													<label>Valutazione media:</label>
												</div>
												<div class="col-md-6">
													<p>4.42</p>
												</div>
											</div>

											<div class="row">
												<div class="col-md-6">
													<label>Isbn:</label>
												</div>
												<div class="col-md-6">
													<p>439554896</p>
												</div>
											</div>
											
											<div class="row">
												<div class="col-md-6">
													<label>Isbn13:</label>
												</div>
												<div class="col-md-6">
													<p>9780439554893</p>
												</div>
											</div>
											
											<div class="row">
												<div class="col-md-6">
													<label>Lingua:</label>
												</div>
												<div class="col-md-6">
													<p>eng</p>
												</div>
											</div>
											
											<div class="row">
												<div class="col-md-6">
													<label>Numero pagine:</label>
												</div>
												<div class="col-md-6">
													<p>352</p>
												</div>
											</div>
											
											<div class="row">
												<div class="col-md-6">
													<label>Numero valutazioni:</label>
												</div>
												<div class="col-md-6">
													<p>6333</p>
												</div>
											</div>
	
											<div class="row">
												<div class="col-md-6">
													<label>Numero revisioni:</label>
												</div>
												<div class="col-md-6">
													<p>244</p>
												</div>
											</div>
	
											<div class="row">
												<div class="col-md-6">
													<label>Data publicazione:</label>
												</div>
												<div class="col-md-6">
													<p>11/1/2003</p>
												</div>
											</div>
	
											<div class="row">
												<div class="col-md-6">
													<label>Casa editrice:</label>
												</div>
												<div class="col-md-6">
													<p>Scholastic</p>
												</div>
											</div>

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</main>
	</div>
</body>
</html>
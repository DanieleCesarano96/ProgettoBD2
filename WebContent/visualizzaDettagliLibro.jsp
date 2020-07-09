<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*"
	import="model.*" %>

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

		<% 
				LibroBean libro= (LibroBean) request.getAttribute("libro");	
		%>
		
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
													<p><%=libro.getTitolo()%></p>
												</div>
											</div>

											<div class="row">
												<div class="col-md-6">
													<label>Autore:</label>
												</div>
												<div class="col-md-6">
												<% 
														if(libro.getAutore()!=null)
														{	
												%>
														<p><%=libro.getAutore() %></p> 
												<% 
														}
												%>
												</div>
											</div>

											<div class="row">
												<div class="col-md-6">
													<label>Valutazione media:</label>
												</div>
												<div class="col-md-6">
												<% 
														if(libro.getValutazione_media()!=-1)
														{	
												%>
														<p><%=libro.getValutazione_media() %></p>
												<% 
														}
												%>
												</div>
											</div>

											<div class="row">
												<div class="col-md-6">
													<label>Isbn:</label>
												</div>
												<div class="col-md-6">
															
												<% 
														if(libro.getIsbn()!=null)
														{	
												%>	
														<p><%=libro.getIsbn() %></p> 
												<% 
														}
												%>
												</div>
											</div>
											
											<div class="row">
												<div class="col-md-6">
													<label>Isbn13:</label>
												</div>
												<div class="col-md-6">
													<% 
															if(libro.getIsbn13()!=null)
															{	
													%>	
															<p><%=libro.getIsbn13() %></p> 
													<% 
															}
													%>
												</div>
											</div>
											
											<div class="row">
												<div class="col-md-6">
													<label>Lingua:</label>
												</div>
												<div class="col-md-6">
													<% 
															if(libro.getLingua()!=null)
															{	
													%>	
															<p><%=libro.getLingua() %></p> 
													<% 
															}
													%>
												</div>
											</div>
											
											<div class="row">
												<div class="col-md-6">
													<label>Numero pagine:</label>
												</div>
												<div class="col-md-6">
													<% 
															if(libro.getNumero_pagine()!=-1)
															{	
													%>
															<p><%=libro.getNumero_pagine() %></p>
													<% 
															}
													%>
												</div>
											</div>
											
											<div class="row">
												<div class="col-md-6">
													<label>Numero valutazioni:</label>
												</div>
												<div class="col-md-6">
													<% 
															if(libro.getNumero_valutazioni()!=-1)
															{	
													%>
															<p><%=libro.getNumero_valutazioni() %></p>
													<% 
															}
													%>
												</div>
											</div>
	
											<div class="row">
												<div class="col-md-6">
													<label>Numero revisioni:</label>
												</div>
												<div class="col-md-6">
												<% 
														if(libro.getNumero_revisioni()!=-1)
														{	
												%>
														<p><%=libro.getNumero_revisioni() %></p>
												<% 
														}
												%>
												</div>
											</div>
	
											<div class="row">
												<div class="col-md-6">
													<label>Data publicazione:</label>
												</div>
												<div class="col-md-6">
												<% 
														if(libro.getData_publicazione()!=null)
														{	
												%>
														<p><%=libro.getData_publicazione()%></p>
												<% 
														}
												%> 
												</div>
											</div>
	
											<div class="row">
												<div class="col-md-6">
													<label>Casa editrice:</label>
												</div>
												<div class="col-md-6">
													<% 
															if(libro.getCasa_editrice()!=null)
															{	
													%>
																<p><%=libro.getCasa_editrice()%></p>
													<% 
															}
													%>
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
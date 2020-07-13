<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*"
	import="model.*"
	%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<% 
						ArrayList<String> autori= (ArrayList<String>) request.getAttribute("autori");
						ArrayList<String> case_editrici= (ArrayList<String>) request.getAttribute("case_editrici");
						String aut= (String)request.getAttribute("autore");
						String casa_ed= (String)request.getAttribute("casa_editrice");
						String num_lib= (String)request.getAttribute("num_lib");
						String media_rate= (String)request.getAttribute("media_rate");
						String num_libri_anno= (String)request.getAttribute("num_libri_anno");
						String rate_max= (String)request.getAttribute("rate_max");
						String rate_min= (String)request.getAttribute("rate_min");
	%>
					
	<div
		style="background-image: linear-gradient(to bottom right, #FF8C00, #FFC04C); min-height: 80vh;">
		<main role="main" class="container">

		<div class="row">
			<div class="col-md-8 my-4">
				<div class="card mb-3 px-3 py-3">
					
				<h4 class="font-italic pt-3 pl-3 pr-3 pb-1">Query analitiche</h4>
				
					<table class="table" style="table-layout: fixed; width: 100%;">
						<tr class="border" style="word-wrap: break-word;">
							<td
								style="font-size: 14px; padding: 5px; margin-right: 2px; word-wrap: break-word;">
								<form action="queryAnalitiche" method="post">
									
									<label for="autori">Scegli un autore:</label>
										<select name="autori" id="autori">
										<option value=""></option>
										<%
										for(String autore:autori)
										{
											
										%>
										  <option value="<%=autore%>"><%=autore%></option>
										<%
										}
												
										%>
										</select>
										
									<label for="case_editrici">Scegli una casa editrice:</label>
										<select  name="case_editrici" id="case_editrici">
										<option value=""></option>
										<%
										for(String casa_editrice:case_editrici)
										{
											
										%>
										  <option value="<%=casa_editrice%>"><%=casa_editrice%></option>
										<%
											}
												
										%>
										</select>
									<h6>Numero libri publicati da un determinato autore o/e casa editrice.</h6>
									<button name="button1" type="submit" class="btn btn-primary mb-2"> Cerca</button>
									
									<h6>Rate max e min per un autore o casa editrice.</h6>
									<button name="button2" type="submit" class="btn btn-primary mb-2"> Cerca</button>
									
									<h6>Media del rate medio di ogni libro per un determinato autore o/e casa editrice.</h6>
									<button name="button3" type="submit" class="btn btn-primary mb-2"> Cerca</button>
								</form>	
							</td>
						</tr>
					</table>
					
					
					<h6>Numero libri publicati da una determinata casa editrice in un anno.</h6>
					<table class="table" style="table-layout: fixed; width: 100%;">
						<tr class="border" style="word-wrap: break-word;">
							<td
								style="font-size: 14px; padding: 5px; margin-right: 2px; word-wrap: break-word;">
								<form action="numeroLibriAnno" method="post">						
									<label for="case_editrici3">Scegli una casa editrice:</label>
										<select  name="case_editrici3" id="case_editrici3">
										<option value=""></option>
										<%
											for(String casa_editrice:case_editrici)
											{
											
										%>
										  <option value="<%=casa_editrice%>"><%=casa_editrice%></option>
										<%
											}
												
										%>
										</select>
										<input class="form-control" type="text"  placeholder="anno" name="anno" required>
										
									<button type="submit" class="btn btn-primary mb-2"> Cerca</button>
								</form>	
							</td>
						</tr>

					</table>
				</div>
			</div>

			
			<aside class="col-md-4 my-4">
				<div class="list-group p-1 card">
				
						<h5 class="card-title mb-1">Risultati&nbsp;</h5>
					
						<%
							if(aut!=null)
							{
						%>
						<div class="row">
							<div class="col-md-6">
								<label>Autore: </label>
							</div>
							<div class="col-md-6">
								<p><%=aut%></p>
							</div>
						</div>
						<%
							}
							if(casa_ed!=null)
							{
						%>
						<div class="row">
							<div class="col-md-6">
								<label>Casa Editrice: </label>
							</div>
							<div class="col-md-6">
								<p><%=casa_ed%></p>
							</div>
						</div>
						<%
							}
							if(rate_max!=null)
							{
						%>
						<div class="row">
							<div class="col-md-6">
								<label>Rate max: </label>
							</div>
							<div class="col-md-6">
								<p><%=rate_max%></p>
							</div>
						</div>
						<%
							}
							if(rate_min!=null)
							{
						%>
						<div class="row">
							<div class="col-md-6">
								<label>Rate min: </label>
							</div>
							<div class="col-md-6">
								<p><%=rate_min%></p>
							</div>
						</div>
						<%
							}
							if(media_rate!=null)
							{
						%>
						<div class="row">
							<div class="col-md-6">
								<label>Media del rate medio: </label>
							</div>
							<div class="col-md-6">
								<p><%=media_rate%></p>
							</div>
						</div>
						<%
							}
							if(num_lib!=null)
							{	
						%>
						
						<div class="row">
							<div class="col-md-6">
								<label>Numero Libri: </label>
							</div>
							<div class="col-md-6">
								<p><%=num_lib%></p>
							</div>
						</div>
						<%
							}
							if(num_libri_anno!=null)
							{	
						%>
						
						<div class="row">
							<div class="col-md-6">
								<label>Numero Libri in un anno: </label>
							</div>
							<div class="col-md-6">
								<p><%=num_libri_anno%></p>
							</div>
						</div>
						<%
							}
						
						%>
				
				</div>

			</aside>
			<aside class="col-md-4 my-4">
				<div class="list-group p-1 card">
					<h4 class="font-italic pt-3 pl-3 pr-3 pb-1">Query di ricerca</h4>
					<table class="table" style="table-layout: fixed; width: 100%;">
						<tr class="border" style="word-wrap: break-word;">
							<td
								style="font-size: 14px; padding: 5px; margin-right: 2px; word-wrap: break-word;">
								<form action="index.jsp" method="post">								
									<button type="submit" class="btn btn-primary mb-2"> Vai alle Query di ricerca</button>
								</form>	
							</td>
						</tr>

					</table>
				</div>

			</aside>
		</div>
		</main>
	</div>
</body>
</html>
<!-- Incluir topo -->
<%@include file="topo.jsp" %>
<%@include file="rodapé.jsp" %>

	<!-- CSS -->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/estilos.css" rel="stylesheet">
	
	
	<link href="calendario/calendar.css" rel="stylesheet">
	<script src="calendario/calendar.js"></script>

<section class="calendario">

<div id="page-body">
    <!-- [PERIOD SELECTOR] -->
    <div id="cal-date">
      <select id="cal-mth"></select>
      <select id="cal-yr"></select>
      <input id="cal-set" type="button" value="Procurar"/>
    </div>

    <!-- [CALENDAR] -->
    <div id="cal-container"></div>

    <!-- [EVENT] -->
    <div id="cal-event"></div>
  </div>
</section>
</body>
</html>
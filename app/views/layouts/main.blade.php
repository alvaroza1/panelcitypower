<html lang="es">
	<head>
		<title>Panel</title>
		<meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
       {{ HTML::script('resources/js/jquery-1.10.2.js') }}
		{{ HTML::script('resources/js/functions.js') }}
		{{ HTML::script('resources/js/mapa.js') }}
	    {{ HTML::script('resources/js/datepicker.js') }}
		{{ HTML::style('resources/css/styles.css'); }}
		{{HTML::script('resources/js/jquery-ui.js')}} 
	   <script type="text/javascript">
       	$(function() {
               $("#datepicker").datepicker({ dateFormat: "yy-mm-dd" }).val()
      		});
  		</script>
	</head>
	<body>
		<section id="header">
			<img src="{{asset('resources/img/cityPowerlogo_picOnly_Trasparent.png')}}" id="logo-header" alt="logo">
			<div class="barra color_morado">
				<h1 class="barra_session contenido_izquierda">{{Session::get('usuario_nombre')}}</h1>
				<h1 id="perfil" class="barra_session contenido_izquierda">{{Session::get('estado')}}</h1>
				<h1 id="agencia" class="barra_session contenido_izquierda">{{Session::get('empresa')}}</h1>
				<h1 class="barra_session contenido_izquierda error">{{Session::get('mensaje_error')}}</h1>
				<a href="{{asset('logout')}}">Salir</a>
			</div>
			<!-- <img id="logo_inicio" src="{{asset('resources/img/logo_inicio.png')}}"> -->
		</section>
		<nav id="menu_main">
			<ul>
				<li><a href="{{asset('')}}">Mapa</a></li>
				<div class="divider"></div>
				<li><a href="{{asset('reportes')}}">Todos los reportes</a></li>
				<div class="divider"></div>
				<li><a href="{{asset('estadistica')}}">Estadística</a></li>
				
			</ul>
		</nav>
		<section id="contenedor">
			@section('informacion')
			@show
		 </section>
		 {{ HTML::script('https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true') }}
		 <script type="text/javascript"> var url = "{{asset('')}}";</script>
		  	{{ HTML::script('resources/js/functions.js') }}
	</body>
</html>	
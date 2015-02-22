<!DOCTYPE html>
<html>
<head>
	<title>Panel City Power</title>
	{{ HTML::script('resources/js/jquery-1.10.2.js') }}
	{{ HTML::script('resources/js/functions.js') }}
	{{ HTML::script('resources/js/mapa.js') }}
    {{ HTML::script('resources/js/datepicker.js') }}
	{{ HTML::style('resources/css/styles.css'); }}
	{{HTML::script('resources/js/jquery-ui.js')}}
</head>
<body>
	<header id="header-login">
	<img src="{{asset('resources/img/cityPowerlogo_picOnly_Trasparent.png')}}" id="logo" alt="logo">
		Panel City Power
	</header>
    <form action="{{asset('login')}}" method="POST">
    	{{Form::token();}}
        <input type="text" name="usuario" class="forma icon_usuario" placeholder="Usuario" />
        <input type="password" name="clave" class="forma icon_password" placeholder="Contraseña" />
        <input type="submit" value="Entrar" class="fondo_boton" />
    </form>
</html>

</body>
</html>
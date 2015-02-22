@extends('layouts.main')
@section('informacion')
<table class="catalogo">
		<thead>
			<tr>
				<td>Descripción</td>
				<td>Colonia</td>
				<td>Fecha</td>
				<td>Estatus</td>
			</tr>
			<tbody>
			<tr onclick="location.href='{{asset('reportes/20.731077/-103.410895')}}'">
				<td>No sirve el alambrado público</td>
				<td>Santa Margarita</td>
				<td>10/02/2015</td>
				<td>En proceso</td>
			</tr>
			<tr onclick="location.href='{{asset('reportes/20.668161/ -103.368351')}}'">
				<td>un poste se derrumbo</td>
				<td>Chapultepec</td>
				<td>10/02/2015</td>
				<td>Atendido</td>
			</tr>
			<tr onclick="location.href='{{asset('reportes/20.731077/-103.410895')}}'">
				<td>se fue la luz en mi cuadra</td>
				<td>Santa Margarita</td>
				<td>23/02/2015</td>
				<td>En proceso</td>
			</tr>
			<tr onclick="location.href='{{asset('reportes/20.668161/ -103.368351')}}'">
				<td>el transformado exploto</td>
				<td>Chapultepec</td>
				<td>23/02/2015</td>
				<td>Atendido</td>
			</tr>
			<tr onclick="location.href='{{asset('reportes/20.731077/-103.410895')}}'">
				<td>chocaron contra un poste</td>
				<td>pablo neruda</td>
				<td>23/02/2015</td>
				<td>En proceso</td>
			</tr>
			<tr onclick="location.href='{{asset('reportes/20.731077/-103.410895')}}'">
				<td>Hay un corto circuito en el alumbrado</td>
				<td>arias</td>
				<td>23/02/2015</td>
				<td>pendiente</td>
			</tr>
			<tr onclick="location.href='{{asset('reportes/20.731077/-103.410895')}}'">
				<td>la lampara esta fundida</td>
				<td>vallarta la patria</td>
				<td>23/02/2015</td>
				<td>En proceso</td>
			</tr>
			<tr onclick="location.href='{{asset('reportes/20.731077/-103.410895')}}'">
				<td>falla alambrado público</td>
				<td>sebastian bach</td>
				<td>23/02/2015</td>
				<td>Pendiente</td>
			</tr>
			<tr onclick="location.href='{{asset('reportes/20.731077/-103.410895')}}'">
				<td>No hay luz en la calle</td>
				<td>Santa Margarita</td>
				<td>23/02/2015</td>
				<td>En proceso</td>
			</tr>
			<tr onclick="location.href='{{asset('reportes/20.671858/-103.430696')}}'">
				<td>No sirve el la luz</td>
				<td>rafael sanzio</td>
				<td>23/02/2015</td>
				<td>Atendido</td>
			</tr>
			</tbody>
		</thead>
	</table>
@stop
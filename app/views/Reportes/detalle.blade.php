@extends('layouts.main')
@section('informacion')
<input id="lat" value="{{$data['lat']}}" hidden>
<input id="lng" value="{{$data['lng']}}" hidden>
<div id="reporte_detalle">
	<div>Fecha: 14-10-2015</div>
	<div>Comentario: Se quemó un gato con el cable</div>
	<div> Colonia: Jalisco</div>
	<div></div>
</div>
<div id="mapa_detalle"></div>
@stop
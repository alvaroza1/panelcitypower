<?php

class ReportesController extends BaseController {

	public function index()
	{

		return View::make('Reportes.reportes');
	}

	public function detalle($lat, $lng){
		$data['lat'] = $lat;
		$data['lng'] = $lng;
		return View::make('Reportes.detalle')->with('data', $data);
	}

	public function estadistica(){
		Return View::make('Reportes.estadistica');
	}
}

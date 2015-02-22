<?php

class IndexController extends BaseController {

	public function getIndex()
	{

		$data['seccion'] = 'Inicio';
		return View::make('Index.index')->with('data', $data);
	}
}

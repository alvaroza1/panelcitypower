<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It's a breeze. Simply tell Laravel the URIs it should respond to
| and give it the Closure to execute when that URI is requested.
|
*/

Route::get('login','LoginController@index');
Route::post('login','LoginController@login');


Route::group(array('before' => 'auth'), function(){
	
	// Sin permisos
	Route::get('forbidden', 'ForbiddenController@mostrar');
	Route::get('/', 'IndexController@getIndex');
	Route::get('logout','LoginController@logout');
	Route::get('reportes','ReportesController@index');
	Route::get('reportes/{lat}/{lng}','ReportesController@detalle');
	Route::get('estadistica','ReportesController@estadistica');
	Route::group(array('before' => 'right'), function(){

	});
});
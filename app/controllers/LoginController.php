<?php

class LoginController extends BaseController {

	public function index()
	{
		return View::make('Login.index');
	}

	public function login(){
		 $userdata = array('correo' => Input::get('usuario'),
                          'password' => Input::get('clave'),
                          'estatus' => 'Disponible');
        Session::put('empresa', 'CFE');
        Session::put('estado', 'Jalisco');
        Session::put('usuario_id', 1);
        return Redirect::to('/');
        // if (Auth::attempt($userdata)){
        // 	Session::put('usuario_id', 1);
        //     return Redirect::to('/');
        
        // }else{
        //     return Redirect::to('login')->with('login_errors',true);
        // }
	}

	public function logout(){
		Session::flush();
		return Redirect::to('login');
	}

}

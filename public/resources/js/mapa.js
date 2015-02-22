
var markermap;
var searchMap;
var markers = [];
var contMarker = 0;

function get_location(id){
    console.log('click');
    var pinColor = "4A8AF6";
    var pinImage = new google.maps.MarkerImage("http://chart.apis.google.com/chart?chst=d_map_pin_letter&chld=%E2%80%A2|" + pinColor,
    new google.maps.Size(21, 34),
    new google.maps.Point(0,0),
    new google.maps.Point(10, 34));

    if(navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function(position) {
                var pos = new google.maps.LatLng(position.coords.latitude,
                                               position.coords.longitude);
                pos;
                //console.log(pos);
                //var latlng = new google.maps.LatLng(pos);
                var latlng = new google.maps.LatLng(pos.k, pos.D);
                 $('#mapa_latitud').val(pos.k);
                $('#mapa_longitud').val(pos.D);
                var settings = {
                    zoom: 15,
                    center: latlng,
                    mapTypeControl: true,
                    mapTypeControlOptions: {style: google.maps.MapTypeControlStyle.DROPDOWN_MENU},
                    navigationControl: true,
                    navigationControlOptions: {style: google.maps.NavigationControlStyle.SMALL},
                    mapTypeId: google.maps.MapTypeId.ROADMAP
                };
               
                var map = new google.maps.Map(document.getElementById(id), settings);
                 markermap = new google.maps.Marker({
                    position: latlng,
                    map: map,
                    draggable:true,
                    animation: google.maps.Animation.DROP,
                    icon: pinImage,
                    title: "Consultorio",
                    disableDefaultUI: true
                });
                drag_listener(markermap);
                mapa_listener(map);
            }, function() {
                handleNoGeolocation(true);
            });
        } else {
        // Browser doesn't support Geolocation

            handleNoGeolocation(false);
        }
}

function click_doctor_center(){
     $('').click(function(){
        // console.log('click bloque');
        var block = $(this);
        // console.log(block.find('.block-lat').val());
        // console.log(block.find('.block-lng').val());
        var latlng = new google.maps.LatLng(block.find('.block-lat').val(), block.find('.block-lng').val());
        searchMap.setZoom(15);
        searchMap.setCenter(latlng);
    });
}

function search_map(id){
    
    if($('#'+id).length > 0){   
          
        var latlng = new google.maps.LatLng(22.621263, -102.462017);
        var settings = {
            zoom: 4,
            center: latlng,
            mapTypeControl: true,
            mapTypeControlOptions: {style: google.maps.MapTypeControlStyle.DROPDOWN_MENU},
            navigationControl: true,
            navigationControlOptions: {style: google.maps.NavigationControlStyle.SMALL},
            mapTypeId: google.maps.MapTypeId.ROADMAP,
            
        };
        searchMap = new google.maps.Map(document.getElementById(id), settings);

        // $(document).ajaxStop(function () {
        //     $.each(search_data['doctors'], function(index, value){
        //         // console.log('algo');
        //         // ubicacion_mapa(value, searchMap);
                
        //     });
        // });
    }
}

function clear_Map(){
     //Loop through all the markers and remove
        for (var i = 0; i < markers.length; i++) {
            markers[i].setMap(null);
        }
        markers = [];
        searchMap.setZoom(4);
        searchMap.setCenter(new google.maps.LatLng(22.621263, -102.462017));

}

function ubicacion_mapa(latitud, longitud, map){
    // var pinColor = "4A8AF6";
    var pinImage = new google.maps.MarkerImage(url+'resources/img/foco_rojo.png',
    new google.maps.Size(30, 30),
    new google.maps.Point(0,0),
    new google.maps.Point(20, 20));
    //var latitud = value.lat;
    //var longitud = value.lng;

    var latlng = new google.maps.LatLng(latitud, longitud);
    
    var marker = new google.maps.Marker({
        position: latlng,
        map: map,
        draggable:false,
        animation: google.maps.Animation.DROP,
        icon: pinImage,
        title: "Consultorio"
    });

    var infowindow = new google.maps.InfoWindow({
          content: '<div class="align-left location-list color-black">Queja masiva</div>'
    });

    google.maps.event.addListener(marker, 'click', function() {
        map.setZoom(15);
        map.setCenter(marker.getPosition());
        // infowindow.open(map,marker);
    });

    google.maps.event.addListener(marker, 'mouseover', function() {
        infowindow.open(map,marker);
    });

    google.maps.event.addListener(marker, 'mouseout', function() {
        infowindow.close();
    });

    markers.push(marker);
}

function mapa (id){

    if($('#'+id).length > 0){   
          
        var latlng = new google.maps.LatLng(22.621263, -102.462017);
        var settings = {
            zoom: 4,
            center: latlng,
            mapTypeControl: true,
            mapTypeControlOptions: {style: google.maps.MapTypeControlStyle.DROPDOWN_MENU},
            navigationControl: true,
            navigationControlOptions: {style: google.maps.NavigationControlStyle.SMALL},
            mapTypeId: google.maps.MapTypeId.ROADMAP,
            
        };
        var map = new google.maps.Map(document.getElementById(id), settings);
        mapa_listener(map);

        $('.form-button-home').click(function(){
            //console.log('click');
             google.maps.event.trigger(map, "resize");
        }); 
    }
}

function mapa_listener(map){
    var pinColor = "4A8AF6";
    var pinImage = new google.maps.MarkerImage("http://chart.apis.google.com/chart?chst=d_map_pin_letter&chld=%E2%80%A2|" + pinColor,
    new google.maps.Size(21, 34),
    new google.maps.Point(0,0),
    new google.maps.Point(10, 34));

     google.maps.event.addListener(map, "click", function(event) {
          
        if(markermap){
            markermap.setMap(null);
            markermap = null;
        }else{      
            markermap = new google.maps.Marker({
                position: event.latLng,
                map: map,
                draggable:true,
                animation: google.maps.Animation.DROP,
                icon: pinImage,
                title: "Consultorio"
            });
            $('#mapa_latitud').val(event.latLng.k);
            $('#mapa_longitud').val(event.latLng.D);
            console.log(event.latLng);
            console.log(event.latLng.k);
            console.log(event.latLng.D);
            drag_listener(markermap);
        }
    });
}

function drag_listener(marker){
    google.maps.event.addListener(marker,'dragend',function(event){
        $('#mapa_latitud').val(event.latLng.k);
        $('#mapa_longitud').val(event.latLng.D);
    });
}
var detailMap;
//Al cargar la pagina 
$(function(){
    $('#map-button-home').click(function(){
        get_location('map-home');
    });
    $('#click_mapa').click(function(){
        mapa('map-home');
    });

    search_map('search_map');
    ubicacion_mapa(20.732645, -103.458621,searchMap);
    ubicacion_mapa(23.675392, -103.370548,searchMap);
    ubicacion_mapa(24.675392, -103.370548,searchMap);
    search_map('mapa_detalle');
    ubicacion_mapa($('#lat').val(),$('#lng').val(),searchMap);
    
});
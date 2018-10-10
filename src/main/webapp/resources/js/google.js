/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Google map js functions
 */
var map;

function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: 17.78, lng: 78.62},
        zoom: 8
    });
}


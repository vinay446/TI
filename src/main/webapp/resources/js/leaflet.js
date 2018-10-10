/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Leaflet map js functions
 */
var map;
map = L.map('map').setView([17.35, 78.08], 7);

// load a tile layer
L.tileLayer('http://103.67.237.75:8111/tile/{z}/{x}/{y}.png').addTo(map);


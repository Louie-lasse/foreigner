import React, { useState } from 'react'
import { GoogleMap, LoadScript, Marker, Polyline, useJsApiLoader } from '@react-google-maps/api';
import '../styling/FlexStylesheet.css';


const containerStyle = {
 width: "100vh",
 height:"100vh",
 minHeight: "100vh",
 minWidth: "100vh"

};

const center = {
 lat: 57.6900542032499,
 lng: 11.972899811393049
};

function getMarkers(bins) {
  let coords = bins.bins;
  let markers = []

  const bigBellyIcon = {
    url: "https://bigbelly.com/wp-content/uploads/2020/09/Bigbelly-Website-Product-Page-Tiles-09-1.png", // url
    scaledSize: new window.google.maps.Size(50, 50), // scaled size
};

  for (let i = 0; i < coords.length; i++){
    markers[i] = <Marker
                  position={{lat: coords[i].latitude, lng: coords[i].longitude}}
                  label={{text: (i+1).toString(), color: "white", fontWeight:"bold" }}
                  icon={bigBellyIcon}

                  />
  }

  return markers;
}

function generatePath(bins){
  let coords = bins.bins
  if (coords.length === 0){
    return <></>
  } 
  let paths = []
  let i = 0;
  while (i < coords.length){
    let coord = coords[i];
    paths[i] = {lat: coord.latitude, lng: coord.longitude}
    i++;
  }
  return <Polyline
          path={paths}
          />;
}
function generateRoute(directionService, directionsRenderer, bins){
  const waypoints = []
  let coords = bins.bins
  if (coords.length === 0){
    return <></>
  } 

  for (let i = 1; i < coords.length; i++) {
    waypoints.push({
      location: {lat: coords[i].latitude, lng: coords[i].longitude},
      stopover: true,
    });
  
}

  let end = coords.length -1 
  directionService.route({
    origin: {lat: coords[0].latitude, lng: coords[0].longitude},
    destination: {lat: coords[end].latitude, lng: coords[end].longitude},
    waypoints: waypoints,
    travelMode: window.google.maps.TravelMode.DRIVING
  })
  .then((response) => {
    directionsRenderer.setDirections(response);
  })
}

function MapComponent(bins) {
  const [map, setMap] = useState(/**@type google.maps.Map */(null))

  const { isLoaded } = useJsApiLoader({
    id: 'google-map-script',
    googleMapsApiKey: "AIzaSyABB237sW4ZMIll6O3meWhgUL7cAROCubY"
  })

  if (!isLoaded) {
    return <p>
      not loaded
    </p>
  }
  const directionService = new window.google.maps.DirectionsService
  const directionsRenderer = new window.google.maps.DirectionsRenderer({suppressMarkers: true});
  directionsRenderer.setMap(map)

  return (
    <div class="item_1">
      <GoogleMap
        mapContainerStyle={containerStyle}
        center={center}
        zoom={12}
        onLoad = {(map) => setMap(map)}
      >
        {getMarkers(bins)}
        {generateRoute(directionService, directionsRenderer, bins)}
      </GoogleMap>
    </div>

  )
}

export default MapComponent

import React from 'react'
import { GoogleMap, LoadScript, Marker, Polyline } from '@react-google-maps/api';

const containerStyle = {
  width: '1280px',
  height: '400px'
};

const center = {
 lat: 57.6900542032499,
 lng: 11.972899811393049
};

function getMarkers(coordinates) {
  let coords = coordinates.coordinates;
  let markers = []
  for (let i = 0; i < coords.length; i++){
    markers[i] = <Marker
                  position={{lat: coords[i].x, lng: coords[i].y}}
                  label={(i+1).toString()}
                  />
  }
  return markers;
}

function generatePath(coordinates){
  let coords = coordinates.coordinates
  if (coords.length === 0){
    console.log('empty')
    return <></>
  } 
  console.log(coords)
  let paths = []
  let i = 0;
  while (i < coords.length){
    let coord = coords[i];
    paths[i] = {lat: coord.x, lng: coord.y}
    i++;
  }
  let coord = coords[0];
  paths[i] = {lat: coord.x, lng: coord.y}
  console.log(paths)
  return <Polyline
          path={paths}
          />;
}

function MapComponent(coordinates) {
  return (
    <div>
    <LoadScript
      googleMapsApiKey="AIzaSyABB237sW4ZMIll6O3meWhgUL7cAROCubY"
    >
      <GoogleMap
        mapContainerStyle={containerStyle}
        center={center}
        zoom={12}
      >
        {getMarkers(coordinates)}
        {generatePath(coordinates)}
      </GoogleMap>
    </LoadScript>
    </div>
  )
}

export default MapComponent
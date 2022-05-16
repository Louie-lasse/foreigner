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

function getMarkers(bins) {
  let coords = bins.bins;
  let markers = []
  for (let i = 0; i < coords.length; i++){
    markers[i] = <Marker
                  position={{lat: coords[i].latitude, lng: coords[i].longitude}}
                  label={(i+1).toString()}
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

function MapComponent(bins) {
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
        {getMarkers(bins)}
        {generatePath(bins)}
      </GoogleMap>
    </LoadScript>
    </div>
  )
}

export default MapComponent

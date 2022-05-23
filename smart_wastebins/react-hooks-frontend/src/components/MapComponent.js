import React, { useState } from 'react'
import { GoogleMap, LoadScript, Marker, Polyline, useJsApiLoader, InfoWindow } from '@react-google-maps/api';
import '../styling/FlexStylesheet.css';

function MapComponent(bins) {

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

const open = (i) => {
  setOpen(true);
  setOpenIndex(i);
}

const close = () => {
  setOpen(false);
}

const [isOpen,setOpen] = useState(false);
const [openIndex, setOpenIndex] = useState(0);

function getMarkers(bins) {
  let coords = bins.bins;
  let markers = []
  

  const bigBellyIcon = {
    url: "https://bigbelly.com/wp-content/uploads/2020/09/Bigbelly-Website-Product-Page-Tiles-09-1.png", // url
    scaledSize: new window.google.maps.Size(50, 50), // scaled size
  };


  for (let i = 1; i < coords.length -1; i++){
    markers[i] = <Marker
                  key={i}
                  onClick={() => {
                    open(i)
                  }}
                  position={{lat: coords[i].latitude, lng: coords[i].longitude}}
                  label={{text: (i+1).toString(), color: "white", fontWeight:"bold" }}
                  icon={bigBellyIcon}
                  >
                       {isOpen && openIndex === i ? <InfoWindow
                       onCloseClick={close}
                       position={{lat: coords[i].latitude, lng: coords[i].longitude}}>
                         <div>
                             {coords[i].fullness == null ? '' : 'Fullness :'+coords[i].fullness}
                         </div>
                       </InfoWindow> : <></>}
                     </Marker>
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

function generateRoute(directionsService, directionsRenderer, bins){
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
  //This is the function that creates the route
  directionsService.route({
    origin: {lat: coords[0].latitude, lng: coords[0].longitude},
    destination: {lat: coords[0].latitude, lng: coords[0].longitude},
    waypoints: waypoints,
    travelMode: window.google.maps.TravelMode.DRIVING
  })
  .then((response) => {
    //This is the function that draws the route
    directionsRenderer.setDirections(response);
  })
}

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
  const directionsService = new window.google.maps.DirectionsService
  //supressMarkers disables the markers from directionsRenderer since we want to use our own.
  const directionsRenderer = new window.google.maps.DirectionsRenderer({suppressMarkers: true});
  //Here you tell the directionsRenderer which map it should draw on
  directionsRenderer.setMap(map)

  console.log(bins)
  return (
    <div class="item_1">
      <GoogleMap
        mapContainerStyle={containerStyle}
        center={center}
        zoom={12}
        onLoad = {(map) => setMap(map)}
      >
        {getMarkers(bins)}
        {//generateRoute needs a directionService, and a directionsRenderer in order to
        //set up the route and then draw it.
        }
        {bins.bins.length > 25? generatePath(bins) : generateRoute(directionsService, directionsRenderer, bins)}
      </GoogleMap>
    </div>

  )
}

export default MapComponent

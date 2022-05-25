import React, { useState } from 'react'
import { GoogleMap, Marker, useJsApiLoader, InfoWindow } from '@react-google-maps/api';
import '../styling/FlexStylesheet.css';

function MapComponent(props) {

  const directions = [];

  const [openIndex, setOpenIndex] = useState(0);
  const [isOpen,setOpen] = useState(false);

  const open = (i) => {
    setOpen(true);
    setOpenIndex(i);
  }
  
  const close = () => {
    setOpen(false);
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

  const getMarkers = (bins, marked) => {
    let markers = [];
    /*
    const bigBellyIcon = {
      url: "https://bigbelly.com/wp-content/uploads/2020/09/Bigbelly-Website-Product-Page-Tiles-09-1.png", // url
      scaledSize: new window.google.maps.Size(50, 50), // scaled size
    };
    */
    let icon = marked ? {url: "https://cdn.picpng.com/google/google-map-marker-red-peg-77453.png",scaledSize: new window.google.maps.Size(30, 50)} : 
      {url: "https://icon-library.com/images/google-maps-icon-vector/google-maps-icon-vector-7.jpg",scaledSize: new window.google.maps.Size(30, 50)}
    for (let i = 0; i < bins.length; i++){
      markers[i] = <Marker
                    key={i}
                    onClick={() => {
                      open(i)
                    }}
                    position={{lat: bins[i].latitude, lng: bins[i].longitude}}
                    label={{text: bins[i].description, color: "black", fontWeight:"bold" }}
                    icon={icon}
                    >
                       {isOpen && openIndex === i ? <InfoWindow
                       onCloseClick={close}
                       position={{lat: bins[i].latitude, lng: bins[i].longitude}}>
                         <div>
                          fullness {bins[i].fullness}
                         </div>
                       </InfoWindow> : <></>}
                     </Marker>
    }
    return markers;
  }

  const getMarked = (props) => {
    let path = props.path;
    let bins = props.bins;
    console.log(bins);
    if (path.length <= 0) {
      return [path,bins];
    }
    let map = new Map();
    for (let i = 0; i < path.length; i++){
      if (path[i].serialNumber) {
        map.set(path[i].serialNumber, true);
      }
    }
    let marked = [];
    let unmarked = [];
    for (let i = 0; i < bins.length; i++){
      if (map.get(bins[i].serialNumber)){
        marked.push(bins[i]);
      } else {
        unmarked.push(bins[i]);
      }
    }
    return [marked,unmarked];
  }

  const generateRoute = (path) => {
    for (let i = 0; i < path.length; i += 24){
      let waypoints = [];
      let j = 1;
      while (j < 24 && i + j < path.length -1){
        waypoints.push({
          location: {lat: path[i+j].latitude, lng: path[i+j].longitude},
          stopover: true
        })
        j++
      }
      const directionsService = new window.google.maps.DirectionsService();
      let directionsRenderer = new window.google.maps.DirectionsRenderer({suppressMarkers: true});
      directionsRenderer.setMap(map);
      directionsService.route({
        origin: {lat: path[j].latitude, lng: path[j].longitude},
        destination: {lat: path[i+j].latitude, lng: path[i+j].longitude},
        waypoints: waypoints,
        travelMode: window.google.maps.TravelMode.DRIVING
      })
      .then((response) => {
        //This is the function that draws the route
        directionsRenderer.setDirections(response);
      })
      directions.push(directionsRenderer);
    }
  }

  let [marked,unmarked] = getMarked(props);

  console.log(props.bins);
  console.log(unmarked);

  return (
    <div class="item_1">
      <GoogleMap
        mapContainerStyle={containerStyle}
        center={center}
        zoom={12}
        onLoad = {(map) => setMap(map)}
      >
        {marked ? getMarkers(marked, true) : <></>}
        {unmarked ? getMarkers(unmarked, false) : <></>}
        {props.path ? generateRoute(props.path): <></>}
      </GoogleMap>
    </div>

  )
}

export default MapComponent

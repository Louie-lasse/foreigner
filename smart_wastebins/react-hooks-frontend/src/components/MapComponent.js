import React, { useState } from 'react'
import { GoogleMap, Marker, useJsApiLoader, InfoWindow } from '@react-google-maps/api';
import '../styling/FlexStylesheet.css';

function MapComponent(bins, path) {

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

  const getMarkers = (path) => {
    let coords = path.path;
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

  const generateRoute = (path) => {
    let coords = path.path; 
    for (let i = 0; i < coords.length; i += 24){
      let waypoints = [];
      let j = 1;
      while (j < 24 && i + j < coords.length -1){
        waypoints.push({
          location: {lat: coords[i+j].latitude, lng: coords[i+j].longitude},
          stopover: true
        })
        j++
      }
      const directionsService = new window.google.maps.DirectionsService();
      let directionsRenderer = new window.google.maps.DirectionsRenderer({suppressMarkers: true});
      directionsRenderer.setMap(map);
      directionsService.route({
        origin: {lat: coords[j].latitude, lng: coords[j].longitude},
        destination: {lat: coords[i+j].latitude, lng: coords[i+j].longitude},
        waypoints: waypoints,
        travelMode: window.google.maps.TravelMode.DRIVING
      })
      .then((response) => {
        //This is the function that draws the route
        directionsRenderer.setDirections(response);
      })
    }
  }

  return (
    <div class="item_1">
      <GoogleMap
        mapContainerStyle={containerStyle}
        center={center}
        zoom={12}
        onLoad = {(map) => setMap(map)}
      >
        {path.lenght ? getMarkers(path) : <></>}
        {path.length ? generateRoute(path): <></>}
      </GoogleMap>
    </div>

  )
}

export default MapComponent

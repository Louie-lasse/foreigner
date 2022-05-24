import React, { useState } from 'react'
import { GoogleMap, Marker, useJsApiLoader, InfoWindow } from '@react-google-maps/api';
import '../styling/FlexStylesheet.css';

function MapComponent(props) {

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

  const getMarkers = (bins) => {
    let markers = []
    const bigBellyIcon = {
      url: "https://bigbelly.com/wp-content/uploads/2020/09/Bigbelly-Website-Product-Page-Tiles-09-1.png", // url
      scaledSize: new window.google.maps.Size(50, 50), // scaled size
    };
    for (let i = 1; i < bins.length -1; i++){
      markers[i] = <Marker
                    key={i}
                    onClick={() => {
                      open(i)
                    }}
                    position={{lat: bins[i].latitude, lng: bins[i].longitude}}
                    label={{text: bins[i].description, color: "black", fontWeight:"bold" }}
                    icon={bigBellyIcon}
                    >
                       {isOpen && openIndex === i ? <InfoWindow
                       onCloseClick={close}
                       position={{lat: bins[i].latitude, lng: bins[i].longitude}}>
                         <div>
                             {bins[i].fullness == null ? '' : 'Fullness :'+bins[i].fullness}
                         </div>
                       </InfoWindow> : <></>}
                     </Marker>
    }
    return markers;
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
        {props.bins ? getMarkers(props.bins) : <></>}
        {props.path ? generateRoute(props.path): <></>}
      </GoogleMap>
    </div>

  )
}

export default MapComponent

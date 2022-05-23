import React from 'react'
import { GoogleMap, LoadScript, Marker, Polyline, InfoWindow } from '@react-google-maps/api';
import '../styling/FlexStylesheet.css';


const containerStyle = {
 width: "100vh",
 height:"100vh",
 minHeight: "100vh",
 minWidth: "100vh"

};

const [isOpen,setOpen] = useState(false);
const [openIndex, setOpenIndex] = useState(0);

const center = {
 lat: 57.6900542032499,
 lng: 11.972899811393049
};

function getMarkers(bins) {
  let coords = bins.bins;
  let markers = []
  for (let i = 0; i < coords.length; i++){
    markers[i] = <Marker
                  key={i}
                  position={{lat: coords[i].latitude, lng: coords[i].longitude}}
                  label={(i+1).toString()}
                  >
                    
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
          onClick={() => generateInfoWindows(coords[i])}
          />;
}



function MapComponent(bins) {
  let markers = getMarkers(bins);
  return (
    <div class="item_1">
    <LoadScript
      googleMapsApiKey="AIzaSyABB237sW4ZMIll6O3meWhgUL7cAROCubY"
    >
      <GoogleMap
        mapContainerStyle={containerStyle}
        center={center}
        zoom={12}
      >
        {markers}
        {generatePath(bins)}
        {generateInfoWindows(markers)}
      </GoogleMap>
    </LoadScript>
    </div>

  )
}

export default MapComponent

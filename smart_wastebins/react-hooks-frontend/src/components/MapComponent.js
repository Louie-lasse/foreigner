import React from 'react'
import { GoogleMap, LoadScript, Marker } from '@react-google-maps/api';

const containerStyle = {
  width: '1280px',
  height: '400px'
};

const center = {
 lat: 57.6900542032499,
 lng: 11.972899811393049
};

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
        {coordinates.coordinates.map(
          coord =>
            <Marker
            position={{lat: coord.x, lng: coord.y}}
            />
        )}
        {/*
        bins.bins.map(
          bin => 
            <Marker
            position={{lat: bin.coordinates.x, lng: bin.coordinates.y}}
            />
        )
        */}
        { /* Child components, such as markers, info windows, etc. */ }
        {/*
        <Marker
        position={{lat: 57.69005420321499, lng: 11.97258981393049 }}
        />
        <Marker
        position={{lat: 57.70476702787386, lng: 11.987573678754286 }}
        />
        <Marker
        position={{lat: 57.68375097532614, lng: 12.05086098640097 }}
        />
        <Marker
        position={{lat: 57.754470129397355, lng: 11.934859677681926 }}
        />
        <Marker
        position={{lat: 57.65340765221782, lng: 11.893727295118847 }}
        />
        */}
      </GoogleMap>
    </LoadScript>
    </div>
  )
}

export default MapComponent

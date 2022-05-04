import { useState,useEffect } from 'react';
import './App.css';
import MapComponent from './components/MapComponent';
import InputPath from './components/InputPath';



function App() {

  const [coords,setCoords] = useState([])

  return (
    <div>
      <MapComponent coordinates={coords}/>
      <InputPath onSubmit={coords => setCoords(coords)}/>
    </div>
  );
}

export default App;

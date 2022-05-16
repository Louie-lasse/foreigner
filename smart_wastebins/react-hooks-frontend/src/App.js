import React from 'react';
import { useState,useEffect } from 'react';
import './App.css';
import MapComponent from './components/MapComponent';
import ListBinComponent from "./components/ListBinComponent";
import MenuComponent from "./components/MenuComponent"
import InputBin from "./components/InputBin";
import InputPath from './components/InputPath';


function App() {

  const [coords,setCoords] = useState([])
  return (
    <div className="App">
        <div style={{ display: "flex", padding: "10px" }}>
      <MapComponent coordinates={coords}/>
      <InputPath onSubmit={coords => setCoords(coords)}/>
    </div>
    </div>
  );
}

export default App;

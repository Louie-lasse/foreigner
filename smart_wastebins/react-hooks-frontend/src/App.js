import React from 'react';
import { useState,useEffect } from 'react';
import './App.css';
import MapComponent from './components/MapComponent';
import ListBinComponent from "./components/ListBinComponent";
import MenuComponent from "./components/MenuComponent"
import InputBin from "./components/InputBin";
import InputPath from './components/InputPath';




function App() {

  const [bins,setBins] = useState([])

  return (
    <div className="App">
        <div style={{ display: "flex", padding: "10px" }}>
            <MapComponent bins={bins}/>
            <InputPath onSubmit={bins => setBins(bins)}/>
    </div>
    </div>
  );
}

export default App;

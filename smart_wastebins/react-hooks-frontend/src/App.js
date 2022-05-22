import React from 'react';
import { useState,useEffect } from 'react';
import './App.css';
import MapComponent from './components/MapComponent';
import ListBinComponent from "./components/ListBinComponent";
import MenuComponent from "./components/NavBar"
import InputBin from "./components/InputBin";
import InputPath from './components/InputPath';
import NavBar from "./components/NavBar";




function App() {

  const [bins,setBins] = useState([])

  return (

    <div className="App">
        <NavBar style ="NavBar">
            </NavBar>
        <div style={{ display: "flex", padding: "10px" }}>
            <MapComponent bins={bins}/>
            <InputPath onSubmit={bins => setBins(bins)}/>

    </div>
    </div>
  );
}

export default App;

import React from 'react';
import { useState,useEffect } from 'react';
import './App.css';
import MapComponent from './components/MapComponent';
import InputPath from './components/InputPath';
import NavBar from "./components/NavBar";
import BinService from './services/BinService';




function App() {

  const [bins,setBins] = useState([]);

  const [loaded,setLoaded] = useState(false);

  const [path,setPath] = useState([]);

  useEffect(() => {BinService.getAllBins().then((response) => {
    setBins(response.data);
    setLoaded(true);
  })}, []);

  return (
    !loaded ? <div>loading...</div> :
    <div className="App">
        <NavBar> </NavBar>
        <div style={{ display: "flex", padding: "10px" }}>
            <MapComponent bins={bins} path={path}/>
            <InputPath onSubmit={path => setPath(path)}/>

    </div>
    </div>
  );
}

export default App;

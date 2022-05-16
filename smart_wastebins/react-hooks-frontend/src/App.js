import React from 'react';
import ReactDOM from 'react-dom';
import { useState,useEffect } from 'react';
import './App.css';
import MapComponent from './components/MapComponent';
import InputPath from './components/InputPath';



function App() {

  const [bins,setBins] = useState([])

  return (
    <div>
      <MapComponent bins={bins}/>
      <InputPath onSubmit={bins => setBins(bins)}/>
    </div>
  );
}

export default App;

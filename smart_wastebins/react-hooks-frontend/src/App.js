import { useState,useEffect } from 'react';
import './App.css';
import CollectBins from './components/CollectBins';
import ListBinComponent from './components/ListBinComponent';
import MapComponent from './components/MapComponent';
import BinService from './services/BinService'
import axios from 'axios'
import InputPath from './components/InputPath';


function App() {

  const [bins,setBins] = useState([])

  console.log(bins);

  const coordinates = bins.map(
    bin => bin.coordinates
  )

  return (
    <div>
      <MapComponent coordinates={coordinates}/>
      <InputPath onSubmit={bins => setBins(bins)}/>
    </div>
  );
}

export default App;

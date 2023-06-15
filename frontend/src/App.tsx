import React, {useEffect, useState} from 'react';
import logo from './logo.svg';
import './App.css';
import StorageGallery from "./components/gallerys/StorageGallery";
import axios from "axios";
import {StorageModel} from "./components/models/StorageModel";

function App() {

    const[storages, setStorages] = useState<StorageModel[]>([])

    function getStorages(){
        axios.get("/api/storages")
            .then(response =>
            setStorages(response.data)
            )
    }

    useEffect(getStorages, [])

  return (
    <div className="Wrapper">
      <header className="App-header">
        <h1>CRATEGO</h1>
      </header>
        <main>
        <StorageGallery storages={storages}/>
        </main>
    </div>


  );
}

export default App;

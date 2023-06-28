import React, {useEffect, useState} from 'react';
import logo from './logo.svg';
import './App.css';
import StorageGallery from "./components/gallerys/StorageGallery";
import axios from "axios";
import {StorageModel} from "./components/models/StorageModel";
import {Route, Routes} from "react-router-dom";
import RegisterPage from "./components/pages/RegisterPage";

function App() {

    const [storages, setStorages] = useState<StorageModel[]>([])

    function getStorages() {
        axios.get("/api/storages")
            .then(response =>
                setStorages(response.data)
            )
    }

    useEffect(getStorages, [])


    return (
        <div>
            {/*<div className="header">*/}
            {/*    <h1>CRATEGO</h1>*/}
            {/*</div>*/}
            {/*<div className="main">*/}
            {/*    <StorageGallery storages={storages}/>*/}
            {/*</div>*/}
            <Routes>
                <Route path={"/"} element={<RegisterPage/>}/>
                <Route path={"/api/storages"} element={<StorageGallery storages={storages}/>}/>
            </Routes>
        </div>
    );
}

export default App;

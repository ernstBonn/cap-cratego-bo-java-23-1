import React, {useEffect, useState} from 'react';
import './App.css';
import StorageGallery from "./components/gallerys/StorageGallery";
import axios from "axios";
import {StorageModel} from "./components/models/StorageModel";
import {Route, Routes} from "react-router-dom";
import RegisterPage from "./components/pages/RegisterPage";
import LoginPage from "./components/pages/LoginPage";
import useUser from "./components/hooks/useUser";

function App() {

    const [storages, setStorages] = useState<StorageModel[]>([])

    function getStorages() {
        axios.get("/api/storages")
            .then(response =>
                setStorages(response.data)
            )
    }

    useEffect(getStorages, [])

    const {login, register} = useUser()

    return (
        <div>
            {/*<div className="header">*/}
            {/*    <h1>CRATEGO</h1>*/}
            {/*</div>*/}
            {/*<div className="main">*/}
            {/*    <StorageGallery storages={storages}/>*/}
            {/*</div>*/}
            <Routes>
                <Route path={"/"} element={<RegisterPage register={register}/>}/>
                <Route path={"/login"} element={<LoginPage login={login}/>}/>
                <Route path={"/api/storages"} element={<StorageGallery storages={storages}/>}/>
            </Routes>
        </div>
    );
}

export default App;

import React, {useEffect, useState} from 'react';
import './App.css';
import StorageGallery from "./components/gallerys/StorageGallery";
import {Route, Routes} from "react-router-dom";
import RegisterPage from "./components/pages/RegisterPage";
import LoginPage from "./components/pages/LoginPage";
import useUser from "./components/hooks/useUser";
import UserStorageGallery from "./components/gallerys/UserStorageGallery";
import useStorage from "./components/hooks/useStorage";
import WelcomePage from "./components/pages/WelcomePage";

function App() {

    const {storages} = useStorage()
    const {login, register} = useUser()

    return (
        <div>
            <Routes>
                <Route path={"/"} element={<RegisterPage register={register}/>}/>
                <Route path={"/login"} element={<LoginPage login={login}/>}/>
                <Route path={"/storages"} element={<StorageGallery storages={storages}/>}/>
                <Route path={"/me"} element={<UserStorageGallery/>}/>
                <Route path={"/welcome"} element={<WelcomePage/>}/>
            </Routes>
        </div>
    );
}

export default App;

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
import AddStoragePage from "./components/pages/AddStoragePage";
import StorageDetailsPage from "./components/pages/StorageDetailsPage";
import Header from "./components/pages/Header";
import Footer from "./components/pages/Footer";

function App() {

    const {storages} = useStorage()
    const {login, register} = useUser()

    return (
        <>
            <header><Header/></header>
            <div className={"main"}>
                <Routes>
                    <Route path={"/register"} element={<RegisterPage register={register}/>}/>
                    <Route path={"/"} element={<LoginPage login={login}/>}/>
                    <Route path={"/storages"} element={<StorageGallery storages={storages}/>}/>
                    <Route path={"/me"} element={<UserStorageGallery/>}/>
                    <Route path={"/welcome"} element={<WelcomePage/>}/>
                    <Route path={"/add"} element={<AddStoragePage/>}/>
                    <Route path={"/storage/:id"} element={<StorageDetailsPage/>}/>
                </Routes>
            </div>
            <footer><Footer/></footer>
        </>
    );
}

export default App;

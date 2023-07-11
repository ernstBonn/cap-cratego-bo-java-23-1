import React from 'react';
import {useNavigate} from "react-router-dom";

function Footer() {

    const nav = useNavigate()

    function navToRegister(){
        nav("/register")
    }

    return (
        <div className={"footer"}>
                <img onClick={navToRegister} className={"logo"} src="/crateGo_logo.png" alt="crateGo_logo" />
        </div>
    );
}

export default Footer;
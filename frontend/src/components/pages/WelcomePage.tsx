import React from 'react';
import {useNavigate} from "react-router-dom";

function WelcomePage() {

    const nav = useNavigate()

    function goToStorages(){
        nav("/me")
    }

    return (
        <div>
            <button className={"welcomeButton"} onClick={goToStorages}>STORAGES</button>
        </div>
    );
}

export default WelcomePage;
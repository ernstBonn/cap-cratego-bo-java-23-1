import React from 'react';
import {useNavigate} from "react-router-dom";

function WelcomePage() {

    const nav = useNavigate()

    function goToStorages(){
        nav("/me")
    }

    return (
        <div>
            <button className={"button"} onClick={goToStorages}>STORAGES</button>
        </div>
    );
}

export default WelcomePage;
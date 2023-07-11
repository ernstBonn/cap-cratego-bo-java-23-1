import React from 'react';
import {useNavigate} from 'react-router-dom';
import axios from "axios";

function Header() {

    const navigate = useNavigate();

    function logout(){
        axios.get("/api/logout")
            .then(() => navigate("/"))
    }

    const handleGoBack = () => {
        navigate(-1);
    };

    return (
        <div className={"header"}>
            <button className={"button"} onClick={handleGoBack}>Go Back</button>
            <h1>crateGo</h1>
            <button className={"button"} onClick={logout}>Logout</button>
        </div>
    );
}

export default Header;
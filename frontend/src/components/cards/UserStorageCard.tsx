import React from 'react';
import {StorageModel} from "../models/StorageModel";
import axios from "axios";
import {useNavigate} from "react-router-dom";

type Props = {
    storage: StorageModel
}
function UserStorageCard(props: Props) {

    const nav = useNavigate()
    function storageDetails(){
        nav("/storage/" + props.storage.id)
    }

    return (
        <div>
            <div className="description">{props.storage.description}</div>
            <div className="crts_now">{props.storage.cratesNow} / {props.storage.cratesOrg} crts</div>
            <button className={"button"} onClick={storageDetails}>Details</button>
        </div>
    );
}

export default UserStorageCard;
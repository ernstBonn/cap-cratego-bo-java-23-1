import React, {useEffect, useState} from 'react';
import axios from "axios";
import {StorageModel} from "../models/StorageModel";
import {AppUserModel} from "../models/AppUser";
import UserStorageCard from "../cards/UserStorageCard";
import {useNavigate} from "react-router-dom";

function UserStorageGallery() {

    const [storages, setStorages] = useState<StorageModel[]>([]);
    const [userName, setUserName] = useState<String>("")

    useEffect(getUser, [])
    const nav = useNavigate()

    function getUser() {
        let user: AppUserModel
        axios.get("/api/me")
            .then(response => {
                user = response.data
            })
            .then(() => {
                setUserName(user.username)
            })
            .then(() => axios.get("api/storages")
                .then(response => {
                    const filteredStorages = response.data.filter((storage: {
                        id: string;
                    }) => user.storages.includes(storage.id))
                    setStorages(filteredStorages)
                }))
    }

    function goToAddStorage(){
        nav("/add")
    }

    return (
        <>
            <div className={"userName"}>
                {userName}
            </div>
            <div>
                {storages.map(current => <UserStorageCard storage={current}/>)}
            </div>
            <button id={"addStorageButton"} onClick={goToAddStorage}>ADD STORAGE</button>
        </>
    );
}

export default UserStorageGallery;
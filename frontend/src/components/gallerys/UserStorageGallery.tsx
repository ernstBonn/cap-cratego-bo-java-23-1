import React, {useEffect, useState} from 'react';
import axios from "axios";
import {StorageModel} from "../models/StorageModel";
import {AppUserModel} from "../models/AppUser";
import UserStorageCard from "../cards/UserStorageCard";

function UserStorageGallery() {

    const [storages, setStorages] = useState<StorageModel[]>([]);
    const [userName, setUserName] = useState<String>("")

    useEffect(getUser, [])

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

    return (
        <>
            <div>
                {userName}
                {storages.map(current => <UserStorageCard storage={current}/>)}
            </div>
            <button>ADD STORAGE</button>
        </>
    );
}

export default UserStorageGallery;
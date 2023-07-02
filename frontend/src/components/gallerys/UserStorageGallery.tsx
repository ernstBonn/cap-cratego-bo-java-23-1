import React, {useEffect, useState} from 'react';
import axios from "axios";
import {StorageModel} from "../models/StorageModel";
import {AppUserModel} from "../models/AppUser";
import UserStorageCard from "../cards/UserStorageCard";

function UserStorageGallery() {

    const [storages, setStorages] = useState<StorageModel[]>([]);
    const [users, setUsers] = useState<AppUserModel[]>([])
    const [userName, setUserName] = useState<String>("")
    const [user, setUser] = useState<AppUserModel>()
    const [storageIds, setStorageIds] = useState<String[]>([])

    // useEffect(getUserStorages, [])
    useEffect(getUser, [])
    useEffect(getUserName, [])
    useEffect(getUsers, [])
    // useEffect(findUser, [])

    function getUser() {
        axios.get("/api/users")
            .then(response => setUsers(response.data))

        axios.get("/api/me")
            .then(response => setUserName(response.data))

        users.map((current) => {
            if(current.username === userName){
                setUser(current)
            }
        })
    }

    function getUserName() {
        axios.get("/api/me")
            .then(response => setUserName(response.data))
    }

    function getUsers() {
        axios.get("/api/users")
            .then(response => setUsers(response.data))
    }

    function findUser() {
        users.map((current) => {
            if (current.username === userName) {
                setUser(current)
            }
        })
    }

    // function getUserStorages() {
    //     axios.get('/api/storage')
    //         .then(response =>
    //             setStorages(response.data))
    // }
    const storagesIds = user?.storages
    return (
        <>
            <div>
                {user?.storages}
            </div>
            <div>
                {userName}
            </div>
            <div>

            </div>
        </>

        // <div>
        //     <h1>User Storages</h1>
        //     {storages.map(storage => (
        //         <div>
        //             <p>{storage.description}</p>
        //         </div>
        //     ))}
        // </div>
    );
}

export default UserStorageGallery;
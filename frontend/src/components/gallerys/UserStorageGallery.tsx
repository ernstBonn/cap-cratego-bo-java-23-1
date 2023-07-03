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

    useEffect(getStorages, [])
    useEffect(getUser, [])
    useEffect(getUserName, [])
    useEffect(getUsers, [])
    useEffect(findUser, [])

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
        console.log(user?.storages);
    }

    function getStorages() {
        axios.get("/api/storages")
            .then(response => {
                const filteredStorages = response.data.filter((storage: { id: string; }) => user?.storages.includes(storage.id));
                setStorages(filteredStorages);
                console.log(storages);
            });
    }

    return (
        <>
            <div>
                {user?.storages}
                {storages.map(current => <UserStorageCard storage={current}/>)}
            </div>
            <div>
                {userName}
            </div>
        </>
    );
}

export default UserStorageGallery;
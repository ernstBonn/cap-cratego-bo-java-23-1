import React, {useEffect, useState} from 'react';
import {useParams} from "react-router-dom";
import {StorageModel} from "../models/StorageModel";
import axios from "axios";
import {AppUserModel} from "../models/AppUser";

function StorageDetailsPage() {

    const [storage, setStorage] = useState<StorageModel>({id: "", description: "", cratesOrg: 0, cratesNow: 0})

    const params = useParams()
    const id: string | undefined = params.id

    useEffect(getStorageById,[storage])

    function getStorageById() {
        axios.get(`/api/storage/${id}`)
            .then(response => setStorage(response.data))
            .catch(error => console.error(error))
    }

    function addCrate() {
        let updatedStorage: StorageModel = storage
        updatedStorage.cratesNow = updatedStorage.cratesNow + 1
        setStorage(updatedStorage)
        axios.put(`/api/storage/${id}`, updatedStorage)
            .then(response => {
            })
            .catch(error => {
                console.error("Error updating storage:", error);
            });
    }

    function removeCrate(){
        let updatedStorage: StorageModel = storage
        updatedStorage.cratesNow = updatedStorage.cratesNow - 1
        setStorage(updatedStorage)
        axios.put(`/api/storage/${id}`, updatedStorage)
            .then(response => {
            })
            .catch(error => {
                console.error("Error updating storage:", error);
            });
    }

    return (
        <>
            <div>{storage.description}</div>
            <div>{storage.cratesNow} / {storage.cratesOrg} crts</div>
            <button onClick={removeCrate}>-</button>
            <button onClick={addCrate}>+</button>
        </>
    );
}
export default StorageDetailsPage;
import React, {useEffect, useState} from 'react';
import {useParams} from "react-router-dom";
import {StorageModel} from "../models/StorageModel";
import axios from "axios";

function StorageDetailsPage() {

    const [storage, setStorage] = useState<StorageModel>({id: "", description: "", cratesOrg: 0, cratesNow: 0})

    const params = useParams()
    const id: string | undefined = params.id

    function getStorageById() {
        axios.get(`/api/storage/${id}`)
            .then(response => setStorage(response.data))
            .catch(error => console.error(error))
    }

    useEffect(getStorageById,[])

    return (
        <>
            <div>{storage.description}</div>
            <div>{storage.cratesNow} / {storage.cratesOrg} crts</div>
        </>
    );
}
export default StorageDetailsPage;
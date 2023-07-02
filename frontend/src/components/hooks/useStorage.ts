import {useEffect, useState} from "react";
import axios from "axios";
import {StorageModel} from "../models/StorageModel";


export default function useStorage() {


    const [storages, setStorages] = useState<StorageModel[]>([])

    useEffect(getStorages, [])

    function getStorages() {
        axios.get("/api/storages")
            .then(response =>
                setStorages(response.data)
            )
    }

    return {storages}
}

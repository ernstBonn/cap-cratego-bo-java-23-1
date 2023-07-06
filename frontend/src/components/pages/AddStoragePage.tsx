import React, {ChangeEvent, FormEvent, useState} from 'react';
import {useNavigate} from "react-router-dom";
import axios from "axios";

function AddStoragePage() {

    const [id, setId] = useState<string>("")
    const [description, setDescription] = useState<string>("")
    const [cratesOrg, setCratesOrg] = useState<number>()
    const cratesNow = cratesOrg

    const nav = useNavigate()

    function onChangeHandlerId(e: ChangeEvent<HTMLInputElement>){
        setId(e.target.value)
    }

    function onChangeHandlerDescription(e: ChangeEvent<HTMLInputElement>){
        setDescription(e.target.value)
    }

    function onChangeHandlerCratesOrg(e: ChangeEvent<HTMLInputElement>){
        const value = parseInt(e.target.value, 10);
        setCratesOrg(value)
    }

    function addStorageOnSubmit(e: FormEvent<HTMLFormElement>){
        e.preventDefault();
        axios.post("api/storage", {
            id: id,
            description: description,
            cratesOrg: cratesOrg,
            cratesNow:cratesNow
        }).catch(error => console.error(error))
            .then(() => nav("/me"))
        setId("")
        setDescription("")
        setCratesOrg(0)
    }

    return (
        <div>
            <h1>addStorage</h1>
            <form onSubmit={addStorageOnSubmit}>
                <input placeholder={"id"} onChange={onChangeHandlerId}/>
                <input placeholder={"description"} onChange={onChangeHandlerDescription}/>
                <input placeholder={"crates"} onChange={onChangeHandlerCratesOrg}/>
                <button>SUBMIT</button>
            </form>
        </div>
    );
}

export default AddStoragePage;
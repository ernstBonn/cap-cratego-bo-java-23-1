import {useState} from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";

export default function useUser(){

    const [user, setUser] = useState<string>("")

    const nav = useNavigate()

    function login(username: string, password: string){
        return axios.post("/api/login", undefined, {auth:{username, password}})
            .then((r) => setUser(r.data))
            .then(() => nav("/welcome"))
            .catch((e) => console.log(e.message))
    }

    function register(username: string, password: string){
        return axios.post("/api/register",{username, password})
            .then((r) => setUser(r.data))
            .then(() => nav("/storages"))
            .catch((e) => console.log(e.message))
    }

    return {login, register, user}
}
import React, {ChangeEvent, FormEvent, useState} from 'react';

type Props = {
    register: (name: string, password: string) => Promise<void>
}

function RegisterPage(props: Props) {

    const [username, setName] = useState<string>("")
    const [password, setPassword] = useState<string>("")

    function onChangeHandlerName(e: ChangeEvent<HTMLInputElement>){
        setName(e.target.value)
    }

    function onChangeHandlerPassword(e: ChangeEvent<HTMLInputElement>){
        setPassword(e.target.value)
    }

    function registerOnSubmit(e: FormEvent<HTMLFormElement>){
        e.preventDefault()
        props.register(username, password)
    }

    return (
        <div>
            <h1>register</h1>
            <form onSubmit={registerOnSubmit}>
                <input placeholder={"name"} onChange={onChangeHandlerName}/>
                <input type={"password"} placeholder={"password"} onChange={onChangeHandlerPassword}/>
                <button className={"button"}>SUBMIT</button>
            </form>
        </div>
    );
}

export default RegisterPage;
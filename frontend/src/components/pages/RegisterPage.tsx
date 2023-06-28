import React, {ChangeEvent, FormEvent, useState} from 'react';

function RegisterPage() {

    const [name, setName] = useState<string>("")
    const [password, setPassword] = useState<string>("")

    function onChangeHandlerName(e: ChangeEvent<HTMLInputElement>){
        setName(e.target.value)
    }

    function onChangeHandlerPassword(e: ChangeEvent<HTMLInputElement>){
        setPassword(e.target.value)
    }

    function registerOnSubmit(e: FormEvent<HTMLFormElement>){
        e.preventDefault()
    }

    return (
        <div>
            <h1>register</h1>
            <form onSubmit={registerOnSubmit}>
                <input type={"text"} onChange={onChangeHandlerName}/>
                <input type={"password"} onChange={onChangeHandlerPassword}/>
                <button>SUBMIT</button>
            </form>
        </div>
    );
}

export default RegisterPage;
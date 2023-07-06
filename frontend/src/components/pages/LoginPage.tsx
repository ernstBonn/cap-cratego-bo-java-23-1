import React, {ChangeEvent, FormEvent, useState} from 'react';

type Props = {
    login: (username: string, password: string) => Promise<void>
}

function LoginPage(props: Props) {

    const [username, setName] = useState<string>("")
    const [password, setPassword] = useState<string>("")

    function onChangeHandlerName(e: ChangeEvent<HTMLInputElement>){
        setName(e.target.value)
    }

    function onChangeHandlerPassword(e: ChangeEvent<HTMLInputElement>){
        setPassword(e.target.value)
    }

    function loginOnSubmit(e: FormEvent<HTMLFormElement>){
        e.preventDefault();
        props.login(username, password)
    }

    return (
        <div>
            <h1>login</h1>
            <form onSubmit={loginOnSubmit}>
                <input placeholder={"name"} onChange={onChangeHandlerName}/>
                <input type={"password"} placeholder={"password"} onChange={onChangeHandlerPassword}/>
                <button>SUBMIT</button>
            </form>
        </div>
    );
}

export default LoginPage;
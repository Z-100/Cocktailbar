import React from 'react';
import { useState } from "react";
import register from "../service/GetFromApiService";

function Register() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [username, setUsername] = useState("");
    const [response, setResponse] = useState("Not registered yet!")

    const handleSubmit = (event) => {
        event.preventDefault();
        setResponse(register( email, password, username))
    }

    return(
        <div>
            <form onSubmit={handleSubmit}>
                <label>Name:
                    <input type="text"
                           name="email"
                           value={email}
                           onChange={(e) => setEmail(e.target.value)}/>
                </label>
                <label>Password:
                    <input type="text"
                           name="email"
                           value={password}
                           onChange={(e) => setPassword(e.target.value)}/>
                </label>
                <label>Username:
                    <input type="text"
                           name="email"
                           value={username}
                           onChange={(e) => setUsername(e.target.value)}/>
                </label>
                <input type="submit" value="Submit" />
            </form>

            <h1>{response}</h1>
        </div>
    );
}

export default Register;
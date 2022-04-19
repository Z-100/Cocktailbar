import React from 'react';
import {useState} from "react";
import register from "../service/GetFromApiService";
import {Link} from "react-router-dom";

function Register() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [username, setUsername] = useState("");
    const [response, setResponse] = useState("Not registered yet!")

    const handleSubmit = (event) => {
        event.preventDefault();
        setResponse(register(email, password, username))
    }

    return (
        <div className={"w-screen flex align-center justify-center"}>
            <div className={"w-96 flex flex-col flex-nowrap"}>
                <form onSubmit={handleSubmit}>
                    <div className={"flex flex-col flex-nowrap"}>
                        <div className="mb-4">
                            <label className="block text-grey-darker text-sm font-bold mb-2">Create username:
                                <input className="shadow appearance-none border rounded w-full py-2 px-3 text-grey-darker"
                                       type="text"
                                       placeholder="Username"
                                       name="username"
                                       value={username}
                                       onChange={(e) => setUsername(e.target.value)}/>
                            </label>
                        </div>
                        <div className="mb-4">
                            <label className="block text-grey-darker text-sm font-bold mb-2">Create new password:
                                <input className="shadow appearance-none border rounded w-full py-2 px-3 text-grey-darker"
                                       type="password"
                                       placeholder="Password"
                                       name="password"
                                       value={password}
                                       onChange={(e) => setPassword(e.target.value)}/>
                            </label>
                        </div>
                        <div className="mb-4">
                            <label className="block text-grey-darker text-sm font-bold mb-2">Enter E-Mail address:
                                <input className="shadow appearance-none border rounded w-full py-2 px-3 text-grey-darker"
                                       type="text"
                                       placeholder="E-Mail address"
                                       name="email"
                                       value={email}
                                       onChange={(e) => setEmail(e.target.value)}/>
                            </label>
                        </div>
                        <div className="flex items-center justify-between">
                            <Link className="inline-block align-baseline font-bold text-sm text-blue hover:text-blue-darker" to="/login">Log in instead</Link>
                            <input className={"py-2 px-4 bg-fourth text-white font-semibold rounded-lg shadow-md hover:bg-third cursor-pointer"} type="submit" value="Register" />
                        </div>
                    </div>
                </form>

                <h1>{response}</h1>
            </div>
        </div>
    );
}

export default Register;
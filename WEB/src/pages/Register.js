import React from 'react';
import {useState} from "react";
import {Link, useNavigate} from "react-router-dom";
import register from '../service/RegisterService'
import Spinner from "../components/Spinner";

function Register({childToParent, user}) {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [username, setUsername] = useState("");
    const [response, setResponse] = useState("")
    const [error, setError] = useState("")

    let navigate = useNavigate();

    const handleSubmit = (event) => {
        event.preventDefault();

        setResponse(null)

        register(email, password, username)
            .then(response => {
                return response.json()
            }).then(data => {
                setResponse(data.value)
                console.log(data.value)

                childToParent(email, data.value)
                console.log("[INFO] Register.js - User set")

                setError("")

                navigate("/", { replace: true });
        }).catch(err => {
            console.log("Error Reading data " + err);
            setError("E-mail and/or username already taken!")
            setResponse("")
        });
    }

    if (response === null)
        return(<Spinner />)

    return (
        <div className={"w-screen"}>
            <div className={"flex align-center justify-center -mb-4"}>
                <div>
                    <h1 className={"text-white text-8xl"}>Cocktail Bar</h1>
                    <h1 className={"text-white text-5xl"}>&nbsp;&nbsp;Create a new account</h1>
                </div>
            </div>
            <div className={"flex align-center justify-center"}>
                <div className={"w-100 flex bg-gray_trans p-4 flex-col flex-nowrap rounded-lg"}>
                    <form onSubmit={handleSubmit}>
                        <div className={"flex flex-col flex-nowrap"}>
                            <div className="mb-4">
                                <label className="block text-white text-sm font-bold mb-2">Create username:
                                    <input className="shadow appearance-none ring-third rounded w-full py-2 px-3 text-grey-darker bg-fifth"
                                        required
                                        autoFocus
                                        type="text"
                                        placeholder="Username"
                                        name="username"
                                        value={username}
                                        onChange={(e) => setUsername(e.target.value)}/>
                                </label>
                            </div>
                            <div className="mb-4">
                                <label className="block text-white text-sm font-bold mb-2">Create new password:
                                    <input className="shadow appearance-none ring-third rounded w-full py-2 px-3 text-grey-darker bg-fifth"
                                        required
                                        type="password"
                                        placeholder="Password"
                                        name="password"
                                        value={password}
                                        onChange={(e) => setPassword(e.target.value)}/>
                                </label>
                            </div>
                            <div className="mb-4">
                                <label className="block text-white text-sm font-bold mb-2">Enter E-Mail address:
                                    <input className="shadow appearance-none ring-third rounded w-full py-2 px-3 text-grey-darker bg-fifth"
                                        required
                                        type="email"
                                        placeholder="E-Mail address"
                                        name="email"
                                        value={email}
                                        onChange={(e) => setEmail(e.target.value)}/>
                                </label>
                            </div>
                            <div className="flex items-center justify-between">
                                <h1 className={"-mt-6 text-red-600"}>{error}</h1>
                            </div>
                            <div className="flex items-center justify-between">
                                <Link className="inline-block align-baseline font-bold text-sm text-blue text-white hover:text-blue-darker"
                                    to="/login">Log in instead</Link>
                                <input className={"py-2 px-4 bg-fourth text-white font-semibold rounded-lg shadow-md hover:bg-third cursor-pointer"}
                                    type="submit" value="Register"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
}

export default Register;
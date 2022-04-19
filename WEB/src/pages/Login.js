import React, {useState} from 'react';
import {Link} from "react-router-dom";
import login from "../service/LoginService";

function Login() {
    const [key, setKey] = useState("");
    const [password, setPassword] = useState("");
    const [response, setResponse] = useState("")

    let isUname = false;

    const handleSubmit = (event) => {
        event.preventDefault();

        isUname = !key.includes("@");

        login([key, password, isUname])
    }

    return(
        <div className={"w-screen flex align-center justify-center"}>
            <div className={"w-96 flex flex-col flex-nowrap"}>
                <form onSubmit={handleSubmit}>
                    <div className={"flex flex-col flex-nowrap"}>
                        <div className="mb-4">
                            <label className="block text-grey-darker text-sm font-bold mb-2">Enter username or E-Mail:
                                <input className="shadow appearance-none border rounded w-full py-2 px-3 text-grey-darker"
                                       type="text"
                                       placeholder="Username / E-Mail"
                                       name="username"
                                       value={key}
                                       onChange={(e) => setKey(e.target.value)}/>
                            </label>
                        </div>
                        <div className="mb-4">
                            <label className="block text-grey-darker text-sm font-bold mb-2">Enter password:
                                <input className="shadow appearance-none border rounded w-full py-2 px-3 text-grey-darker"
                                       type="password"
                                       placeholder="Password"
                                       name="password"
                                       value={password}
                                       onChange={(e) => setPassword(e.target.value)}/>
                            </label>
                        </div>
                        <div className="flex items-center justify-between">
                            <Link className="inline-block align-baseline font-bold text-sm text-blue hover:text-blue-darker" to="/register">Register instead</Link>
                            <input className={"py-2 px-4 bg-fourth text-white font-semibold rounded-lg shadow-md hover:bg-third cursor-pointer"} type="submit" value="Log in" />
                        </div>
                    </div>
                </form>

                <h1>{response}</h1>
            </div>
        </div>
    );
}

export default Login;
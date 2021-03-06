import React, {useState} from 'react';
import {Link} from "react-router-dom";
import {useNavigate} from 'react-router-dom';
import login from "../service/LoginService";
import Spinner from "../components/Spinner";

function Login({childToParent, user}) {
    const [uName, setUName] = useState("");
    const [password, setPassword] = useState("");
    const [response, setResponse] = useState("")
    const [error, setError] = useState(null)

    let navigate = useNavigate();

    const handleSubmit = (event) => {
        event.preventDefault();

        setResponse(null)

        login(uName, password, !uName.includes("@"))
            .then(response => {
                return response.json()
            }).then(data => {
                setResponse(data.value)

                childToParent(uName, data.value)
                console.log("[INFO] Login.js - User set")

                setError(null)

                navigate("/", { replace: true });
            }).catch(err => {
                console.log("Error Reading data " + err);
                setError("Invalid e-mail/username and/or password!")
                setResponse("")
            });
    }

    if (response === null)
        return(<Spinner />)

    return(
        <div className={"w-screen"}>
            <div className={"flex align-center justify-center -mb-7"}>
                <div>
                    <h1 className={"text-white text-6xl"}>Cocktail Bar</h1>
                    <h1 className={"text-white text-9xl"}>Login</h1>
                </div>
            </div>
            <div className={"flex align-center justify-center"}>
                <div className={"w-100 flex bg-gray_trans p-4 flex-col flex-nowrap rounded-lg"}>
                    <form onSubmit={handleSubmit}>
                        <div className={"flex flex-col flex-nowrap"}>
                            <div className="mb-4">
                                <label className="block text-white text-sm font-bold mb-2">Enter username or E-Mail:
                                    <input className="shadow appearance-none ring-third rounded w-full py-2 px-3 text-grey-darker bg-fifth"
                                           autoFocus
                                           required
                                           type="text"
                                           placeholder="Username / E-Mail"
                                           name="username"
                                           value={uName}
                                           onChange={(e) => setUName(e.target.value)}/>
                                </label>
                            </div>
                            <div className="mb-4">
                                <label className="block text-white text-sm font-bold mb-2">Enter password:
                                    <input className="shadow appearance-none rounded w-full py-2 px-3 text-grey-darker bg-fifth"
                                           required
                                           type="password"
                                           placeholder="Password"
                                           name="password"
                                           value={password}
                                           onChange={(e) => setPassword(e.target.value)}/>
                                </label>
                            </div>
                            <div className="flex items-center justify-between">
                                <h1 className={"-mt-6 text-red-600"}>{error}</h1>
                            </div>
                            <div className="flex items-center justify-between">
                                <Link className="inline-block text-white align-baseline font-bold text-sm text-blue hover:fifth" to="/register">Register instead</Link>
                                <input className={"py-2 px-4 bg-fourth text-white font-semibold rounded-lg shadow-md hover:bg-third cursor-pointer"} type="submit" value="Log in" />
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
}

export default Login;
import React, {useEffect, useState} from 'react';
import getAccount from "../service/GetFromApiService";
import {Link} from "react-router-dom";

function Profile({childToParent, user}) {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [username, setUsername] = useState("");
    const [response, setResponse] = useState("Not registered yet!")

    const handleSubmit = () => {
        console.log(user.email)
        getAccount(user.email)
            .then(response => {
                console.log(response)
                return response.json();
            }).then(data => {
                console.log(data)
            setEmail(data.email)
            setUsername(data.username)
            }).catch(err => {
                console.log("Error Reading data " + err);
            });
    }

    useEffect(handleSubmit, [])

    return(
        <div className={"flex align-center justify-center"}>
            <div className={"w-100 flex bg-gray_trans p-4 flex-col flex-nowrap rounded-lg"}>
                    <div className={"flex flex-col flex-nowrap"}>
                        <div className="mb-4">
                            <label className="block text-white text-sm font-bold mb-2">Your E-Mail Address
                                <input className="shadow appearance-none ring-third rounded w-full py-2 px-3 text-grey-darker bg-fifth"
                                       disabled
                                       type="text"
                                       placeholder="Username / E-Mail"
                                       name="username"
                                       value={email}
                                       onChange={(e) => setEmail(e.target.value)}/>
                            </label>
                        </div>
                        <div className="mb-4">
                            <label className="block text-white text-sm font-bold mb-2">Your username:
                                <input className="shadow appearance-none rounded w-full py-2 px-3 text-grey-darker bg-fifth"
                                       disabled
                                       type="text"
                                       name="username"
                                       value={username}
                                       onChange={(e) => setUsername(e.target.value)}/>
                            </label>
                        </div>
                    </div>
            </div>
        </div>
    );
}

export default Profile;
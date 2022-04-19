import React, {useState} from 'react';
import register from "../service/GetFromApiService";
import getAccount from "../service/GetFromApiService";

function Profile() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [username, setUsername] = useState("");
    const [response, setResponse] = useState("Not registered yet!")

    const edit = true

    const handleSubmit = (event) => {
        event.preventDefault();
        setResponse(register(email, password, username))
    }

    let profile = getAccount("username")
    // setEmail(profile.email)
    // setUsername(profile.username)

    return(
        <div className={"w-screen flex align-center justify-center"}>
            <div className={"shadow w-4/12 flex flex-col flex-nowrap"}>
                <form className={"p-5"}>
                    <div className={"flex flex-col flex-nowrap"}>
                        <div className="mb-4">
                            <label className="block text-grey-darker text-sm font-bold mb-2">Your username
                                <input className="shadow appearance-none border rounded w-full py-2 px-3 text-grey-darker"
                                    placeholder="Username"
                                    name="username"
                                    value={username}
                                    disabled={true} />
                            </label>
                        </div>
                        <div className="mb-4">
                            <label className="block text-grey-darker text-sm font-bold mb-2">Your password:
                                <input className="shadow appearance-none border rounded w-full py-2 px-3 text-grey-darker"
                                       type="password"
                                       placeholder="Password"
                                       name="password"
                                       value={password}
                                       onChange={(e) => setPassword(e.target.value)}
                                       disabled={edit} />
                            </label>
                        </div>
                        <div className="mb-4">
                            <label className="block text-grey-darker text-sm font-bold mb-2">Your E-Mail address:
                                <input className="shadow appearance-none border rounded w-full py-2 px-3 text-grey-darker"
                                       type="text"
                                       placeholder="E-Mail address"
                                       name="email"
                                       value={email}
                                       onChange={(e) => setEmail(e.target.value)}
                                       disabled={edit} />
                            </label>
                        </div>
                        <div className="flex items-center justify-between hidden">
                            <input className={"py-2 px-4 bg-fourth text-white font-semibold rounded-lg shadow-md hover:bg-third cursor-pointer"} type="submit" value="Register" />
                        </div>
                    </div>
                </form>
            </div>
        </div>
    );
}

export default Profile;
import React, {useState} from 'react';
import getAccount from "../service/GetFromApiService";

function Profile() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [username, setUsername] = useState("");
    const [response, setResponse] = useState("Not registered yet!")

    const handleSubmit = () => {
        const shit = getAccount("username")
            .then(response => {
                console.log(response)
                return response.json();
            }).then(data => {
                console.log(data)
            }).catch(err => {
                console.log("Error Reading data " + err);
            });
    }

    let profile = getAccount("username")

    return(
        <div>
            <form onSubmit={handleSubmit}>
                <input className={"py-2 px-4 bg-fourth text-white font-semibold rounded-lg shadow-md hover:bg-third cursor-pointer"} type="submit" value="Register" />
            </form>
        </div>

    );
}

export default Profile;
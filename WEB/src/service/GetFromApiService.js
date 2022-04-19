import Axios from 'axios';
import React, {useEffect, useState} from 'react';

const Register = (username) => {

    let url = "http://localhost:8080/account/get?username=" + username
    const [account, setAccount] = useState("");

    let cfg = {
        headers: {
            'Content-Type': 'application/json;charset=UTF-8',
            "Access-Control-Allow-Origin": "*",
        }
    };

    useEffect(() => {
        // GET request using axios inside useEffect React hook
        Axios.get(url, cfg)
            .then(response => setAccount(response.data));
    }, []);

    console.log(account)
    return {
        username: account.username,
        email: account.email,
    }
}

export default Register;
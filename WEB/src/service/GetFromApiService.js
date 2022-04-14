import Axios from 'axios';

const Register = (email, password, username) => {

    let url = "http://localhost:8080/account/register"
    let response = "Process started";

    let axiosConfig = {
        headers: {
            'Content-Type': 'application/json;charset=UTF-8',
            "Access-Control-Allow-Origin": "*",
            'email': email,
            'password': password,
            'username': username,
        }
    };

    Axios.post(url, {}, axiosConfig)
        .then((res) => {
            console.log("RESPONSE RECEIVED: ", res);
            return("Account has been registered");
        }).catch((err) => {
            console.log("AXIOS ERROR: ", err);
            return("Registering process failed");
        })

    return(response)
}

export default Register;
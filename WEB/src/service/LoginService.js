import Axios from 'axios';

const Login = ([key, password, isUname]) => {

    let url = "http://localhost:8080/account/login"

    let cfg = {
        headers: {
            'Content-Type': 'application/json;charset=UTF-8',
            "Access-Control-Allow-Origin": "*",
            'key': key,
            'password': password,
            'is-uname': isUname
        }
    };

        Axios.post(url, {}, cfg)
        .then(response => {
            sessionStorage.setItem("token", response.data);
        })
        .catch(error => console.error(error));

    return {
        token: "token",
    }
}

export default Login;
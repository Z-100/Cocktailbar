async function Login(key, password, isUname) {

    let url = "http://localhost:8080/account/login"

    return await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=UTF-8',
            'Accept': 'application/json',
            "Access-Control-Allow-Origin": "*",
            'key': key,
            'password': password,
            'is-uname': isUname
        },
    })
}

export default Login
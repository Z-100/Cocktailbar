async function Register(email, password, username) {

    let url = "http://localhost:8080/account/register"

    return await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=UTF-8',
            'Accept': 'application/json',
            "Access-Control-Allow-Origin": "*",
            'email': email,
            'password': password,
            'username': username
        },
    })
}

export default Register
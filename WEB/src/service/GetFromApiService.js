async function GetAccount(username) {

    let url = "http://localhost:8080/account/get/" + username

    return await fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json;charset=UTF-8',
            'Accept': 'application/json',
            "Access-Control-Allow-Origin": "*",
        },
    })
}

export default GetAccount
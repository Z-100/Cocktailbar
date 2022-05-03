async function GetFromUser(userName) {

    let url = "http://localhost:8080/recipe/get-all/" + userName

    return await fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json;charset=UTF-8',
            'Accept': 'application/json',
            "Access-Control-Allow-Origin": "*",
        },
    })
}

export default GetFromUser
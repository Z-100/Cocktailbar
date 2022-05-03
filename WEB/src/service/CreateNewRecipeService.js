async function Insert(email, token, title, description) {

    let url = "http://localhost:8080/recioe/insert"

    return await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=UTF-8',
            'Accept': 'application/json',
            "Access-Control-Allow-Origin": "*",
            'email': email,
            'token': token,
            'title': title,
            'description': description,
            'ingredients': []
        },
    })
}

export default Insert
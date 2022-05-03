async function GetRecommended() {

    let url = "http://localhost:8080/recipe/get-latest"

    return await fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json;charset=UTF-8',
            'Accept': 'application/json',
            "Access-Control-Allow-Origin": "*",
        },
    })
}

export default GetRecommended
import getAccount from '../service/GetFromApiService'

const Drink = () => {

    let message = "API Response"

    const getRequest = () => {
        console.log("Button pressed")
        message = getAccount("http://localhost:8080/account/login", "marvin@why.com", "sananas")
        console.log(message)
    }

    return (
        <div>
            <div className="h1 bg-secondary text-white text-center p-2">
                { message }
            </div>

            <button onClick={getRequest}>Login</button>
        </div>
    );
}

export default Drink;
import getAccount from '../service/GetFromApiService'

const Drink = () => {

    let message = "API Response"

    console.log("Button pressed")
    message = getAccount("http://localhost:8080/account/login", "ANDREI", "sananas", "d7d08774-BOOBIES-4442-b656-060250c80d19")

    return (
        <div>
            <div className="h1 bg-secondary text-white text-center p-2">
                { message }
            </div>
        </div>
    );
}

export default Drink;
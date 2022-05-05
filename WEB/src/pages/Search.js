import React, {useState} from 'react';
import Drink from "../components/Drink";
import Spinner from "../components/Spinner";
import getFromUser from "../service/GetRecipesFromUserService";

function Search() {
    const [recommended, setRecommended] = useState([])
    const [userName, setUserName] = useState("")
    const [error, setError] = useState(null)

    const fetch = (event) => {
        event.preventDefault();

        setRecommended([])

        if (userName.length <= 0) {
            setError("Please enter a name!")
            return;
        }
        getFromUser(userName)
            .then(response => {
                return response.json();
            }).then(data => {
            setRecommended(data)
            setError(null)
        }).catch(err => {
            console.log("Error Reading data " + err);
            setError("No drinks have been found! Try again later")
        })
    }

    if (recommended === null)
        return(<Spinner />)

    return(
        <div>
            <div className={"flex align-center justify-center mb-5"}>
                <div className={"w-100 flex mt-10 bg-gray_trans p-4 flex-col flex-nowrap rounded-lg"}>
                    <form onSubmit={fetch}>
                        <label className="block text-white text-sm font-bold">Enter username of an account:
                            <div className={"flex flex-row flex-nowrap"}>
                                <input className="shadow appearance-none ring-third rounded w-full py-2 px-4 text-grey-darker bg-fifth"
                                       autoFocus
                                       type="text"
                                       placeholder="Username / E-Mail"
                                       name="username"
                                       value={userName}
                                       onChange={(e) => setUserName(e.target.value)}/>
                                <div className="flex items-center justify-between">
                                    <input className={"py-2 px-4 ml-5 bg-fourth text-white font-semibold rounded-lg shadow-md hover:bg-third cursor-pointer"} type="submit" value="Search recipes" onClick={fetch}/>
                                </div>
                            </div>
                        </label>
                        <div className="flex items-center justify-between">
                            <h1 className={"mt-2 text-red-600"}>{error}</h1>
                        </div>
                    </form>
                </div>
            </div>

            <div className={"w-screen flex flex-row align-center justify-center"}>
                <div className={"flex flex-row flex-wrap justify-center content-start overflow-y-auto max-h-screen no-scrollbar"}>
                    {recommended.map(drink => (
                        <div >
                            <Drink title={drink.title} key={drink.key} rating={5} description={drink.description} />
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
}

export default Search;
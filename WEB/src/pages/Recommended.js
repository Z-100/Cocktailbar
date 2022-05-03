import React, {useState, useEffect} from 'react';
import Drink from "../components/Drink";
import getRecommended from '../service/GetRecommendedRecipesService'
import Spinner from "../components/Spinner";

function Recommended() {
    const [recommended, setRecommended] = useState(null)
    const [error, setError] = useState(null)

    const fetch = () => {
        getRecommended()
            .then(response => {
                return response.json();
            }).then(data => {
                setRecommended(data)
            }).catch(err => {
                console.log("Error Reading data " + err);
                setError("No drinks have been found! Try again later")
            })
    }

    useEffect(fetch, [])

    if (recommended === null && error === null)
        return(<Spinner />)
    else if (error !== null)
        return(<h1 className={"text-center px-3 text-white font-semibold"}>{error}</h1>)
    else
        return(
            <div className={" h-screen flex flex-row justify-center text-center items-center"}>
                <div className={"flex flex-row flex-wrap justify-items-start items-stretch content-start overflow-y-auto max-h-screen no-scrollbar"}>
                    {recommended.map(drink => (
                        <div >
                            <Drink title={drink.title} rating={5} description={drink.description} />
                        </div>
                    ))}
                </div>
            </div>
        );
}

export default Recommended;